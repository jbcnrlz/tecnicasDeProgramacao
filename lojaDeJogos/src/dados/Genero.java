package dados;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import dao.Persistir;
import dao.ConnectionManager;

public class Genero{

	private int id;
	private String nome;

	public Genero(String n) {
		this.id = 0;
		this.setNome(n);		
	}
	
	public int getId() {
		return id;
	}	
	
	public void setId(int id) {
		this.id = id;
	}
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	
}
