package dao;

import java.util.LinkedList;

public interface Persistir {
	
	public boolean salvar();
	public boolean deletar();
	public boolean atualizar();
	public int getID();
	public LinkedList<Object> findAll(String campos[], String operador);

}
