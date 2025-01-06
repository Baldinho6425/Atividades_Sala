package programaReceitaFederal;

public abstract class Pessoa {
	private String nome;
	private Integer telefone;
	protected Double rendaBruta;
	
	public Pessoa(String nome, Integer telefone, Double rendaBruta) {
		super();
		this.nome = nome;
		this.telefone = telefone;
		this.rendaBruta = rendaBruta;
	}
	
	public String getNome() {
		return nome;
	}
	public Integer getTelefone() {
		return telefone;
	}
	
	public Double getRendaBruta() {
		return rendaBruta;
	}
	
	
	@Override
	public String toString() {
		return ": "+nome + ", Telefone = " + telefone + ", Renda Bruta: " + rendaBruta + ", ";
	}

	public abstract void calcularImposto();
	
	public abstract void mostraImposto(double imposto);
	
	
	
}
