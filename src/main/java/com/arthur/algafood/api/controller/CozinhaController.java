package com.arthur.algafood.api.controller;

import java.util.List;

import com.arthur.algafood.api.assembler.disassembler.CozinhaInputDisassembler;
import com.arthur.algafood.api.assembler.CozinhaModelAssembler;
import com.arthur.algafood.api.model.CozinhaModel;
import com.arthur.algafood.api.model.input.CozinhaInput;
import com.arthur.algafood.domain.service.CadastroCozinhaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import com.arthur.algafood.domain.model.Cozinha;
import com.arthur.algafood.domain.repository.CozinhaRepository;

import javax.validation.Valid;

@RestController
	@RequestMapping("/cozinhas")
	public class CozinhaController {
	@Autowired
	private CozinhaModelAssembler cozinhaModelAssembler;

	@Autowired
	private CozinhaInputDisassembler cozinhaInputDisassembler;
	@Autowired
		private CozinhaRepository cozinhaRepository;

		@Autowired
		private CadastroCozinhaService cadastroCozinha;

	@GetMapping
	public List<CozinhaModel> listar() {
		List<Cozinha> todasCozinhas = cozinhaRepository.findAll();

		return cozinhaModelAssembler.toCollectionModel(todasCozinhas);
	}

	@GetMapping("/{cozinhaId}")
	public CozinhaModel buscar(@PathVariable Long cozinhaId) {
		Cozinha cozinha = cadastroCozinha.buscarOuFalhar(cozinhaId);

		return cozinhaModelAssembler.toModel(cozinha);
	}

	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public CozinhaModel adicionar(@RequestBody @Valid CozinhaInput cozinhaInput) {
		Cozinha cozinha = cozinhaInputDisassembler.toDomainObject(cozinhaInput);
		cozinha = cadastroCozinha.salvar(cozinha);

		return cozinhaModelAssembler.toModel(cozinha);
	}

	@PutMapping("/{cozinhaId}")
	public CozinhaModel atualizar(@PathVariable Long cozinhaId,
								  @RequestBody @Valid CozinhaInput cozinhaInput) {
		Cozinha cozinhaAtual = cadastroCozinha.buscarOuFalhar(cozinhaId);
		cozinhaInputDisassembler.copyToDomainObject(cozinhaInput, cozinhaAtual);
		cozinhaAtual = cadastroCozinha.salvar(cozinhaAtual);

		return cozinhaModelAssembler.toModel(cozinhaAtual);
	}


		@DeleteMapping("/{id}")
		@ResponseStatus(HttpStatus.NO_CONTENT)
		public void remover(@PathVariable  Long id) {
			cadastroCozinha.excluir(id);
		}

		
}
