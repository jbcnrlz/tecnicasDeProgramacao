package sistema;

import java.util.LinkedList;

import javax.swing.table.AbstractTableModel;

import dados.Genero;

public class GeneroTableModel extends AbstractTableModel{

	private static final long serialVersionUID = 1L;
	private LinkedList<Genero> gs;
	private String[] colunas = {"ID","Nome"};

	public GeneroTableModel(LinkedList<Genero> g) {
		this.gs = g;
	}
	
	@Override
	public int getRowCount() {
		return this.gs.size();
	}

	@Override
	public int getColumnCount() {		
		return this.colunas.length;
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		if (columnIndex == 0) {
			return this.gs.get(rowIndex).getId();
		} else if (columnIndex == 1) {
			return this.gs.get(rowIndex).getNome();
		}
		return null;
	}

	@Override
	public Class<?> getColumnClass(int columnIndex) {
		// TODO Auto-generated method stub
		switch (columnIndex){
		case 0: {
			return Integer.class;
		}
		case 1: {
			return String.class;
		}
		default:
			throw new IllegalArgumentException("Unexpected value: " + columnIndex);
		}
	}

	@Override
	public String getColumnName(int column) {
		// TODO Auto-generated method stub
		return this.colunas[column];
	}
}
