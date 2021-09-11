package br.com.example.hackerrank;

import java.io.IOException;

public class Solution19 {

    /*
     * Complete the pageCount function below.
     */
    static int pageCount(int n, int p) {
    	
    	int r1 = 0;
    	for (int i = 0; i < n; i++) {
    		if (i == p || i + 1 == p) {
				break;
			} else {
				r1 += 1;
				i++;
			}
		}
    	
    	int r2 = 0;
    	for (int i = n; i > 0; i--) {
    		if (i == p || i - 1 == p) {
    			if (p%2!=0 && n%2==0) {
    				r2 += 1;
				}
				break;
			} else {
				r2 += 1;
				i--;
			}
		}
    	System.out.println( r1 + " " + r2);
    	
    	if (r1 < r2) {
			return r1;
		} else {
			return r2;
		}
    }

    public static void main(String[] args) throws IOException {
    	System.out.println(pageCount(6, 5));
    }
}
