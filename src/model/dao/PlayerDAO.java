package model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.bean.Subject;
import model.bean.Player;
import model.bean.Question;

public class PlayerDAO {
	
	Connection con = null;
	
	public PlayerDAO(){
		con = DatabaseConnection.getConnection();
	}
	
	public void inserirPontuacao(int idEscola)
	{
		PreparedStatement stmt = null;
		String sql = "INSERT INTO pontuacao(id_escola, resposta_certa, resposta_errada) VALUES(?,0,0)";
		try {
		stmt = con.prepareStatement(sql);
		stmt.setInt(1, idEscola);
		stmt.executeUpdate();
		stmt.close();
		} catch (SQLException e) { 
			e.printStackTrace();
		} finally{
			try { stmt.close(); 
			} catch (SQLException e) {e.printStackTrace(); }
		}
	}
	
	public void inserirJogador(String nome)
	{
		PreparedStatement stmt = null;
		String sql = "INSERT INTO escola(nome) VALUES(?)";
		try {
		stmt = con.prepareStatement(sql);
		stmt.setString(1, nome);
		stmt.executeUpdate();
		stmt.close();
		} catch (SQLException e) { 
			e.printStackTrace();
		} finally{
			try { stmt.close(); 
			} catch (SQLException e) {e.printStackTrace(); }
		}
	}
	
	public List<Player> listarJogadores(){
		List<Player> jogador = new ArrayList<Player>();
		PreparedStatement stmt = null;
		String sql = "SELECT id,nome FROM escola";
		ResultSet rs;
		try {
		stmt = con.prepareStatement(sql);
		rs = stmt.executeQuery();
		while(rs.next()){
			Player jg = new Player(rs.getString("nome"), rs.getInt("id"));
			jogador.add(jg);
		}
		stmt.close();
		return jogador;
		} catch (SQLException e) { 
			e.printStackTrace();
		} finally{
			try { stmt.close(); 
			} catch (SQLException e) {e.printStackTrace(); }
		}
		return jogador;
	}
	
	public int[] assuntoDisponivel(int index)
	{
		int[] assuntosJogados = new int[6];
		PreparedStatement stmt = null;
		String sql = "SELECT id_assunto FROM escola_escolhe_assunto WHERE id_escola = (?)";
		ResultSet rs;
		int contador = 0;
		try {
		stmt = con.prepareStatement(sql);
		stmt.setInt(1, index);
		rs = stmt.executeQuery();
		while(rs.next()){
			assuntosJogados[contador++] = rs.getInt("id_assunto");
		}
		stmt.close();
		return assuntosJogados;
		} catch (SQLException e) { 
			e.printStackTrace();
		} finally{
			try { stmt.close(); 
			} catch (SQLException e) {e.printStackTrace(); }
		}
		return assuntosJogados;
	}
	
	public void alterarAssuntoDisponivel(int idEscola, int idAssunto){
		PreparedStatement stmt = null;
		String sql = "INSERT INTO escola_escolhe_assunto VALUES (?,?)";
		try {
			stmt = con.prepareStatement(sql);
			stmt.setInt(1, idEscola);
			stmt.setInt(2, idAssunto);
			stmt.executeUpdate();
			stmt.close();
		} catch (SQLException e) { 
			e.printStackTrace();
		} finally{
			try { stmt.close(); 
			} catch (SQLException e) {e.printStackTrace(); }
		}	
	}
	
	public List<Player> listaOgranizadaRespostaCerta(){
		List<Player> jogador = new ArrayList<Player>();
		PreparedStatement stmt = null;
		String sql = "SELECT e.nome, e.id "+
				"FROM pontuacao p "+
				"INNER JOIN escola e "+
				"ON e.id = p.id_escola "+
				"ORDER BY p.resposta_certa DESC, p.resposta_errada ASC";
				;
		ResultSet rs;
		try {
		stmt = con.prepareStatement(sql);
		rs = stmt.executeQuery();
		while(rs.next()){
			Player jg = new Player(rs.getString("nome"), rs.getInt("id"));
			jogador.add(jg);
		}
		stmt.close();
		return jogador;
		} catch (SQLException e) { 
			e.printStackTrace();
		} finally{
			try { stmt.close(); 
			} catch (SQLException e) {e.printStackTrace(); }
		}
		return jogador;
	}
	
	public void atualizarPerguntaRespondida(int idPergunta) {
			
		PreparedStatement stmt = null;
		String sql = "UPDATE pergunta SET respondida = 's' WHERE id = (?)";
		
		try {
			stmt = con.prepareStatement(sql);
			stmt.setInt(1, idPergunta);
			stmt.executeUpdate();
			stmt.close();
		} catch (SQLException ex) { throw new RuntimeException(ex);
			// TODO: handle exception
		}finally{
			try{ stmt.close();}catch(SQLException e){
				e.printStackTrace();
			}
		}
			
	}
	
	public void zerarPergunta(int idPergunta) {
		
		PreparedStatement stmt = null;
		String sql = "UPDATE pergunta SET respondida = 'n' WHERE id = (?)";
		
		try {
			stmt = con.prepareStatement(sql);
			stmt.setInt(1, idPergunta);
			stmt.executeUpdate();
			stmt.close();
		} catch (SQLException ex) { throw new RuntimeException(ex);
			// TODO: handle exception
		}finally{
			try{ stmt.close();}catch(SQLException e){
				e.printStackTrace();
			}
		}
			
	}
	
	public List<Question> listarPerguntaRespondida(){
		List<Question> pergunta = new ArrayList<Question>();
		PreparedStatement stmt = null;
		String sql = "SELECT id FROM pergunta WHERE respondida = 's'";
		ResultSet rs;
		try {
		stmt = con.prepareStatement(sql);
		rs = stmt.executeQuery();
		while(rs.next()){
			Question p = new Question(rs.getInt("id"));
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
	
	public void zerarJogadores(){
		PreparedStatement stmt = null;
		String sql = "DELETE FROM escola";
		try {
			stmt = con.prepareStatement(sql);
			stmt.executeUpdate();
			stmt.close();
		} catch (SQLException e) { 
			e.printStackTrace();
		} finally{
			try { stmt.close(); 
			} catch (SQLException e) {e.printStackTrace(); }
		}	
	}
	
	public void zerarPontuacao(){
		PreparedStatement stmt = null;
		String sql = "DELETE FROM pontuacao";
		try {
			stmt = con.prepareStatement(sql);
			stmt.executeUpdate();
			stmt.close();
		} catch (SQLException e) { 
			e.printStackTrace();
		} finally{
			try { stmt.close(); 
			} catch (SQLException e) {e.printStackTrace(); }
		}	
	}
	
	public void zerarEscolaEscolheAssuntos(){
		PreparedStatement stmt = null;
		String sql = "DELETE FROM escola_escolhe_assunto";
		try {
			stmt = con.prepareStatement(sql);
			stmt.executeUpdate();
			stmt.close();
		} catch (SQLException e) { 
			e.printStackTrace();
		} finally{
			try { stmt.close(); 
			} catch (SQLException e) {e.printStackTrace(); }
		}	
	}
}
