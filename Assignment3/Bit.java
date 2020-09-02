
public class Bit {

    private boolean value;
	private int data;
    
	public Bit(boolean value) {
		// enter 0 if the value is false and 1 if else
		if (value == false)
			this.data = 0;
		else 
			this.data = 1;
	}

    public String toString() {
    	String s;
    	// enter into a variable the string of "0" if the value is 0 and "1" if else
    	if (this.data == 0)
    		s = "0";
    	else
    		s = "1";
    	return s;
    }

    public boolean isOne() {
    	boolean output;
    	// return true if the value is 1
    	if (this.data == 1)
    		output = true;
    	else
    		output = false;
		return output;
    }

    public boolean lessThan(Bit digit) {
    	boolean output;
    	// check if the number is smaller than the input
    	if(this.data < digit.data)
    		output = true;
    	else
    		output = false;
        return output; 
	}

    public boolean lessEq(Bit digit) {
    	boolean output;
    	// check if the number is smaller or equal the input
    	if (this.data <= digit.data)
    		output = true;
    	else
    		output = false;
        return output; 
	}

   public static Bit fullAdderSum(Bit A, Bit B, Bit Cin) {
	   Bit sum = new Bit(false);
	   // if A is equal B the sum is depend on Cin
	   if (A.data == B.data)
		   sum = Cin;
	   else {
		   // if A not equal B and Cin is false sum is true
		   if (Cin.data == sum.data)
			   sum.data = 1;
	   }
       return sum; 
   }
   public static Bit fullAdderCarry(Bit A, Bit B, Bit Cin) {
	   Bit Carry = new Bit(false);
	   // if A equals B Carry is the value of A/B
	   if (A.data == B.data)
		   Carry = A;
	   else
		   Carry = Cin;
	   return Carry; 
   }
   
}
