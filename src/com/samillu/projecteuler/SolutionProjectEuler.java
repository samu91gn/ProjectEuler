package com.samillu.projecteuler;

import java.util.ArrayList;
import java.util.Scanner;


public class SolutionProjectEuler {
    
    
    private static String result(int B, int[] digits){
        
        String res = "";
        int base10Number = 0;

        for(int i = digits.length -1; i >= 0; i--){
            base10Number += digits[i] * Math.pow(B, digits.length - 1 - i);
        }

        ArrayList<Integer> BBalancedNumbers = new ArrayList<>();

        int totalSum = 0;
        
        for(int i = 1; i <= base10Number; i++){
            
            int currNum = i;

            int sumHalf = 0;

            double ratio = Math.log(currNum)/Math.log(B);
            if(Math.ceil(ratio) - ratio < 0.00000001d)
            	ratio = Math.ceil(ratio);
            
            int numDigits = (int)Math.floor(ratio) + 1;
            

            for(int ind = 0; ind < (int)Math.ceil(numDigits/2d); ind++) {
                sumHalf += currNum % B;
                if(numDigits % 2 == 0 || ind+1 < (int)Math.ceil(numDigits/2d))
                    currNum /= B; // to be done just if the digits are even OR the digit is NOT the last
            }

            for(int ind = 0; ind < (int)Math.ceil(numDigits/2d); ind++) {
                sumHalf -= currNum % B;
                currNum /= B;
            }

            if(sumHalf == 0) {
                BBalancedNumbers.add(i);
                totalSum += i;
            }

        }
        
        res += BBalancedNumbers.size() + " " + totalSum;
        return res;
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