import java.util.Scanner;

public class Task1b {
	
	public static void main(String[] args) {

            // ----------------- write your code BELOW this line only --------
        	// your code here (add lines)
			// asking for a number to check and enter it into variable
			Scanner myScanner = new Scanner(System.in);
			int number = myScanner.nextInt();
			// checking if the number is positive
			if (number > 0) {
				// checking which numbers that are smaller than the number are giving a Pythagorean triple
				for (int i=number ; i > 2 ; i=i-1) {
					for (int k=i-1 ; k >= 2 ; k=k-1) {
						for (int j = k-1 ; j >= 1 ; j=j-1) {
							if (k*k + j*j == i*i)
								System.out.println (j+" "+k+" "+i);
						}
					}
				}
			}
            // ----------------- write your code ABOVE this line only ---------
	}
}
