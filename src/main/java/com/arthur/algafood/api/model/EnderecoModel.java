package com.arthur.algafood.api.model;

import com.arthur.algafood.domain.model.*;
import lombok.*;

import javax.persistence.*;

@Getter
@Setter
public class EnderecoModel {


    private String cep;
    private String logradouro;
    private String numero;
    private String complemento;
    private String bairro;
    private CidadeResumoModel cidade;
}
