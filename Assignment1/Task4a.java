import java.util.Scanner;

public class Task4a {
	
	public static void main(String[] args) {

            // ----------------- write your code BELOW this line only --------
            // your code here (add lines)
			// asking for numbers and enter them into variables
			Scanner myScanner = new Scanner (System.in);
			int number1 = myScanner.nextInt();
			int number2 = myScanner.nextInt();
			int number3 = myScanner.nextInt();
			// finding the greatest common divisor of number1 and number2
			int r = number1%number2;
			while (r!=0) {
				number1=number2;
				number2=r;
				r=number1%number2;
			}
			// finding the greatest common divisor of the GCD of number1 & number2 with number3
			int r2 = number3%number2;
			while (r2!=0) {
				number3=number2;
				number2=r2;
				r2=number3%number2;
			}
			System.out.println(number2);
			// ----------------- write your code ABOVE this line only ---------
		
	}
}
