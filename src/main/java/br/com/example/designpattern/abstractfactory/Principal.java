package br.com.example.designpattern.abstractfactory;

import java.math.BigDecimal;

public class Principal {

	public static void main(String[] args) {
		
		Produto produto = new Produto();
		
		produto.setNome("Smartphone Moto X");
		produto.setQuantidade(1);
		produto.setValorUnitario(new BigDecimal(1000));
		
		NFE notaFiscal = new NFE("RJ");
		Boleto boleto = new Boleto("bmg");
		
		Venda venda = new Venda(produto, boleto, notaFiscal);
		venda.realizarVenda();
	}

}
