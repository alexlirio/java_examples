package br.com.example;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class FileProperties {

	private static Properties props = new Properties();
	
	public static void main(String[] args) {
		
		try {
			props.load(new FileInputStream("src/main/resources/config.properties"));
		} catch (FileNotFoundException e) {
			System.out.println("ERRO: FileNotFoundException 'config.properties'.");
			e.printStackTrace();
		} catch (IOException e) {
			System.out.println("ERRO: IOException 'config.properties'.");
			e.printStackTrace();
		}
		System.out.println(props.getProperty("propriedade.nome"));
		System.out.println(props.getProperty("propriedade.senha"));
	}

}
