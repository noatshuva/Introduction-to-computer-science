import java.util.Scanner;

public class Task3 {
	
	public static void main(String[] args) {

            // ----------------- write your code BELOW this line only --------
            // your code here (add lines)
			Scanner myScanner = new Scanner(System.in);
			int n = myScanner.nextInt();
			// Finding all the prime numbers from 2 to n
			for (int i=2 ; i <= n ; i=i+1) {
				boolean isPrime = true;		
				for (int divisor=2 ; divisor*divisor <= i & isPrime ; divisor = divisor+1) {
					if (i % divisor == 0) {
						isPrime = false;
					}
				}
				// If the number was found prime checks if it the number divides n 
				if (isPrime) {
					int r = n%i;
					if (r==0) {
						int counter = 1;
						int left = n/i;
						if (left >=i) {
							r = left % i;
							// Checking the amount of times that the number can be divided by n
									while (r==0 & left>=i) {
										left = left/i;
										r = left % i;
										counter = counter +1;
									}
						}
						if (counter > 1)
							System.out.println (i + " " +counter);
						else
							System.out.println (i);
						int m = i;
						while (counter >1) {
							m = m*i;
							counter = counter -1;
						}
						n = n/m;
					}
				}
			}
            // ----------------- write your code ABOVE this line only ---------
	}
}