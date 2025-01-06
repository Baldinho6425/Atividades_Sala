package br.edu.unoesc.testejpa.model;

import java.io.Serializable;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "departamentos")
public class Departamento implements Serializable {
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	@Column(length = 40, nullable = false)
	private String nome;
	@OneToOne(mappedBy = "departamento")
	private Gerente gerente;
	
// construtor completo (sem id) e vazio
//getters/setters
//toString
	public Departamento() {
		super();
	}
public Departamento(Integer id, String nome) {
	super();
	this.id = id;
	this.nome = nome;
}
public Departamento(String nome) {
	super();
	this.nome = nome;
	
}
public Departamento(String nome, Gerente gerente) {
	super();
	this.nome = nome;
	this.gerente = gerente;
}
public Departamento(Integer id, String nome, Gerente gerente) {
	super();
	this.id = id;
	this.nome = nome;
	this.gerente = gerente;
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
public static long getSerialversionuid() {
	return serialVersionUID;
	
}
public Gerente getGerente() {
	return gerente;
}
public void setGerente(Gerente gerente) {
	this.gerente = gerente;
}
@Override
public String toString() {
	return "Departamento [id=" + id + ", nome=" + nome + ", gerente=" + gerente + "]";
}

	
	
	
}