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
			return cozinhaRepository.findById(id)
					.orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
		}

		@ResponseStatus(HttpStatus.CREATED)
		@PostMapping
		public Cozinha salvar(@RequestBody Cozinha cozinha){
			return cadastroCozinhaService.salvar(cozinha);
		}

		@PutMapping("/{id}")
		public ResponseEntity<Cozinha>atualizar(@RequestBody Cozinha cozinha,@PathVariable  Long id){
			Optional<Cozinha> cozinhaBD = cozinhaRepository.findById(id);

			if(!cozinhaBD.isEmpty()){
				BeanUtils.copyProperties(cozinha,cozinhaBD.get(),"id");

				cozinhaRepository.save(cozinhaBD.get());
				return ResponseEntity.ok().body(cozinhaBD.get());
			}

			return ResponseEntity.notFound().build();
		}

		@DeleteMapping("/{id}")
		public ResponseEntity<Cozinha> remover(@PathVariable  Long id){
			try{
				cadastroCozinhaService.excluir(id);
				return ResponseEntity.noContent().build();
			}catch (EntidadeEmUsoException e){
				return ResponseEntity.status(HttpStatus.CONFLICT).build();
			}
			catch (EntidadeNaoEncontradaException e){
				return ResponseEntity.notFound().build();
			}
		}

		
}
