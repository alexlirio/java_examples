package br.com.example;

import java.util.List;
import java.util.logging.Logger;

import com.human.gateway.client.bean.Response;
import com.human.gateway.client.bean.SimpleMessage;
import com.human.gateway.client.exception.ClientHumanException;
import com.human.gateway.client.service.SimpleMessageService;

public class SMSs {
	
	SimpleMessageService clienteHuman = null;

	private final static Logger LOGGER = Logger.getLogger(SMSs.class
			.getName());
	
	public static void main(String[] args) {
		
		String id = "01000240704106455251";
		String numero = "5521988844171";
		String mensagem = "Consulte sua NF em http://goo.gl/ZxbF3a";
		String user = "no_arquivo_secret_gist_credenciais.txt";
		String senha = "no_arquivo_secret_gist_credenciais.txt";
		
		String resultado = "";
		
		try {
			resultado = enviaSMS(id, numero, mensagem, user, senha);
		} catch (ClientHumanException e) {
			e.printStackTrace();
		}
		
		System.out.println("Resultado do envio de SMS: " + resultado);
	}

	public static String enviaSMS(String id, String numero, String mensagem, String user, String senha) throws ClientHumanException {
		String result = "Erro";
		// Cria uma instancia do cliente de conexao
		SimpleMessageService clienteHuman = new SimpleMessageService(user, senha);

		// Cria uma mensagem individual
		SimpleMessage msgSMSInstance = new SimpleMessage();
		// Id da mensagem
		msgSMSInstance.setId(id);
		// Numero do celular de destino
		msgSMSInstance.setTo(numero);
		// Conteudo do SMS
		msgSMSInstance.setMessage(mensagem);

		LOGGER.info("Enviando " + mensagem + " para " + numero);

		// Obtem o retorno da integracao (codigo/descricao)
		List<Response> retornos;
		retornos = clienteHuman.send(msgSMSInstance);
		for (Response retorno : retornos) {
			result = retorno.getReturnCode() + ":" + retorno.getReturnDescription();
			LOGGER.info(result);
		}

		return result;

	}
	
}
