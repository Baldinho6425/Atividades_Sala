package br.edu.unoesc.testejpa.app;

import java.util.List;

import br.edu.unoesc.testejpa.model.Pessoa;
import br.edu.unoesc.testejpa.util.JPAUtil;
import jakarta.persistence.EntityManager;

public class App2 {
	private static EntityManager em;

	public static void main(String[] args) {
		App2 app = new App2();
		em = JPAUtil.getEntityManager();
		// Adicionar pessoas
		app.adicionar();
		// Alterar dados
		app.alterar();
//Dados da pessoa 1
		System.out.println("Dados da pessoa 1");
		System.out.println(app.buscarPorId(1).getNome());
//Dados da pessoa 10
		System.out.println("Dados da pessoa 10");
		Pessoa p = app.buscarPorId(10);
		if (p == null) {
			System.out.println("Pessoa inesistente!");
		} else {
			System.out.println(p.getNome());
		}
//Todos os dados cadastrados
		System.out.println("Todos os cadastrados");
		List<Pessoa> lista = app.buscarTodos();
		for (Pessoa pessoa : lista) {
			System.out.println(pessoa.getNome());
		}
//ou
//app.buscarTodos().forEach(System.out::println);
//Buscar por nome
		System.out.println("Buscar por nome Maria");
		lista = app.buscarPorId("Maria");
		for (Pessoa pessoa : lista) {
			System.out.println(pessoa.getNome());
		}
//Excluir
		app.excluir();
		em.close();
		JPAUtil.closeEntityManagerFactory();
	}

	private List<Pessoa> buscarPorId(String string) {
		// TODO Auto-generated method stub
		return null;
	}

	private void excluir() {
		// TODO Auto-generated method stub
		
	}

	private List<Pessoa> buscarTodos() {
		// TODO Auto-generated method stub
		return null;
	}

	private Pessoa buscarPorId(int i) {
		// TODO Auto-generated method stub
		return null;
	}

	private void alterar() {
		// TODO Auto-generated method stub
		
	}

	private void adicionar() {
		// TODO Auto-generated method stub
		
	}

}