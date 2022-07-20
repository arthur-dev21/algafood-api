package com.arthur.algafood.domain.service;

import com.arthur.algafood.domain.exception.*;
import com.arthur.algafood.domain.model.*;
import com.arthur.algafood.domain.repository.*;
import org.springframework.beans.factory.annotation.*;
import org.springframework.stereotype.*;

import javax.transaction.*;

@Service
public class EmissaoPedidoService {

    @Autowired
    private PedidoRepository pedidoRepository;



    @Autowired
    private CadastroRestauranteService cadastroRestaurante;

    @Autowired
    private CadastroCidadeService cadastroCidade;

    @Autowired
    private CadastroUsuarioService cadastroUsuario;

    @Autowired
    private CadastroProdutoService cadastroProduto;

    @Autowired
    private CadastroFormaPagamentoService cadastroFormaPagamento;

    public Pedido buscarOuFalhar(String  codigoPedido) {
        return pedidoRepository.findByCodigo(codigoPedido)
                .orElseThrow(() -> new PedidoNaoEncontradoException(codigoPedido));
    }

    @Transactional
    public Pedido emitir(Pedido pedido) {
        validarPedido(pedido);
        validarItens(pedido);

        pedido.setTaxaFrete(pedido.getRestaurante().getTaxaFrete());
        pedido.calcularValorTotal();

        return pedidoRepository.save(pedido);
    }

    private void validarPedido(Pedido pedido) {
        Cidade cidade = cadastroCidade.buscarOuFalhar(pedido.getEnderecoEntrega().getCidade().getId());
        Usuario cliente = cadastroUsuario.buscarOuFalhar(pedido.getCliente().getId());
        Restaurante restaurante = cadastroRestaurante.buscarOuFalhar(pedido.getRestaurante().getId());
        FormaPagamento formaPagamento = cadastroFormaPagamento.buscarOuFalhar(pedido.getFormaPagamento().getId());

        pedido.getEnderecoEntrega().setCidade(cidade);
        pedido.setCliente(cliente);
        pedido.setRestaurante(restaurante);
        pedido.setFormaPagamento(formaPagamento);

        if (restaurante.naoAceitaFormaPagamento(formaPagamento)) {
            throw new NegocioException(String.format("Forma de pagamento '%s' não é aceita por esse restaurante.",
                    formaPagamento.getDescricao()));
        }
    }

    private void validarItens(Pedido pedido) {
        pedido.getItens().forEach(item -> {
            Produto produto = cadastroProduto.buscarOuFalhar(
                    pedido.getRestaurante().getId(), item.getProduto().getId());

            item.setPedido(pedido);
            item.setProduto(produto);
            item.setPrecoUnitario(produto.getPreco());
        });
    }
}
