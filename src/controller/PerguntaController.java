package controller;

import java.util.List;

import model.bean.Alternative;
import model.bean.Question;
import model.dao.Repository;

public class PerguntaController {
	
	public List<Question> listaPergunta(int idAssunto)
	{
		Repository tidao = new Repository();
		return tidao.getQuestions(idAssunto);
	}
	
	public List<Alternative> listaAlternativa(int idPergunta)
	{
		Repository tidao = new Repository();
		return tidao.getAlternatives(idPergunta);
	}
	
}
