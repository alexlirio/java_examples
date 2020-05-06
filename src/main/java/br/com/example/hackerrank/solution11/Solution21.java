package br.com.example.hackerrank.solution11;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;


class Result21 {

    /*
     * Complete the 'countMeetings' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts following parameters:
     *  1. INTEGER_ARRAY firstDay
     *  2. INTEGER_ARRAY lastDay
     */

    public static int countMeetings(List<Integer> firstDay, List<Integer> lastDay) {
    	
    	//create investors list
    	List<Investor> investorList = new ArrayList<>();
    	for (int i = 1; i <= firstDay.size(); i++) {
    		List<Integer> availebleDays = new ArrayList<>();
    		for (int j = firstDay.get(i-1); j <= lastDay.get(i-1); j++) {
    			availebleDays.add(j);
			}
    		investorList.add(new Investor(i, availebleDays));
		}
    	
    	//calendar
    	Calendar calendar = new Calendar();
    	calendar.schedule(investorList);
    	
    	return calendar.scheduleMap.size();
    }
}

class Calendar {
	
	static HashMap<Integer, Investor> scheduleMap = new HashMap<>();
	
	public void schedule(List<Investor> investorList) {
		//check maxDay
		int maxDay = 0;
		for (Investor investor : investorList) {
			for (Integer i : investor.getAvailableDays()) {
				if (i > maxDay) {
					maxDay = i;
				}
			}
		}
		//days between 1 and 100000
    	for (int day = 1; day <= maxDay; day++) {
    		schedule(day, investorList);
		}
	}

	private void schedule(int day, List<Investor> investorList) {
		//check maxAvailableDays
		int maxAvailableDays = 0;
		for (Investor investor : investorList) {
			if (investor.getAvailableDays().size() > maxAvailableDays) {
				maxAvailableDays = investor.getAvailableDays().size();
			}
		}
		//schedule investor with less available days before
    	for (int i = 1; i <= maxAvailableDays; i++) {
    		schedule(day, investorList, i);
		}
	}

	private void schedule(int day, List<Investor> investorList, int availableDays) {
		for (Investor investor : investorList) {
			//check if day already scheduled (!scheduleMap.containsKey(day))
			//and check if investor was not scheduled already (investor.getScheduledDay() != null)
			//and check if investor available days contains the day (investor.getAvailableDays().contains(day))
			if (!scheduleMap.containsKey(day) 
					&& investor.getScheduledDay() == null 
					&& investor.getAvailableDays().contains(day) 
					&& investor.getAvailableDays().size() == availableDays) {
				scheduleMap.put(day, investor);
				investor.setScheduledDay(day);
			}
		}
	}
}

class Investor {
    	
    	Integer id = null;
    	Integer scheduledDay = null;
		List<Integer> availableDays = new ArrayList<>();
    	
		public Investor(Integer id, List<Integer> availableDays) {
			super();
			this.id = id;
			this.availableDays = availableDays;
		}
		
		public Integer getScheduledDay() {
			return scheduledDay;
		}
		
		public void setScheduledDay(Integer scheduledDay) {
			this.scheduledDay = scheduledDay;
		}
		
    	public List<Integer> getAvailableDays() {
			return availableDays;
		}

		public void setAvailableDays(List<Integer> availableDays) {
			this.availableDays = availableDays;
		}

		@Override
		public String toString() {
			return "Investor [id=" + id + "]";
		}
}

public class Solution21 {
    public static void main(String[] args) throws IOException {
    	
    	List<Integer> firstDay = Arrays.asList(1, 1, 3);
    	List<Integer> lastDay = Arrays.asList(1, 2, 9);
    	int result = Result21.countMeetings(firstDay, lastDay);
    	System.out.println("result: " + result);
    	
//        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
//        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));
//
//        int firstDayCount = Integer.parseInt(bufferedReader.readLine().trim());
//
//        List<Integer> firstDay = IntStream.range(0, firstDayCount).mapToObj(i -> {
//            try {
//                return bufferedReader.readLine().replaceAll("\\s+$", "");
//            } catch (IOException ex) {
//                throw new RuntimeException(ex);
//            }
//        })
//            .map(String::trim)
//            .map(Integer::parseInt)
//            .collect(toList());
//
//        int lastDayCount = Integer.parseInt(bufferedReader.readLine().trim());
//
//        List<Integer> lastDay = IntStream.range(0, lastDayCount).mapToObj(i -> {
//            try {
//                return bufferedReader.readLine().replaceAll("\\s+$", "");
//            } catch (IOException ex) {
//                throw new RuntimeException(ex);
//            }
//        })
//            .map(String::trim)
//            .map(Integer::parseInt)
//            .collect(toList());
//
//        int result = Result.countMeetings(firstDay, lastDay);
//
//        bufferedWriter.write(String.valueOf(result));
//        bufferedWriter.newLine();
//
//        bufferedReader.close();
//        bufferedWriter.close();
    }
}
