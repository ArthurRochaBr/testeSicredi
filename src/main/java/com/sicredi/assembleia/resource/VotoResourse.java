package com.sicredi.assembleia.resource;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.sicredi.assembleia.model.Voto;
import com.sicredi.assembleia.repository.VotoRepository;

@RestController
@RequestMapping("/voto")
public class VotoResourse {
	
	@Autowired
	private VotoRepository votoRepository;

	@GetMapping(produces="application/json")
	public @ResponseBody  Iterable<Voto> listaVotos(){
		Iterable<Voto> listaVotos = votoRepository.findAll();
		return listaVotos;
	}
	
	@PostMapping()
	public Voto cadastraVoto(@RequestBody Voto voto){
		return votoRepository.save(voto);
	}
	
	@DeleteMapping()
	public Voto deletaVoto(@RequestBody Voto voto){
		votoRepository.delete(voto);
		return voto;
	}
}
