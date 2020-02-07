package br.com.example.designpattern.abstractfactory;

public class NFE {
	
	private String uf;

	public NFE(String uf) {
		super();
		this.uf = uf;
	}
	
	public double calcularImposto() {
		if (uf.equalsIgnoreCase("MG")) {
			return 18;
		} if (uf.equalsIgnoreCase("RJ")) {
			return 20;
		} else {
			return 10;
		}
	}

}
