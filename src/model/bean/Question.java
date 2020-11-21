package model.bean;

public class Question {
	private int id;
	private String pergunta;
	private String respondida;
	
	public Question() {
		
	}
	
	public Question(int id) {
		this.id = id;
	}
	
	public Question(int id, String pergunta) {
		super();
		this.id = id;
		this.pergunta = pergunta;
	}
	
	public Question(String pergunta, String respondida) {
		super();
		this.pergunta = pergunta;
		this.respondida = respondida;
	}

	public Question(int id, String pergunta, String respondida) {
		super();
		this.id = id;
		this.pergunta = pergunta;
		this.respondida = respondida;
	}
	
	public int getId() {
		return id;
	}

	public String getPergunta() {
		return pergunta;
	}

	public String getRespondida() {
		return respondida;
	}

	public void setId(int id) {
		this.id = id;
	}

	public void setPergunta(String pergunta) {
		this.pergunta = pergunta;
	}

	public void setRespondida(String respondida) {
		this.respondida = respondida;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Pergunta [id=").append(id).append(", pergunta=").append(pergunta).append(", respondida=")
				.append(respondida).append("]");
		return builder.toString();
	}
	
	
	
	
}
