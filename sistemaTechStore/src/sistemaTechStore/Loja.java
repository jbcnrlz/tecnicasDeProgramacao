package sistemaTechStore;

import java.text.DecimalFormat;
import java.util.LinkedList;

public class Loja {

	private String nome;
	private LinkedList<Produto> estoque;
	
	public void setNome(String n) {
		this.nome = n;
	}
	
	public String getNome(String n) {
		return this.nome;
	}
	
	public Loja(String n) {		
		this.setNome(n);
		this.estoque = new LinkedList<>();
	}
	
	public void adicionarProduto(Produto p) {
		this.estoque.add(p);		
	}
	
	public void listarEstoque() {
		System.out.println("Produtos no estoque: ");
		for(int i = 0;i < this.estoque.size();i += 1) {
			System.out.println(this.estoque.get(i).getDescricao());
		}
	}
	
	public void realizarVenda(Produto p) {
		boolean vendeu = false;
		for(int i = 0;i < this.estoque.size();i += 1) {
			if (this.estoque.get(i).equals(p)) {
				vendeu = true;
				DecimalFormat df = new DecimalFormat("#.##");
				System.out.println("Produto sendo comprado: ");
				System.out.println(p.getDescricao());
				System.out.println("Você deve pagar o valor de: " + df.format(p.calcularPagamento()));
				this.estoque.remove(i);
			}
		}
		if (!vendeu) {
			System.out.println("Produto não está em estoque.");
		}
	}
	
	public void realizarVenda(Produto p, int quantidade) {
		boolean vendeu = false;
		for(int i = 0;i < this.estoque.size();i += 1) {
			if (this.estoque.get(i).equals(p)) {
				vendeu = true;
				DecimalFormat df = new DecimalFormat("#.##");
				System.out.println("Produto sendo comprado: ");
				System.out.println(p.getDescricao());
				System.out.println("Você deve pagar o valor de: " + df.format(p.calcularPagamento()*quantidade));
				this.estoque.remove(i);
			}
		}
		if (!vendeu) {
			System.out.println("Produto não está em estoque.");
		}
	}
	
}
