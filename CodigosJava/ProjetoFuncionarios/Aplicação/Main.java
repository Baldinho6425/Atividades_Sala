package ProjetoFuncionarios.Aplicação;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import ProjetoFuncionarios.Entidades.Funcionarios;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Funcionarios> funcionarios = new ArrayList<>();

        System.out.println("Digite o Codigo do Funcionario");
        int Codigo = scanner.nextInt();

        scanner.nextLine();
        System.out.println("Digite o Nome do Funcionario");
        String Nome = scanner.nextLine();

        System.out.println("Digite o Salario do Funcionario");
        double Salario = scanner.nextDouble();

        Funcionarios funcionario = new Funcionarios(Codigo, Nome, Salario);
        funcionarios.add(funcionario);

        System.out.println("Digite o Codigo do Funcionario para receber o aumento");
        int CodigoAumento = scanner.nextInt();

        for (Funcionarios i : funcionarios) {
            if (i.getCodigo() == CodigoAumento) {
                System.out.println("Valor do Aumento: ");
                double ValorAumento = scanner.nextDouble();

                i.setSalario(i.getSalario() + i.getSalario() * ValorAumento / 100);

                System.out.println("");
                System.out.println("Salario Atual: " + i.getSalario());

            }

        }
        scanner.close();
    }
}