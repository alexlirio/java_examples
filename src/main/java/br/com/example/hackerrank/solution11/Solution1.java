package br.com.example.hackerrank.solution11;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.HashMap;
import java.util.Map.Entry;

import javax.net.ssl.HttpsURLConnection;


class Result1 {

    /*
     * Complete the 'getTransactions' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts following parameters:
     *  1. INTEGER userId
     *  2. INTEGER locationId
     *  3. INTEGER netStart
     *  4. INTEGER netEnd
     *
     *  https://jsonmock.hackerrank.com/api/transactions/search?userId=
     */

    public static int getTransactions(int userId, int locationId, int netStart, int netEnd) {
    	int result = getTransactions(userId, locationId, netStart, netEnd, 0, 1);
    	System.out.println("FINAL: " + result);
    	return result;
    }
    
    public static int getTransactions(int userId, int locationId, int netStart, int netEnd, int sumResponse, int page) {
//    	System.out.println(">>>>>>>>>>>>>page: " + page);
    	String jsonResponse = request(userId, page);
//    	System.out.println("jsonResponse: " + jsonResponse);
    	HashMap<String, HashMap<String, String>> hashMapResponse = converter(jsonResponse);
//    	System.out.println("hashMapResponse: " + hashMapResponse);
    	HashMap<String, HashMap<String, String>> hashMapResponseFiltered = filter(hashMapResponse, locationId, netStart, netEnd);
//    	System.out.println("hashMapResponseFiltered: " + hashMapResponseFiltered);
    	sumResponse += sum(hashMapResponseFiltered);
//    	System.out.println("sum: " + sumResponse);
    	
    	page = Integer.parseInt(jsonResponse.substring(jsonResponse.indexOf("\"page\"") + 8, jsonResponse.indexOf("\"per_page\"") - 2));
    	Integer total_pages = Integer.parseInt(jsonResponse.substring(jsonResponse.indexOf("\"total_pages\"") + 14, jsonResponse.indexOf("\"data\"") - 1));
    	if (page < total_pages) {
    		sumResponse = getTransactions(userId, locationId, netStart, netEnd, sumResponse, page + 1);
    	}
    	
    	return sumResponse;
    }

    private static int sum(HashMap<String, HashMap<String, String>> hashMapResponseFiltered) {
		int responseSum = 0;
		for(Entry<String, HashMap<String, String>> entry : hashMapResponseFiltered.entrySet()) {
			Double amount = Double.parseDouble(entry.getValue().get("amount").replace(",", ""));
			responseSum += Math.round(amount);
		}
		return responseSum;
	}

	private static HashMap<String, HashMap<String, String>> filter(HashMap<String, HashMap<String, String>> hashMapResponse, int locationId, int netStart, int netEnd) {
		HashMap<String, HashMap<String, String>> hashMapResponseFiltered = new HashMap<String, HashMap<String, String>>();
		for(Entry<String, HashMap<String, String>> entry : hashMapResponse.entrySet()) {
		    String key = entry.getKey();
			// check 'locationId'
			if (entry.getValue().get("locationId").equalsIgnoreCase(String.valueOf(locationId))) {
				// check between 'netStart' and 'netEnd'
				String ip = entry.getValue().get("ip");
				int ipPartOne = Integer.parseInt(ip.substring(0, ip.indexOf(".")));
				if (ipPartOne >= netStart && ipPartOne <= netEnd) {
					hashMapResponseFiltered.put(key, entry.getValue());
				}
			}
		}
		return hashMapResponseFiltered;
	}
	
	private static HashMap<String, HashMap<String, String>> converter(String jsonResponse) {
		HashMap<String, HashMap<String, String>> hashMapResponse = new HashMap<String, HashMap<String, String>>();
		String[] parts = jsonResponse.split("\\},\\{");
		for (int i = 0; i < parts.length; i++) {
			HashMap<String, String> hashMap = new HashMap<String, String>();
			hashMap.put("amount", parts[i].substring(parts[i].indexOf("\"amount\"") + 11, parts[i].indexOf("\"location\"") - 2));
			hashMap.put("locationId", parts[i].substring(parts[i].indexOf("\"location\"") + 17, parts[i].indexOf("\"address\"") - 1));
			hashMap.put("ip", parts[i].substring(parts[i].indexOf("\"ip\"") + 6, parts[i].lastIndexOf("\"")));
			hashMapResponse.put(String.valueOf(i), hashMap);
		}
		return hashMapResponse;
	}

	private static String request(int userId, int page) {
		String jsonObject = null;
    	try {
    		String host = "https://jsonmock.hackerrank.com/api/transactions/search?userId=" + userId + "&page=" + page;
    		URL obj = new URL(host);
    		HttpsURLConnection con = (HttpsURLConnection) obj.openConnection();
    		con.setRequestProperty("Content-Type", "application/json");
    		//add header
    		con.setRequestMethod("GET");
    		
//    		int responseCode = con.getResponseCode();
//    		System.out.println("Sending 'GET' request to URL: " + host);
//    		System.out.println("Response Code: " + responseCode);
    		
    		BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
    		String inputLine;
    		StringBuffer response = new StringBuffer();
    		
    		while ((inputLine = in.readLine()) != null) {
    			response.append(inputLine);
    		}
    		in.close();
    		
    		jsonObject = response.toString();
    	} catch (IOException e) {
    		System.out.println("Exception: " + e);
    	}
    	return jsonObject;
	}
}

public class Solution1 {
    public static void main(String[] args) throws IOException {
        int result = Result1.getTransactions(2, 8, 5, 50);
    }
    
//    public static void main(String[] args) throws IOException {
//    	BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
//    	BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));
//    	
//    	int userId = Integer.parseInt(bufferedReader.readLine().trim());
//    	
//    	int locationId = Integer.parseInt(bufferedReader.readLine().trim());
//    	
//    	int netStart = Integer.parseInt(bufferedReader.readLine().trim());
//    	
//    	int netEnd = Integer.parseInt(bufferedReader.readLine().trim());
//    	
//    	int result = Result.getTransactions(userId, locationId, netStart, netEnd);
//    	
//    	bufferedWriter.write(String.valueOf(result));
//    	bufferedWriter.newLine();
//    	
//    	bufferedReader.close();
//    	bufferedWriter.close();
//    }
}
