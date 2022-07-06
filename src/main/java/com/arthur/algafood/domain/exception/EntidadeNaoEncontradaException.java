package com.arthur.algafood.domain.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.server.ResponseStatusException;


public class EntidadeNaoEncontradaException  extends NegocioException{

    public EntidadeNaoEncontradaException(String mensagem) {
        super(mensagem);
    }
}
