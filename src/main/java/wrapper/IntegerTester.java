package wrapper;

public class IntegerTester {

	public static void main(String[] args) {

		Integer x = new Integer(10);
		Integer y = new Integer (10);
		System.out.println(x == y);
		System.out.println(x);
		System.out.println(y);
		
		
		Integer x1 = new Integer(10);
		Integer y1 = 10;
		System.out.println(x1);
		System.out.println(y1);
		System.out.println(x1 == y1);
		
		Integer x2 = 10;
		Integer y2 = 10;
		System.out.println(x2);
		System.out.println(y2);
		System.out.println(x2 == y2);
		
		
		Integer x3 = 10;
		Integer y3 = 10;
		System.out.println(x3);
		System.out.println(y3);
		System.out.println(x3 == y3);
		
		
		Integer x4 = 10000;
		Integer y4 = 10000;
		System.out.println(x4);
		System.out.println(y4);
		System.out.println(x4 == y4);
		
		
		Integer x5 = 128;
		Integer y5 = 128;
		System.out.println(x5);
		System.out.println(y5);
		System.out.println(x5 == y5);
	}

}
