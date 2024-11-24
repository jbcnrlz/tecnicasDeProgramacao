package dados;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import dao.ConnectionManager;
import dao.Persistir;

public class Jogos{

	private int id;
	private String nome;
	private float preco;
	private Genero generoDoJogo;

	public Jogos(String n, float p, Genero g) {
		this.setNome(n);
		this.setPreco(p);
		this.setGeneroDoJogo(g);		
	}
	
	public int getId() {
		return id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public float getPreco() {
		return preco;
	}
	public void setPreco(float preco) {
		this.preco = preco;
	}
	public Genero getGeneroDoJogo() {
		return generoDoJogo;
	}
	public void setGeneroDoJogo(Genero generoDoJogo) {
		this.generoDoJogo = generoDoJogo;
	}

	public boolean salvar() {
		try {
			ConnectionManager cm = ConnectionManager.buildConnection();
			PreparedStatement st = cm.doQuery("INSERT INTO Jogos(nome,preco,Genero_id) values(?,?,?);");
			st.setString(1, this.getNome());
			st.setString(1, this.getNome());
			st.setFloat(2, this.getPreco());
			st.setInt(3, this.getGeneroDoJogo().getId());
			int ri = st.executeUpdate();
			return true;
		} catch (SQLException e) {
			System.err.println("Erro ao salvar");
			e.printStackTrace();
			return false;
		}		

	}
	
}
