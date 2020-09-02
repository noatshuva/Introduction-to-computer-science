import java.util.Scanner;

public class Task4b {
	
	public static void main(String[] args) {

            // ----------------- write your code BELOW this line only --------
            // your code here (add lines)
			// asking for numbers and enter them into variables
			Scanner myScanner = new Scanner (System.in);
			int number1 = myScanner.nextInt();
			int number2 = myScanner.nextInt();
			int number3 = myScanner.nextInt();
			int m = number1*number2;
			// finding the LCM of number1 and number2
			int r = number1%number2;
			while (r!=0) {
				number1=number2;
				number2=r;
				r=number1%number2;
			}
			// finding the LCM of the LCM of number1 & number2 with number3
			int d = m/number2;
			int m2 = d*number3;
			int r2 = number3%d;
			while (r2!=0) {
				number3=d;
				d=r2;
				r2=number3%d;
			}
			int d2 = m2/d;
			System.out.println(d2);
            // ----------------- write your code ABOVE this line only ---------
		
	}
}
