package br.com.example.jpa.teste;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import br.com.example.jpa.model.Conta;
import br.com.example.jpa.util.JPAUtil;

public class TesteMovimentacaoConta {

	public static void main(String[] args) {

		EntityManager manager = new JPAUtil().getEntityManager();
		Query query = manager.createQuery("SELECT DISTINCT c FROM Conta c LEFT JOIN FETCH c.movimentacoes");

		List<Conta> contas = query.getResultList();

		for (Conta conta : contas) {
			System.out.println("Titular: " + conta.getTitular());
			System.out.println("Número de movimentações ...: " + conta.getMovimentacoes().size());
		}
	}
}