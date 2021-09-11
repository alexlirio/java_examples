package br.com.example.hackerrank;

public class Foo1 {
	
	String a, b, c, d;
	
	void setA(String b) {
		a = b;
	}
	
	void setB(String b) {
		b = this.a;
	}
	
	void setC(String d) {
		this.c = this.d;
	}
	
	void setD(String a) {
		this.d = d;
	}
}