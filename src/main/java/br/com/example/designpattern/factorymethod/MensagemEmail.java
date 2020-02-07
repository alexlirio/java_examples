package br.com.example.designpattern.factorymethod;

public class MensagemEmail implements Mensagem {

	@Override
	public void enviar(String mensagem) {
		System.out.println("E-mail: " + mensagem);
	}

}
