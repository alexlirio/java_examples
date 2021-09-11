package br.com.example.hackerrank;
import java.io.IOException;

public class Solution31 {

    // Complete the utopianTree function below.
    static int utopianTree(int n) {
    	if (n == 0) {
    		return 1;
    	} else if (n == 1) {
    		return 2;
    	}
    	
    	int r = 0;
    	for (int i = 0; i <= n; i++) {
    		
        	if (i == 0) {
        		r = 1;
        	} else if (i == 1) {
        		r = 2;
        	} else if (i%2==0) {
				r++;
			} else {
				r = r + r;
			}
			
		}
    	return r;
    }

    public static void main(String[] args) throws IOException {
        System.out.println(utopianTree(0));
        System.out.println(utopianTree(1));
        System.out.println(utopianTree(4));
    }
}