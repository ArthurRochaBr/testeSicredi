package com.sicredi.assembleia.resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.sicredi.assembleia.model.Associado;
import com.sicredi.assembleia.repository.AssociadoRepository;

@RestController
@RequestMapping("/associado")
public class AssociadoResourse {
	
	@Autowired
	private AssociadoRepository associadoRepository;

	@GetMapping(produces="application/json")
	public @ResponseBody  Iterable<Associado> listaAssociados(){
		Iterable<Associado> listaAssociados = associadoRepository.findAll();
		return listaAssociados;
	}
	
	@PostMapping()
	public Associado cadastraAssociado(@RequestBody Associado associado){
		return associadoRepository.save(associado);
	}
	
	@DeleteMapping()
	public Associado deletaAssociado(@RequestBody Associado associado){
		associadoRepository.delete(associado);
		return associado;
	}
}
