package model;

public class Cancela {

	private Integer codigo;
	private boolean aberta;
	private String nome;

	public Cancela() {
	}

	public Cancela(Integer codigo, String nome, boolean aberta) {
		super();
		this.codigo = codigo;
		this.aberta = aberta;
		this.nome = nome;
	}

	public Cancela(boolean aberta, String nome) {
		super();
		this.aberta = aberta;
		this.nome = nome;
	}

	@Override
	public String toString() {
		return "Código: " + this.codigo + "\nNome: " + this.nome + "\nAberta? " + this.aberta;
	}
	
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Integer getCodigo() {
		return codigo;
	}

	public void setCodigo(Integer codigo) {
		this.codigo = codigo;
	}

	public boolean isAberta() {
		return aberta;
	}

	public void setAberta(boolean aberta) {
		this.aberta = aberta;
	}

}
