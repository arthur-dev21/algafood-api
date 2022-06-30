package com.arthur.algafood.domain.service;

import com.arthur.algafood.domain.exception.EntidadeEmUsoException;
import com.arthur.algafood.domain.exception.EntidadeNaoEncontradaException;
import com.arthur.algafood.domain.model.Cozinha;
import com.arthur.algafood.domain.repository.CozinhaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

@Service
public class CadastroCozinhaService {

    @Autowired
    private CozinhaRepository cozinhaRepository;

    public Cozinha salvar(Cozinha cozinha){
        return cozinhaRepository.save(cozinha);
    }

    public Cozinha buscar(Long id ){
        return cozinhaRepository.findById(id)
                .orElseThrow(() -> new EntidadeNaoEncontradaException(
                        String.format("Cozinha de id %d nao foi encontrado" , id)));
    }

    public void excluir(Long cozinhaId){
        try{
            cozinhaRepository.deleteById(cozinhaId);
        }catch (DataIntegrityViolationException ex){
            throw new EntidadeEmUsoException(
                    String.format("Cozinha com o codigo %d nao pode ser removida ois esta em uso",cozinhaId));
        }
        catch (EmptyResultDataAccessException ex){
            throw new EntidadeNaoEncontradaException(
                    String.format("Cozinha com o codigo %d nao foi encontrada",cozinhaId));
        }
    }
}
