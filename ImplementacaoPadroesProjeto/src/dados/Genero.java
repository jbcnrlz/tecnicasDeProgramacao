package dados;

public class Genero {
	
	private int id;
	private String nome;
	
	public Genero(String n) {
		this.setNome(n);
		this.setId(0);
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}	
	
	@Override
	public String toString() {
		return this.getNome();
	}
	
}
