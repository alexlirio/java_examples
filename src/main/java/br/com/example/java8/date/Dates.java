package br.com.example.java8.date;

import java.text.SimpleDateFormat;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Month;
import java.time.OffsetDateTime;
import java.time.ZoneId;
import java.time.ZoneOffset;
import java.time.ZonedDateTime;
import java.time.temporal.ChronoUnit;
import java.util.Calendar;
import java.util.Date;

public class Dates {

	public static void main(String[] args) {
		
		// Format dates
		String horaLimite = new SimpleDateFormat("yyyyMMddHHmmss").format(new Date(113, 0, 1, 14, 30, 15));
		System.out.println(horaLimite); // 20130101143015
		Calendar c = Calendar.getInstance();
		c.set(Calendar.HOUR_OF_DAY, 15);
		c.set(Calendar.MINUTE, 45);
		String horaLimite2 = new SimpleDateFormat("yyyyMMddHHmmss").format(c.getTime());
		System.out.println(horaLimite2); // 20200709154543
		
		// Java 8 - Format dates
//		String horaLimite = new SimpleDateFormat("yyyyMMddHHmmss").format(new Date(113, 0, 1, 14, 30, 15));
//		System.out.println(horaLimite); // 20130101143015
//		Calendar c = Calendar.getInstance();
//		c.set(Calendar.HOUR_OF_DAY, 15);
//		c.set(Calendar.MINUTE, 45);
//		String horaLimite2 = new SimpleDateFormat("yyyyMMddHHmmss").format(c.getTime());
//		System.out.println(horaLimite2); // 20200709154543
		
		// Java 8 - Format dates with min and max time
		LocalDateTime ldt1 = LocalDate.now().atTime(LocalTime.MIN);
		LocalDateTime ldt2 = LocalDate.now().atTime(LocalTime.MAX);
		Date d1 = Date.from(ldt1.atZone(ZoneId.systemDefault()).toInstant());
		Date d2 = Date.from(ldt2.atZone(ZoneId.systemDefault()).toInstant());
		System.out.println(d1); // Thu Jul 09 00:00:00 BRT 2020
		System.out.println(d2); // Thu Jul 09 23:59:59 BRT 2020
		
		
		
		/*********************************************************/
		// Java 8 examples - without timezone
		/*********************************************************/
		System.out.println("\nJava 8 examples - without timezone");
		
	    // LocalDate - yyyy-MM-dd
	    LocalDate ldNow = LocalDate.now();
	    System.out.println("LocalDate yyyy-MM-dd: " + ldNow);
	    
	    LocalDate ld = LocalDate.of(1990, Month.AUGUST, 6);
	    System.out.println("LocalDate 1990-08-06: " + ld);
	    
	    LocalDate ld2 = ld.plusWeeks(2).plusDays(1).minusMonths(1);
	    System.out.println("LocalDate 1990-07-21: " + ld2);
	    
	    
	    // LocalTime - HH:mm:ss.SSS
	    LocalTime ltNow = LocalTime.now();
	    System.out.println("LocalTime HH:mm:ss.SSS: " + ltNow);
	    
	    LocalTime lt = LocalTime.of(11, 10, 01, 100000);
	    System.out.println("LocalTime 11:10:01.000100: " + lt);
	    
	    
	    // LocalDateTime - yyyy-MM-ddTHH:mm:ss.SSS
	    LocalDateTime ldtNow = LocalDateTime.now();
	    System.out.println("LocalDateTime yyyy-MM-ddTHH:mm:ss.SSS: " + ldtNow);
	    
	    LocalDateTime ldt = LocalDateTime.of(ld, lt);
	    System.out.println("LocalDateTime 1990-08-06T11:10:01.000100: " + ldt);
	    
	    
	    
	    /*********************************************************/
	    // Java 8 examples - with timezone
	    /*********************************************************/
	    System.out.println("\nJava 8 examples - with timezone");
	    
	    // Instant - yyyy-MM-ddTHH:mm:ss.SSSZ
	    Instant iNow = Instant.now(); //*Best option to get current UTC hour. e.g.: 2020-07-10T00:47:53.267Z
	    System.out.println("Instant yyyy-MM-ddTHH:mm:ss.SSSZ: " + iNow);
	    
	    Instant i = Instant.ofEpochMilli(500000000000L);
	    System.out.println("Instant 1985-11-05T00:53:20Z: " + i);
	    
	    Instant plus = i.plus(1, ChronoUnit.DAYS); //e.g.: plus MONTHS, YEARS or "OLDER" is not supported here  
	    System.out.println("Instant 1985-11-06T00:53:20Z: " + plus);
	    
	    
	    // OffsetDateTime - yyyy-MM-ddTHH:mm:ss.SSS-03:00
	    OffsetDateTime odtNow = OffsetDateTime.now(); //*Best option to get current GMT hour. e.g.: 2020-07-09T21:49:39.886-03:00
	    System.out.println("OffsetDateTime yyyy-MM-ddTHH:mm:ss.SSS-03:00: " + odtNow);
	    
	    ZoneOffset zoneOffset = ZoneOffset.of("-07:00");
	    OffsetDateTime odt = OffsetDateTime.of(ld, lt, zoneOffset);
	    System.out.println("Instant yyyy-MM-ddTHH:mm:ss.SSS-07:00: " + odt);
	    
	    
	    // ZonedDateTime - yyyy-MM-ddTHH:mm:ss.SSS-03:00[America/Sao_Paulo]
	    ZonedDateTime zdtNow = ZonedDateTime.now();
	    System.out.println("Instant yyyy-MM-ddTHH:mm:ss.SSS-03:00[America/Sao_Paulo]: " + zdtNow);
	    
	    ZoneId zoneId = ZoneId.of("US/Pacific");
	    ZonedDateTime zdt = ZonedDateTime.of(ld, lt, zoneId);
	    System.out.println("Instant yyyy-MM-ddTHH:mm:ss.SSS-07:00[US/Pacific]: " + zdt);
	}
}
