package br.com.example.jpa.teste;

import java.math.BigDecimal;
import java.util.Calendar;

import javax.persistence.EntityManager;

import br.com.example.jpa.model.Conta;
import br.com.example.jpa.model.Movimentacao;
import br.com.example.jpa.model.TipoMovimentacao;
import br.com.example.jpa.util.JPAUtil;

public class TesteJPARelacionamento {

	public static void main(String[] args) {

		Conta conta = new Conta();
		conta.setAgencia("111");
		conta.setBanco("Itau");
		conta.setNumero("54321");
		conta.setTitular("Leonardo");

		Movimentacao movimentacao = new Movimentacao();
		movimentacao.setData(Calendar.getInstance());
		movimentacao.setDescricao("Churrascaria");
		movimentacao.setTipoMovimentacao(TipoMovimentacao.SAIDA);
		movimentacao.setValor(new BigDecimal("200.0"));

		movimentacao.setConta(conta);

		EntityManager manager = new JPAUtil().getEntityManager();
		manager.getTransaction().begin();

		manager.persist(conta);
		manager.persist(movimentacao);

		manager.getTransaction().commit();
		manager.close();
	}
}