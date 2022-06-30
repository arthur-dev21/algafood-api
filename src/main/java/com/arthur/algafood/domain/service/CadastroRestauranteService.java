package com.arthur.algafood.domain.service;

import com.arthur.algafood.domain.model.Restaurante;
import com.arthur.algafood.domain.repository.RestauranteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CadastroRestauranteService {

    @Autowired
    private RestauranteRepository restauranteRepository;

    @Autowired
    private CadastroCozinhaService cadastroCozinhaService;



    public Restaurante salvar(Restaurante restaurante){
        cadastroCozinhaService.buscar(restaurante.getCozinha().getId());
        return  restauranteRepository.save(restaurante);
    }
}
