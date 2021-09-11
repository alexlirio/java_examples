package br.com.example.jpa.model.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import br.com.example.jpa.model.Conta;
import br.com.example.jpa.model.TipoMovimentacao;

public class MovimentacaoDao {
	
	private EntityManager em;

	public MovimentacaoDao(EntityManager manager) {
		this.em = manager;
	}

	public List<Double> getMediasPorDiaETipo(TipoMovimentacao tipoMovimentacao, Conta conta) {
		String jpql = "SELECT DISTINCT AVG(m.valor) FROM Movimentacao m "
				+ "WHERE m.conta = :pConta AND m.tipoMovimentacao = :pTipo GROUP BY m.data";
		TypedQuery<Double> query = em.createQuery(jpql, Double.class);
		query.setParameter("pConta", conta);
		query.setParameter("pTipo", tipoMovimentacao);
		return query.getResultList();
	}
}
