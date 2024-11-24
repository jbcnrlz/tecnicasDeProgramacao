package conexaoBanco;

import java.nio.file.Paths;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class GestaoDeConexao {

	private static GestaoDeConexao gdc = null;
	private String driverConexao;
	private String urlConexao;
	private String usuario;
	private String senha;	
	private Connection con;	
	
	private GestaoDeConexao() throws ConfiguracaoNaoEncontradaException {
		List<String> conf = this.getConfigs("configs.txt");
		if (conf == null) {
			throw new ConfiguracaoNaoEncontradaException("Config. perdida");
		}
		this.driverConexao = conf.get(0);
		this.urlConexao = conf.get(1);
		this.usuario = conf.get(2);
		this.senha = conf.get(3);
		this.con = null;
	}
	
	private GestaoDeConexao(String path) throws ConfiguracaoNaoEncontradaException {
		List<String> conf = this.getConfigs(path);
		if (conf == null) {
			throw new ConfiguracaoNaoEncontradaException("Config. perdida");
		}
		this.driverConexao = conf.get(0);
		this.urlConexao = conf.get(1);
		this.usuario = conf.get(2);
		this.senha = conf.get(3);
		this.con = null;
	}

	
	public PreparedStatement fazQuery(String q) {
		this.iniciarConexao();
		PreparedStatement ps = null;
		try {
			ps = this.getCon().prepareStatement(q);
		} catch(SQLException e) {
			System.err.println("Erro com a query, verifique ela.");
			e.printStackTrace();
		}
		return ps;
	}
	
	private List<String> getConfigs(String fp){
		List<String> conteudo = null;		
		Path fileFpath = Paths.get(fp);
		try {
			conteudo = Files.readAllLines(fileFpath);
		} catch (IOException e) {
			System.err.println("Arquivo não existe");
		}
		return conteudo;
	}
	
	public void iniciarConexao() {
		try {
			Class.forName(this.driverConexao);
			Connection cn = DriverManager.getConnection(
				this.urlConexao,
				this.usuario,
				this.senha
			);
			this.con = cn;
		} catch(ClassNotFoundException e) {
			System.err.println("Classe não encontrada!");
		} catch (SQLException e) {
			System.err.println("Erro ao conectar");
		}
	}
	
	public Connection getCon() {
		return this.con;
	}

	public static GestaoDeConexao constuirConexao(String path) {
		if (GestaoDeConexao.gdc == null) {
			try {
				GestaoDeConexao.gdc = new GestaoDeConexao(path);
			}catch (ConfiguracaoNaoEncontradaException ce) {
				System.err.println("VErifique o path do arquivo.");
			}
		}
		return GestaoDeConexao.gdc;
	}
	
	public static GestaoDeConexao constuirConexao() {
		if (GestaoDeConexao.gdc == null) {
			try {
				GestaoDeConexao.gdc = new GestaoDeConexao();
			}catch (ConfiguracaoNaoEncontradaException ce) {
				System.err.println("VErifique o path do arquivo.");
			}
		}
		return GestaoDeConexao.gdc;
	}
	
}
