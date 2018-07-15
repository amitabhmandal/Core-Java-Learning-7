package operators;

/* Arithematic Operators + - / * %
 * 
 * If we apply any arithematic operators then the result is always between 
 * two variables 'a' and 'b'. The result type is always
 * max(int, type of a , type of b) 
 * 
 * byte > short > int > long > float > double
 * char > int > long > float > double
 * 
 * Here are the Type Promotion Rules:

 * All byte and short values are promoted to int.
 * If one operand is a long, the whole expression is promoted to long.
 * If one operand is a float, the entire expression is promoted to float.
 * If any of the operands is double, the result is double.
 * 
 * 
 * 
 * byte + short = int 
 * byte + byte = int 
 * short + short = int 
 * byte + long = long 
 * long + double = double 
 * float + long = float 
 * char + char = int 
 * char + double = double
 * 
 * 
 */
public class ArithematicOperatorTester {

	public static void main(String[] args) {
		System.out.println('a' + 'b'); // 195 //char + char = int
		System.out.println('a' + 0.95); // 97.75 // char + double = double

		System.out.println((char) ('a' + 'b'));
		System.out.println((char) ('a' + 1.95));

		// In integral data types ie byte, short , int and long infinity cannot be
		// represented
		// But in float point arithematic ie float and double there is a concept of
		// positive
		// and negative infinity.
		// if we see the Double.class there is
		// positive infinity constant POSITIVE_INFINITY = 1.0 / 0.0
		// negative infinity constant NEGATIVE_INFINITY = -1.0 / 0.0;
		// Not-a-Number (NaN)= 0.0d / 0.0;

		// CASE A:
		// Int by Int = Int. This represents infinity hence
		// We will get run time exception
		// Exception in thread "main" java.lang.ArithmeticException: / by zero

		// System.out.println(10 / 0);

		// CASE B:
		// int by double = double
		// Floating point arithematic there is a represent infinity which is the output
		// Infinity

		System.out.println(10 / 0.0);

		// CASE C:
		// int by int = int
		// 0 by 0 in normal mathematics = undefined.
		// If result in undefined then there is no way to represent it in integral value
		//
		// Hence Exception in thread "main" java.lang.ArithmeticException: / by zero
		// System.out.println(0 / 0);

		// CASE D:
		// double by int = double
		// if the result is undefined in floating point arithematic
		// to represent undefined called as Not-a-Number
		System.out.println(0.0 / 0);

		// For any x values any operation will result in false
		// x < Nan == False
		// x > NaN == False
		// x == NaN == False
		// x >= NaN == False
		// x <= NaN == False
		// only when x != NaN == True
		System.out.println(10 < Float.NaN); // false
		System.out.println(10 <= Float.NaN); // false
		System.out.println(10 >= Float.NaN); // false
		System.out.println(10 > Float.NaN); // false
		System.out.println(10 == Float.NaN);// false
		System.out.println(10 != Float.NaN);// true
		System.out.println(Float.NaN == Float.NaN);// false
		System.out.println(Float.NaN != Float.NaN);// true

		// Arithematic Exceptions
		// It is run time Exception
		// but not compile time error.

		// AE will occur only integral arithematic operation but not in floating point
		// Arithematic
		
		
		//AE will occur only in the following two mathematical operator
		//Division ie /
		//Modulos Operator ie %
	}

}
