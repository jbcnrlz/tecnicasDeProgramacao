package locadora;

public class Montadora {

	private String nome;
	private String paisDeOrigem;
	
	public Montadora(String n, String p) {
		this.setNome(n);
		this.setPaisDeOrigem(p);
	}
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getPaisDeOrigem() {
		return paisDeOrigem;
	}
	public void setPaisDeOrigem(String paisDeOrigem) {
		this.paisDeOrigem = paisDeOrigem;
	}
	
	@Override
	public String toString() {
		return this.getNome() + " - " + this.getPaisDeOrigem();
	}
	
}
