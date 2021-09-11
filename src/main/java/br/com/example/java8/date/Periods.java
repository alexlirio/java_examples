package br.com.example.java8.date;

import java.time.LocalDate;
import java.time.Month;
import java.time.Period;

public class Periods {

	public static void main(String[] args) {
	    /*******************************************************************/
		// Java 8 examples - Period (*Use with '*Date' - e.g.: LocalDate)
	    /*******************************************************************/
	    System.out.println("\nJava 8 examples - Period");
	    
	    Period of = Period.of(1, 5, 0);
	    System.out.println(of);

	    Period cincoAnos = Period.ofYears(5);
	    System.out.println(cincoAnos);
	    
	    LocalDate ld = LocalDate.of(1990, Month.AUGUST, 6);
	    LocalDate ld2 = ld.plusWeeks(2).plusDays(1).plusMonths(1);
	    Period between1 = Period.between(ld, ld2);//*Period.between is to use with '*Date'(e.g.: LocalDate)
	    System.out.println(between1);
	    
	    Period between2 = between1.plusDays(10);
	    System.out.println(between2);

	    Period until = ld.until(ld2);
	    System.out.println(until);

	    LocalDate plus = ld.plus(cincoAnos);
	    System.out.println(plus);
	    
//	    // Caution - Don't use 'Period' with '*Time' (e.g.: LocalTime)
//	    LocalTime ltNow2 = LocalTime.now();
//	    LocalTime plus2 = ltNow2.plus(cincoAnos); //Throw UnsupportedTemporalTypeException: Unsupported unit: Years
//	    System.out.println(plus2);
	    
	    LocalDate nascimento = LocalDate.of(1990, Month.AUGUST, 6);
	    LocalDate hoje = LocalDate.now();
	    Period between3 = Period.between(nascimento, hoje);
	    System.out.println(between3);
	}
}
