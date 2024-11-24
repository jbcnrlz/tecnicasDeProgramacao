package test;

import static org.junit.jupiter.api.Assertions.*;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import conexaoBanco.GestaoDeConexao;
import conexaoBanco.ManipularGenero;
import conexaoBanco.ManipularJogo;
import dados.Genero;
import dados.Jogos;

class TestManipularJogo {
	
	@BeforeAll
	static void setUpBeforeClass() throws Exception {		
		GestaoDeConexao gc = GestaoDeConexao.constuirConexao("configsTest.txt");
		String[] listaDeJogos = {"Luta","RPG","JRPG","Simulação"};
		for (int i = 0;i < listaDeJogos.length;i += 1) {
			Genero g = new Genero(listaDeJogos[i]);
			ManipularGenero mg = new ManipularGenero(gc, g);
			mg.salvar();			
		}
	}
	
	@AfterAll
	static void cleanUpAfterClass() throws Exception {
		GestaoDeConexao gc = GestaoDeConexao.constuirConexao("configsTest.txt");
		String[] tabelas = {"Jogos","Genero"};
		for (String tb : tabelas) {
			PreparedStatement ps = gc.fazQuery("DELETE from "+tb+";");
			try {
				ps.executeUpdate();
			} catch ( SQLException e) {
				e.printStackTrace();
			}			
		}

		
	}
	
	@Test
	void testSalvar() {
		GestaoDeConexao gc = GestaoDeConexao.constuirConexao("configsTest.txt");
		Genero g = ManipularGenero.getByNome("Luta");
		Jogos j = new Jogos("Jogo bom demais", 50.25f, g);
		ManipularJogo mj = new ManipularJogo(gc, j);
		mj.salvar();
		assertFalse(j.getId() == 0);
		
		PreparedStatement ps = gc.fazQuery(
			"SELECT count(*) FROM Jogos;"
		);
		int countJogo = 0;
		try {			
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				countJogo = rs.getInt(1);
			}
		}catch (SQLException e) {
			System.err.println("Erro ao buscar o ID");
			e.printStackTrace();
		}
		assertTrue(countJogo > 0);
		
	}

	@Test
	void testDeletar() {
		fail("Not yet implemented");
	}

	@Test
	void testAtualizar() {
		fail("Not yet implemented");
	}

	@Test
	void testGetID() {
		fail("Not yet implemented");
	}

}
