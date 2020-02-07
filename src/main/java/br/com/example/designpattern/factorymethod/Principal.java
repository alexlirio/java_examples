package br.com.example.designpattern.factorymethod;

public class Principal {

	public static void main(String[] args) {
		
		String texto = "Texto exemplo!";
		
		Mensagem mensagem = MensagemFactory.getMensagem(1); //Factory Method - Design Pattern
		mensagem.enviar(texto);
		
	}
}
