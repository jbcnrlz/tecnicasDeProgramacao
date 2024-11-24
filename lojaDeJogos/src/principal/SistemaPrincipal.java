package principal;

import dados.Genero;
import dados.Jogos;
import dao.ConnectionManager;
import dao.PersistirGenero;

public class SistemaPrincipal {

	public static void main(String[] args) {
		Genero gen = new Genero("Ação");
		System.out.println(gen.getId());
		ConnectionManager cm = ConnectionManager.buildConnection();
		PersistirGenero pg = new PersistirGenero(cm, gen);
		pg.salvar();
		System.out.println(gen.getId());
	}
	
}