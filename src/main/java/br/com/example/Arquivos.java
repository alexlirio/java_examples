package br.com.example;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Arquivos {

	// Java 7
	final static String INPUT_FILE = "src/main/resources/input.txt";
	final static String OUTPUT_FILE = "src/main/resources/output.txt";
	final static Charset ENCODING = StandardCharsets.UTF_8;

	public static void main(String[] args) throws IOException {

		Arquivos text = new Arquivos();

		// treat as a small file
		List<String> lines = text.readSmallTextFile(INPUT_FILE);
		log(lines);
		lines.add("This is a line added in code.");
		text.writeSmallTextFile(lines, INPUT_FILE);

		// treat as a large file - use some buffering
		text.readLargerTextFile(INPUT_FILE);
		lines = Arrays.asList("Down to the Waterline", "Water of Love");
		text.writeLargerTextFile(OUTPUT_FILE, lines);
	}

	// For smaller files

	List<String> readSmallTextFile(String aFileName) throws IOException {
		Path path = Paths.get(aFileName);
		return Files.readAllLines(path, ENCODING);
	}

	void writeSmallTextFile(List<String> aLines, String aFileName) throws IOException {
		Path path = Paths.get(aFileName);
		Files.write(path, aLines, ENCODING);
	}

	// For larger files
	void readLargerTextFile(String aFileName) throws IOException {
		Path path = Paths.get(aFileName);
		try (Scanner scanner = new Scanner(path, ENCODING.name())) {
			while (scanner.hasNextLine()) {
				// process each line in some way
				log(scanner.nextLine());
			}
		}
	}

	void readLargerTextFileAlternate(String aFileName) throws IOException {
		Path path = Paths.get(aFileName);
		try (BufferedReader reader = Files.newBufferedReader(path, ENCODING)) {
			String line = null;
			while ((line = reader.readLine()) != null) {
				// process each line in some way
				log(line);
			}
		}
	}

	void writeLargerTextFile(String aFileName, List<String> aLines) throws IOException {
		Path path = Paths.get(aFileName);
		try (BufferedWriter writer = Files.newBufferedWriter(path, ENCODING)) {
			for (String line : aLines) {
				writer.write(line);
				writer.newLine();
			}
		}
	}

	private static void log(Object aMsg) {
		System.out.println(String.valueOf(aMsg));
	}

//	// Java 6 ou anterior.
//	public static void main(String[] args) throws IOException {
//		File file = new File("resources/arquivo.txt");
//		file.createNewFile();
//		System.out.println(File.separator);
//		System.out.println(File.separatorChar);
//		System.out.println(File.pathSeparator);
//		System.out.println(File.pathSeparatorChar);
//	}

}
