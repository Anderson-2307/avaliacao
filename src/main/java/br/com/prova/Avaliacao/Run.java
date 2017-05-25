package br.com.prova.Avaliacao;

import java.text.ParseException;
import java.text.SimpleDateFormat;

import org.json.simple.JSONObject;

import br.com.prova.model.Depositante;
import br.com.prova.model.Favorecido;

public class Run {

	
	public static void main(String[] args) throws ParseException{
		 JSONObject my_obj = new JSONObject();
		 my_obj.put("Depositante", "TED0114004851Antonio Alves da Silva        54561747150003256924032017");

		 String json_depositante = (String) my_obj.get("Depositante");
		 
		 Depositante depositante = new Depositante();
		 depositante.setTipoTransacao(json_depositante.substring(0, 3));
		 //depositante.setAgencia(json_depositante.substring(3, 7));
		 depositante.setConta(json_depositante.substring(7, 12));
		 depositante.setDigitoConta(json_depositante.substring(12, 13));
		 depositante.setFavorecido(json_depositante.substring(13, 43));
		 depositante.setCpf(json_depositante.substring(43, 54));
		 depositante.setValor(json_depositante.substring(54, 59));
		 depositante.setDecimalValor(json_depositante.substring(59, 61));
		 SimpleDateFormat sdf = new SimpleDateFormat("ddmmyyyy");
		 String data = json_depositante.substring(61, 69);
		 depositante.setDataTransacao(sdf.parse(data));
		 
		 System.out.println("Objeto Completo -> " + json_depositante);
//		 System.out.println("Tipo Transação -> " + depositante.getTipoTransacao());
//		 System.out.println("Agência -> " + depositante.getAgencia());
//		 System.out.println("Conta -> " + depositante.getConta());
//		 System.out.println("Digito Conta -> " + depositante.getDigitoConta());
//		 System.out.println("Favorecido -> " + depositante.getFavorecido());
//		 System.out.println("CPF -> " + depositante.getCpf());
//		 System.out.println("Valor -> " + depositante.getValor());
//		 System.out.println("Decimal Valor -> " + depositante.getDecimalValor());
//		 System.out.println("Data Transação -> " + depositante.getDataTransacao());
//		 
		 Favorecido favorecido = new Favorecido();
		 favorecido.setCpf(depositante.getCpf());
		 favorecido.setFavorecido(depositante.getFavorecido());
		 //favorecido.setAgencia(depositante.getAgencia());
		 favorecido.setContaFormatado(depositante.getConta() + '-' + depositante.getDigitoConta());
		 favorecido.setConta(depositante.getConta());
		 favorecido.setDigitoConta(depositante.getDigitoConta());
		 favorecido.setValorFormatado(depositante.getValor() + ',' + depositante.getDecimalValor());
		 favorecido.setValor(depositante.getValor());
		 favorecido.setDecimal(depositante.getDecimalValor());
		 favorecido.setTipoTransacao(depositante.getTipoTransacao());
		 favorecido.setDataTransacao(depositante.getDataTransacao());
		 
		 
//		 System.out.println("Tipo Transação -> " + favorecido.getTipoTransacao());
//		 System.out.println("Agência -> " + favorecido.getAgencia());
//		 System.out.println("Conta -> " + favorecido.getConta());
//		 System.out.println("Favorecido -> " + favorecido.getFavorecido());
//		 System.out.println("CPF -> " + favorecido.getCpf());
//		 System.out.println("Valor -> " + favorecido.getValor().replaceFirst("0*", ""));
//		 System.out.println("Data Transação -> " + favorecido.getDataTransacao());
//		 SimpleDateFormat format = new SimpleDateFormat("ddmmyy");
//		 System.out.println("Data Formatada -> " + format.format(favorecido.getDataTransacao()));
		 String objetoEnviado = favorecido.getCpf() + favorecido.getFavorecido() + favorecido.getAgencia() + favorecido.getConta() + favorecido.getDigitoConta() + favorecido.getValor() + favorecido.getDecimal() + favorecido.getTipoTransacao() + favorecido.getDataFormatada();
		
		 System.out.println("Objeto Enviado -> " + objetoEnviado);
	}


}
