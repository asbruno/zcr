package com.zcrbend.controller;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.zcrbend.model.Rota;
import com.zcrbend.service.RotaService;

@RestController
@RequestMapping("/api/rota")
@CrossOrigin(origins="*")
public class RotaController {

	private static final Logger log = LoggerFactory.getLogger(RotaController.class);
	
	@Autowired
	private RotaService rotaService;
	
	@GetMapping(value="/listagem", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Response<List<Rota>>> listagemRota() {
		Response<List<Rota>> response = new Response<List<Rota>>();
		List<Rota> listagem = rotaService.carregarTodos();
		if (listagem.isEmpty()) {
			response.getErrors().add("Listagem vazia para Rota(s)");
			return ResponseEntity.badRequest().body(response);
		}
		response.setData(listagem);
		return ResponseEntity.ok(response);
	}
	
	@PostMapping(value="/gravar", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Response<Rota>> gravar(@Valid @RequestBody Rota pNovaRota, BindingResult result) {
		
		Response<Rota> response = new Response<Rota>();
		validarPreGravar(pNovaRota, result);
		if (result.hasErrors()) {
			log.error("Erro(s) validando: {}", result.getAllErrors());
			result.getAllErrors().forEach(error -> response.getErrors().add(error.getDefaultMessage()));
			return ResponseEntity.badRequest().body(response);
		}

		response.setData(this.rotaService.gravar(pNovaRota));
		return ResponseEntity.ok(response);
		
	}
	
	@GetMapping(value="/buscar_descricao/{dsc}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Response<Rota>> buscarPorDescricao(@PathVariable("dsc") String dsc) {
		Response<Rota> response = new Response<Rota>();
		
		//Não vou validar o ID, segue o mesmo principio do gravar.....
		
		Rota fitro = new Rota();
		fitro.setDescricao(dsc); //Não estou considerando formato da descricao informada
		Optional<Rota> rota = this.rotaService.recuperarPorDescricao(fitro); 
		
		if (!rota.isPresent()) {
			response.getErrors().add("Rota não encontrado para a desrição " + fitro.getDescricao());
			return ResponseEntity.badRequest().body(response);
		}

		response.setData(rota.get());
		return ResponseEntity.ok(response);
				
	}
	
	@DeleteMapping(value="/excluir/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Response<Rota>> gravar(@PathVariable("id") Integer id) {
		
		//Não vou validar o ID, segue o mesmo principio do gravar.....
		
		//Aqui logica de exclusão
		
		return null;
				
	}
	
	/*
	 * Validando dados de entrada
	 */
	private void validarPreGravar(Rota pNovaRota, BindingResult result) {
		if (pNovaRota.getId() == null) {
			result.addError(new ObjectError("id", "Id não informado."));
			return;
		}
		log.info("Validando Nova Rota id {}: ", pNovaRota.getId());
	}
}
