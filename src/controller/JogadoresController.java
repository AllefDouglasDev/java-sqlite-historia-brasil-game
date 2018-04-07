package controller;

import java.util.ArrayList;
import java.util.List;

import model.bean.Jogador;
import model.bean.Pergunta;
import model.dao.JogadoresDAO;

public class JogadoresController {
	private JogadoresDAO jdao = new JogadoresDAO();
	
	public void insertJogador(String nome)
	{
		jdao.inserirJogador(nome);
	}
	
	public void insertPontuacao(int idEscola)
	{
		jdao.inserirPontuacao(idEscola);
	}
	
	public List<Jogador> listarJogadores()
	{
		return jdao.listarJogadores();
	}
	
	public List<Jogador> listarlistaOgranizadaRespostaCerta(){
		return jdao.listaOgranizadaRespostaCerta();
	}
	
	public int[] assuntoDisponivel(int idEscola)
	{
		JogadoresDAO jdao = new JogadoresDAO();
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
		
		List<Pergunta> lp = new ArrayList<Pergunta>();
		lp.addAll(jdao.listarPerguntaRespondida());
		
		for (int i = 0; i < lp.size(); i++) {
			jdao.zerarPergunta(lp.get(i).getId());
		}
	}
}
