package locadora;

public class Carro {
	private Montadora marca;
	private String modelo;
	private int ano;
	private String cor;
	private static int qtCriados = 0;
	
	public Carro(Montadora m, String mod, int a, String c) {
		this.setMarca(m);
		this.setModelo(mod);
		this.setAno(a);
		this.setCor(c);
		Carro.qtCriados += 1;
	}
	
	public static int getQuantidade() {
		return Carro.qtCriados;
	}
	
	public Montadora getMarca() {
		return marca;
	}
	public void setMarca(Montadora marca) {
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

	@Override
	public String toString() {
		String desc = "";
		desc = "Marca: " + this.getMarca() + "\n";
		desc = desc + "Modelo: " + this.getModelo() + "\n";
		desc = desc + "Cor: " + this.getCor() + "\n";
		desc = desc + "Ano: " + Integer.toString(this.getAno()) + "\n";
		return desc;
	}
	
	@Override
	public boolean equals(Object obj) {
		Carro c2 = Carro.class.cast(obj);
		if (
			(this.getAno() == c2.getAno()) && 
			this.getCor().equals(c2.getCor()) &&
			this.getMarca().equals(c2.getMarca()) &&
			this.getModelo().equals(c2.getModelo())
		) {
			return true;
		}else {
			return false;
		}
	}
	
}
