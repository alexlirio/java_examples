package br.com.example;

public class Threads3 {

	public static void main(String[] args) {
		System.out.println("Line 1");
		new Thread(t1).start();
		System.out.println("Line 2");
	}
	
	private static Runnable t1 = new Runnable() {
		public void run() {
			try {
				System.out.println("t1");
			} catch (Exception e) {
			}
		}
	};

}
