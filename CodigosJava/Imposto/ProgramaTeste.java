package programaReceitaFederal;

import java.util.ArrayList;
import java.util.Scanner;

public class ProgramaTeste {
	public static void main(String[]args) {
		Scanner sc = new Scanner(System.in);
		
		Pessoa pf2 = new PessoaFisica("Miguel", 88318494, 1900.0, 156823, 6519319,"rua xv");
		Pessoa pf1 = new PessoaFisica("Nícolas", 88318494, 2500.0, 105823, 6519319,"rua xv");	
		Pessoa pf4 = new PessoaFisica("Otilia", 88318494, 2900.0, 1231823, 6519319,"rua xv");
		Pessoa pf3 = new PessoaFisica("Jose", 88318494, 4000.0, 53213, 6519319,"rua xv");
		Pessoa pf5 = new PessoaFisica("Matheus", 88318494, 4700.0, 105343, 6519319,"rua xv");
		Pessoa pj = new PessoaJuridica("Unoesc", 88318494, 50000.0, 893423,"Uno@gmail.com");
		
		ArrayList<Pessoa> lista = new ArrayList<Pessoa>(6);
		lista.add(pf1);
		lista.add(pf2);
		lista.add(pf3);
		lista.add(pf4);
		lista.add(pf5);
		lista.add(pj);
		
		// Calculo do Imposto
		System.out.println("Cálculo imposto de renda de pessoas físicas e jurídicas: ");
		for(Pessoa p: lista) {
			p.calcularImposto();
		}
		
		System.out.println();
		System.out.println("Pressione Enter pra continuar!");
		sc.nextLine();
		
		// toString personalizado
		System.out.println("toStrings Personalizados:");
		for(Pessoa p: lista) {
			System.out.println(p.toString());
		}
		sc.close();
	}
}
