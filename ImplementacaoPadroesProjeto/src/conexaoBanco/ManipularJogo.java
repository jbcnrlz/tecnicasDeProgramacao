package conexaoBanco;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import dados.Genero;
import dados.Jogos;

public class ManipularJogo extends ManipularItemBanco{

	public ManipularJogo(GestaoDeConexao gc, Object oo) {
		super(gc, oo);
	}

	@Override
	public boolean salvar() {
		Jogos j = Jogos.class.cast(this.getO());
		PreparedStatement ps = this.getCc().fazQuery("INSERT INTO Jogos(nome,preco,genero_id) values(?,?,?);");
		try {
			ps.setString(1, j.getNome());
			ps.setFloat(2, j.getPreco());
			ps.setInt(3, j.getGenero().getId());
			ps.executeUpdate();
			j.setId(this.getID());
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
		Jogos g = Jogos.class.cast(this.getO());
		PreparedStatement ps = this.getCc().fazQuery("SELECT id FROM Jogos where nome = ? ORDER BY id DESC;");
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

}
