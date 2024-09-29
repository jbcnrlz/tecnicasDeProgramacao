package dados;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import dao.Persistir;
import dao.ConnectionManager;

public class Genero implements Persistir{

	private int id;
	private String nome;

	public Genero(String n) {
		this.id = 0;
		this.setNome(n);		
	}
	
	public int getId() {
		if (this.id == 0) {
			try {
				ConnectionManager cm = ConnectionManager.getConnection();
				Connection cn = cm.getConexao();
				PreparedStatement st = cn.prepareStatement(
					"SELECT id FROM Genero WHERE nome = ?;"
				);
				st.setString(1, this.getNome());
				ResultSet rs = st.executeQuery();
				if (rs.next()) {
					this.id = rs.getInt(1);
				}
				
				cn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return id;
	}

	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}

	@Override
	public boolean salvar() {
		try {
			ConnectionManager cm = ConnectionManager.getConnection();
			Connection cn = cm.getConexao();
			PreparedStatement st = cn.prepareStatement(
				"INSERT INTO Genero(nome) "
				+ "values(?);"
			);
			st.setString(1, this.getNome());
			int ri = st.executeUpdate();
			cn.close();
		} catch (SQLException e) {
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
