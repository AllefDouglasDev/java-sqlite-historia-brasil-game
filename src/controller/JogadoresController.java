package controller;

import java.util.ArrayList;
import java.util.List;

import model.bean.Player;
import model.bean.Question;
import model.dao.PlayerDAO;

public class JogadoresController {
	private PlayerDAO jdao = new PlayerDAO();
	
	public void insertJogador(String nome)
	{
		jdao.inserirJogador(nome);
	}
	
	public void insertPontuacao(int idEscola)
	{
		jdao.inserirPontuacao(idEscola);
	}
	
	public List<Player> listarJogadores()
	{
		return jdao.listarJogadores();
	}
	
	public List<Player> listarlistaOgranizadaRespostaCerta(){
		return jdao.listaOgranizadaRespostaCerta();
	}
	
	public int[] assuntoDisponivel(int idEscola)
	{
		PlayerDAO jdao = new PlayerDAO();
		return jdao.assuntoDisponivel(idEscola);
	}
	
	public void alterarAssuntoDisponivel(int idEscola, int idAssunto)
	{
		jdao.alterarAssuntoDisponivel(idEscola, idAssunto);
	}
	
	public void atualizarPerguntaRespondida(int idPergunta)
	{
		jdao.atualizarPerguntaRespondida(idPergunta);
	}
	
	public void zerarGame(){
		jdao.zerarJogadores();
		jdao.zerarPontuacao();
		jdao.zerarEscolaEscolheAssuntos();
		
		List<Question> lp = new ArrayList<Question>();
		lp.addAll(jdao.listarPerguntaRespondida());
		
		for (int i = 0; i < lp.size(); i++) {
			jdao.zerarPergunta(lp.get(i).getId());
		}
	}
}
