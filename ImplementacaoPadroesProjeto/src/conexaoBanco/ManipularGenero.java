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
	
}
