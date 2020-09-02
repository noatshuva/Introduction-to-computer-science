import java.util.Iterator;

public class NumberTester
{
    public static void main(String[] args)
    {
        System.out.println("testNumber() = " + testNumber());
        System.out.println("testIsZero() = " + testIsZero());
        System.out.println("testBitIterator() = " + testBitIterator());
        System.out.println("testIncrement() = " + testIncrement());
        System.out.println("testIsLegal() = " + testIsLegal());
        System.out.println("testEquals() = " + testEquals());
        System.out.println("testToString() = " + testToString());
        System.out.println("testLessEq() = " + testLessEq());
        System.out.println("testLessThan() = " + testLessThan());
        System.out.println("testCompareTo() = " + testCompareTo());
        System.out.println("testAdd() = " + testAdd());
        System.out.println("testMultiply() = " + testMultiply());
    }


    public static boolean testNumber(){
    	boolean test = true;
    	Number num4 = new Number(1897);
    	Number num5 = new Number(129);
    	Number num6 = new Number(10);
    	if (!(num4.toString().equals("11101101001")))
    		test = false;
    	else if (!(num5.toString().equals("10000001")))
    		test = false;
    	else if (!(num6.toString().equals("1010")))
    		test = false;
    	Number num7 = new Number("129");
    	Number num8 = new Number("1897");
    	Number num9 = new Number("10");
    	if (!(num8.toString().equals("11101101001")))
    		test = false;
    	else if (!(num7.toString().equals("10000001")))
    		test = false;
    	else if (!(num9.toString().equals("1010")))
    		test = false;
    	Number num1 = new Number(4);
    	Number num2 = new Number(num1);
    	Number num3 = new Number(5);
    	num1.increment(); 
    	if (num1.equals(num2))
    		test = false;
    	else if (!(num1.equals(num3)))
    		test = false;
    	else if (num2.equals(num3))
    		test = false;
    	return test;
    }


    public static boolean testIsZero(){
    	boolean zero = true;
    	Number num1 = new Number();
    	Number num2 = new Number(12);
    	if (!(num1.isZero()))
    		zero = false;
    	if (num2.isZero())
    		zero = false;
    	num1.increment();
    	if (num1.isZero())
    		zero = false;
    	return zero;
    }

    public static boolean testBitIterator(){
    	boolean test = true;
    	Number num = new Number (10);
		Iterator<Bit> it = num.bitIterator();
		int [] arr = new int [4];
		arr[0] = 0;
		arr[1] = 1;
		arr[2] = 0;
		arr[3] = 1;
		while (it.hasNext()) {
			for (int i = 0; i<arr.length & test ; i=i+1) {
				Bit a = new Bit (true);
				if (arr[i] == 0)
					a = new Bit(false);
				if (!(it.next().equals(a)))
					test = false;
			}
		}
    	return test;
    }


    public static boolean testIncrement(){
    	boolean test = true;
    	Number num1 = new Number();
    	Number num3 = new Number(100);
    	Number num4 = new Number(101);
    	Number num2 = new Number(1);
    	num1.increment();
    	num1.increment();
    	num2.increment();
    	if (!(num1.equals(num2)))
    		test = false;
    	else if (num1.equals(num3))
    		test = false;
    	num3.increment();
    	if (!(num4.equals(num3)))
    		test = false;
    	return test;
    }


    public static boolean testIsLegal(){
    	boolean test = true;
    	String a = "124";
    	String b = "@!45";
    	String c = "000";
    	if (!(Number.isLegal(a))) 
    		test = false;
    	if (Number.isLegal(b))
    		test = false;
    	if (Number.isLegal(c))
    		test = false;
    	return test;
    }


    public static boolean testEquals(){
    	boolean test = true;
    	Number num1 = new Number(15);
    	Number num2 = new Number(155);
    	Number num3 = new Number("155");
    	if (num1.equals(num2))
    		test = false;
    	if (num1.equals(num3))
    		test = false;
    	if (!(num2.equals(num3)))
    		test = false;
    	return test;
    }

    public static boolean testToString(){
    	boolean test = true;
    	Number num1 = new Number(15);
    	Number num2 = new Number(155);
    	Number num3 = new Number("45");
    	if (!(num1.toString().equals("1111")))
    		test = false;
    	if (!(num2.toString().equals("10011011")))
    		test = false;
    	if (!(num3.toString().equals("101101")))
    		test = false;
    	return test; 
    }


    public static boolean testLessEq(){
    	boolean test = true;
    	Number num1 = new Number(15);
    	Number num2 = new Number(15);
    	Number num3 = new Number(16);
    	if (!(Number.lessEq(num1, num2)))
    		test = false;
    	if (!(Number.lessEq(num1, num3)))
    		test = false;
    	if (Number.lessEq(num3, num1))
    		test = false;
    	return test;
    }


    public static boolean testLessThan(){
    	boolean test = true;
    	Number num1 = new Number(15);
    	Number num2 = new Number(15);
    	Number num3 = new Number(16);
    	if (!(Number.lessThan(num1, num3)))
    		test = false;
    	if (Number.lessThan(num3, num1))
    		test = false;
    	if (Number.lessThan(num1, num2))
    		test = false;
    	return test;   
    }


    public static boolean testCompareTo(){
    	boolean test = true;
    	Number num1 = new Number(15);
    	Number num2 = new Number(15);
    	Number num3 = new Number(16);
    	if(!(num1.compareTo(num2) == 0))
    		test = false;
    	if (!(num1.compareTo(num3) < 0))
    		test = false;
    	if (!(num3.compareTo(num1) > 0))
    		test = false;
    	return test;	
    }


    public static boolean testAdd(){
       	boolean test = true;
    	Number num1 = new Number(10);
    	Number num2 = new Number(15);
    	Number num3 = new Number(25);
    	Number num4 = new Number(5);
    	Number num5 = new Number(9);
    	Number num6 = new Number(14);
    	Number num7 = new Number(7);
    	if (!(Number.add(num1, num2).equals(num3)))
    		test = false;
    	if (!(Number.add(num4, num5).equals(num6)))
    		test = false;
    	if (!(Number.add(num7, num7).equals(num6)))
    		test = false;
    	return test;
    }

    public static boolean testMultiply(){
       	boolean test = true;
    	Number num1 = new Number(10);
    	Number num2 = new Number(15);
    	Number num3 = new Number(150);
    	Number num4 = new Number(5);
    	Number num5 = new Number(9);
    	Number num6 = new Number(45);
    	Number num7 = new Number(3);
    	if (!(Number.multiply(num1, num2).equals(num3)))
    		test = false;
    	if (!(Number.multiply(num4, num5).equals(num6)))
    		test = false;
    	if (!(Number.multiply(num7, num7).equals(num5)))
    		test = false;
    	return test;
    }
}
