package br.com.prova.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import br.com.prova.model.InstituicaoFinanceira;

public class PersistenceDAO {

	
	public void salvarInstituicaoFinanceira(InstituicaoFinanceira instituicao){
		
		String url = "jdbc:postgresql://localhost:5432/avaliacao";
		try	{

			Class.forName("org.postgresql.Driver");
			Connection db = DriverManager.getConnection(url,"postgres","123456");
			db.setAutoCommit(false);
			Statement sq_stmt = db.createStatement();

			String sql = "INSERT INTO INSTITUICAO_FINANCEIRA (AGENCIA, AGENCIA_DESTINO) "+ "VALUES (" + instituicao.getAgencia() + ", " + instituicao.getAgenciaDestino() + ");";

			sq_stmt.execute(sql);
		
			sq_stmt.close();
			db.commit();
			db.close();
			
		}	catch ( java.lang.ClassNotFoundException e ){
		
			System.err.println(e.getMessage());
			
		} catch (SQLException e) {

			e.printStackTrace();
		}
		
	}
	
	public List<InstituicaoFinanceira> obter(InstituicaoFinanceira instituicao){
		String url = "jdbc:postgresql://localhost:5432/avaliacao";
		try	{

			Class.forName("org.postgresql.Driver");
			Connection db = DriverManager.getConnection(url,"postgres","123456");
			db.setAutoCommit(false);
			String sql = "SELECT AGENCIA, AGENCIA_DESTINO FROM INSTITUICAO_FINANCEIRA WHERE AGENCIA = " + instituicao.getAgencia();
			PreparedStatement preparedStatement = null;
			preparedStatement = db.prepareStatement(sql);
			

			ResultSet rs = preparedStatement.executeQuery();
			List<InstituicaoFinanceira> lista = new ArrayList<InstituicaoFinanceira>();
			while (rs.next()) {
				InstituicaoFinanceira i = new InstituicaoFinanceira();
				i.setAgencia(rs.getInt("AGENCIA"));
				i.setAgenciaDestino(rs.getInt("AGENCIA_DESTINO"));
				lista.add(i);
			}
		
			preparedStatement.close();
			db.commit();
			db.close();
			
			return lista;
			
		}	catch ( java.lang.ClassNotFoundException e ){
		
			System.err.println(e.getMessage());
			
		} catch (SQLException e) {

			e.printStackTrace();
		}
		
		return null;
	}
}
