package biblioteca;

public class LivroDigital extends Livro{

	private float tamanhoEmMB;
	
	public void setTamanhoEmMB(float t) {
		this.tamanhoEmMB = t;
	}
	
	public float getTamanhoEmMB() {
		return this.tamanhoEmMB;
	}
	
	public LivroDigital(String a, String t, int np, float tmb) {
		super(a,t,np);
		this.setTamanhoEmMB(tmb);		
	}
	
	@Override
	public String toString() { 
		String livroString = super.toString();
		livroString = livroString + "Tamanho em MB: " + Float.toString(this.getTamanhoEmMB()) + "\n";
		return livroString;
	}
	
}
