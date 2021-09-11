package br.com.example;

import java.util.Arrays;
import java.util.List;

public enum Enumerador {
	CONFIRMADA("000b"),
	BILHETE_PREMIADO_000("000"),
	BILHETE_PREMIADO_010("010"),
	BILHETE_PREMIADO_011("011"),
	BILHETE_NAO_PREMIADO_100("100"),
	TRANSACAO_NEGADA("999b"),
	TRANSACAO_SEM_RESPOSTA("999c"),;

	private String code;

	private Enumerador(String code) {
		this.code = code;
	}

	public String getCode() {
		return code;
	}

	public String getKey() {
		return String.valueOf(this.ordinal());
	}

	public String getDescription() {
		switch (this) {
		case CONFIRMADA:
			return "Transacao confirmada";
		case BILHETE_PREMIADO_000:
			return "Bilhete Premiado, pague o premio";
		case BILHETE_PREMIADO_010:
			return "Bilhete Premiado, dirija-se a Loterj";
		case BILHETE_PREMIADO_011:
			return "Bilhete Premiado, exige confirmacao e identificacao do operador";
		case BILHETE_NAO_PREMIADO_100:
			return "Bilhete nao premiado";
		case TRANSACAO_NEGADA:
			return "Transacao negada";
		case TRANSACAO_SEM_RESPOSTA:
			return "Transacao sem resposta";
		}

		return "";
	}

	public static List<Enumerador> getList() {
		return Arrays.asList(Enumerador.values());
	}
}
