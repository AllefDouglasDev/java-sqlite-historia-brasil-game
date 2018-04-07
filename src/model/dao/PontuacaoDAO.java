package model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.bean.Pontuacao;

public class PontuacaoDAO {
	Connection con = null;
	
	public PontuacaoDAO(){
		con = ConexaoBanco.obterConexao();
	}
	
	public Pontuacao buscarPontuacaoJogador(int idEscola){
		Pontuacao pontuacao = null;
		PreparedStatement stmt = null;
		String sql = "SELECT resposta_certa, resposta_errada FROM pontuacao WHERE id_escola = (?)";
		ResultSet rs;
		try {
		stmt = con.prepareStatement(sql);
		stmt.setInt(1, idEscola);
		rs = stmt.executeQuery();
		while(rs.next()){
			pontuacao = new Pontuacao(rs.getInt("resposta_certa"), rs.getInt("resposta_errada"));
		}
		stmt.close();
		return pontuacao;
		} catch (SQLException e) { 
			e.printStackTrace();
		} finally{
			try { stmt.close(); 
			} catch (SQLException e) {e.printStackTrace(); }
		}
		return pontuacao;
	}
	
	public List<Pontuacao> listarPontuacao(){
		List<Pontuacao> pontuacao = new ArrayList<Pontuacao>();
		PreparedStatement stmt = null;
		String sql = "SELECT id,resposta_certa,resposta_errada FROM pontuacao";
		ResultSet rs;
		try {
		stmt = con.prepareStatement(sql);
		rs = stmt.executeQuery();
		while(rs.next()){
			Pontuacao pt = new Pontuacao(rs.getInt("resposta_certa"), rs.getInt("resposta_errada"));
			pontuacao.add(pt);
		}
		stmt.close();
		return pontuacao;
		} catch (SQLException e) { 
			e.printStackTrace();
		} finally{
			try { stmt.close(); 
			} catch (SQLException e) {e.printStackTrace(); }
		}
		return pontuacao;
	}
	
	public List<Pontuacao> listaOgranizadaRespostaCerta(){
		List<Pontuacao> pontuacao = new ArrayList<Pontuacao>();
		PreparedStatement stmt = null;
		String sql = "select p.resposta_certa, p.resposta_errada, "+
				"(select 5-(p.resposta_certa + p.resposta_errada)) as falta_responder "+
				"from pontuacao p "+
				"inner join escola e "+
				"on e.id = p.id_escola "+
				"order by p.resposta_certa DESC, p.resposta_errada ASC";
				;
		ResultSet rs;
		try {
		stmt = con.prepareStatement(sql);
		rs = stmt.executeQuery();
		while(rs.next()){
			Pontuacao pt = new Pontuacao(rs.getInt("falta_responder"), rs.getInt("resposta_certa"), rs.getInt("resposta_errada"));
			pontuacao.add(pt);
		}
		stmt.close();
		return pontuacao;
		} catch (SQLException e) { 
			e.printStackTrace();
		} finally{
			try { stmt.close(); 
			} catch (SQLException e) {e.printStackTrace(); }
		}
		return pontuacao;
	}
	
	public void atualizarPontuacao(int idEscola, int resposta) {
		
		Pontuacao pt = buscarPontuacaoJogador(idEscola);
		
		PreparedStatement stmt = null;
		String sql = "";
		if(resposta == 1)
			sql = "UPDATE pontuacao SET resposta_certa = "+ (pt.getRespostaCerta() + 1) +" WHERE id = (?)";
		else
			sql = "UPDATE pontuacao SET resposta_errada = "+ (pt.getRespostaErrada() + 1) +" WHERE id = (?)";
		try {
			stmt = con.prepareStatement(sql);
			stmt.setInt(1, idEscola);
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

}