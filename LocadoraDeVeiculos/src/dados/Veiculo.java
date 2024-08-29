package dados;

public class Veiculo {
	
	private static int qtCriados = 0;
	private String nome;
	private int ano;
	
	public Veiculo(String n, int a) {
		this.setNome(n);
		this.setAno(a);
		Veiculo.qtCriados += 1;
	}
	
	public static int getQtCriados() {
		return Veiculo.qtCriados;
	}
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public int getAno() {
		return ano;
	}
	public void setAno(int ano) {
		this.ano = ano;
	}
	
	

}
