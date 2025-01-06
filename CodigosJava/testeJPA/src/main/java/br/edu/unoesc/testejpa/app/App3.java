package br.edu.unoesc.testejpa.app;

import java.math.BigDecimal;
import java.util.List;

import br.edu.unoesc.testejpa.model.Departamento;
import br.edu.unoesc.testejpa.model.Pessoa;
import br.edu.unoesc.testejpa.util.JPAUtil;
import jakarta.persistence.EntityManager;

public class App3 {
	private static EntityManager em;

	public static void main(String[] args) {
		em = JPAUtil.getEntityManager();
		Departamento d1 = new Departamento("Desenvolvimento");
		Departamento d2 = new Departamento("Testes");
		Pessoa p1 = new Pessoa("Maria", java.sql.Date.valueOf("2000-04-01"), new BigDecimal("10000.0"), d1);
		Pessoa p2 = new Pessoa("Antônio", java.sql.Date.valueOf("2001-05-02"), new BigDecimal("20000.0"), d2);
		Pessoa p3 = new Pessoa("Osvaldo", java.sql.Date.valueOf("2001-05-10"), new BigDecimal("10000.0"), d1);
		em.getTransaction().begin();
		em.persist(d1);
		em.persist(d2);
		em.persist(p1);
		em.persist(p2);
		em.persist(p3);
		em.getTransaction().commit();
		em.close();
		JPAUtil.closeEntityManagerFactory();
	}

	private List<Pessoa> buscarPorNome(String nome) {
		String jpql = "SELECT p FROM Pessoa p WHERE p.nome LIKE: nome";
		return em.createQuery(jpql, Pessoa.class).setParameter("nome", "%" + nome + "%").getResultList();
	}

	private List<Pessoa> buscarTodos() {
		String jpql = "SELECT p FROM Pessoa p";
		return em.createQuery(jpql, Pessoa.class).getResultList();
	}

	private Pessoa buscarPorId(Integer id) {
		return em.find(Pessoa.class, id);
	}

	private void alterar() {
		Pessoa pessoa = this.buscarPorId(1);
		pessoa.setNome("Outra Otilia");
		pessoa.setDataNascimento(java.sql.Date.valueOf("2002-05-05"));
		pessoa.setSalario(new BigDecimal("12345.67"));
		em.getTransaction().begin();
		em.getTransaction().commit();
	}

	private void excluir() {
		Pessoa pessoa = this.buscarPorId(2);
		em.getTransaction().begin();
		em.remove(pessoa);
		em.getTransaction().commit();
	}
}