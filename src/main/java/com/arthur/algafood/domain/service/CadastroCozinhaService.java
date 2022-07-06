package com.arthur.algafood.domain.service;

import com.arthur.algafood.domain.exception.EntidadeEmUsoException;
import com.arthur.algafood.domain.exception.EntidadeNaoEncontradaException;
import com.arthur.algafood.domain.model.Cozinha;
import com.arthur.algafood.domain.repository.CozinhaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

@Service
public class CadastroCozinhaService {

    private static String MSG_COZINHA_NAO_ENCONTRADA = "Nao existe um cadastro de Cozinha com o id : %d";
    private static String MSG_COZINHA_EM_USO = "Cozinha com o codigo %d nao pode ser removida ois esta em uso";

    @Autowired
    private CozinhaRepository cozinhaRepository;

    public Cozinha salvar(Cozinha cozinha){
        return cozinhaRepository.save(cozinha);
    }

    public Cozinha buscarOuFalhar(Long id ){
        return cozinhaRepository.findById(id)
                .orElseThrow(() -> new EntidadeNaoEncontradaException(
                        String.format(MSG_COZINHA_NAO_ENCONTRADA, id)));
    }

    public void excluir(Long cozinhaId){
        try{
            cozinhaRepository.deleteById(cozinhaId);
        }catch (DataIntegrityViolationException ex){
            throw new EntidadeEmUsoException(
                    String.format(MSG_COZINHA_EM_USO,cozinhaId));
        }
        catch (EmptyResultDataAccessException ex){
            throw new EntidadeNaoEncontradaException(
                    String.format(MSG_COZINHA_NAO_ENCONTRADA , cozinhaId));
        }
    }
}
