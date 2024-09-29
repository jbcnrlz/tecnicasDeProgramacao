package principal;

import dados.Genero;
import dados.Jogos;

public class SistemaPrincipal {

	public static void main(String[] args) {
		Genero gen = new Genero("Ação");
		if (gen.salvar()) {
			System.out.println("Salvo com sucesso!");
		} else {
			System.out.println("Erro ao salvar!");
		}
		Jogos game = new Jogos("The ultimate adventure of Ximira", 325.12f, gen);
		if (game.salvar()) {
			System.out.println("Salvo com sucesso!");
		} else {
			System.out.println("Erro ao salvar!");
		}		
	}
	
}
