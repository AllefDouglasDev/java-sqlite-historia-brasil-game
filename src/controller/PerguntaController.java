package controller;

import java.util.List;

import model.bean.Alternativa;
import model.bean.Pergunta;
import model.dao.TabelasInsertsDAO;

public class PerguntaController {
	
	public List<Pergunta> listaPergunta(int idAssunto)
	{
		TabelasInsertsDAO tidao = new TabelasInsertsDAO();
		return tidao.listarPergunta(idAssunto);
	}
	
	public List<Alternativa> listaAlternativa(int idPergunta)
	{
		TabelasInsertsDAO tidao = new TabelasInsertsDAO();
		return tidao.listarAlternativa(idPergunta);
	}
	
}
