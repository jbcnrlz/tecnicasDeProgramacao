package arquivos;

public class FabricaDeCSV extends Fabrica{
	
	@Override
	public Arquivo criarArquivo() {
		return new ArquivoCSV();
	}

}
