package com.arthur.algafood.api.controller;

import com.arthur.algafood.api.assembler.*;
import com.arthur.algafood.api.assembler.disassembler.*;
import com.arthur.algafood.api.model.*;
import com.arthur.algafood.api.model.input.*;
import com.arthur.algafood.domain.exception.*;
import com.arthur.algafood.domain.model.*;
import com.arthur.algafood.domain.repository.*;
import com.arthur.algafood.domain.service.*;
import org.springframework.beans.factory.annotation.*;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;

import javax.validation.*;
import java.util.*;

@RestController
@RequestMapping(value = "/restaurantes/{restauranteId}/forma-pagamento")
public class RestauranteFormaPagamentoController {



    @Autowired
    private CadastroRestauranteService cadastroRestaurante;

    @Autowired
    private FormaPagamentoModelAssembler formaPagamentoModelAssembler;


    @GetMapping
    public List<FormaPagamentoModel> listar(@PathVariable Long restauranteId) {
        Restaurante restaurante = cadastroRestaurante.buscarOuFalhar(restauranteId);

        return formaPagamentoModelAssembler.toCollectionModel( restaurante.getFormasPagamento());

    }

    @DeleteMapping("/{formaPagamentoId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void desassciar(@PathVariable Long restauranteId , @PathVariable Long formaPagamentoId) {
         cadastroRestaurante.desassociarFormaPagamento(restauranteId , formaPagamentoId);
    }

    @PutMapping("/{formaPagamentoId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void associar(@PathVariable Long restauranteId , @PathVariable Long formaPagamentoId) {
         cadastroRestaurante.associarFormaPagamento(restauranteId , formaPagamentoId);
    }






}
