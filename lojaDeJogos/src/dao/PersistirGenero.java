package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;

import dados.Genero;

public class PersistirGenero extends PersistirDados{
	
	public PersistirGenero(ConnectionManager cm, Object o) {
		super(cm, o);
	}

	@Override
	public boolean salvar() {
		Genero g = Genero.class.cast(this.getOb());
		try {			
			PreparedStatement st = this.getCm().doQuery("INSERT INTO Genero(nome) values(?);");
			st.setString(1, g.getNome());
			st.executeUpdate();
			g.setId(this.getID());
			return true;
		} catch (SQLException e) {
			System.err.println("Erro ao salvar");
			e.printStackTrace();
			return false;
		}		

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

	@Override
	public int getID() {
		Genero g = Genero.class.cast(this.getOb());
		try {
			PreparedStatement st = this.getCm().doQuery("SELECT id FROM Genero WHERE nome = ?;");
			st.setString(1, g.getNome());
			ResultSet rs = st.executeQuery();
			if (rs.next()) {
				return rs.getInt(1);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();			
		}			
		return -1;
	}

	@Override
	public LinkedList<Object> findAll(String[] campos, String operador) {
		// TODO Auto-generated method stub
		return null;
	}
	
	

}
