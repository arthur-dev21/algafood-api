package com.arthur.algafood.domain.service;

import com.arthur.algafood.domain.exception.EntidadeEmUsoException;
import com.arthur.algafood.domain.exception.EntidadeNaoEncontradaException;
import com.arthur.algafood.domain.model.Cozinha;
import com.arthur.algafood.domain.model.Estado;
import com.arthur.algafood.domain.repository.EstadoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

@Service
public class CadastroEstadoService {

    @Autowired
    private EstadoRepository estadoRepository;

    public Estado salvar(Estado estado) {
        return estadoRepository.save(estado);
    }

    public Estado buscar(Long id ){
        return estadoRepository.findById(id)
                .orElseThrow(() -> new EntidadeNaoEncontradaException(
                        String.format("Estado de id %d nao foi encontrado" , id)));
    }


    public void excluir(Long estadoId) {
        try {
            estadoRepository.deleteById(estadoId);

        } catch (EmptyResultDataAccessException e) {
            throw new EntidadeNaoEncontradaException(
                    String.format("Não existe um cadastro de estado com código %d", estadoId));

        } catch (DataIntegrityViolationException e) {
            throw new EntidadeEmUsoException(
                    String.format("Estado de código %d não pode ser removido, pois está em uso", estadoId));
        }
    }
}
