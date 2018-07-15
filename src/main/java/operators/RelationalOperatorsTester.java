package operators;

/*
 * Relational Operators : < , <= , >, >= 
 * 
 * We can apply relational operators for every primitive type except boolean
 * 
 * We cannot use relational operators for Object type. If we use relational operators 
 * then it will lead to compile time error
 * 
 * Nesting of relational operators not allowed and will lead to compilation error in Java
 * 
 * 
 * 
 */

public class RelationalOperatorsTester {

	public static void main(String[] args) {

		System.out.println(10 < 20); // true

		// 'a' will be promoted to int and it's corresponding 97 value will be used in
		// comparison
		System.out.println('a' < 20); // false

		// 'a' will be promoted to int and it's corresponding 97 value will be used in
		// comparison
		System.out.println('a' < 97.6);// true

		// 'a' will be promoted to int and it's corresponding 97 value will be used in
		// comparison
		System.out.println('a' > 'A');// true

		// System.out.println(true > false);// compiler
		/*
		 * compiler error bad operand types for binary operator '>'
		 * System.out.println(true > false);//true ^ first type: boolean second type:
		 * boolean
		 */

		// relational operators cannot be used to compare Objects. If used then will
		// result in
		// compile time error
		//System.out.println("amitabh" > "mandal");
		/*
		 * bad operand types for binary operator '>' System.out.println("amitabh" >
		 * "mandal"); // true ^ first type: String second type: String 1 error
		 */
		
		
		//The following statement will lead to compiler error.
		//Because 10 < 20 will result in true. 
		//true then cannot be compared with < 30.
		//Hence the statement of 10 < 20 < 30 will result in compilation error.
		//Thus nesting of relational operators not allowed.
		//System.out.println(10 < 20 < 30 );
		
	}

}
