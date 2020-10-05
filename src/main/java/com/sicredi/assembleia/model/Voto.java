package com.sicredi.assembleia.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.sun.istack.NotNull;

@Entity
public class Voto {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@NotNull
	private long idPauta;
	
	@NotNull
	private long idAssociado;
	
	@NotNull
	private char voto;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public long getIdPauta() {
		return idPauta;
	}

	public void setIdPauta(long idPauta) {
		this.idPauta = idPauta;
	}

	public long getIdAssociado() {
		return idAssociado;
	}

	public void setIdAssociado(long idAssociado) {
		this.idAssociado = idAssociado;
	}

	public char getVoto() {
		return voto;
	}

	public void setVoto(char voto) {
		this.voto = voto;
	}

}
