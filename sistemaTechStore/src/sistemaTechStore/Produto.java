package sistemaTechStore;

import java.text.DecimalFormat;

public class Produto extends Pagavel{
	
	private String nome;
	private double preco;
	
	public Produto(String n, double p) {
		this.setNome(n);
		this.setPreco(p);
	}
	
	public String getNome() {
		return this.nome;
	}
	
	public void setNome(String n) {
		this.nome = n;
	}
	
	public double getPreco() {
		return this.preco;
	}
	
	public void setPreco(double p) {
		if (p >= 0) {
			this.preco = p;
		} else {
			System.err.println("O preço deve ser maior que 0. O valor 0 será atribuído ao atributo.");
		}
	}

	public String getDescricao() {
		DecimalFormat df = new DecimalFormat("#.##");
		return "Nome: " + this.getNome() + "\nPreço: " + df.format(this.getPreco());
	}
	
	@Override
	public double calcularPagamento() {
		return this.getPreco();
	}
	
}
