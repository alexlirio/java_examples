package br.com.example.hackerrank;

class Foo {
	Object myMethod(String arg) {
		return "f";
	}
}
public class Bar extends Foo {
	
	String myMethod(String arg) {
		return "b";
	}

	
	public static void main(String[] args) {
		Bar bar = new Bar();
		Foo foo = new Bar();
		System.out.println(bar.myMethod(""));
		System.out.println(foo.myMethod(""));
	}
}