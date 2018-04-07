package model.bean;

public class Pergunta {
	private int id;
	private String pergunta;
	private String respondida;
	
	public Pergunta() {
		
	}
	
	public Pergunta(int id) {
		this.id = id;
	}
	
	public Pergunta(int id, String pergunta) {
		super();
		this.id = id;
		this.pergunta = pergunta;
	}
	
	public Pergunta(String pergunta, String respondida) {
		super();
		this.pergunta = pergunta;
		this.respondida = respondida;
	}

	public Pergunta(int id, String pergunta, String respondida) {
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
