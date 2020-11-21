package model.bean;

public class Point {
	
	private int id;
	private int respostaCerta;
	private int respostaErrada;
	private int falta_responder;
	
	
	public Point(int id, int respostaCerta, int respostaErrada) {
		super();
		this.id = id;
		this.respostaCerta = respostaCerta;
		this.respostaErrada = respostaErrada;
	}
	
	public Point(int id, int falta_responder, int respostaCerta, int respostaErrada) {
		this.id = id;
		this.falta_responder = falta_responder;
		this.respostaCerta = respostaCerta;
		this.respostaErrada = respostaErrada;
	}
	
	public Point(int respostaCerta, int respostaErrada) {
		this.respostaCerta = respostaCerta;
		this.respostaErrada = respostaErrada;
	}


	public Point(int id) {
		super();
		this.id = id;
	}


	public int getId() {
		return id;
	}
	
	public int getFaltaResponder(){
		return falta_responder;
	}

	public int getRespostaCerta() {
		return respostaCerta;
	}


	public int getRespostaErrada() {
		return respostaErrada;
	}


	public void setId(int id) {
		this.id = id;
	}

	public void setFaltaResponder(int falta_responder){
		this.falta_responder = falta_responder;
	}

	public void setRespostaCerta(int respostaCerta) {
		this.respostaCerta = respostaCerta;
	}


	public void setRespostaErrada(int respostaErrada) {
		this.respostaErrada = respostaErrada;
	}


	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Pontuacao [id=");
		builder.append(id);
		builder.append(", falta_responder=");
		builder.append(falta_responder);
		builder.append(", respostaCerta=");
		builder.append(respostaCerta);
		builder.append(", respostaErrada=");
		builder.append(respostaErrada);
		builder.append("]");
		return builder.toString();
	}
	
	
}
