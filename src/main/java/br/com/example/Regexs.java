package br.com.example;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Regexs {
	
	public static void main(String[] args) {
		
		System.out.println("Letras e numeros: " + Pattern.matches("[a-zA-Z0-9]*", "asd001"));
		System.out.println("E-mail: " + Pattern.matches("[a-zA-Z0-9]+[a-zA-Z0-9_.-]+@{1}[a-zA-Z0-9_.-]*\\.+[a-z]{2,4}", "aa@a.aa"));
		System.out.println("Entre 2 e 5 caracteres: " + Pattern.matches("[a-zA-Z0-9]{2,5}+", "aa"));
		System.out.println("Hora e minutos: " + Pattern.matches("([01]?[0-9]|2[0-3]):[0-5][0-9]", "23:59"));
		System.out.println("11 ou 14 numeros " + Pattern.matches("([0-9]{11})|([0-9]{14})", "12345678901"));

		System.out.println("E-mail: " + Pattern.matches("alex.lirio", "alex.lirio"));
		
		
		// Formatar Strings
		// Telefone de 9999999999 para (99) 9999-9999
        Pattern pattern = Pattern.compile("(\\d{2})(\\d{4})(\\d{4})");  
        Matcher matcher = pattern.matcher("9999999999");  
        if (matcher.matches()) {
        	System.out.println(matcher.replaceAll("($1) $2-$3"));
        }
        
		// Formatar Strings
		// CNPJ de 17.367.322/0001-76 para 17367322000176 (3 opcaes iguais)
        System.out.println("17.367.322/0001-76".replaceAll("[^0-9]", "")); 
        System.out.println("17.367.322/0001-76".replaceAll("[^\\d]", ""));      
        System.out.println("17.367.322/0001-76".replaceAll("[\\D]", ""));

        /**
            Explanation:
			^                 # start-of-string
			(?=.*[0-9])       # a digit must occur at least once
			(?=.*[a-z])       # a lower case letter must occur at least once
			(?=.*[A-Z])       # an upper case letter must occur at least once
			(?=.*[@#$%^&+=])  # a special character must occur at least once
			(?=\S+$)          # no whitespace allowed in the entire string
			.{8,}             # anything, at least eight places though
			$                 # end-of-string
         */
        System.out.println("Password1: " + Pattern.matches("^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=])(?=\\S+$).{8,}$", "aSD1111@"));
        System.out.println("Password2(melhorado): " + Pattern.matches("^(?=.*[\\d])(?=.*[a-z])(?=.*[A-Z])(?=.*[^a-zA-Z0-9])(?=\\S+$).{8,}$", "aSD1111@"));
	}

}
