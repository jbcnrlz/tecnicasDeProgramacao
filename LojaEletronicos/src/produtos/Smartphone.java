package produtos;

public class Smartphone implements Eletronicos{

	private String marca;
	private String modelo;
	private int capacidadeBateria;
	private boolean suporta5G;
	private boolean ligado;

	public Smartphone(String m, String mo, int c, boolean s5g) {
		this.setMarca(m);
		this.setModelo(mo);
		this.setCapacidadeBateria(c);
		this.setSuporta5G(s5g);
		this.ligado = false;
	}
	
	public String getMarca() {
		return marca;
	}
	public void setMarca(String marca) {
		this.marca = marca;
	}
	public String getModelo() {
		return modelo;
	}
	public void setModelo(String modelo) {
		this.modelo = modelo;
	}
	public int getCapacidadeBateria() {
		return capacidadeBateria;
	}
	public void setCapacidadeBateria(int capacidadeBateria) {
		this.capacidadeBateria = capacidadeBateria;
	}
	public boolean isSuporta5G() {
		return suporta5G;
	}
	public void setSuporta5G(boolean suporta5g) {
		suporta5G = suporta5g;
	}
	@Override
	public void ligar() {
		if (this.ligado) {
			System.err.println("O smartphone já está ligado!");
		}else {
			System.out.println("O smartphone foi ligado!");
			this.ligado = true;
		}
	}
	
	@Override
	public void desligar() {
		if (!this.ligado) {
			System.err.println("O smartphone já está desligado!");
		}else {
			System.out.println("O smartphone foi desligado!");
			this.ligado = false;
		}		
	}
	@Override
	public String exibir() {
		String textOutput = "";
		if (this.ligado) {
			textOutput += "Smartphone ligado.\n"; 
		} else {
			textOutput += "Smartphone desligado.\n";
		}
		textOutput += "Marca: " + this.getMarca() + "\n";
		textOutput += "Modelo: " + this.getModelo() + "\n";
		textOutput += "Capacidade de bateria: " + Integer.toString(this.getCapacidadeBateria()) + "mAh\n";
		if (this.isSuporta5G()) {
			textOutput += "Suporta 5G: Sim\n";
		}else {
			textOutput += "Suporta 5G: Não\n";
		}
		return textOutput;
	}
	
	
	
}
