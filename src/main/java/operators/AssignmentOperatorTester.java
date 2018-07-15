package operators;

import com.sun.org.apache.xpath.internal.operations.Variable;

/*
 * Assignment operator are of 3 types
 * 
 * Simple Assignment 
 * int x = 10
 * 
 * Chained Assignment 
 * a = b = c = d =20;
 * 
 * Compound Assignment - Assignment operator mixed with some other operator 
 * a +=20;
 * 
 * Possible compound assignment +=, -=, *=, /=, %=
 * 
 * &=
 * |=
 * ^=
 * >>=  Right Shift which includes signed bit.
 * >>>= Unsigned shift operator but always filled with 0.
 * <<=
 * <<<=. There is no such kind of operator in Java.
 * 
 * 11 compound assignment operators.
 * 
 * 
 * 
 * 
 * 
 */
public class AssignmentOperatorTester {

	public static void main(String[] args) {
		int a, b, c, d;

		// Example of chained assignment
		a = b = c = d = 20;
		System.out.println(a + " " + b + " " + c + " " + d);

		// The following declaration will result into compile time error
		// int a = b = c =d = 20;
		/*
		 * error: cannot find symbol int a = b = c =d = 20; ^ symbol: variable b
		 * location: class InstanceBlockVsConstructor prog.java:11: error: cannot find
		 * symbol int a = b = c =d = 20; ^ symbol: variable c location: class
		 * InstanceBlockVsConstructor prog.java:11: error: cannot find symbol int a = b
		 * = c =d = 20; ^ symbol: variable d
		 * 
		 * we cannot perform chained assignment directly at the time of declaration.
		 */

		// This is legal declaration
		int p, q, r;
		int s = p = q = r = 20;

		// incase of compound operators internal typecasting will be performed
		// automatically

		byte w = 10;

		/*
		 * The following statement will result into compilation Error This is due to the
		 * reason max(int , byte , int) will result into int Hence how can we assign an
		 * int value to a byte Variable As it leads to loss of information.
		 * 
		 * w = w + 1;
		 */

		// However the following statement is valid as it undergoes implicit type
		// casting
		// as (byte)(w+1) hence it is valid compilation statement.
		w++;

		// The following statement is also valid as it also undergoes internal type
		// casting
		// hence the following statement is treated as (byte)(w+1)
		w += 1;

		int a1, b1, c1, d1;

		a1 = b1 = c1 = d1 = 20;
		
		//Assignment is going to happen right to left
		
		//d1 = 20. Thus d1 = 10
		//c1 = c1 * d1 = 20 * 10 = 200
		//b1 = b1 - c1 = 20 - 200 = -180
		//a1 = a1 + b1 = 20 -180 = -160
		a1 += b1 -= c1 *= d1 /= 2;
		
		
		System.out.println(a1);
		System.out.println(b1);
		System.out.println(c1);
		System.out.println(d1);
	}

}
