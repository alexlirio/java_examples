package br.com.example.hackerrank;

import java.io.*;
import java.math.*;
import java.text.*;
import java.util.*;
import java.util.regex.*;

public class Solution2 {

    /*
     * Complete the simpleArraySum function below.
     */
    static int simpleArraySum(int[] ar) {
    	int r = 0;
    	for (int i = 0; i < ar.length; i++) {
			r += Integer.valueOf(ar[i]);
		}
		return r;
    }

//    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
//        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int arCount = 6;

        int[] ar = new int[arCount];

        String[] arItems = "1 2 3 4 10 11".split(" ");

        for (int arItr = 0; arItr < arCount; arItr++) {
            int arItem = Integer.parseInt(arItems[arItr].trim());
            ar[arItr] = arItem;
        }

        int result = simpleArraySum(ar);

        System.out.println(String.valueOf(result));
//        bufferedWriter.newLine();

//        bufferedWriter.close();
    }
}
