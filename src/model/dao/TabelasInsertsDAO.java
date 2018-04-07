package model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.bean.Alternativa;
import model.bean.Pergunta;


public class TabelasInsertsDAO {
	
	Connection con = null;
	
	public TabelasInsertsDAO(){
		con = ConexaoBanco.obterConexao();
	}
	
	public boolean criarTabela(String tabela){
		PreparedStatement stmt = null;
		String sql = tabela;
		try {
			stmt = con.prepareStatement(sql);
			stmt.executeUpdate();
			stmt.close();
			return true;
		} catch (SQLException e) { 
			e.printStackTrace();
		} finally{
			try { stmt.close(); 
			} catch (SQLException e) {e.printStackTrace(); }
		}	
		return false;
	}
	
	public boolean inserirJogador(String nome)
	{
		PreparedStatement stmt = null;
		String sql = "INSERT INTO escola(nome) VALUES(?);";
		try {
		stmt = con.prepareStatement(sql);
		stmt.setString(1, nome);
		stmt.executeUpdate();
		stmt.close();
		return true;
		} catch (SQLException e) { 
			e.printStackTrace();
		} finally{
			try { stmt.close(); 
			} catch (SQLException e) {e.printStackTrace(); }
		}
		return false;
	}
	
	public boolean inserirAssunto(String nome)
	{
		PreparedStatement stmt = null;
		String sql = "INSERT INTO assunto(nome) VALUES(?);";
		try {
		stmt = con.prepareStatement(sql);
		stmt.setString(1, nome);
		stmt.executeUpdate();
		stmt.close();
		return true;
		} catch (SQLException e) { 
			e.printStackTrace();
		} finally{
			try { stmt.close(); 
			} catch (SQLException e) {e.printStackTrace(); }
		}
		return false;
	}
	
	public boolean inserirPergunta(String pergunta, String respondida, int idAssunto)
	{
		PreparedStatement stmt = null;
		String sql = "INSERT INTO pergunta(pergunta, respondida, id_assunto) VALUES(?,?,?);";
		try {
		stmt = con.prepareStatement(sql);
		stmt.setString(1, pergunta);
		stmt.setString(2, respondida);
		stmt.setInt(3, idAssunto);
		stmt.executeUpdate();
		stmt.close();
		return true;
		} catch (SQLException e) { 
			e.printStackTrace();
		} finally{
			try { stmt.close(); 
			} catch (SQLException e) {e.printStackTrace(); }
		}
		return false;
	}
	
	public boolean inserirResposta(int idPergunta, String resposta, String correta)
	{
		PreparedStatement stmt = null;
		String sql = "INSERT INTO alternativa(id_pergunta, resposta, correta) VALUES(?,?,?);";
		try {
		stmt = con.prepareStatement(sql);
		stmt.setInt(1, idPergunta);
		stmt.setString(2, resposta);
		stmt.setString(3, correta);
		stmt.executeUpdate();
		stmt.close();
		return true;
		} catch (SQLException e) { 
			e.printStackTrace();
		} finally{
			try { stmt.close(); 
			} catch (SQLException e) {e.printStackTrace(); }
		}
		return false;
	}
	
	public List<Pergunta> listarPergunta(int idAssunto){
		List<Pergunta> pergunta = new ArrayList<Pergunta>();
		PreparedStatement stmt = null;
		String sql = "SELECT id, pergunta FROM pergunta WHERE id_assunto = (?) and respondida = ('n')";
		ResultSet rs;
		try {
		stmt = con.prepareStatement(sql);
		stmt.setInt(1, idAssunto);
		rs = stmt.executeQuery();
		while(rs.next()){
			Pergunta p = new Pergunta(rs.getInt("id"), rs.getString("pergunta"));
			pergunta.add(p);
		}
		stmt.close();
		return pergunta;
		} catch (SQLException e) { 
			e.printStackTrace();
		} finally{
			try { stmt.close(); 
			} catch (SQLException e) {e.printStackTrace(); }
		}
		return pergunta;
	}
	
	public List<Alternativa> listarAlternativa(int idPergunta){
		List<Alternativa> alternativa = new ArrayList<Alternativa>();
		PreparedStatement stmt = null;
		String sql = "SELECT resposta, correta FROM alternativa WHERE id_pergunta = (?)";
		ResultSet rs;
		try {
		stmt = con.prepareStatement(sql);
		stmt.setInt(1, idPergunta);
		rs = stmt.executeQuery();
		while(rs.next()){
			Alternativa a =  new Alternativa(1, rs.getString("resposta"), rs.getString("correta"));
			alternativa.add(a);
		}
		stmt.close();
		return alternativa;
		} catch (SQLException e) { 
			e.printStackTrace();
		} finally{
			try { stmt.close(); 
			} catch (SQLException e) {e.printStackTrace(); }
		}
		return alternativa;
	}
	
}
