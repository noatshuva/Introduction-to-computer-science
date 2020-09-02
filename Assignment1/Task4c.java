import java.util.Scanner;

public class Task4c {
	
	public static void main(String[] args) {

            // ----------------- write your code BELOW this line only --------
            // your code here (add lines)
			// asking for numbers and enter them into variable
			Scanner myScanner = new Scanner (System.in);
			int a = myScanner.nextInt();
			int b = myScanner.nextInt();
			int c = myScanner.nextInt();
			int d = myScanner.nextInt();
			int e = myScanner.nextInt();
			int f = myScanner.nextInt();
			// Creating a common denominator
			int sum1 = b*d*f;
			int sum2 = a*d*f+c*b*f+e*d*b;
			// checking if the numerator and the denominator are the same
			if (sum1==sum2)
				System.out.println("yes");
			else
				System.out.println("no");
            // ----------------- write your code ABOVE this line only ---------
		
	}
}
