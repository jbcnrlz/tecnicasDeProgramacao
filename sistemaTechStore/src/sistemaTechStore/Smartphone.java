package sistemaTechStore;

public class Smartphone extends Eletronico{
	
	private int armazenamento;
	
	public int getArmazenamento() {
		return this.armazenamento;
	}
	
	public void setArmazenamento(int a) {
		this.armazenamento = a;
	}
	
	public Smartphone(String n, double p, String m, int a) {
		super(n,p,m);
		this.setArmazenamento(a);
	}

	@Override
	public String getDescricao() {
		String desc = super.getDescricao();
		return desc + "\nTamanho do armazenamento (em GB): " + Integer.toString(this.getArmazenamento());
	}
	
	@Override
	public double calcularPagamento() {
		double vf = this.getPreco() + (this.getPreco() * 0.1);
		return vf;
	}
	
}
