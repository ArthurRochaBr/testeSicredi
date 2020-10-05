package com.sicredi.assembleia.resource;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.sicredi.assembleia.model.Associado;
import com.sicredi.assembleia.model.ResultadoVotacao;
import com.sicredi.assembleia.model.Voto;
import com.sicredi.assembleia.service.VotacaoService;

@RestController
@RequestMapping("/votacao")
public class VotacaoResourse {
	
	@Autowired
	private VotacaoService votacaoService;
		
	@PostMapping("/iniciarVotacao/{idPauta}")
	public String iniciarVotacao(@PathVariable(value="idPauta") long idPauta){
		return votacaoService.iniciarVotacao(idPauta, null);
	}
	
	@PostMapping("/iniciarVotacaoData/{idPauta}")
	public String iniciarVotacao(@PathVariable(value="idPauta") long idPauta, @RequestBody Date data){
		return votacaoService.iniciarVotacao(idPauta, data);
	}
	
	@PostMapping("/encerrarVotacao/{idPauta}")
	public String encerrarVotacao(@PathVariable(value="idPauta") long idPauta){
		return votacaoService.encerrarVotacao(idPauta, null);
	}
	
	@PostMapping("/encerrarVotacaoData/{idPauta}")
	public String encerrarVotacao(@PathVariable(value="idPauta") long idPauta, @RequestBody Date data){
		return votacaoService.encerrarVotacao(idPauta, data);
	}
	
	@PostMapping("/votar/{idPauta}/{idAssociado}/{statusVoto}")
	public String votar(@PathVariable(value="idPauta") long idPauta, @PathVariable(value="idAssociado") long idAssociado,  @PathVariable(value="statusVoto") char statusVoto){
		Voto voto = new Voto();
		voto.setIdAssociado(idAssociado);
		voto.setIdPauta(idPauta);
		voto.setVoto(statusVoto);
		return votacaoService.votar(voto);
	}
	
	@GetMapping("/resultado/{idPauta}")
	public @ResponseBody  ResultadoVotacao getResultado(@PathVariable(value="idPauta") long idPauta){
		return votacaoService.getResultado(idPauta);
	}
}
