package conexaoBanco;

public abstract class ManipularItemBanco implements ItemBanco{
	
	private GestaoDeConexao cc;
	private Object o;

	public ManipularItemBanco(GestaoDeConexao gc,Object oo) {
		this.setCc(gc);
		this.setO(oo);		
	}
	
	public GestaoDeConexao getCc() {
		return cc;
	}

	public void setCc(GestaoDeConexao cc) {
		this.cc = cc;
	}

	public Object getO() {
		return o;
	}

	public void setO(Object o) {
		this.o = o;
	}

}
