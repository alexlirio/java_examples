package br.com.example;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.ZoneId;
import java.util.Calendar;
import java.util.Date;

public class Datas {

	public static void main(String[] args) {
		
		// Formata datas
		String horaLimite = new SimpleDateFormat("yyyyMMddHHmmss").format(new Date(113, 0, 1, 14, 30, 15));
		System.out.println(horaLimite);
		Calendar c = Calendar.getInstance();
		c.set(Calendar.HOUR_OF_DAY, 15);
		c.set(Calendar.MINUTE, 45);
		String horaLimite2 = new SimpleDateFormat("yyyyMMddHHmmss").format(c.getTime());
		System.out.println(horaLimite2);
		
		// Java 8 - Format dates with min and max time
		LocalDateTime ldt1 = LocalDate.now().atTime(LocalTime.MIN);
		LocalDateTime ldt2 = LocalDate.now().atTime(LocalTime.MAX);
		Date d1 = Date.from(ldt1.atZone(ZoneId.systemDefault()).toInstant());
		Date d2 = Date.from(ldt2.atZone(ZoneId.systemDefault()).toInstant());
		System.out.println(d1);
		System.out.println(d2);
			
		
	}

}
