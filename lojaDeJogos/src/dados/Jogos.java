package dados;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import dao.Persistir;

public class Jogos implements Persistir{

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

	@Override
	public boolean salvar() {
		try {
			Class.forName("org.mariadb.jdbc.Driver");
			Connection cn = DriverManager.getConnection(
				"jdbc:mariadb://localhost:3306/lojaDeJogos",
				"jbcnrlz",
				"a12b25c54");
			PreparedStatement st = cn.prepareStatement(
				"INSERT INTO Jogos(nome,preco,Genero_id) "
				+ "values(?,?,?);"
			);
			st.setString(1, this.getNome());
			st.setFloat(2, this.getPreco());
			st.setInt(3, this.getGeneroDoJogo().getId());
			int ri = st.executeUpdate();
			cn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return true;
	}

	@Override
	public boolean deletar() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean atualizar() {
		// TODO Auto-generated method stub
		return false;
	}
	
}
