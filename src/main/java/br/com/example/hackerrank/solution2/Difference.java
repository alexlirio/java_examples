package br.com.example.hackerrank.solution2;

public class Difference {
  	private int[] elements;
  	public int maximumDifference;
  	
    public Difference(int[] elements) {
		super();
		this.elements = elements;
	}

	public void computeDifference() {
		this.maximumDifference = 0;
		for (int i = 0; i < elements.length; i++) {
			for (int j = 0; j < elements.length; j++) {
				if (elements[i] - elements[j] > maximumDifference) {
					maximumDifference = elements[i] - elements[j]; 
				}
			}
		}
	}
}

