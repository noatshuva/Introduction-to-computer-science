import java.util.Scanner;

public class Task2b {
	
	public static void main(String[] args) {

            // ----------------- write your code BELOW this line only --------
            // your code here (add lines)
			// asking for numbers and enter them into variables
			Scanner myScanner = new Scanner(System.in);
			int n = myScanner.nextInt();			
			int k = myScanner.nextInt();
			if (n>0 & k>1) {
				int r = n%k;
				// Find the remainder of the division of all the numbers in the n double factorial with k
				for (int t=n-1 ; t>0 ; t=t-1) {
					r = (r*t)%k;
				}
				System.out.println(r);
			}
            // ----------------- write your code ABOVE this line only ---------
		
	}
}
