package br.com.example;

import java.text.Normalizer;

public class Strings {
	
	public static void main(String[] args) {
		System.out.println(Normalizar("Nao vai haver golpe!"));
	}
	
	/**
	 * Metodo para retirar a acentuacao e caracteres especiais
	 * 
	 * @param txtToNormalize
	 * @return String normalizada
	 */
	public static String Normalizar(String txtToNormalize) {
		if (txtToNormalize != null && !"".equals(txtToNormalize)) {
			return Normalizer.normalize(txtToNormalize, Normalizer.Form.NFD)
					.replaceAll("[^\\p{ASCII}]", "");
		} else {
			return "";
		}

	}

}
