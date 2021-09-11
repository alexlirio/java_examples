package br.com.example.jpa.teste;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import br.com.example.jpa.model.Conta;
import br.com.example.jpa.model.TipoMovimentacao;
import br.com.example.jpa.util.JPAUtil;

public class TesteFuncaoJPQL {
	public static void main(String[] args) {

		EntityManager manager = new JPAUtil().getEntityManager();

		Conta conta = new Conta();
		conta.setId(3);

		TypedQuery<Double> query = manager.createNamedQuery("MediasPorDiaETipo", Double.class);

		query.setParameter("pConta", conta);
		query.setParameter("pTipo", TipoMovimentacao.SAIDA);

		List<Double> medias = query.getResultList();

		for (Double media : medias) {
			System.out.println("A média é: " + media);
		}
	}
}