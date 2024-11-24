package arquivos;

public class ArquivoDeTexto extends Fabrica{

	@Override
	public Arquivo criarArquivo() {
		return new ArquivoTexto();
	}
	
}
