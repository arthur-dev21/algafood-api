package com.arthur.algafood.domain.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.arthur.algafood.domain.exception.EntidadeEmUsoException;
import com.arthur.algafood.domain.exception.EntidadeNaoEncontradaException;
import com.arthur.algafood.domain.model.Cidade;
import com.arthur.algafood.domain.model.Estado;
import com.arthur.algafood.domain.repository.CidadeRepository;

@Service
public class CadastroCidadeService {

    @Autowired
    private CidadeRepository cidadeRepository;

    @Autowired
    private CadastroEstadoService cadastroEstadoService;


    public Cidade buscar(Long id ){
        return cidadeRepository.findById(id)
                .orElseThrow(() -> new EntidadeNaoEncontradaException(
                        String.format("Cidade de id %d nao foi encontrado" , id)));
    }

    public Cidade salvar(Cidade cidade) {
        Long estadoId = cidade.getEstado().getId();
        Estado estado = cadastroEstadoService.buscar(estadoId);

        

        if (estado == null) {
            throw new EntidadeNaoEncontradaException(
                    String.format("Não existe cadastro de estado com código %d", estadoId));
        }

        cidade.setEstado(estado);

        return cidadeRepository.save(cidade);
    }







    public void excluir(Long cidadeId) {
        try {
            cidadeRepository.deleteById(cidadeId);

        } catch (EmptyResultDataAccessException e) {
            throw new EntidadeNaoEncontradaException(
                    String.format("Não existe um cadastro de cidade com código %d", cidadeId));

        } catch (DataIntegrityViolationException e) {
            throw new EntidadeEmUsoException(
                    String.format("Cidade de código %d não pode ser removida, pois está em uso", cidadeId));
        }
    }
}
