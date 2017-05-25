package br.com.prova.model;

import java.io.Serializable;
import java.util.Date;

public class Depositante implements Serializable{

	private static final long serialVersionUID = 1713754623999728378L;
	private Long id;
	private String tipoTransacao;
	private InstituicaoFinanceira agencia;
	private String conta;
	private String digitoConta;
	private String favorecido;
	private String cpf;
	private String valor;
	private String decimalValor;
	private Date dataTransacao;
	public String getTipoTransacao() {
		return tipoTransacao;
	}
	public void setTipoTransacao(String tipoTransacao) {
		this.tipoTransacao = tipoTransacao;
	}
	public String getConta() {
		return conta;
	}
	public void setConta(String conta) {
		this.conta = conta;
	}
	public String getDigitoConta() {
		return digitoConta;
	}
	public void setDigitoConta(String digitoConta) {
		this.digitoConta = digitoConta;
	}
	public String getFavorecido() {
		return favorecido;
	}
	public void setFavorecido(String favorecido) {
		this.favorecido = favorecido;
	}
	public String getCpf() {
		return cpf;
	}
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	public String getValor() {
		return valor;
	}
	public void setValor(String valor) {
		this.valor = valor;
	}
	public String getDecimalValor() {
		return decimalValor;
	}
	public void setDecimalValor(String decimalValor) {
		this.decimalValor = decimalValor;
	}
	public Date getDataTransacao() {
		return dataTransacao;
	}
	public void setDataTransacao(Date dataTransacao) {
		this.dataTransacao = dataTransacao;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public InstituicaoFinanceira getAgencia() {
		return agencia;
	}
	public void setAgencia(InstituicaoFinanceira agencia) {
		this.agencia = agencia;
	}
	
		
}
