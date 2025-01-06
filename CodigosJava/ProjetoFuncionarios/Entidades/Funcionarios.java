package ProjetoFuncionarios.Entidades;

public class Funcionarios {
    private int Codigo;
    private String nome;
    private double Salario;

    public Funcionarios(int codigo, String nome, double Salario) {
        this.Codigo = codigo;
        this.nome = nome;
        this.Salario = Salario;
    }

    public int getCodigo() {
        return Codigo;
    }

    public String getNome() {
        return nome;
    }

    public double getSalario() {
        return Salario;
    }

    public void setSalario(double Salario) {
        this.Salario = Salario;
    }

}
