package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionManager {

	private static ConnectionManager cm = null;
	private Connection conexao;
	
	public Connection getConexao() {
		return conexao;
	}

	public void setConexao(Connection conexao) {
		this.conexao = conexao;
	}

	private ConnectionManager() {
		try {
			Class.forName("org.mariadb.jdbc.Driver");
			Connection cn = DriverManager.getConnection(
				"jdbc:mariadb://localhost:3306/lojaDeJogos",
				"jbcnrlz",
				"a12b25c54");
			this.setConexao(cn);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	
	public static ConnectionManager getConnection() {
		if (ConnectionManager.cm == null) {
			ConnectionManager.cm = new ConnectionManager();
		}
		return ConnectionManager.cm;
	}
	
}
