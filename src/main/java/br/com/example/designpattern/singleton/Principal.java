package br.com.example.designpattern.singleton;

public class Principal {

	public static void main(String[] args) {
		
//		GerenciadorImpressao g1 = new GerenciadorImpressao();
//		GerenciadorImpressao g2 = new GerenciadorImpressao();
		
		GerenciadorImpressao g1 = GerenciadorImpressao.getInstance(); //Singleton - Design Pattern
		GerenciadorImpressao g2 = GerenciadorImpressao.getInstance(); //Singleton - Design Pattern
		
		System.out.println(g1);
		System.out.println(g2);
		
	}
}
