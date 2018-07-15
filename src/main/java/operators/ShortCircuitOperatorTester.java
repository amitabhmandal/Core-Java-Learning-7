package operators;

/*
 * && and || 
 * 
 * In case of normal & operator whether the second operator is required or not it is going to be
 * evaluated which wastes system time and decreases the performance.
 * Normal & and | operator is applicable for integral and boolean type.
 * 
 * 
 * 
 * && -> if the first one is going to be true then it is going to evualate the second
 * If the first one is not true then the second one is not going to be evaluated.
 * 
 * Short-circuit && and || operator is only applicable for boolean type. Because to evaluate
 * the second operand it needs to know whether the first one is true or false. Thus these 
 * operators can only be applicable for boolean operands.
 * 
 * Short circult && - Will evaluate the second operand only if the first results in true.
 * Short circuit || - Will evaluate the second operand only if the first one is false.
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 */
public class ShortCircuitOperatorTester {

	public static void main(String[] args) {
		int x = 10;
		/*
		 * since the first operand evaluates to false hence the second operand will
		 * never be checked hence it does not check the second operand and thus run time
		 * exception arithematic exception never happens
		 */
		if (++x < 10 && (x / 0 > 10)) {
			System.out.println("Hello");
		} else {
			System.out.println("Hi");
		}

		
		//This will result into runtime exception AE : / by zero 
		int y = 10;
		if (++y < 10 || (y / 0 > 10)) {
			System.out.println("Hello");
		} else {
			System.out.println("Hi");
		}
	}

}
