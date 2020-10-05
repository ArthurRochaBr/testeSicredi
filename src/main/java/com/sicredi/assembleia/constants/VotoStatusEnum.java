package com.sicredi.assembleia.constants;

public enum VotoStatusEnum {
	SIM('S'), NAO('N');
	
	private final char status;

	private VotoStatusEnum(char status) {
		this.status = status;
	}

	public char getStatus() {
		return status;
	}
}
