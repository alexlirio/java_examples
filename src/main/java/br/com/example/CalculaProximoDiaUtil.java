package br.com.example;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class CalculaProximoDiaUtil {

//	private final static String HORARIO_CORTE = "2359"; // Dentro do horario
	private final static String HORARIO_CORTE = "0001"; // Fora do horario

	public static void main(String[] args) {
		System.out.println(new CalculaProximoDiaUtil().getProximaDataValida(new Date()));
	}

	private String getProximaDataValida(Date date) {

		if (isDiaValido(date)) {
			if (isAntesHorarioDeCorte(date)) {
				return new SimpleDateFormat("yyyyMMdd").format(date);
			} else {
				Calendar c = Calendar.getInstance();
				c.setTime(date); // TODO
				c.add(Calendar.DATE, 1);
				return getProximaDataValida(c.getTime());
			}
		} else {
			Calendar c = Calendar.getInstance();
			c.setTime(date);
			c.add(Calendar.DATE, 1);
			return getProximaDataValida(c.getTime());
		}

	}

	private boolean isDiaValido(Date date) {
		
		Calendar c = Calendar.getInstance();
		c.setTime(date); // TODO
		
		if (c.get(Calendar.DAY_OF_WEEK) == Calendar.SATURDAY ||
				c.get(Calendar.DAY_OF_WEEK) == Calendar.SUNDAY ||
				isFeriado(c.getTime())) {
			return false;
		} else {
			return true;
		}

	}
	
	private boolean isFeriado(Date date) {
		
		boolean retorno = false;
		
		@SuppressWarnings("deprecation")
		Date feriado1 = new Date(113, 0, 1);
		Date feriado2 = new Date(113, 0, 2);
		Date feriado3 = new Date(113, 2, 14);
		Date feriado4 = new Date(113, 2, 15);
		
		List<Date> feriados = new ArrayList<Date>();
		feriados.add(feriado1);
		feriados.add(feriado2);
		feriados.add(feriado3);
		feriados.add(feriado4);
		
		for (Date feriado : feriados) {
			String dataAtual = new SimpleDateFormat("yyyyMMdd").format(date);
			String dataFeriado = new SimpleDateFormat("yyyyMMdd").format(feriado);
			if (dataAtual.equals(dataFeriado)) {
				retorno = true;
			}
		}
		System.out.println("Feriado = " + retorno);
		return retorno;
	}
	
	private boolean isAntesHorarioDeCorte(Date date) {
		
		if (date.after(new Date())) {
			return true;
		}
		
		String horaAtual = new SimpleDateFormat("HHmm").format(new Date());
		
		if (Long.valueOf(horaAtual) < Long.valueOf(HORARIO_CORTE)) {
			return true;
		} else {
			return false;
		}
		
	}

}
