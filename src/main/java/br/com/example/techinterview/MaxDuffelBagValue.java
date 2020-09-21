package br.com.example.techinterview;

import org.json.JSONArray;
import org.json.JSONObject;

public class MaxDuffelBagValue {
	
	static int val;

	public static void main(String[] args) {
		
//		JSONArray cakeTypes = new JSONArray();
//		cakeTypes.put(new JSONObject("{ weight: 7, value: 160 }"));
//		cakeTypes.put(new JSONObject("{ weight: 3, value: 90 }"));
//		cakeTypes.put(new JSONObject("{ weight: 2, value: 15 }"));
		
//		JSONArray cakeTypes = new JSONArray("[{ weight: 7, value: 160 },{ weight: 3, value: 90 },{ weight: 2, value: 15 }]");
//		JSONArray cakeTypes = new JSONArray("[{ weight: 1, value: 1 },{ weight: 2, value: 2 },{ weight: 10, value: 11 }]");
		JSONArray cakeTypes = new JSONArray("[{ weight: 10, value: 11 },{ weight: 1, value: 1 },{ weight: 2, value: 2 }]");
		
		int capacity = 10;
		
		maxDuffelBagValue(cakeTypes, capacity);
		System.out.println(val);
	}

	private static void maxDuffelBagValue(JSONArray cakeTypes, int capacity) {
		//TODO cakeTypes need to sort by most expensive (value/weight)??
        for (int i = 0; i < cakeTypes.length(); i++) {
        	JSONObject cakeType = (JSONObject) cakeTypes.remove(i);
        	if (cakeType.getInt("weight") <= capacity) {
        		val += cakeType.getInt("value");
        		capacity -= cakeType.getInt("weight");
        		maxDuffelBagValue(cakeTypes, capacity);
			}
        }
	}
}
