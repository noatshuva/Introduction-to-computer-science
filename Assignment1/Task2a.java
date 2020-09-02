import java.util.Scanner;

public class Task2a {
	
	public static void main(String[] args) {

            // ----------------- write your code BELOW this line only --------
            // your code here (add lines)
			// asking for a number to check and enter it into variable
			Scanner myScanner = new Scanner(System.in);
			int number = myScanner.nextInt();
			int a = 1;
			// multiply the number with all the numbers that are smaller than him.
			if (number >= 0) {
				for (int i=1 ; i<= number ; i= i+1) {				
					a = a*i;
				}
				System.out.println (a);
			}
            // ----------------- write your code ABOVE this line only ---------
		
	}
}
