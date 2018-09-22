package com.samillu.projecteuler;

import java.util.Scanner;


public class SolutionProjectEuler {
    
    
    private static String result(int B, int[] digits){
            	
        String res = "";
        int base10Number = 0;

        for(int i = digits.length -1; i >= 0; i--){
            base10Number += digits[i] * Math.pow(B, digits.length - 1 - i);
        }

        int totalSum = 0;
        int count = 0;
        
        for(int currNum = 1; currNum <= base10Number; currNum++){
            int tmpCurrNum = currNum;
            int sumHalf = 0;

            int numDigits = getNumDigits(currNum, B);

            for(int ind = 0; ind < (int)Math.ceil(numDigits/2d); ind++) {
                sumHalf += tmpCurrNum % B;
                if(numDigits % 2 == 0 || ind+1 < (int)Math.ceil(numDigits/2d))
                	tmpCurrNum /= B; // remove a digit just if the digits are even OR the digit is NOT the mid digit (case odd)
            }

            for(int ind = 0; ind < (int)Math.ceil(numDigits/2d); ind++) {
                sumHalf -= tmpCurrNum % B;
                tmpCurrNum /= B;
            }

            if(sumHalf == 0) {
                count++;
                totalSum += currNum;
            }
        }
        
        res += count + " " + totalSum;
        return res;
    }
    
    private static int getNumDigits(int number, int base) {
    	double ratio = Math.log(number)/Math.log(base);
        if(Math.ceil(ratio) - ratio < 0.00000001d) //avoid approximation errors with numbers such as 1000
        	ratio = Math.ceil(ratio);
        return (int)Math.floor(ratio) + 1;
    }

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner scanner = new Scanner(System.in);
        
        String[] line = scanner.nextLine().split(" ");
        Integer B = Integer.parseInt(line[0]);
        Integer L = Integer.parseInt(line[1]);
        
        int[]digits = new int[L];
        
        String[] bababa = scanner.nextLine().split(" ");
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            for (int j = 0; j < L; j++) {
                int item = Integer.parseInt(bababa[j]);
                digits[j] = item;
            }
        
        System.out.println(result(B, digits));
        scanner.close();
    }
}