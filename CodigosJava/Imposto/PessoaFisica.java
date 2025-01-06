package programaReceitaFederal;

public class PessoaFisica extends Pessoa {
	private Integer cpf;
	private Integer rg;
	private String endereco;

	
	public PessoaFisica(String nome, Integer telefone, Double rendaBruta, Integer cpf, Integer rg, String endereco) {
		super(nome, telefone, rendaBruta);
		this.cpf = cpf;
		this.rg = rg;
		this.endereco = endereco;
	}

	public Integer getCpf() {
		return cpf;
	}

	public Integer getRg() {
		return rg;
	}

	public String getEndereco() {
		return endereco;
	}
	
	@Override
	public void mostraImposto(double imposto) {
		System.out.printf("A Pessoa Física '%s' pagará %.2f de imposto -> Renda bruta final = %.2f\n", super.getNome(),
				imposto, super.rendaBruta - imposto);
	}
	
	@Override
	public void calcularImposto() {
		double imposto = 0;
		if (super.rendaBruta < 1903.99) {
			System.out.printf("A Pessoa Física '%s' está isento de imposto\n", super.getNome());
		} else {
			if (super.rendaBruta < 2826.66) {
				imposto = rendaBruta * 0.075;
			} else if (super.rendaBruta < 3751.06) {
				imposto = rendaBruta * 0.15;
			} else if (super.rendaBruta < 4664.69) {
				imposto = rendaBruta * 0.225;
			} else {
				imposto = rendaBruta * 0.275;
			}
			mostraImposto(imposto);
		}

	}

	@Override
	public String toString() {
		return "Pessoa Física "+super.toString()+"CPF = " + cpf + ", RG = " + rg + ", Endereço = " + endereco;
	}
	
	
}
