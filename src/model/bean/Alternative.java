package model.bean;

public class Alternative {
	
	private int id;
	private String resposta;
	private String correta;
	
	public Alternative(int id) {
		super();
		this.id = id;
	}
	public Alternative(int id, String resposta, String correta) {
		super();
		this.id = id;
		this.resposta = resposta;
		this.correta = correta;
	}
	
	public int getId() {
		return id;
	}
	public String getResposta() {
		return resposta;
	}
	public String getCorreta() {
		return correta;
	}
	public void setId(int id) {
		this.id = id;
	}
	public void setResposta(String resposta) {
		this.resposta = resposta;
	}
	public void setCorreta(String correta) {
		this.correta = correta;
	}
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Alternativa [id=");
		builder.append(id);
		builder.append(", resposta=");
		builder.append(resposta);
		builder.append(", correta=");
		builder.append(correta);
		builder.append("]");
		return builder.toString();
	}
	
	
	
}
