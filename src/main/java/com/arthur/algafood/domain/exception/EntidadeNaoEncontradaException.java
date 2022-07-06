package com.arthur.algafood.domain.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.server.ResponseStatusException;

@ResponseStatus( value = HttpStatus.NOT_FOUND )
public class EntidadeNaoEncontradaException  extends RuntimeException{

    public EntidadeNaoEncontradaException(String mensagem) {
        super(mensagem);
    }
}
