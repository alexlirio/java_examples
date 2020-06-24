package br.com.example;

import java.util.Optional;

public class OptionalTest02 {

	public static void main(String[] args) {
		System.out.println(Optional.ofNullable("alex").orElse(null)); //print 'alex'
		System.out.println(Optional.ofNullable(null).orElse(null)); //print null
	}
}
