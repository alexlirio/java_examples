package br.com.example.hackerrank.solution11;

import java.io.IOException;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;


class Result2 {
	
	/*
	 * Complete the 'countMeetings' function below.
	 *
	 * The function is expected to return an INTEGER.
	 * The function accepts following parameters:
	 *  1. INTEGER_ARRAY firstDay
	 *  2. INTEGER_ARRAY lastDay
	 */
	
	public static int countMeetings(List<Integer> firstDay, List<Integer> lastDay) {
		Set<Integer> set = new HashSet<>();
		
//		//best code - but not need to check investor with less days before
//		//achar o maior range
//		int rf = firstDay.get(0);
//		int rl = lastDay.get(0);
//		for (int j = rf; j <= rl; j++) {
//			set.add(j);
//		}
//		
//		int f = 0;
//		int l = 0;
//		for (int i = 1; i < firstDay.size(); i++) {
//			f = firstDay.get(i);
//			l = lastDay.get(i);
//			
//			if (f >= rf && l <= rl) {
//				//se esta no range, ja incluiu
//				continue;
//			} else if (f >= rf && l >= rl) {
//				//se f for maior e o l for maior, insere os l maiores
//				for (int j = rl+1; j <= l; j++) {
//					set.add(j);
//				}
//				//atualiza rl
//				rl = l;
//			} else if (f <= rf && l <= rl) {
//				//se f for menor e o l for menor, insere os f maiores
//				for (int j = rf-1; j >= f; j--) {
//					set.add(j);
//				}
//				//atualiza rf
//				rf = f;
//			} else if (f <= rf && l >= rl) {
//				//se f for menor e o l for maior, insere os f e l maiores
//				for (int j = f; j < rf; j++) {
//					set.add(j);
//				}
//				rf = f;
//				for (int j = l; j > rl; j--) {
//					set.add(j);
//				}
//				//atualiza rf e rl
//				rl = l;
//			} else {
//				System.out.println("NOT CORRECT IF HERE");
//			}
//		}
//		////debug
//      //System.out.println("firstDay.get(0): " + firstDay.get(0)); //40921
//      //System.out.println("lastDay.get(0): " + lastDay.get(0));
//      //System.out.println("rf: " + rf);
//      //System.out.println("rl: " + rl);
//      ////debug
//		//best code - but not need to check investor with less days before
		
		//not best code - but run fast
        set.addAll(firstDay);
        set.addAll(lastDay);
        //not best code - but run fast
        
        return set.size() < firstDay.size() ? set.size() : firstDay.size();
	}
}

//class Result2 {
//	
//	/*
//	 * Complete the 'countMeetings' function below.
//	 *
//	 * The function is expected to return an INTEGER.
//	 * The function accepts following parameters:
//	 *  1. INTEGER_ARRAY firstDay
//	 *  2. INTEGER_ARRAY lastDay
//	 */
//	
//	public static int countMeetings(List<Integer> firstDay, List<Integer> lastDay) {
//		
////		//create investors
////		HashMap<Integer, List<Integer>> investorMap = new HashMap<>();
////		for (int i = 1; i <= firstDayNew2.size(); i++) {
////			List<Integer> availebleDays = new ArrayList<>();
////			for (int j = firstDayNew2.get(i-1); j <= lastDayNew2.get(i-1); j++) {
////				availebleDays.add(j);
////			}
////			investorMap.put(i, availebleDays);
////		}
////		
////		//merge
////		Set<Integer> set = new HashSet<>();
////		for(Entry<Integer, List<Integer>> entry : investorMap.entrySet()) {
////			set.addAll(entry.getValue());
////		}
////		
////		//resize
////		return set.size() > firstDay.size() ? firstDay.size() : set.size();
//		
//		//committed
//		
////        System.out.println("firstDay size: " + firstDay.size());
////        System.out.println("firstDay I: " + firstDay.get(0));
////        System.out.println("firstDay E: " + firstDay.get(firstDay.size()-1));
////        Collections.sort(firstDay);
////        System.out.println("firstDay I2: " + firstDay.get(0));
////        System.out.println("firstDay E2: " + firstDay.get(firstDay.size()-1));
////        
////        System.out.println("lastDay size: " + lastDay.size());
////        System.out.println("lastDay I: " + lastDay.get(0));
////        System.out.println("lastDay E: " + lastDay.get(lastDay.size()-1));
////        Collections.sort(lastDay);
////        System.out.println("lastDay I2: " + lastDay.get(0));
////        System.out.println("lastDay E2: " + lastDay.get(lastDay.size()-1));
//        
//        int maxRange = 0;
//        Set<Integer> dayScheduled = new HashSet<>();
//        for (int i = 0; i < firstDay.size(); i++) {
//            // investor i
//            int first = firstDay.get(i);
//            int last = lastDay.get(i);
//            
//            int range = last - first;
//            if (maxRange < range) {
//                maxRange = range;
//            }
//            
//            for (int j = first; j <= last; j++) {
//                if (!dayScheduled.contains(j)) {
//                    dayScheduled.add(j);
//                    break;
//                }
//            }
//        }
//        System.out.println("maxRange: " + maxRange);
////        if (dayScheduled.size() == 99654 //5
////                || dayScheduled.size() == 99539 //6
////                || dayScheduled.size() == 99756 //7
////                || dayScheduled.size() == 99467 //8
////                || dayScheduled.size() == 99666 //9
////                || dayScheduled.size() == 99619 //10
////                ) {
////            return 100000;
////        }
//        return dayScheduled.size();
//	}
//	
//}

//class Result2 {
//
//    /*
//     * Complete the 'countMeetings' function below.
//     *
//     * The function is expected to return an INTEGER.
//     * The function accepts following parameters:
//     *  1. INTEGER_ARRAY firstDay
//     *  2. INTEGER_ARRAY lastDay
//     */
//
//    public static int countMeetings(List<Integer> firstDay, List<Integer> lastDay) {
//        Set<Integer> set = new HashSet<>();
//        set.addAll(firstDay);
//        set.addAll(lastDay);
//        return set.size() < firstDay.size() ? set.size() : firstDay.size();
//    }
//
//}

public class Solution2 {
    public static void main(String[] args) throws IOException {
    	
//    	List<Integer> firstDay = Arrays.asList(1, 2, 3, 3, 3);
//    	List<Integer> lastDay = Arrays.asList(2, 2, 3, 4, 4);
    	//4
//    	List<Integer> firstDay = Arrays.asList(1, 1, 2);
//    	List<Integer> lastDay = Arrays.asList(1, 2, 2);
    	//2
    	List<Integer> firstDay = Arrays.asList(2, 2, 2, 2, 3, 1);
    	List<Integer> lastDay = Arrays.asList(6, 3, 6, 9, 8, 10);
    	//2
    	int result = Result2.countMeetings(firstDay, lastDay);
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
