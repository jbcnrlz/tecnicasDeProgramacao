package sistemaTechStore;

public class SistemaLoja {

	public static void main(String[] args) {
		Loja l = new Loja("TechStore");
		
		Produto ps5 = new Eletronico("Playstation 5", 4145.00, "Sony");
		Produto iPhone = new Smartphone("iPhone 15 Pro Max", 7999.00, "Apple", 256);
		Produto s24 = new Smartphone("Galaxy S24 Ultra", 9899.10, "Samsung", 512);
		
		l.adicionarProduto(ps5);
		l.adicionarProduto(iPhone);
		l.adicionarProduto(s24);
		
		System.out.println();
		
		l.listarEstoque();
		
		System.out.println();
		l.realizarVenda(ps5);
		System.out.println();
		l.realizarVenda(iPhone,3);
		System.out.println();
		l.realizarVenda(ps5);

		
	}
	
}
