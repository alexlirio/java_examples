package br.com.example.jpa.teste;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import br.com.example.jpa.model.Conta;
import br.com.example.jpa.model.Movimentacao;
import br.com.example.jpa.model.TipoMovimentacao;
import br.com.example.jpa.util.JPAUtil;

public class TesteJPQL {

	public static void main(String[] args) {
		EntityManager manager = new JPAUtil().getEntityManager();

		Conta conta = new Conta();
		conta.setId(1);

		Query query = manager.createQuery("SELECT m FROM Movimentacao m "
				+ "WHERE m.conta = :pConta AND m.tipo = :pTipo ORDER BY m.valor DESC");

		query.setParameter("pConta", conta);
		query.setParameter("pTipo", TipoMovimentacao.ENTRADA);

		List<Movimentacao> movimentacoes = query.getResultList();

		for (Movimentacao m : movimentacoes) {
			System.out.println("Descricao: " + m.getDescricao());
			System.out.println("Conta.id:" + m.getValor());
		}
	}
}