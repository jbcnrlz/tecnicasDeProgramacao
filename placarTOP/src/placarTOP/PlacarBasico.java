package placarTOP;

public class PlacarBasico {

	private String nomeTimeA;
	private String nomeTimeB;
	private int pontuacaoA;
	private int pontuacaoB;
	
	public PlacarBasico(String ta, String tb) {
		this.setNomeTimeA(ta);
		this.setNomeTimeB(tb);
		this.setPontuacaoA(0);
		this.setPontuacaoB(0);
	}
	
	public void mostrarPlacar() {
		System.out.printf("%s X %s\n", this.nomeTimeA, this.nomeTimeB);
		System.out.printf("%03d - %03d", this.pontuacaoA, this.pontuacaoB);
	}
	
	public String getNomeTimeA() {
		return nomeTimeA;
	}

	public void setNomeTimeA(String nomeTimeA) {
		this.nomeTimeA = nomeTimeA;
	}

	public String getNomeTimeB() {
		return nomeTimeB;
	}

	public void setNomeTimeB(String nomeTimeB) {
		this.nomeTimeB = nomeTimeB;
	}

	public int getPontuacaoA() {
		return pontuacaoA;
	}

	public void setPontuacaoA(int pontuacaoA) {
		this.pontuacaoA = pontuacaoA;
	}

	public int getPontuacaoB() {
		return pontuacaoB;
	}

	public void setPontuacaoB(int pontuacaoB) {
		this.pontuacaoB = pontuacaoB;
	}

	public void pontuar(int time) {
		if (time == 0) {
			this.setPontuacaoA(this.getPontuacaoA()+1);
		} else {
			this.setPontuacaoB(this.getPontuacaoB()+1);
		}
	}
	
}
