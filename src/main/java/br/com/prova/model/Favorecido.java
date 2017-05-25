package br.com.prova.model;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Favorecido implements Serializable{

	
	private static final long serialVersionUID = -2807421486802572442L;
	
	private Long id;
	private String cpf;
	private String favorecido;
	private InstituicaoFinanceira agencia;
	private String conta;
	private String digitoConta;
	private String contaFormatado;
	private String valor;
	private String valorFormatado;
	private String decimal;
	private String tipoTransacao;
	private Date dataTransacao;
	private String dataFormatada;
	
	public String getCpf() {
		return cpf;
	}
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	public String getFavorecido() {
		return favorecido;
	}
	public void setFavorecido(String favorecido) {
		this.favorecido = favorecido;
	}
	public String getConta() {
		return conta;
	}
	public void setConta(String conta) {
		this.conta = conta;
	}
	public String getValor() {
		return valor;
	}
	public void setValor(String valor) {
		this.valor = valor;
	}
	public String getTipoTransacao() {
		return tipoTransacao;
	}
	public void setTipoTransacao(String tipoTransacao) {
		this.tipoTransacao = tipoTransacao;
	}
	public Date getDataTransacao() {
		return dataTransacao;
	}
	public void setDataTransacao(Date dataTransacao) {
		this.dataTransacao = dataTransacao;
	}
	public String getDigitoConta() {
		return digitoConta;
	}
	public void setDigitoConta(String digitoConta) {
		this.digitoConta = digitoConta;
	}
	public String getContaFormatado() {
		return contaFormatado;
	}
	public void setContaFormatado(String contaFormatado) {
		this.contaFormatado = contaFormatado;
	}
	public String getValorFormatado() {
		return valorFormatado;
	}
	public void setValorFormatado(String valorFormatado) {
		this.valorFormatado = valorFormatado;
	}
	public String getDecimal() {
		return decimal;
	}
	public void setDecimal(String decimal) {
		this.decimal = decimal;
	}
	public String getDataFormatada() {
		SimpleDateFormat format = new SimpleDateFormat("ddmmyy");
		return format.format(dataTransacao);
	}
	public void setDataFormatada(String dataFormatada) {
		this.dataFormatada = dataFormatada;
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
