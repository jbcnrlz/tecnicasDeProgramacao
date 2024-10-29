package dados;

public class Jogos {

	private int id;
	private String nome;
	private float preco;
	private Genero genero;
	
	public Jogos(String n, float p, Genero g) {
		this.setGenero(g);
		this.setNome(n);
		this.setPreco(p);
		this.id=0;
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

	public float getPreco() {
		return preco;
	}

	public void setPreco(float preco) {
		this.preco = preco;
	}

	public Genero getGenero() {
		return genero;
	}

	public void setGenero(Genero genero) {
		this.genero = genero;
	}
	
	
	
}
