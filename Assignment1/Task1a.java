import java.util.Scanner;

public class Task1a {
	
	public static void main(String[] args) {

            // ----------------- write your code BELOW this line only --------
			// asking for numbers and enter them into variables
			Scanner myScanner = new Scanner(System.in);
			int number1 = myScanner.nextInt();
			int number2 = myScanner.nextInt();
			int number3 = myScanner.nextInt();
			boolean isPythagoras = false;
			int a = number1*number1;
			int b = number2*number2;
			int c = number3*number3;
			// checking if the numbers are giving a Pythagorean triple
			if (number1 > 0 && number1 <= number2 && number2 <= number3) {
				if (a+b == c) {
					isPythagoras = true;
				}
				if (isPythagoras)
					System.out.println("yes");
				else
					System.out.println("no");
			}          
			// ----------------- write your code ABOVE this line only ---------
		
	}
}
