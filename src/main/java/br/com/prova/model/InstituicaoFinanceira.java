package br.com.prova.model;

import java.io.Serializable;

public class InstituicaoFinanceira implements Serializable{

	private static final long serialVersionUID = -7025482149134081998L;
	private Long id;
	private Integer agencia;
	private Integer agenciaDestino;
	
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Integer getAgencia() {
		return agencia;
	}
	public void setAgencia(Integer agencia) {
		this.agencia = agencia;
	}
	public Integer getAgenciaDestino() {
		return agenciaDestino;
	}
	public void setAgenciaDestino(Integer agenciaDestino) {
		this.agenciaDestino = agenciaDestino;
	}
}
