package model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.bean.Alternative;
import model.bean.Subject;
import model.bean.Question;


public class Repository {
	
	Connection con = null;
	
	public Repository(){
		con = DatabaseConnection.getConnection();
	}
	
	public boolean createTable(String sql){
		PreparedStatement stmt = null;
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
	
	public boolean createPlayer(String nome)
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
	
	public boolean createSubject(String nome)
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
	
	public boolean createQuestion(String pergunta, String respondida, int idAssunto)
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
	
	public boolean createAlternative(int idPergunta, String resposta, String correta)
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
	
	public List<Subject> getSubjects() {
		List<Subject> subjects = new ArrayList<Subject>();
		
		PreparedStatement stmt = null;
		ResultSet rs;

		String sql = "SELECT id, nome FROM assunto";
		
		try {
			stmt = con.prepareStatement(sql);
			rs = stmt.executeQuery();
			
			while(rs.next()){
				subjects.add(new Subject(rs.getInt("id"), rs.getString("nome")));
			}
			
			stmt.close();
			
			return subjects;
		} catch (SQLException e) { 
			e.printStackTrace();
		} finally{
			try { stmt.close(); 
			} catch (SQLException e) {e.printStackTrace(); }
		}
		
		return subjects;
	}
	
	public List<Question> getQuestions(int idAssunto){
		List<Question> pergunta = new ArrayList<Question>();
		PreparedStatement stmt = null;
		String sql = "SELECT id, pergunta FROM pergunta WHERE id_assunto = (?) and respondida = ('n')";
		ResultSet rs;
		try {
		stmt = con.prepareStatement(sql);
		stmt.setInt(1, idAssunto);
		rs = stmt.executeQuery();
		while(rs.next()){
			Question p = new Question(rs.getInt("id"), rs.getString("pergunta"));
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
	
	public List<Alternative> getAlternatives(int idPergunta){
		List<Alternative> alternativa = new ArrayList<Alternative>();
		PreparedStatement stmt = null;
		String sql = "SELECT resposta, correta FROM alternativa WHERE id_pergunta = (?)";
		ResultSet rs;
		try {
		stmt = con.prepareStatement(sql);
		stmt.setInt(1, idPergunta);
		rs = stmt.executeQuery();
		while(rs.next()){
			Alternative a =  new Alternative(1, rs.getString("resposta"), rs.getString("correta"));
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
