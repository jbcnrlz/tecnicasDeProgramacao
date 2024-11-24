package conexaoBanco;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;

import dados.Genero;

public class ManipularGenero extends ManipularItemBanco{

	public ManipularGenero(GestaoDeConexao gc, Object oo) {
		super(gc, oo); 
	}

	@Override
	public boolean salvar() {
		Genero g = Genero.class.cast(this.getO());
		PreparedStatement ps = this.getCc().fazQuery("INSERT INTO Genero(nome) values(?);");
		try {
			ps.setString(1, g.getNome());
			ps.executeUpdate();
			g.setId(this.getID());
		}catch (SQLException e) {
			System.err.println("Erro ao salvar");
			e.printStackTrace();
			return false;			
		}		
		return true;
	}

	@Override
	public boolean deletar() {
		Genero g = Genero.class.cast(this.getO());
		PreparedStatement ps = this.getCc().fazQuery("DELETE FROM Genero WHERE id = ?;");				
		try {
			ps.setInt(1, g.getId());
			ps.executeUpdate();			
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}

	@Override
	public boolean atualizar() {
		Genero g = Genero.class.cast(this.getO());
		PreparedStatement ps = this.getCc().fazQuery("UPDATE Genero SET nome = ? WHERE id = ?;");
		try {
			ps.setString(1, g.getNome());
			ps.setInt(2, g.getId());
			System.out.println(ps);
			boolean rs = ps.execute();
		}catch (SQLException e) {
			System.err.println("Erro ao atualizar");
			e.printStackTrace();
			return false;			
		}		
		return true;
	}

	@Override
	public int getID() {
		Genero g = Genero.class.cast(this.getO());
		PreparedStatement ps = this.getCc().fazQuery("SELECT id FROM Genero where nome = ? ORDER BY id DESC;");
		try {
			ps.setString(1, g.getNome());
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				return rs.getInt(1);
			}
		}catch (SQLException e) {
			System.err.println("Erro ao buscar o ID");
			e.printStackTrace();
		}
		return 0;
	}
	
	public static LinkedList<Genero> getAll(){
		GestaoDeConexao gc = GestaoDeConexao.constuirConexao();
		PreparedStatement ps = gc.fazQuery("SELECT id, nome FROM Genero;");
		ResultSet rs;
		LinkedList<Genero> llg = new LinkedList<Genero>();
		try {
			rs = ps.executeQuery();
			while (rs.next()) {
				Genero g = new Genero(rs.getString(2));
				g.setId(rs.getInt(1));
				llg.add(g);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return llg;		
	}
	
	public static Genero getByID(int id) {
		GestaoDeConexao gc = GestaoDeConexao.constuirConexao();
		PreparedStatement ps = gc.fazQuery("SELECT id, nome FROM Genero WHERE id = ?;");		
		ResultSet rs;
		try {
			ps.setInt(1, id);
			rs = ps.executeQuery();
			while (rs.next()) {				
				Genero g = new Genero(rs.getString(2));
				g.setId(rs.getInt(1));
				return g;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	public static Genero getByNome(String nome) {
		GestaoDeConexao gc = GestaoDeConexao.constuirConexao();
		PreparedStatement ps = gc.fazQuery("SELECT id, nome FROM Genero WHERE nome = ?;");		
		ResultSet rs;
		try {
			ps.setString(1, nome);
			rs = ps.executeQuery();
			while (rs.next()) {				
				Genero g = new Genero(rs.getString(2));
				g.setId(rs.getInt(1));
				return g;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;		
	}
	
}
