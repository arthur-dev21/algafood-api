package com.arthur.algafood.api.controller;

import java.util.List;
import java.util.Optional;

import com.arthur.algafood.domain.exception.EntidadeEmUsoException;
import com.arthur.algafood.domain.exception.EntidadeNaoEncontradaException;
import com.arthur.algafood.domain.service.CadastroCozinhaService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.arthur.algafood.domain.model.Cozinha;
import com.arthur.algafood.domain.repository.CozinhaRepository;
import org.springframework.web.server.ResponseStatusException;

import javax.validation.Valid;

@RestController
	@RequestMapping("/cozinhas")
	public class CozinhaController {

		@Autowired
		private CozinhaRepository cozinhaRepository;

		@Autowired
		private CadastroCozinhaService cadastroCozinhaService;
		
		@GetMapping(produces = MediaType.APPLICATION_XML_VALUE)
		public List<Cozinha> listar() {
			return cozinhaRepository.findAll();
		}

		@ResponseStatus(HttpStatus.OK)
		@GetMapping("/{id}")
		public Cozinha buscar(@PathVariable  Long id){
			return  cadastroCozinhaService.buscarOuFalhar(id);
		}

		@ResponseStatus(HttpStatus.CREATED)
		@PostMapping
		public Cozinha salvar(@RequestBody @Valid Cozinha cozinha){
			return cadastroCozinhaService.salvar(cozinha);
		}

		@PutMapping("/{id}")
		public Cozinha atualizar(@RequestBody @Valid Cozinha cozinha,@PathVariable  Long id){
			Cozinha cozinhaAtual = cadastroCozinhaService.buscarOuFalhar(id);
			BeanUtils.copyProperties(cozinha,cozinhaAtual,"id");

			return cozinhaRepository.save(cozinhaAtual);
		}


		@DeleteMapping("/{id}")
		@ResponseStatus(HttpStatus.NO_CONTENT)
		public void remover(@PathVariable  Long id) {
			cadastroCozinhaService.excluir(id);
		}

		
}
