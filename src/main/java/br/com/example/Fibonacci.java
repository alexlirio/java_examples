package br.com.example;

import java.math.BigInteger;
import java.util.HashMap;
import java.util.Map;

public class Fibonacci {
	
	public static void main(String[] args) {
		// Explanations:
		// The first n numbers in fibonacci sequence is: 0, 1, 1, 2, 3, 5, 8, 13, 21, 34, ...
		// f(92) = 7540113804746346429 (*n=92 is the last possible to store in a long type) 
		// f(93) = 12200160415121876738 (*n=93 is not possible to store in a long type. Use BigInteger if n > 92)
		// *The max long value is 9223372036854775807 (use BigInteger to store a larger value)
		
		int n = 0;
		
		long ms = 0; // To calc the milliseconds execution
		
		ms = System.currentTimeMillis();
		n = 1000; // f(1000) = 43466557686937456435688527675040625802564660517371780402481729089536555417949051890403879840079255169295922593080322634775209689623239873322471161642996440906533187938298969649928516003704476137795166849228875
		System.out.println("#1 fibonacci with memorization and BigInteger (*fast execution and support big values in result)");
		System.out.println("   f(" + n + ")");
		System.out.println("   Result = " + fibonacciWithMemorizationAndBigInteger(n) + " in " + (System.currentTimeMillis() - ms) + "ms");
		System.out.println("   Time = " + (System.currentTimeMillis() - ms) + "ms\n");
		
		ms = System.currentTimeMillis();
		n = 92; // f(92) = 7540113804746346429
		System.out.println("#2 fibonacci with memorization and long (*fast execution but not support big values in result - The max long value is 9223372036854775807)");
		System.out.println("   f(" + n + ")");
		System.out.println("   Result = " + fibonacciWithMemorization(n) + " in " + (System.currentTimeMillis() - ms) + "ms");
		System.out.println("   Time = " + (System.currentTimeMillis() - ms) + "ms\n");
		
		ms = System.currentTimeMillis();
		n = 72; // f(72) = 498454011879264
		System.out.println("#3 fibonacci with Binet's Math Formula (*fast execution but result is wrong if n > 71. e.g.: f(72))");
		System.out.println("   f(" + n + ")");
		System.out.println("   Result = " + fibonacciWithBinetFormula(n) + " in " + (System.currentTimeMillis() - ms) + "ms");
		System.out.println("   Time = " + (System.currentTimeMillis() - ms) + "ms\n");
		
		ms = System.currentTimeMillis();
		n = 50; // f(50) = 12586269025
		System.out.println("#4 fibonacci classic (*very slow execution with big values in result)");
		System.out.println("   f(" + n + ")");
		System.out.println("   Result = " + fibonacciClassic(n) + " in " + (System.currentTimeMillis() - ms) + "ms");
		System.out.println("   Time = " + (System.currentTimeMillis() - ms) + "ms\n");
	}
	
	/**
	 * Fibonacci with memorization and BigInteger
	 * Attention: this has a fast time execution, the result is correct and support a big results
	 * @param n
	 * @return
	 */
	public static BigInteger fibonacciWithMemorizationAndBigInteger(int n) {
		Map<Integer, BigInteger> memoryMap = new HashMap<>();
		BigInteger ret = fibonacciWithMemorizationAndBigInteger(n - 1, memoryMap).add(fibonacciWithMemorizationAndBigInteger(n - 2, memoryMap));
		memoryMap.put(n, ret);
		return ret;
	}
	private static BigInteger fibonacciWithMemorizationAndBigInteger(int n, Map<Integer, BigInteger> memoryMap) {
		if (memoryMap.containsKey(n)) {
			return memoryMap.get(n);
		}
		if (n <= 1) {
			return new BigInteger(Integer.toString(n));
			
		} else {
			BigInteger ret = fibonacciWithMemorizationAndBigInteger(n - 1, memoryMap).add(fibonacciWithMemorizationAndBigInteger(n - 2, memoryMap));
			memoryMap.put(n, ret);
			return ret;
		}
	}
	
	/**
	 * Fibonacci with memorization
	 * Attention: this has a fast time execution, the result is correct but not support result > 9223372036854775807 (Long.MAX_VALUE)
	 * @param n
	 * @return
	 */
	public static long fibonacciWithMemorization(int n) {
		Map<Integer, Long> memoryMap = new HashMap<>();
		long ret = fibonacciWithMemorization(n - 1, memoryMap) + fibonacciWithMemorization(n - 2, memoryMap);
		memoryMap.put(n, ret);
		return ret;
	}
	private static long fibonacciWithMemorization(int n, Map<Integer, Long> memoryMap) {
		if (memoryMap.containsKey(n)) {
			return memoryMap.get(n);
		}
		if (n <= 1) {
			return n;
			
		} else {
			long ret = fibonacciWithMemorization(n - 1, memoryMap) + fibonacciWithMemorization(n - 2, memoryMap);
			memoryMap.put(n, ret);
			return ret;
		}
	}
	
	/**
	 * Binet's Fibonacci Math Formula
	 * Reference: https://mathworld.wolfram.com/BinetsFibonacciNumberFormula.html
	 * Attention: this has a fast time execution but the result is not correct with n > 71
	 * @param n
	 * @return
	 */
	private static long fibonacciWithBinetFormula(int n) {
		double pha = Math.pow(1 + Math.sqrt(5), n);
		double phb = Math.pow(1 - Math.sqrt(5), n);
		double div = Math.pow(2, n) * Math.sqrt(5);
		
		return (long) ((pha - phb) / div);
	}

	/**
	 * Fibonacci classic way
	 * Attention: this has a very slow time execution
	 * @param n
	 * @return
	 */
	public static long fibonacciClassic(int n) {
		if (n <= 1) // index == 0 or index == 1
			return n;
		else
			return fibonacciClassic(n - 1) + fibonacciClassic(n - 2);
	}
}