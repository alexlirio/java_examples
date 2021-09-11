package br.com.example.hackerrank;

public class Solution27 {

    // Complete the hurdleRace function below.
    static int hurdleRace(int k, int[] height) {
    	int hinghest = 0;
    	for (int i : height) {
			if (i > hinghest) {
				hinghest = i;
			}
		}
    	
    	if (hinghest - k < 0) {
    		return 0;
		} else {
			return hinghest - k;
		}
    }

    public static void main(String[] args) {
        int k = 4;
        int[] height = new int[] {1, 6, 3, 5, 2};
        System.out.println(hurdleRace(k, height));
    }

}
