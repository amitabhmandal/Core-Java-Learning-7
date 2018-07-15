package operators;

/*
 * ONLY OVERLOADED OPERATOR IN JAVA IS '+' OPERATOR
 * SOMETIMES IN ARITHEMATIC addition OPERATION 10+20 = 30
 * SOMETIMES IN STRING CONCATENATION "ab" + "cd" = "abcd"
 * 
 * 
 * When + acts as arithematic operator
 * When + acts as string concatenation
 * 
 * If atleast argument is string type then + operator acts as concatenation operator and 
 * if both the arguments are number type then + operator acts as arithematic addition operator
 * 
 * 
 * 
 */

public class StringConcatenationOperatorTester {

	public static void main(String[] args) {
		String a = "abcd";
		int b = 10, c = 20, d = 30;

		System.out.println(a + b + c + d); // abcd102030

		System.out.println(b + c + d + a); // 60abcd

		System.out.println(b + a + c + d); // 10abcd2030

		System.out.println(b + c + a + d); // 30abcd30

		//int value cannot be assigned to a string variable. compiler error
		//a = b + c + d;

		//String concatenation hence can be assigned a string
		a = a + b + c;

		//String value how can be assigned to an int variable. Compiler error
		//b = a + c + d;

		
		b = b + c + d;

	}

}
