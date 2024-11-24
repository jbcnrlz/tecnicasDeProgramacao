package arquivos;

public class Fabrica {

	public Arquivo criarArquivo() {
		return null;
	}
	
	public static void main(String[] args) {
		String arquivoAbrir = "caminho";
		String tipoArquivo = "csv";
		Fabrica f = null;
		Arquivo a = null;
		if (tipoArquivo.equals("csv")) {
			f = new FabricaDeCSV();
			a = f.criarArquivo();
		} else {
			f = new ArquivoDeTexto();
			a = f.criarArquivo();
		}
	}
	
}
