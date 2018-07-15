package operators;

/* Increment operators 
 * y = ++x; Increment x value and assign it to y. It is called pre-increment
 * y = x++; Post increment operator. First assign and then increment.
 * 
 * Decrement operator
 * y = --x; decrement x value and assign it to y. it is pre-decrement
 * y = x--; post decrement operator. First assign and then decrement operator
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 */

public class IncrementDecrementTester {

	public static void main(String[] args) {
		// pre-increment
		int x = 10;
		int y = ++x;
		System.out.println("pre-increment x = " + x + " y = " + y);
		// post-increment
		x = 10;
		int z = x++;
		System.out.println("post-increment x = " + x + " z = " + z);
		// pre-decrement
		x = 10;
		y = --x;
		System.out.println("pre-decrement x = " + x + " y = " + y);

		// post-decrement
		x = 10;
		y = x--;
		System.out.println("post-decrement x = " + x + " y = " + y);

		// CONCLUSION #1:
		// increment and decrement operators only for variables and not for values.
		x = 10;
		// y = ++ 10; increment and decrement operators applicable only variables and
		// not for
		// constant values. Unexpected type found value required variable
		System.out.println("y = " + y);

		x = 10;

		// CONCLUSION #2 : Nesting of incrementing and decrement operator not allowed.
		/*
		 * y = ++ (++x); //Compile time error
		 * 
		 * after applying the ++x it will become value, for the value how come you can
		 * apply operator
		 * 
		 * y = ++ ++x; //compile time error
		 */

		/*
		 * CONCLUSION #3 : Final values cannot be re-assigned. if tried to reassign it will lead
		 * to compile error.
		 */
		final int w = 10;
		// w = 11; //compile error

		// For final variables we cannot apply increment or decrement operators.
		// If we use them then it will lead to compile time error.
		// Error : cannot assign a value to final variable
		final int q = 10;
		// q++; // q = q + 1;
		System.out.println("final value q = " + q);

		// CONCLUSION #4 : Increment and decrement operators applicable for int,
		// double and char data types, long and float and all other primitive operators
		// except boolean
		// as shown below
		int p = 10;
		p++;
		char ch = 'a'; // a = a + 1 = b
		ch++;
		double d = 10.5; // d = 10.5 + 1 = 11.5
		d++;

		float f = 11.1f;
		f++;

		long l = 11l;
		l++;
		boolean b = true; // b++ will lead to compile time error as bad operand type boolean
							// for unary
							// operator '++'

		System.out.println(p);

		System.out.println(ch);
		System.out.println(d);
		System.out.println(f);
		System.out.println(l);
		// System.out.println(b++);

		// Byte increment or decrement
		
		//CONCLUSION #5. In case of byte, there is difference between byte ++ and byte = byte +1
		byte b1 = 127;
		// b1 = b1 + 1; max(int , byte , by default every number is int) which is int. 
		//Hence how can we assign a int value to byte thus we get compile time error
		//for b = b + 1;
		
		//why b1++ works without compile time error
		b1++; // Internal type casting is performed which translates to 
		// (type of b1) (b1 + 1)  == Results in Byte

		// incase of bytes b++ is not same as b = b + 1
		System.out.println("b1 " + b1);

		// Following addition of bytes lead to compilation error
		byte a2 = 100, b2 = 100;
		//byte c2 = a2 + b2;
		//error: incompatible types: possible lossy conversion from int to byte
		//System.out.println("c2 " + c2);
		
		//If we apply any arithematic operator between two variables a and b.
		//The result type is always max(int , type of a , type of b)
		//max (int , byte , byte)
		//how to handle this compile time error is to use type casting
		
		byte c2 = (byte )(a2 +  b2);
		System.out.println("c2 " + c2);

	}

}
