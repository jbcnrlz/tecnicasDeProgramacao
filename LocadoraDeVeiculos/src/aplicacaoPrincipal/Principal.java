package aplicacaoPrincipal;

import dados.Veiculo;
import dados.Carro;
import dados.Marca;

public class Principal {

	public static void main(String[] args) {
		Carro[] cs = new Carro[5];
		Marca m = new Marca("Wolksvagem");
		for (int i = 0;i < cs.length;i++) {
			cs[i] = new Carro(m, "Teste", 2015 + i, "Vermelho");
		}				
		System.out.println(Carro.getQtdCriados());		
	}
	
}

