package br.com.example.designpattern.factorymethod;

public class MensagemFactory {
	
	public static Mensagem getMensagem(int i) {
		if (i == 1) {
			return new MensagemSMS();
		} else if (i == 2) {
			return new MensagemEmail();
		} else {
			return new MensagemSMS();
		}
	}

	public static void main(String[] args) {
		
		String texto = "Texto exemplo!";
		
		Mensagem mensagem = new MensagemSMS();
		mensagem.enviar(texto);
		
	}
}
