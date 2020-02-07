package br.com.example.hackerrank;

import java.time.LocalDate;
import java.util.Scanner;

public class Solution33 {

	public static void main(String[] args) {
		/* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
		Scanner scanner = new Scanner(System.in);
		String[] d1 = scanner.nextLine().split(" ");
		String[] d2 = scanner.nextLine().split(" ");
		scanner.close();

//        String[] d1 = new String[] {"1", "1", "2010"}; // date returned
//        String[] d2 = new String[] {"31", "12", "2009"}; // date expected to  be returned

        LocalDate ld1 = LocalDate.of(Integer.valueOf(d1[2]), Integer.valueOf(d1[1]), Integer.valueOf(d1[0]));
        LocalDate ld2 = LocalDate.of(Integer.valueOf(d2[2]), Integer.valueOf(d2[1]), Integer.valueOf(d2[0]));
        
        long r = 0;
        if (ld1.isAfter(ld2)) {
        	int daysBetween = Integer.valueOf(d1[0]) - Integer.valueOf(d2[0]);
        	int monthsBetween = Integer.valueOf(d1[1]) - Integer.valueOf(d2[1]);
        	int yearsBeteween = Integer.valueOf(d1[2]) - Integer.valueOf(d2[2]);
        	
        	if (yearsBeteween > 0) {
        		// 1 year or more = 10000 hackos
        		r = 10000;
        	} else if (monthsBetween > 0) {
        		// 1 month = 500 hackos
        		r = monthsBetween * 500;
        	} else if (daysBetween > 0) {
        		// 1 day = 15 hackos
        		r = daysBetween * 15;
        	}
		}
		System.out.println(r);
	}
}