package dados;

public class Carro {

	private Marca marca;
	private String modelo;
	private int ano;
	private String cor;
	private static int qtdCriados = 0;
	
	public static void aumentaCriados() {
		Carro.qtdCriados += 1;
	}
	
	public static int getQtdCriados() {
		return Carro.qtdCriados;
	}
	
	public Carro(Marca marca, String modelo, int ano, String cor) {
		this.setMarca(marca);
		this.setModelo(modelo);
		this.setAno(ano);
		this.setCor(cor);
		Carro.aumentaCriados();
	}
	
	@Override
	public boolean equals(Object obj) {
		Carro cComp = Carro.class.cast(obj);
		if (
				(this.getAno() == cComp.getAno()) && 
				(this.getMarca().equals(cComp.getMarca())) && 
				(this.getModelo().equals(cComp.getModelo())) &&
				(this.getCor().equals(cComp.getCor()))
			) {
			return true;
		}else {
			return false;
		}
	}
	
	@Override
	public String toString() {
		String retorno;
		retorno = this.getMarca() + " " +this.getModelo() + "\n";
		retorno = retorno + Integer.toString(this.getAno()) + " - " + this.getCor() + "\n";
		return retorno;
	}
	
	public Marca getMarca() {
		return marca;
	}
	public void setMarca(Marca marca) {
		this.marca = marca;
	}
	public String getModelo() {
		return modelo;
	}
	public void setModelo(String modelo) {
		this.modelo = modelo;
	}
	public int getAno() {
		return ano;
	}
	public void setAno(int ano) {
		this.ano = ano;
	}
	public String getCor() {
		return cor;
	}
	public void setCor(String cor) {
		this.cor = cor;
	}
	
	
	
}
