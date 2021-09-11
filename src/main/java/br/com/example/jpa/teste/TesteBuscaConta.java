package br.com.example.jpa.teste;

import javax.persistence.EntityManager;

import br.com.example.jpa.model.Conta;
import br.com.example.jpa.util.JPAUtil;

public class TesteBuscaConta {

	public static void main(String[] args) {

		EntityManager em = new JPAUtil().getEntityManager();
		em.getTransaction().begin();

		Conta conta = em.find(Conta.class, 1);

		em.getTransaction().commit();
		em.close();
	}
}