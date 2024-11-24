package dao;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import excecoes.ConfiguracaoNotFoundException;

public class ConnectionManager {

	private static ConnectionManager cm = null;
	private Connection conexao;
	private String odbcDriver;
	private String url;
	private String usuario;
	private String senha;
	
	public PreparedStatement doQuery(String query) {
		this.startConnection();
		try {
			return this.getConexao().prepareStatement(query);
		} catch (SQLException e) {
			System.err.println("Erro ao preparar o statement");
			e.printStackTrace();
			return null;
		}
	}
	
	public void startConnection() {
		try {
			Class.forName(this.odbcDriver);
			Connection cn = DriverManager.getConnection(
				this.url,
				this.usuario,
				this.senha);
			this.setConexao(cn);
		} catch (ClassNotFoundException e) {
			System.err.println("Classe não encontrada - verifique sua inclusão.");
			e.printStackTrace();
		} catch (SQLException e) {
			System.err.println("Erro ao conectar com a base SQL.");
			e.printStackTrace();
		}

	}
	
	private ConnectionManager() throws ConfiguracaoNotFoundException {
		List<String> confs = this.getConfigs("configs.txt");
		if (confs == null) {
			throw new ConfiguracaoNotFoundException("Arquivo de configuração não encontrado");
		}
		this.odbcDriver = confs.get(0);
		this.url = confs.get(1);
		this.usuario = confs.get(2);
		this.senha = confs.get(3);
		this.conexao = null;
	}
	
	public static ConnectionManager buildConnection() {
		if (ConnectionManager.cm == null) {
			try {
				ConnectionManager.cm = new ConnectionManager();
			} catch (ConfiguracaoNotFoundException e) {
				System.err.println("Arquivo de configuração não encontrado!");
				return null;
			}
		}
		return ConnectionManager.cm;
	}

	public Connection getConexao() {
		return conexao;
	}

	public void setConexao(Connection conexao) {
		this.conexao = conexao;
	}
	
	private List<String> getConfigs(String fp) {
		try {
			Path filePath = Paths.get(fp);
			return Files.readAllLines(filePath);
		} catch (IOException e) {			
			return null;
		}
	}
	
	
}
