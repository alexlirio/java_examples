package br.com.example.designpattern.builder;

import java.math.BigDecimal;
import java.util.ArrayList;

public class Principal {

//	public static void main(String[] args) {
//		
//		Cliente cliente = new Cliente();
//		cliente.setCodigo(100);
//		cliente.setNome("Carlos");
//		cliente.setTelefone("8888-8888");
//		
//		Vendedor vendedor = new Vendedor();
//		vendedor.setCodigo(1);
//		vendedor.setNome("Joao");
//		
//		Produto produto1 = new Produto();
//		produto1.setQuantidade(1);
//		produto1.setNome("Caderno");
//		produto1.setValor(new BigDecimal(10.00));
//		
//		Produto produto2 = new Produto();
//		produto2.setQuantidade(2);
//		produto2.setNome("Caneta");
//		produto2.setValor(new BigDecimal(1.50));
//		
//		Pedido pedido = new Pedido();
//		pedido.setNumeroPedido("00001");
//		pedido.setCliente(cliente);
//		pedido.setVendedor(vendedor);
//		pedido.setProdutos(new ArrayList<Produto>());
//		pedido.getProdutos().add(produto1);
//		pedido.getProdutos().add(produto2);
//		
//		pedido.informacoes();
//	}
	
	public static void main(String[] args) {
		
		Pedido pedido = new PedidoBuilder()
							.setPedido("9999")
							.setCliente(100, "Luiz", "9999-9999")
							.setVendedor(2, "Joao")
							.setProduto("Caderno", 1, new BigDecimal(12.00))
							.setProduto("Lapis", 3, new BigDecimal(1.00))
							.setProduto("Borracha", 2, new BigDecimal(0.50))
							.builder(); //Builder - Design Pattern
		
		pedido.informacoes();
	}
}
