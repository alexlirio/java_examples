package br.com.example.java8.date;

import java.time.Duration;
import java.time.LocalTime;

public class Durations {

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
	}
}
