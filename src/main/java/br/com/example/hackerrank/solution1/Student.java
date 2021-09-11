package br.com.example.hackerrank.solution1;

public class Student extends Person {
	
	private int[] testScores;

	public Student(String firstName, String lastName, int id, int[] scores) {
		super(firstName, lastName, id);
		this.testScores = scores;
	}
	
	
	public static void main(String[] args) {
		String firstName = "Heraldo";
		String lastName = "Memelli";
		int id = 8135627;
		int numberOfTestScore = 2;
		int[] testScores = {100, 80};
		Student s = new Student(firstName, lastName, id, testScores);
//		s.printPerson();
		System.out.println("Grade: " + s.calculate() );
	}


	public char calculate() {
		int sum = 0;
		for (int i = 0; i < this.testScores.length; i++) {
			sum += this.testScores[i];
		}
		
		int score = sum / testScores.length;
		
		if (score >= 90 && score <= 100) {
			return 'O';
		} else if (score >= 80 && score < 90) {
			return 'E';
		} else if (score >= 70 && score < 80) {
			return 'A';
		} else if (score >= 55 && score < 70) {
			return 'P';
		} else if (score >= 40 && score < 55) {
			return 'D';
		} else if (score < 40) {
			return 'T';
		} else {
			return 'X';
		}
		
	}
}