package controller;

import java.util.List;

import model.bean.Point;
import model.dao.PlayerDAO;
import model.dao.PointDAO;

public class PontuacaoController {
	
	PointDAO ptdao = new PointDAO();
	
	public List<Point> listarPontuacao(){
		return ptdao.listarPontuacao();
	}
	
	public List<Point> listaOgranizadaRespostaCerta(){
		
		return ptdao.listaOgranizadaRespostaCerta();
	}
	/**
	 * Altera a pontua��o do jogador.
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
