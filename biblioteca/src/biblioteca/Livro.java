package biblioteca;

public class Livro {
	
	private String titulo;
	private String autor;
	private int numeroPaginas;
	
	public String getTitulo() {
		return this.titulo;
	}
	
	public void setTitulo(String t) {
		this.titulo = t;
	}
	
	public String getAutor() {
		return autor;
	}

	public void setAutor(String autor) {
		this.autor = autor;
	}

	public int getNumeroPaginas() {
		return numeroPaginas;
	}

	public void setNumeroPaginas(int numeroPaginas) {
		this.numeroPaginas = numeroPaginas;
	}

	public Livro(String t, String a, int n) {
		this.titulo = t;
		this.autor = a;
		this.numeroPaginas = n;
	}
	
	public Livro(String tit, String a) {
		this.setTitulo(tit);
		this.setAutor(a);
	}
	
	@Override
	public String toString() {
		String exibicao = "Titulo: " + this.titulo + "\n";
		exibicao = exibicao + "Autor: " + this.autor + "\n";
		exibicao = exibicao + "Número de páginas: " + Integer.toString(this.numeroPaginas) + "\n";
		return exibicao;
	}

}
