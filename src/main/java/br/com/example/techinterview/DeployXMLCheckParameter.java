package br.com.example.techinterview;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class DeployXMLCheckParameter {
	
	static String parameter = "label"; 
	static int maxSize = 48; 
	
	// to read deploy.xml
	public static void main(String[] args) throws IOException {
		File file = new File("/home/alirio/Desktop/deploy.xml");
		FileReader in = new FileReader(file);
		try (BufferedReader br = new BufferedReader(in)) { // Try used here to close the "BufferedReader"
			br.lines()
				.forEach(
						e -> {
							String parameterTemp = parameter + "=";
							if (e.indexOf(parameterTemp) > -1) {
								String s1 = e.substring(e.indexOf(parameterTemp) + 1 + parameter.length() + 1);
								String s2 = s1.substring(0, s1.indexOf("\""));
								if (s2.length() > maxSize) {
									System.out.println(s2);
								}
							}
						}
				);
		}
	}

}
