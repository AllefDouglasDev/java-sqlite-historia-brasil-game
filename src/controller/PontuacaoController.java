package controller;

import java.util.List;

import model.bean.Pontuacao;
import model.dao.JogadoresDAO;
import model.dao.PontuacaoDAO;

public class PontuacaoController {
	
	PontuacaoDAO ptdao = new PontuacaoDAO();
	
	public List<Pontuacao> listarPontuacao(){
		return ptdao.listarPontuacao();
	}
	
	public List<Pontuacao> listaOgranizadaRespostaCerta(){
		
		return ptdao.listaOgranizadaRespostaCerta();
	}
	/**
	 * Altera a pontuação do jogador.
	 * Escolha 1 para resposta certa
	 * Escolha 2 para resposta errada
	 * 
	 * @param idEscola
	 * @param resposta
	 */
	public void atualizarPontuacao(int idEscola, int resposta)
	{
		ptdao.atualizarPontuacao(idEscola, resposta);
	}
	
}
