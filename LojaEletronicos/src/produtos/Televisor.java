package produtos;

public class Televisor implements Eletronicos{
	
	private String marca;
	private int polegadas;
	private String resolucao;
	private boolean isSmart;
	private boolean ligado;

	@Override
	public void desligar() {
		if (!this.ligado) {
			System.err.println("A TV já está desligada!");
		}else {
			System.out.println("A tv foi desligada!");
			this.ligado = false;
		}
	}

	@Override
	public String exibir() {
		String textOutput = "";
		if (this.ligado) {
			textOutput += "Televisão ligada.\n"; 
		} else {
			textOutput += "Televisão desligada.\n";
		}
		textOutput += "Marca: " + this.getMarca() + "\n";
		textOutput += "Polegadas: " + Integer.toString(this.getPolegadas()) + "\n";
		if (this.getSmart()) {
			textOutput += "Smart: Sim\n";
		}else {
			textOutput += "Smart: Não\n";
		}
		return textOutput;
	}

	@Override
	public void ligar() {
		if (this.ligado) {
			System.err.println("A TV já está ligada!");
		}else {
			System.out.println("A tv foi ligada!");
			this.ligado = true;
		}
	}

	
	public Televisor(String m, int p, String r,boolean s) {
		this.setMarca(m);
		this.setPolegadas(p);
		this.setResolucao(r);
		this.setSmart(s);
		this.ligado = false;
	}

	public void setSmart(boolean s) {
		this.isSmart = s;
	}
	
	public boolean getSmart() {
		return this.isSmart;
	}
	
	public String getMarca() {
		return marca;
	}
	public void setMarca(String marca) {
		this.marca = marca;
	}
	public int getPolegadas() {
		return polegadas;
	}
	public void setPolegadas(int polegadas) {
		this.polegadas = polegadas;
	}
	public String getResolucao() {
		return resolucao;
	}
	public void setResolucao(String resolucao) {
		this.resolucao = resolucao;
	}

}
