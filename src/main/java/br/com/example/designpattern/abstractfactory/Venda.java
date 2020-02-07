package br.com.example.designpattern.abstractfactory;

public class Venda {
	
	Produto produto;
	Boleto boleto;
	NFE notaFiscal;
	
	public Venda(Produto produto, Boleto boleto, NFE notaFiscal) {
		super();
		this.produto = produto;
		this.boleto = boleto;
		this.notaFiscal = notaFiscal;
	}

	public void realizarVenda() {
		// TODO Auto-generated method stub
	}

}
