package operators;

/* Bitwise Operators : & | ^ (Applicable for both boolean and integral types
 * & -> AND ==> Returns true iff and only if both arguments are true
 * | -> OR  ==> Returns true iff  atleast one argument is true
 * ^ ->X-OR ==> Exclusive OR. Returns true iff both arguments are different
 * 
 * 
 * 
 * //Bitwise compliment operator ~ Applicable for only integral types and not for boolean types
 * 
 * 
 * 
 * Boolean compliment operator - applicable for only boolean types and not for integral types
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 */

public class BitwiseOperatorTester {

	public static void main(String[] args) {
		System.out.println(true & false); // false
		System.out.println(true | false); // true
		System.out.println(true ^ false); // true
		System.out.println(true ^ true); // false

		// This statement will lead to compilation error:
		/*
		 * bad operand types for binary operator '|' System.out.println(4.1 | 5.1); ^
		 * first type: double second type: double
		 */
		// System.out.println(4.1 | 5.1);

		// We can apply these operators for integral data types ie byte, short, long and
		// int along with boolean types
		System.out.println(4 | 5); // 100 | 101 == 101 ==> 5
		System.out.println(4 ^ 5); // 100 ^ 101 == 001 ==> 1
		System.out.println(4 & 5); // 100 & 101 == 100 ==> 4

		// Bitwise compliment operator ~
		// we can apply this operator only for integral types and not for boolean types.

		// System.out.println(~true);
		/*
		 * ad operand type boolean for unary operator '~' System.out.println(~true); ^
		 */
		
		//memory level representation 
		//MSB - sign bit 
		//0 means +ve
		//1 means -ve
		//+ve numbers will be represented directly in memory
		//-ve numbers will be represented indirectly in 2's compliment form
		//
		System.out.println(~4); 
		
		
		//Boolean compliment operator !
		//This is only applicable for boolean values and not for integral or floating data types
		
		//Hence the following statement will result in compilation error
		//System.out.println(!4);
		
	}

}
