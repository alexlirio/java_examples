package br.com.example.jpa.teste;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import br.com.example.jpa.model.Categoria;
import br.com.example.jpa.model.Movimentacao;
import br.com.example.jpa.util.JPAUtil;

public class TesteMovimentacoesPorCategoria {

	public static void main(String[] args) {

		EntityManager manager = new JPAUtil().getEntityManager();

		Categoria categoria = new Categoria();
		categoria.setId(1);

		Query query = manager.createQuery("SELECT m FROM Movimentacao m JOIN m.categoria c WHERE c = :pCategoria");

		query.setParameter("pCategoria", categoria);

		List<Movimentacao> movimentacoes = query.getResultList();

		for (Movimentacao m : movimentacoes) {
			System.out.println("\nDescricao ..: " + m.getDescricao());
			System.out.println("Valor ......: R$ " + m.getValor());
		}

	}
}
