package produtos;

public class Computador implements Eletronicos, Persistente{

	private String marca;
	private String processador;
	private int ram;
	private boolean gamer;
	private boolean ligado;
	
	public Computador(String m, String p, int r, boolean g) {
		this.setMarca(m);
		this.setProcessador(p);
		this.setRam(r);
		this.setGamer(g);
		this.ligado = false;
	}
	
	public String getMarca() {
		return marca;
	}
	public void setMarca(String marca) {
		this.marca = marca;
	}
	public String getProcessador() {
		return processador;
	}
	public void setProcessador(String processador) {
		this.processador = processador;
	}
	public int getRam() {
		return ram;
	}
	public void setRam(int ram) {
		this.ram = ram;
	}
	public boolean isGamer() {
		return gamer;
	}
	public void setGamer(boolean gamer) {
		this.gamer = gamer;
	}
	@Override
	public void ligar() {
		if (this.ligado) {
			System.err.println("O Computador já está ligado!");
		}else {
			System.out.println("O Computador foi ligado!");
			this.ligado = true;
		}
	}
	@Override
	public void desligar() {
		if (!this.ligado) {
			System.err.println("O Computador já está desligado!");
		}else {
			System.out.println("O Computador foi desligado!");
			this.ligado = false;
		}	
	}
	@Override
	public String exibir() {
		String textOutput = "";
		if (this.ligado) {
			textOutput += "Computador ligado.\n"; 
		} else {
			textOutput += "Computador desligado.\n";
		}
		textOutput += "Marca: " + this.getMarca() + "\n";
		textOutput += "Processador: " + this.getProcessador() + "\n";
		textOutput += "Memória RAM: " + Integer.toString(this.getRam()) + "GB\n";
		if (this.isGamer()) {
			textOutput += "Gamer: Sim\n";
		}else {
			textOutput += "Gamer: Não\n";
		}
		return textOutput;
	}

	@Override
	public boolean salvar() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean atualizar() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean deletar() {
		// TODO Auto-generated method stub
		return false;
	}
	
	
	
}
