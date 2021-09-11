package br.com.example.jpa.teste;

import javax.persistence.EntityManager;

import br.com.example.jpa.model.Cliente;
import br.com.example.jpa.model.Conta;
import br.com.example.jpa.util.JPAUtil;

public class TestaContaCliente {

	public static void main(String[] args) {

		/*
		 * OBS: Não esqueça que sera necessario deletar o banco e criar de novo para ver o @JoinColumn funcionando
		 */

		Cliente cliente = new Cliente();
		cliente.setNome("Leonardo");
		cliente.setEndereco("Rua Fulano, 123");
		cliente.setProfissao("Professor");

		Cliente cliente2 = new Cliente();
		cliente2.setNome("Douglas");
		cliente2.setEndereco("Rua Fulano, 234");
		cliente2.setProfissao("Professor");

		Conta conta = new Conta();
		conta.setId(2); // essa conta esta no estado 'Detached' pois ja possui um id!!

		cliente.setConta(conta);
		cliente2.setConta(conta);

		EntityManager em = new JPAUtil().getEntityManager();
		em.getTransaction().begin();

		em.persist(cliente);
//        em.persist(cliente2);

		em.getTransaction().commit();
	}
}