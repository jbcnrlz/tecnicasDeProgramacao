package sistemaTechStore;

public class Eletronico extends Produto{
	
	private String marca;
	
	public String getMarca() {
		return this.marca;
	}
	
	public void setMarca(String m) {
		this.marca = m;
	}
	
	public Eletronico(String n, double p, String m) {
		super(n,p);
		this.setMarca(m);
	}
	
	@Override
	public String getDescricao() {
		String descEletronico = super.getDescricao();
		descEletronico = descEletronico + "\nMarca: " + this.getMarca();
		return descEletronico;		
	}

}
