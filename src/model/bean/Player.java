package model.bean;

public class Player {
	private String nome;
	private int id;
	
	public Player() {
		super();
	}
	public Player(int id) {
		super();
		this.id = id;
	}
	public Player(String nome, int id) {
		super();
		this.nome = nome;
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Jogador [nome=");
		builder.append(nome);
		builder.append(", id=");
		builder.append(id);
		builder.append("]");
		return builder.toString();
	}

	
	
}
