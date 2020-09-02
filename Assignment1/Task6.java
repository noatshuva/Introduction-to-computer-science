// You may not change or erase any of the lines and comments 
// in this file. You may only add lines.

import java.util.Scanner;

public class Task6 {


    public static void main(String[] args){


            // ----------------- write any code BELOW this line only --------
            // your code here (add lines)
    		boolean isRight = true;
    		// Check all the arranging options of 0 and 1 in a number with 5 digits
    		for (int i=0 ; i<=1 & isRight ; i=i+1) {
    			for (int z=0 ; z<=1 & isRight ; z=z+1) {
    				for (int k=0 ; k<=1 & isRight ; k=k+1) {
    					for (int j=0 ; j<=1 & isRight ; j=j+1) {
    						for (int y=0 ; y<=1 & isRight ; y=y+1) {
    							int a = i;
    							int b = z;
    							int c = k;
    							int d = j;
    							int e = y;
    							int sum = a + b + c + d + e;
    							
            // ----------------- write any code ABOVE this line only ---------


            // -----------------  copy here the code from Task 5 that is between
            // -----------------  the comments "A" and "B"
            // code from Task 5 here
    							// Checking which number is the smallest
    							if (b<=a & b<=c & b<=d & b<=e) {
    								int tmp = a;
    								a = b;
    								b = tmp;
    							}
    							if (c<=a & c<=b & c<=d & c<=e) {
    								int tmp = a;
    								a = c;
    								c = tmp;
    							}
    							if (d<=a & d<=c & d<=b & d<=e) {
    								int tmp = a;
    								a = d;
    								d = tmp;
    							}
    							if (e<=a & e<=c & e<=d & e<=b) {
    								int tmp = a;
    								a = e;
    								e = tmp;
    							}
    							// Checking which number is the biggest 
    							if (c>=b & c>=d & c>=e) {
    								int tmp1 = e;
    								e = c;
    								c = tmp1;
    							}
    							if (d>=b & d>=c & d>=e) {
    								int tmp1 = e;
    								e = d;
    								d = tmp1;
    							}
    							if (b>=e & b>=d & b>=c) {
    								int tmp1 = e;
    								e = b;
    								b = tmp1;
    							}
            // -----------------  end of copied code from Task 5

            // ----------------- write any code BELOW this line only --------
            // your code here (add lines)
    							// check whether the program prints the largest and smallest numbers.
    			    			if (sum==0 & (a!= 0 | e!=0)) {
    			    				isRight = false;
        			    			System.out.println(a);
        			    			System.out.println(b);
        			    			System.out.println(c);
        			    			System.out.println(d);
        			    			System.out.println(e);
    			    			}
    			    			if (sum==5 & (a!=1 | e!=1)) {
    			    				isRight = false;
           			    			System.out.println(a);
        			    			System.out.println(b);
        			    			System.out.println(c);
        			    			System.out.println(d);
        			    			System.out.println(e);
        			    		}
    			    			if (sum <=4 & sum >=1 & (a!=0 | e!=1)) {
    			    				isRight = false;
           			    			System.out.println(a);
        			    			System.out.println(b);
        			    			System.out.println(c);
        			    			System.out.println(d);
        			    			System.out.println(e);
        			    		}
    						}
    					}
    				}
    			}
    		}
    		if (isRight)
    			System.out.println("Verified!");
            // ----------------- write any code ABOVE this line only ---------

    } // end of main
} //end of class Task6

