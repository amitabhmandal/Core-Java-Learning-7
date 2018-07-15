package operators;

/*
 * Type Casting are of two type
 * 
 * -----------------------
 * Implicit Type Casting :
 * ----------------------- 
 * int x = 'a'; sopln(x) result in 97. 
 * 
 * Internally compiler converts char to int automatically by implicit type casting
 * 
 * who is responsible: Compiler does this casting
 * It is called widening or upcasting.
 * there is no loss of information in this type of casting.
 * 
 * byte ->> short  ->> int  ->> long ->> float  ->> double
 * 
 * char  ->> int  ->> long ->> float  ->> double
 * 
 * -----------------------
 * Explicit Type Casting :
 * -----------------------
 * int x = 130;
 * byte b = x; this will result into compile time error as there will loss of information
 * hence compiler will not do any casting.
 * 
 * Hence explicit casting will be required.
 * 
 * byte b = (byte)x; This explicit casting would happen but it would result in loss of 
 * information.
 * who is responsible: Programmer is responsible.
 * Bigger data type value into smaller data type value.
 * It is called as narrowing or down-casting.
 * There might be a chance of loss information.
 * 
 * 
 * If we assign floating point values to integral types by explicit type casting.
 * The digits after the decimal point will be lost.
 * 
 * 
 * 
 */
public class TypeCastingOperatorTester {

	public static void main(String[] args) {

		// If we assign floating point values to integral types by explicit type
		// casting.
		// The digits after the decimal point will be lost.
		
		double d = 130.456;
		int x = (int) d;
		System.out.println(x);

		byte b = (byte) d;
		System.out.println(b);

	}

}
