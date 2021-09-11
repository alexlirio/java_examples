package br.com.example;

public class Threads implements Runnable {
	private Acount acct = new Acount();

	public static void main(String[] args) {
		Threads r = new Threads();
		Thread one = new Thread(r);
		Thread two = new Thread(r);

		one.setName("Fred");
		two.setName("Lucy");
		one.start();
		two.start();

	}

	// metodo que inicia o sistema
	public void run() {
		for (int x = 0; x < 5; x++) {
			calculo(10);
			if (acct.getBalance() < 0) {
				System.out.println("Conta esta negativa  ");
			}
		}
	}

	// metodo que inicia a retirada
	private void calculo(int amt) {
		if (acct.getBalance() >= amt) {
			System.out.println(Thread.currentThread().getName() + " Sistema fazendo retirada ");

			try {
				Thread.sleep(500);
			} catch (InterruptedException ex) {
			}

			acct.retirada(amt);
			System.out.println(Thread.currentThread().getName() + " Sistema completou retirada ");

		} else {
			System.out.println("Nao e possivel na conta de " + Thread.currentThread().getName() + " fazer retirada " + acct.getBalance());

		}

	}

	public class Acount {
		// Cria variavel para saldo
		private int balance = 50;

		// metodo que retorna o saldo
		public int getBalance() {
			return balance;
		}

		// metodo que faz retirada
		public void retirada(int menos) {
			balance -= menos;
		}
	}

}
