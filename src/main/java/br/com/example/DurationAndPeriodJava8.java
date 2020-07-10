package br.com.example;

import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.Month;
import java.time.Period;

public class DurationAndPeriodJava8 {

	public static void main(String[] args) {
		
		/*******************************************************************/
		// Java 8 examples - Duration (*Use with '*Time' - e.g.: LocalTime)
		/*******************************************************************/
		System.out.println("\nJava 8 examples - Duration");
		
	    Duration ofDays = Duration.ofDays(2);
	    System.out.println(ofDays); //PT48H
	    
	    Duration ofHours = Duration.ofHours(1);
	    System.out.println(ofHours); //PT1H
	    
	    Duration ofMinutes = Duration.ofMinutes(500);
	    System.out.println(ofMinutes); //PT8H20M
	    
	    Duration ofSeconds = Duration.ofSeconds(10, 5000);
	    System.out.println(ofSeconds); //PT10.000005S

	    LocalTime ltNow = LocalTime.now();
	    LocalTime lt = LocalTime.of(11, 10, 01);
	    Duration between = Duration.between(ltNow, lt); //*Duration.between is to use with '*Time'(e.g.: LocalTime)
	    System.out.println(between); //PT-10H-48M-13.056S
	    
	    Duration plusMillis = between.plusMillis(500);
	    System.out.println(plusMillis); //PT-10H-48M-12.556S
	    
//	    // Caution - Don't use 'Duration' with '*Date' (e.g.: LocalDate)
//	    LocalDate ld = LocalDate.of(1990, Month.AUGUST, 6);
//	    LocalDate ld2 = ld.plusWeeks(2).plusDays(1).minusMonths(1);    
//	    Duration between2 = Duration.between(ld, ld2); //Throw UnsupportedTemporalTypeException: Unsupported unit: Seconds
//	    System.out.println(between2);
	    
	    
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
