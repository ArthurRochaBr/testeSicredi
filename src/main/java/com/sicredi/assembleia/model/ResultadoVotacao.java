package com.sicredi.assembleia.model;

public class ResultadoVotacao {
	
	private int quantidadeVotosTotal;
	
	private int quantidadeVotosSim;
	
	private int quantidadeVotosNao;
	
	private Double porcentagemSim;
	
	private Double porcentagemNao;
	
	private String resultado;

	public int getQuantidadeVotosTotal() {
		return quantidadeVotosTotal;
	}

	public void setQuantidadeVotosTotal(int quantidadeVotosTotal) {
		this.quantidadeVotosTotal = quantidadeVotosTotal;
	}

	public int getQuantidadeVotosSim() {
		return quantidadeVotosSim;
	}

	public void setQuantidadeVotosSim(int quantidadeVotosSim) {
		this.quantidadeVotosSim = quantidadeVotosSim;
	}

	public int getQuantidadeVotosNao() {
		return quantidadeVotosNao;
	}

	public void setQuantidadeVotosNao(int quantidadeVotosNao) {
		this.quantidadeVotosNao = quantidadeVotosNao;
	}

	public Double getPorcentagemSim() {
		return porcentagemSim;
	}

	public void setPorcentagemSim(Double porcentagemSim) {
		this.porcentagemSim = porcentagemSim;
	}

	public Double getPorcentagemNao() {
		return porcentagemNao;
	}

	public void setPorcentagemNao(Double porcentagemNao) {
		this.porcentagemNao = porcentagemNao;
	}

	public String getResultado() {
		return resultado;
	}

	public void setResultado(String resultado) {
		this.resultado = resultado;
	}
	
	
}
