package com.arthur.algafood.core.modelmapper;

import com.arthur.algafood.api.model.RestauranteModel;
import com.arthur.algafood.domain.model.Restaurante;
import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ModelMapperConfig {

    @Bean
    public ModelMapper modelMapper(){
        var modelMapper = new ModelMapper();

        modelMapper.createTypeMap(Restaurante.class, RestauranteModel.class)
                .addMapping(Restaurante::getTaxaFrete , RestauranteModel :: setTaxaFrete);
        return modelMapper;
    }
}
