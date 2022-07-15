package com.arthur.algafood.domain.service;

import com.arthur.algafood.domain.exception.EntidadeEmUsoException;
import com.arthur.algafood.domain.exception.EntidadeNaoEncontradaException;
import com.arthur.algafood.domain.exception.EstadoNaoEncontradoException;
import com.arthur.algafood.domain.model.Cozinha;
import com.arthur.algafood.domain.model.Estado;
import com.arthur.algafood.domain.repository.EstadoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
public class CadastroEstadoService {

    private static final String MSG_ESTADO_EM_USO  =
            "Estado de código %d não pode ser removido, pois está em uso";



    @Autowired
    private EstadoRepository estadoRepository;
    @Transactional
    public Estado salvar(Estado estado) {
        return estadoRepository.save(estado);
    }

    public Estado buscarOuFalhar(Long estadoId) {
        return estadoRepository.findById(estadoId)
                .orElseThrow(() -> new EstadoNaoEncontradoException( estadoId));
    }

    @Transactional
    public void excluir(Long estadoId) {
        try {
            estadoRepository.deleteById(estadoId);


        } catch (DataIntegrityViolationException e) {
            throw new EntidadeEmUsoException(
                    String.format(MSG_ESTADO_EM_USO, estadoId));
        } catch (EmptyResultDataAccessException e) {
            throw new EstadoNaoEncontradoException(estadoId);


        }
    }
}
