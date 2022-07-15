package com.arthur.algafood.core.jackson;

import com.arthur.algafood.domain.model.Cidade;
import com.arthur.algafood.domain.model.Cozinha;
import com.arthur.algafood.domain.model.Restaurante;
import com.arthur.algafood.domain.model.mixin.CidadeMixin;
import com.arthur.algafood.domain.model.mixin.CozinhaMixin;
import com.arthur.algafood.domain.model.mixin.RestauranteMixin;
import com.fasterxml.jackson.databind.module.SimpleModule;
import org.springframework.stereotype.Component;

@Component
public class JacksonMixinModule extends SimpleModule {

    public JacksonMixinModule() {
        setMixInAnnotation(Restaurante.class, RestauranteMixin.class);
        setMixInAnnotation(Cidade.class, CidadeMixin.class);
        setMixInAnnotation(Cozinha.class, CozinhaMixin.class);
    }
}
