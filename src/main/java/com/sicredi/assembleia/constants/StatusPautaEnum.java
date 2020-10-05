package com.sicredi.assembleia.constants;

public enum StatusPautaEnum {
	ABERTA('A'), ENCERRADA('E');
	
	private final char status;

	private StatusPautaEnum(char status) {
		this.status = status;
	}

	public char getStatus() {
		return status;
	}
	
}
