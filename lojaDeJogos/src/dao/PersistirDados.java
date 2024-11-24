package dao;

public abstract class PersistirDados implements Persistir{
	
	private ConnectionManager cm;	
	private Object ob;
	
	public PersistirDados(ConnectionManager cm, Object o) {
		this.setCm(cm);
		this.setOb(o);
	}

	public ConnectionManager getCm() {
		return cm;
	}

	public void setCm(ConnectionManager cm) {
		this.cm = cm;
	}

	public Object getOb() {
		return ob;
	}

	public void setOb(Object ob) {
		this.ob = ob;
	}
	
}
