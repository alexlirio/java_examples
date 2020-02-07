package br.com.example;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class AmazonTest01 {
	
    List<String> listToReturn = new ArrayList<String>();
    String stringToReturn = new String();

    public static void main(String[] args) {
        String A = "photo.jpg, Warsaw, 2013-09-05 14:08:15\n" +
                   "john.png, London, 2015-06-20 15:13:22\n" +
                   "myFriends.png, Warsaw, 2013-09-05 14:07:13\n" +
                   "Eiffel.jpg, Paris, 2015-07-23 08:03:02\n" +
                   "pisatower.jpg, Paris, 2015-07-22 23:59:59\n" +
                   "BOB.jpg, London, 2015-08-05 00:02:03\n" +
                   "notredame.png, Paris, 2015-09-01 12:00:00\n" +
                   "me.jpg, Warsaw, 2013-09-06 15:40:22\n" +
                   "a.png, Warsaw, 2016-02-13 13:33:50\n" +
                   "b.jpg, Warsaw, 2016-01-02 15:12:22\n" +
                   "c.jpg, Warsaw, 2016-01-02 14:34:30\n" +
                   "d.jpg, Warsaw, 2016-01-02 15:15:01\n" +
                   "e.png, Warsaw, 2016-01-02 09:49:09\n" +
                   "f.png, Warsaw, 2016-01-02 10:55:32\n" +
                   "g.jpg, Warsaw, 2016-02-29 22:13:11";
        AmazonTest01 s = new AmazonTest01();
        System.out.println(s.solution(A));
    }
   
    public String solution(String s) {
    	
    	// Renamed to 'city+date+name'. Ex: 'photo.jpg, Warsaw, 2013-09-05 14:08:15\n' to ' Warsaw, 2013-09-05 14:08:15,photo.jpg\n'
        List<String> listToRename = Arrays.asList(s.split("\\n"));
        for (int i = 0; i < listToRename.size(); i++) {
        	String col1 = listToRename.get(i).split(",")[0];
        	String col2 = listToRename.get(i).split(",")[1];
        	String col3 = listToRename.get(i).split(",")[2];
        	listToRename.set(i, col2 + "," + col3 + "," + col1 + System.getProperty("line.separator"));
		}
        
        //  Warsaw, 2013-09-05 14:08:15,photo.jpg
        for (int i = 0; i < listToRename.size(); i++) {
            String col1 = listToRename.get(i).split(",")[0].trim();
            String col2 = returnOrder(listToRename, i);
            String col3 = listToRename.get(i).substring(listToRename.get(i).indexOf("."));
            stringToReturn += col1+col2+col3;
		}
        
        return stringToReturn;
    }

    private String returnOrder(List<String> listToRename, int position) {
    	int totalPhotosOfCity = 1;
    	int orderPhotosOfCity = 1;
    	String currentLine = listToRename.get(position);
    	String currentCityLine = currentLine.split(",")[0].trim();
    	String currentDateLine = currentLine.split(",")[1].trim();
    	
    	for (int i = 0; i < listToRename.size(); i++) {
    		// Check if not same position
    		if (i != position) {
    			// Check if same 'city'
				if (currentCityLine.compareTo(listToRename.get(i).split(",")[0].trim()) == 0) {
					totalPhotosOfCity += 1;
					// Check to need to increment the position of current line
					if (currentDateLine.compareTo(listToRename.get(i).split(",")[1].trim()) > 0) {
						orderPhotosOfCity += 1;
					}
				}
			}
		}
    	return String.format("%0" + String.valueOf(totalPhotosOfCity).length() + "d", orderPhotosOfCity);
    }
}
