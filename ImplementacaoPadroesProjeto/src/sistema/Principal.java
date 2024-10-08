package sistema;

import conexaoBanco.GestaoDeConexao;
import conexaoBanco.ManipularGenero;
import dados.Genero;

public class Principal {

	public static void main(String[] args) {
		Genero g = new Genero("Acariciar Gatinhos");
		ManipularGenero mg = new ManipularGenero(GestaoDeConexao.constuirConexao(), g);
		if (mg.salvar()) {
			System.out.println("Salvo com sucesso!");
			System.out.println(g.getId());
		}else {
			System.out.println("Não foi possível salvar!");
		}
	}
	
}
