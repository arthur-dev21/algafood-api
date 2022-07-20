package com.arthur.algafood.api.model.input;

import com.arthur.algafood.api.model.*;
import lombok.*;

import javax.validation.*;
import javax.validation.constraints.*;

@Getter
@Setter
public class EnderecoInput {


    @NotBlank
    private String cep;

    @NotBlank
    private String logradouro;

    @NotBlank
    private String numero;

    private String complemento;

    @NotBlank
    private String bairro;

    @Valid
    @NotNull
    private CidadeIdInput cidade;
}
