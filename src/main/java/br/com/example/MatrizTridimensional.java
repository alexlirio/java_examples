package br.com.example;

public class MatrizTridimensional {

	public static void main(String[] args) {
		
		int[][][] matrizTridimensional = new int[3][3][3];

		//For para setar o valor de cada posicao
		for (int i=0; i<matrizTridimensional.length; i++){
			for (int j=0; j<matrizTridimensional[i].length; j++){
				for (int k=0; k<matrizTridimensional[i][j].length; k++){
					System.out.println("i = " + i + " - j = " + j + " - k = " + k);
					//Seta o valor com a soma dos indices
					matrizTridimensional[i][j][k] = i + j + k;
				}
			}
		}
		
		int soma = 0;
		int somaPares = 0;
		int somaImpares = 0;
		for (int i=0; i<matrizTridimensional.length; i++){
			for (int j=0; j<matrizTridimensional[i].length; j++){
				for (int k=0; k<matrizTridimensional[i][j].length; k++){
					
					int valor = matrizTridimensional[i][j][k];
					soma += valor;
					
					if (valor % 2 == 0){
						somaPares += valor;
					} else {
						somaImpares += valor;
					}
				}
			}
		}
		
		System.out.println("Soma total = " + soma);
		System.out.println("Soma pares = " + somaPares);
		System.out.println("Soma impares = " + somaImpares);
	}
}