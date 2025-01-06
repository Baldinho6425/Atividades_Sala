package br.edu.unoesc.testejpa.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.sql.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;

@Entity
@Table(name = "funcionarios")
public class Funcionario implements Serializable {
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	@Column(length = 50, nullable = false)
	private String nome;
	@Temporal(TemporalType.DATE)
	@Column(name = "data_nascimento", nullable = false)
	private java.sql.Date dataNascimento;
	@Column(precision = 12, scale = 2, nullable = false)
	private BigDecimal salario;
	@ManyToOne
	private Cargo cargo;
	public Funcionario(Integer id, String nome, Date dataNascimento, BigDecimal salario, Cargo cargo) {
		super();
		this.id = id;
		this.nome = nome;
		this.dataNascimento = dataNascimento;
		this.salario = salario;
		cargo.adicionarFuncionario(this);
		
		
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public java.sql.Date getDataNascimento() {
		return dataNascimento;
	}
	public void setDataNascimento(java.sql.Date dataNascimento) {
		this.dataNascimento = dataNascimento;
	}
	public BigDecimal getSalario() {
		return salario;
	}
	public void setSalario(BigDecimal salario) {
		this.salario = salario;
	}
	public Cargo getCargo() {
		return cargo;
	}
	public void setCargo(Cargo cargo) {
		this.cargo = cargo;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	@Override
	public String toString() {
		return "Funcionario [id=" + id + ", nome=" + nome + ", dataNascimento=" + dataNascimento + ", salario="
				+ salario + ", cargo=" + cargo + "]";
	}
	
	

	
	
	
	
}