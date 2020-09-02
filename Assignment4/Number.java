import java.util.Iterator;

public class Number implements Comparable<Number> {
    private static final int BASE = 2;
    private static final Number ZERO = new Number();
    private static final Number ONE = new Number(1);
    private List<Bit> list;
	
    /**
     * Constructs a new Number defaulted to the value zero.
     */
    public Number(){
        list = new LinkedList<Bit>();
        list.add(new Bit(false));
    }

    /**
     * Constructs a new Number from an int.
     * @param number an int representing a decimal number
     */
    public Number(int number){  // assignment #1
    	if (number < 0) // ensure number is positive and legal
    		throw new IllegalArgumentException("Illegal input");
    	list = new LinkedList<Bit>();
    	if (number == 0) // check if number is only 0
    		list.add(new Bit(false));
    	while (number > 0){
    		if(number%BASE == 0) { // if the reminder of number and 2 is 0 add 0
        		list.add(new Bit(false));
    		}
    		else { // if the reminder of number and 2 is 1 add 1
        		list.add(new Bit(true));
    		}	
    		number = number/2;
    	}	
    }

    /**
     * Constructs a new Number from a String.
     * @param s a String (possibly) representing a decimal number.
     */
    public Number(String s){    // assignment #2
    	// check that all the parameters in string are numbers
    	boolean isLegal = true;
    	for (int i = 0; i < s.length() & isLegal ; i=i+1) {
    		if ('0' > s.charAt(i) | s.charAt(i) > '9')
    			isLegal = false;
    	}
    	// check that the first number is legal
    	if (s.charAt(0) == '0')
    		isLegal = false;
    	if (!isLegal)
    		throw new IllegalArgumentException ("illegal input");
    	int number = 0, power = 1, value = 0;
    	// casting the number from string to int
    	for (int i = s.length() - 1; i >= 0; i = i - 1) {
    		value = s.charAt(i) - '0';
    		number = number + value * power;
    		power = power * 10;
    	}
    	list = new LinkedList<Bit>();
    	if (number == 0) // check if number is only 0
    		list.add(new Bit(false));
    	while (number > 0){
    		if(number%BASE == 0) { // if the reminder of number and 2 is 0 add 0
        		list.add(new Bit(false));
    		}
    		else { // if the reminder of number and 2 is 1 add 1
        		list.add(new Bit(true));
    		}	
    		number = number/2;
    	}	
    }

    /**
     * Constructs a new Number which is a deep copy of the provided Number.
     * @param number a Number to be copied
     */
    public Number(Number number){ // assignment #3
        list = new LinkedList<Bit>();
        Iterator<Bit> it = number.bitIterator();
        while (it.hasNext()) // past throw all the parameters in it and add them to list
        	list.add((Bit) it.next());
    }

    /**
     * Checks if this Number is zero.
     * @return true if and only if this object representing the number zero.
     */
    public boolean isZero(){ // assignment #4
        boolean isZero = true;
        if (!(this.equals(ZERO))) // if the number is not 0 return false
        	isZero = false;
        return isZero;
    }


    /**
     * Returns an iterator over the Bit objects in the representation of this number,
     * which iterates over the Bit objects from LSB (first) to MSB (last).
     * @return a LSB-first iterator over the Bit objects in the representation of this number.
     */
    public Iterator<Bit> bitIterator(){ // assignment #5
    	return list.iterator();
    }


    /**
     * Adds 1 to the number
     */
    public void increment(){ // assignment #6
    	if (list == null || list.size() == 0) 
    		throw new IllegalArgumentException ("illegal input");
    	if (list.size() == 1) { // if there is only one bit change it from 0 to 1 or add 0.
    		if (list.get(0).isZero()) // if the bit is 0 change it to 1
   				list.set(0, new Bit(true)); 
   			else
   				list.add(0, new Bit (false));; // if the bit is 1 add 0
   		}
    	else if (list.size() > 1) { // if there is more than one bit
    		boolean checkZero = true;
    		int i = 0;
        	for (i = 0; i < list.size() & checkZero ; i=i+1) { // past throw all the elements in list
        		if (list.get(i).isZero()) { // if its zero change it to 1 and get of the loop
        			list.set(i, new Bit (true));
        			checkZero = false;
        		}
        		else {
        			list.set(i, new Bit (false)); // if its 1 change it to 0 
        		}
   	    	}
        	if (checkZero) // if the number contains only 1 add 1 to the end
        		list.add(i, new Bit(true));
   		}
    }


    /**
     * Checks if a provided String represent a legal decimal number.
     * @param s a String that possibly represents a decimal number, whose legality to be checked.
     * @return true if and only if the provided String is a legal decimal number
     */
    public static boolean isLegal(String s){ // assignment #7
    	boolean isLegal = true;
    	// past throw all the parameters and check if they contain only numbers
    	for (int i = 0; i < s.length() & isLegal ; i=i+1) {
    		if ('0' > s.charAt(i) | s.charAt(i) > '9')
    			isLegal = false;
    	}
    	// check that the first number is legal
    	if (s.charAt(0) == '0')
    		isLegal = false;
    	return isLegal;
    }


    /**
     * Compares the specified object with this Number for equality.
     * Returns true if and only if the specified object is also a
     * Number (object) which represents the same number.
     * @param obj he object to be compared for equality with this Number
     * @return true if and only if the specified object is equal to this object
     */
    public boolean equals(Object obj){ // assignment #8
    	boolean isEqual = true;
    	// check if obj is instance of Number
    	if (!(obj instanceof Number))
    		isEqual = false ;
    	Number num = (Number) obj ;
    	// check if obj has the same size
    	if (this.list.size() != num.list.size() )
    		isEqual = false ;
    	// check if they has the same values
    	else {
    		for (int i = 0; i < list.size() & isEqual ; i = i+1) {
    			if (!(list.get(i).equals(num.list.get(i))))
    					isEqual = false;
    		}
    	}
   		return isEqual ;
    }


    /**
     * Returns a string representation of this Number
     * as a binary number.
     * @return a string representation of this Number
     */
    public String toString(){ // assignment #9
        String output = "" ;
		Iterator<Bit> it = this.bitIterator();
		while (it.hasNext()) {
			output = it.next() + output;
		}
        return output;
    }


    /**
     * Compares the two provided numbers, and returns true if
     * the first parameter is less than or equal to the second
     * parameter, as numbers.
     * @param num1 the first number to compare
     * @param num2 the second number to compare
     * @return true if and only if the first number is less than
     * or equal to the second parameter, as numbers.
     */
    public static boolean lessEq(Number num1, Number num2){ // assignment #10
    	if (num1 == null || num1.list.isEmpty()) // check if input is valid
    		throw new IllegalArgumentException ("illegal input");
		if (num2 == null || num2.list.isEmpty())
    		throw new IllegalArgumentException ("illegal input"); // check if input is valid
		// create iterator for both numbers
		Iterator<Bit> it1 = num1.bitIterator();
		Iterator<Bit> it2 = num2.bitIterator();
		boolean output = true; // if num1 equals num2 the output is true
		// check if num1 is less than num2
		while (it1.hasNext() & it2.hasNext()) {
			Bit a = it1.next();
			Bit b = it2.next();
			// check if the bit of num1 is less than num2
			if (!(a.equals(b))) { 
				if (a.lessThan(b)) 
					output = true;
				else if (b.lessThan(a))
					output = false;
			}
		}
		// check if num2 contains more bits
		if (it2.hasNext())
			output = true;
		else if (it1.hasNext())
			output = false;
		return output;
    }


    /**
     * Compares the two provided numbers, and returns true if
     * the first parameter is strictly less than the second
     * parameter, as numbers.
     * @param num1 the first number to compare
     * @param num2 the second number to compare
     * @return true if and only if the first number is strictly
     * less than the second parameter, as numbers.
     */
    public static boolean lessThan(Number num1, Number num2){ // assignment #11
    	if (num1 == null || num1.list.isEmpty()) // check if input is valid
    		throw new IllegalArgumentException ("illegal input");
		if (num2 == null || num2.list.isEmpty()) // check if input is valid
    		throw new IllegalArgumentException ("illegal input");
		// create iterator for both numbers
		Iterator<Bit> it1 = num1.bitIterator();
		Iterator<Bit> it2 = num2.bitIterator();
		boolean output = false; // if num1 equals num2 the output is false
		// check if num1 is less than num2
		while (it1.hasNext() & it2.hasNext()) {
			Bit a = it1.next();
			Bit b = it2.next();
			if (!(a.equals(b))) { // check if the bit of num1 is less than num2
				if (a.lessThan(b)) 
					output = true;
				else if (b.lessThan(a))
					output = false;
			}
		}
		// check if num2 contains more bits
		if (it2.hasNext())
			output = true;
		else if (it1.hasNext())
			output = false;
		return output;
	}
		


    /**
     * Compares this object with the specified object for order.  Returns a
     * negative integer, zero, or a positive integer as this object is less
     * than, equal to, or greater than the specified object.
     *
     * @param o the object to be compared.
     * @return a negative integer, zero, or a positive integer as this object
     * is less than, equal to, or greater than the specified object.
     */
    @Override
    public int compareTo(Number o){ // assignment #12
    	if (o == null || o.list.isEmpty())
    		throw new IllegalArgumentException ("illegal input");
    	int output = 0; // return 0 if equal
    	if (Number.lessThan(this, o)) // return -1 if this is less than the input
    		output = -1;
    	if (Number.lessThan(o, this)) // return 1 if this is bigger than input
    		output = 1;
    	return output;
    }


    /**
     * Adds the specified Number objects, and returns their sum.
     * @param num1 the first addend
     * @param num2 the second addend
     * @return the sum of the specified Number objects.
     */
    public static Number add(Number num1, Number num2){ // assignment #13
    	if (num1 == null || num1.list.isEmpty()) // check if input is valid
    		throw new IllegalArgumentException ("illegal input");
		if (num2 == null || num2.list.isEmpty()) // check if input is valid
    		throw new IllegalArgumentException ("illegal input");
		// create iterator for both numbers
    	Iterator<Bit> it1 = num1.bitIterator();
		Iterator<Bit> it2 = num2.bitIterator();
		Bit Cin = new Bit(false); // create a Bit that we will be used to save the carry
		Number output = new Number ();
		output.list.remove(new Bit(false)); // remove the default Bit from the number
		while (it1.hasNext() & it2.hasNext()) {
			Bit A = it1.next();
			Bit B = it2.next();
			Bit sum = Bit.fullAdderSum(A, B, Cin);
			output.list.add(sum); // add to number the Sum of the two bits
			Cin = Bit.fullAdderCarry(A, B, Cin); // save the new carry
		}
		// check if num1 has more bits
		if (it1.hasNext()) {
			while (it1.hasNext()) {
				Bit A = it1.next();
				Bit B = new Bit(false);
				Bit sum = Bit.fullAdderSum(A, B, Cin);
				output.list.add(sum);
				Cin = Bit.fullAdderCarry(A, B, Cin);
			}
		}
		// check if num2 has more bits
		else if (it2.hasNext()) {
			while (it2.hasNext()) {
				Bit A = it2.next();
				Bit B = new Bit(false);
				Bit sum = Bit.fullAdderSum(A, B, Cin);
				output.list.add(sum);
				Cin = Bit.fullAdderCarry(A, B, Cin);
			}
		}
		// check if there is a carry that left to add
		if (Cin.isOne())
			output.list.add(Cin);
		return output;
    }


    /**
     * Multiply the specified Number objects, and returns their product.
     * @param num1 the first factor
     * @param num2 the second factor
     * @return the product of the specified Number objects.
     */
    public static Number multiply(Number num1, Number num2){ // assignment #14
    	if (num1 == null || num1.list.isEmpty()) // check if input is valid
    		throw new IllegalArgumentException ("illegal input");
		if (num2 == null || num2.list.isEmpty()) // check if input is valid
    		throw new IllegalArgumentException ("illegal input");
    	Iterator<Bit> it1 = num1.bitIterator(); // create iterator num1
		Number sum = new Number ();
		int i = 0;
		while (it1.hasNext()) {
			Bit A = it1.next();
			Number num = new Number();
			num.list.remove(new Bit(false)); // remove the default Bit from the number
			for (int j = i; j>0 ; j=j-1) // add 0 to the number
				num.list.add(new Bit(false));
			Iterator<Bit> it2 = num2.bitIterator();
			while (it2.hasNext()) {
				Bit B =it2.next();
				if (B.isOne() & A.isOne()) // only if both numbers are 1 add 1
					num.list.add(new Bit(true));
				else // if one of them is 0 add 0
					num.list.add(new Bit (false)); 
			}
			i = i+1;
			sum = Number.add(num, sum);
		}
		return sum;
    }

}
