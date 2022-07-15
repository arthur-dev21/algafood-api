package com.arthur.algafood.domain.model.mixin;

import com.arthur.algafood.core.validation.Groups;
import com.arthur.algafood.domain.model.Cozinha;
import com.arthur.algafood.domain.model.Endereco;
import com.arthur.algafood.domain.model.FormaPagamento;
import com.arthur.algafood.domain.model.Produto;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;


import java.time.OffsetDateTime;
import java.util.ArrayList;
import java.util.List;

public abstract class RestauranteMixin {

    @JsonIgnoreProperties(value = "nome" , allowGetters = true)
    private Cozinha cozinha;

    @JsonIgnore
    private Endereco endereco;

    @JsonIgnore
    private OffsetDateTime dataCadastro;

    @JsonIgnore
    private OffsetDateTime dataAtualizacao;

    @JsonIgnore
    private List<FormaPagamento> formasPagamento  = new ArrayList<>();

    @JsonIgnore
    private List<Produto> produtos = new ArrayList<>();


}
