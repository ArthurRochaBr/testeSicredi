package com.sicredi.assembleia.service;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sicredi.assembleia.constants.StatusPautaEnum;
import com.sicredi.assembleia.constants.VotoStatusEnum;
import com.sicredi.assembleia.model.Pauta;
import com.sicredi.assembleia.model.ResultadoVotacao;
import com.sicredi.assembleia.model.Voto;
import com.sicredi.assembleia.repository.PautaRepository;
import com.sicredi.assembleia.repository.VotoRepository;

@Service
public class VotacaoService {

	@Autowired
	private PautaRepository pautaRepository;
	
	@Autowired
	private VotoRepository votoRepository;

	public String iniciarVotacao(long idPauta, Date inicio) {
		Pauta pauta = null;

		try {
			pauta = pautaRepository.getOne(idPauta);
		} catch (Exception e) {
			return "Não foi possivel encontrar a pauta de ID =" + idPauta + ", tente novamente!";
		}

		if (pauta.getEncerramento() != null) {
			return "A votação da pauta ''" + pauta.getNome() + "'', já foi finalizada";
		} else if (pauta.getInicio() != null) {
			return "A votação da pauta ''" + pauta.getNome() + "'', já foi iniciada";
		}

		if (inicio != null) {
			pauta.setInicio(inicio);
		} else {
			pauta.setInicio(new Date());
		}

		pauta.setStatus(StatusPautaEnum.ABERTA.getStatus());

		pautaRepository.save(pauta);

		return "Votação Iniciada com sucesso";
	}
	
	public String encerrarVotacao(long idPauta, Date encerramento) {
		Pauta pauta = null;
		
		try {
			pauta = pautaRepository.getOne(idPauta);
		} catch (Exception e) {
			return "Não foi possivel encontrar a pauta de ID =" + idPauta + ", tente novamente!";
		}
		
		if(pauta.getEncerramento() != null) {
			return "A votação da pauta ''" + pauta.getNome() + "'', já foi finalizada";
		} else if(pauta.getInicio() == null) {
			return "A votação da pauta ''" + pauta.getNome() + "'', ainda não foi iniciada";
		}
		
		if(encerramento != null) {
			pauta.setEncerramento(encerramento);
		} else {
			pauta.setEncerramento(new Date());
		}
		
		pauta.setStatus(StatusPautaEnum.ENCERRADA.getStatus());
		
		pautaRepository.save(pauta);
		
		return "Votação Encerrada com sucesso";
	}

	public String votar(Voto voto) {
		if(!(voto.getVoto() == VotoStatusEnum.SIM.getStatus()) && !(voto.getVoto() == VotoStatusEnum.NAO.getStatus())) {
			return "Esse voto não é válido!";
		}
		
		Iterable<Voto> votos = votoRepository.findAll();
		for(Voto v : votos) {
			if(v.getIdPauta() == voto.getIdPauta()) {
				if(v.getIdAssociado() == voto.getIdAssociado()) {
					return "Esse voto já foi computado";
				}
			}
		}
		
		votoRepository.save(voto);
		return "Voto computado com sucesso";
	}

	public ResultadoVotacao getResultado(long idPauta) {
		ResultadoVotacao resultadoVotacao = new ResultadoVotacao();
		Pauta pauta = pautaRepository.getOne(idPauta);
		if(pauta.getInicio() == null) {
			resultadoVotacao.setResultado("Dados indisponiveis, votação ainda não iniciada");
			return resultadoVotacao;
		} else if(pauta.getEncerramento() == null) {
			resultadoVotacao.setResultado("Dados indisponiveis, votação ainda não encerrada");
			return resultadoVotacao;
		}
		
		Iterable<Voto> votos = votoRepository.findAll();
		for(Voto v : votos) {
			if(v.getVoto() == VotoStatusEnum.SIM.getStatus()) {
				resultadoVotacao.setQuantidadeVotosSim(resultadoVotacao.getQuantidadeVotosSim() + 1);
			} else if(v.getVoto() == VotoStatusEnum.NAO.getStatus()) {
				resultadoVotacao.setQuantidadeVotosNao(resultadoVotacao.getQuantidadeVotosNao() + 1);
			}
			resultadoVotacao.setQuantidadeVotosTotal(resultadoVotacao.getQuantidadeVotosTotal() + 1);
		}

		resultadoVotacao.setPorcentagemSim((double) ((resultadoVotacao.getQuantidadeVotosSim() * 100) / resultadoVotacao.getQuantidadeVotosTotal()));
		resultadoVotacao.setPorcentagemNao((double) ((resultadoVotacao.getQuantidadeVotosNao() * 100) / resultadoVotacao.getQuantidadeVotosTotal()));
		
		resultadoVotacao.setResultado("A pauta " + pauta.getDescricao()
				+ " teve um total de " + resultadoVotacao.getQuantidadeVotosTotal() + " votos válidos,"
				+ "cujo Sim : " + resultadoVotacao.getQuantidadeVotosSim() + " - " + resultadoVotacao.getPorcentagemSim() + " %"
				+ " e Não : " + resultadoVotacao.getQuantidadeVotosNao() + " - " + resultadoVotacao.getPorcentagemNao() + " %");
		
		return resultadoVotacao;
	}
}
