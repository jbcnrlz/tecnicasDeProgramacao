package placarTOP;

public class PlacarFutebol extends PlacarBasico{

	public PlacarFutebol(String ta, String tb) {
		super(ta, tb);
	}

	@Override
	public void mostrarPlacar() {
		System.out.printf("%s %d\n",this.getNomeTimeA(),this.getPontuacaoA());
		System.out.printf("%s %d\n",this.getNomeTimeB(),this.getPontuacaoB());
	}
	
}
