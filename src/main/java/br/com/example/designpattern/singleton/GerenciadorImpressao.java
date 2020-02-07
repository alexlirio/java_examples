package br.com.example.designpattern.singleton;

public class GerenciadorImpressao {
	
	private static GerenciadorImpressao gerenciadorImpressao;
	
	public GerenciadorImpressao() {
		// TODO Auto-generated constructor stub
	}
	
	public static GerenciadorImpressao getInstance() {
		if (gerenciadorImpressao == null) {
			gerenciadorImpressao = new GerenciadorImpressao();
		}
		return gerenciadorImpressao;
	}

}
