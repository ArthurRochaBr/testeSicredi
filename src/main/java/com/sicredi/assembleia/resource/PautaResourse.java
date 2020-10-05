package com.sicredi.assembleia.resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.sicredi.assembleia.model.Pauta;
import com.sicredi.assembleia.repository.PautaRepository;

@RestController
@RequestMapping("/pauta")
public class PautaResourse {
	
	@Autowired
	private PautaRepository pautaRepository;

	@GetMapping(produces="application/json")
	public @ResponseBody  Iterable<Pauta> listaPautas(){
		Iterable<Pauta> listaPautas = pautaRepository.findAll();
		return listaPautas;
	}
	
	@PostMapping()
	public Pauta cadastraPauta(@RequestBody Pauta pauta){
		return pautaRepository.save(pauta);
	}
	
	@DeleteMapping()
	public Pauta deletaPauta(@RequestBody Pauta pauta){
		pautaRepository.delete(pauta);
		return pauta;
	}
}
