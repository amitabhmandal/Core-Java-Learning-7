package operators;

/* There is operator precedence but no operand precedence.
 * Hence all operands will be evaluated from left to right 
 * 
 * 
 * 
 * 
 * 
 */
public class OperatorPrecedenceTester {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(m(1) + m(2) * m(3) / m(4) + m(5) * m(6));
	}
	
	public static int m(int i) {
		System.out.println(i);
		return i;
	}

}


