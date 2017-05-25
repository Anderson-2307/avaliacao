package br.com.prova.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import org.json.simple.JSONObject;

import br.com.prova.dao.PersistenceDAO;
import br.com.prova.model.Depositante;
import br.com.prova.model.Favorecido;
import br.com.prova.model.InstituicaoFinanceira;

@ViewScoped
@ManagedBean
public class ProvaController {


	private PersistenceDAO persistenceDAO;
	private InstituicaoFinanceira instituicaoFinanceira;
	private List<InstituicaoFinanceira> listaInstituicaoFinanceira;
	private String linhaInformacao;
	private List<String> listaLinhaInformacao;
	private List<String> listaLinhaInformacaoConvertida;
	private Depositante depositante;
	private Favorecido favorecido;
	private String linhaFormatada;
	

	@PostConstruct
	public void init(){
		this.instituicaoFinanceira = new InstituicaoFinanceira();
		this.depositante = new Depositante();
		this.depositante.setAgencia(new InstituicaoFinanceira());
		this.favorecido = new Favorecido();
		this.favorecido.setAgencia(new InstituicaoFinanceira());
		this.listaLinhaInformacao = new ArrayList<String>();
		this.listaLinhaInformacaoConvertida = new ArrayList<String>();
		this.persistenceDAO = new PersistenceDAO();
	}
	
	public void converterLinha(){
		
		JSONObject my_obj = new JSONObject();
		my_obj.put("Depositante", this.linhaInformacao);
		String json_depositante = (String) my_obj.get("Depositante");
		this.preencheDepositante(json_depositante);
	 	this.preencheFavorecido();
	 	this.persistenceDAO.salvarInstituicaoFinanceira(this.instituicaoFinanceira);
	 	this.listaLinhaInformacaoConvertida.add(retornaLinhaConvertida());
	}

	public void converterVariasLinhas(){
	
		for(String depositante: this.listaLinhaInformacao){
			JSONObject my_obj = new JSONObject();
			my_obj.put("Depositante", depositante);
			String json_depositante = (String) my_obj.get("Depositante");
			this.preencheDepositante(json_depositante);
		 	this.preencheFavorecido();
		 	this.persistenceDAO.salvarInstituicaoFinanceira(this.instituicaoFinanceira);
		 	this.listaLinhaInformacaoConvertida.add(retornaLinhaConvertida());
		 	return;
		}
		
		adicionarInstrucao();
		converterVariasLinhas();
		
	}

	public void preencheDepositante(String json_depositante){
		
		this.depositante.setTipoTransacao(json_depositante.substring(0, 3));
		this.depositante.getAgencia().setAgencia(new Integer((json_depositante.substring(3, 7))));
		this.depositante.setConta(json_depositante.substring(7, 12));
		this.depositante.setDigitoConta(json_depositante.substring(12, 13));
		this.depositante.setFavorecido(json_depositante.substring(13, 43));
		this.depositante.setCpf(json_depositante.substring(43, 54));
		this.depositante.setValor(json_depositante.substring(54, 59));
		this.depositante.setDecimalValor(json_depositante.substring(59, 61));
		SimpleDateFormat sdf = new SimpleDateFormat("ddmmyyyy");
	 	String data = json_depositante.substring(61, 69);
	 	try {
			this.depositante.setDataTransacao(sdf.parse(data));
		} catch (ParseException e) {
			e.printStackTrace();
		}
	 	
	}
	
	public void preencheFavorecido(){
		
		this.favorecido.setCpf(this.depositante.getCpf());
	 	this.favorecido.setFavorecido(this.depositante.getFavorecido());
	 	this.favorecido.setAgencia(this.depositante.getAgencia());
	 	this.favorecido.setContaFormatado(this.depositante.getConta() + '-' + this.depositante.getDigitoConta());
	 	this.favorecido.setConta(this.depositante.getConta());
	 	this.favorecido.setDigitoConta(this.depositante.getDigitoConta());
	 	this.favorecido.setValorFormatado(this.depositante.getValor() + ',' + this.depositante.getDecimalValor());
	 	this.favorecido.setValor(this.depositante.getValor());
	 	this.favorecido.setDecimal(this.depositante.getDecimalValor());
	 	this.favorecido.setTipoTransacao(this.depositante.getTipoTransacao());
	 	this.favorecido.setDataTransacao(this.depositante.getDataTransacao());
	 	
	}
	
	public void pesquisar(){
		this.listaInstituicaoFinanceira = this.persistenceDAO.obter(this.instituicaoFinanceira);
		if(this.listaInstituicaoFinanceira != null){
			FacesContext context = FacesContext.getCurrentInstance();  
	        context.addMessage(null, new FacesMessage("Pesquisa retornou " + this.listaInstituicaoFinanceira.size() + " registro(s)"));
		}
		
	}
	
	public void adicionarInstrucao(){
		this.listaLinhaInformacao.add(this.linhaInformacao);
		this.linhaInformacao = null;
		FacesContext context = FacesContext.getCurrentInstance();  
        context.addMessage(null, new FacesMessage("Instrução adicionada com sucesso!"));
	}
	
	public String retornaLinha(){
		return "linha.xhtml";
	}
	
	public String retornaVariasLinhas(){
		return "variasLinhas.xhtml";
	}
	
	public String retornaPesquisa(){
		return "pesquisa.xhtml";
	}
	
	public String index(){
		return "index.xhtml";
	}
	
	public String retornaLinhaConvertida(){
	
		return this.favorecido.getCpf() + this.favorecido.getFavorecido() + this.favorecido.getAgencia().getAgencia() + this.favorecido.getConta() + this.favorecido.getDigitoConta() + this.favorecido.getValor() + this.favorecido.getDecimal() + this.favorecido.getTipoTransacao() + this.favorecido.getDataFormatada();
	}
	
	public String getLinhaInformacao() {
		return linhaInformacao;
	}


	public void setLinhaInformacao(String linhaInformacao) {
		this.linhaInformacao = linhaInformacao;
	}


	public Depositante getDepositante() {
		return depositante;
	}


	public void setDepositante(Depositante depositante) {
		this.depositante = depositante;
	}


	public Favorecido getFavorecido() {
		return favorecido;
	}


	public void setFavorecido(Favorecido favorecido) {
		this.favorecido = favorecido;
	}

	public void setLinhaFormatada(String linhaFormatada) {
		this.linhaFormatada = linhaFormatada;
	}

	public String getLinhaFormatada() {
		return linhaFormatada;
	}

	public List<String> getListaLinhaInformacao() {
		return listaLinhaInformacao;
	}

	public void setListaLinhaInformacao(List<String> listaLinhaInformacao) {
		this.listaLinhaInformacao = listaLinhaInformacao;
	}

	public List<String> getListaLinhaInformacaoConvertida() {
		return listaLinhaInformacaoConvertida;
	}

	public void setListaLinhaInformacaoConvertida(
			List<String> listaLinhaInformacaoConvertida) {
		this.listaLinhaInformacaoConvertida = listaLinhaInformacaoConvertida;
	}

	public InstituicaoFinanceira getInstituicaoFinanceira() {
		return instituicaoFinanceira;
	}

	public void setInstituicaoFinanceira(InstituicaoFinanceira instituicaoFinanceira) {
		this.instituicaoFinanceira = instituicaoFinanceira;
	}

	public List<InstituicaoFinanceira> getListaInstituicaoFinanceira() {
		return listaInstituicaoFinanceira;
	}

	public void setListaInstituicaoFinanceira(
			List<InstituicaoFinanceira> listaInstituicaoFinanceira) {
		this.listaInstituicaoFinanceira = listaInstituicaoFinanceira;
	}

}
