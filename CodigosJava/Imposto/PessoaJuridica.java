package programaReceitaFederal;

public class PessoaJuridica extends Pessoa {
	private Integer cnpj;
	private String email;

	public PessoaJuridica(String nome, Integer telefone, Double rendaBruta, Integer cnpj, String email) {
		super(nome, telefone, rendaBruta);
		this.cnpj = cnpj;
		this.email = email;
	}

	public Integer getCnpj() {
		return cnpj;
	}

	public String getEmail() {
		return email;
	}

	@Override
	public void mostraImposto(double imposto) {
		System.out.printf("A pessoa jurídica %s pagará %.2f de imposto -> Renda bruta final = %.2f\n", super.getNome(),imposto, super.rendaBruta - imposto);
	}
	
	@Override
	public void calcularImposto() {
		double imposto = super.rendaBruta*0.1;
		mostraImposto(imposto);
	}

	@Override
	public String toString() {
		return "Pessoa Jurídica "+ super.toString() +", CNPJ = " + cnpj + ", E-mail = " + email ;
	}


	
}
