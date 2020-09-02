// You may not change or erase any of the lines and comments 
// in this file. You may only add lines in the designated 
// area.

import java.util.Scanner;

public class Task5 {


    public static void main(String[] args){
 

            // ----------------- "A": write your code BELOW this line only --------
            // your code here (add lines)
			// asking for numbers and enter them into variables
    		Scanner myScanner = new Scanner (System.in);
    		int a = myScanner.nextInt();
    		int b = myScanner.nextInt();
    		int c = myScanner.nextInt();
    		int d = myScanner.nextInt();
			int e = myScanner.nextInt();
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
				int tmp1 = b;
				b = c;
				c = tmp1;
			}
			if (d>=b & d>=c & d>=e) {
				int tmp1 = b;
				b = d;
				d = tmp1;
			}
			if (e>=b & e>=d & e>=c) {
				int tmp1 = b;
				b = e;
				e = tmp1;
			}
			
			System.out.println(a);
			System.out.println(b);
			
			// ----------------- "B" write your code ABOVE this line only ---------

       

    } // end of main
} //end of class Task5

