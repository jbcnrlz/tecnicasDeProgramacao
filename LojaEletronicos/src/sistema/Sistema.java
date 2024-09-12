package sistema;

import produtos.Computador;
import produtos.Eletronicos;
import produtos.Smartphone;
import produtos.Televisor;

public class Sistema {
	public static void main(String[] args) {
		Eletronicos tvSamsung = new Televisor("Samsung", 55, "4K", true);
		Eletronicos iPhone = new Smartphone("Apple", "iPhone 13", 3500, true);
		Eletronicos compDell = new Computador("Dell", "Intel i7", 16, false);
		
		System.out.println(tvSamsung.exibir());
		System.out.println(iPhone.exibir());
		System.out.println(compDell.exibir());
	}
}
