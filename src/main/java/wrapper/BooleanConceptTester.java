package wrapper;

public class BooleanConceptTester {

	public static void main(String[] args) {
		
		
		//If the String value is "true" [CASE INSENSITIVE] then everything will be true else any other string 
		//will result in false
		Boolean x = new Boolean ("yes");
		Boolean y = new Boolean ("no");
		Boolean z = new Boolean ("amitabh");
		Boolean w = new Boolean ("true");
		Boolean u = new Boolean ("TRUE");
		System.out.println(x.booleanValue());
		System.out.println(y.booleanValue());
		System.out.println(x.booleanValue());
		System.out.println(w.booleanValue());
		System.out.println(u.booleanValue());
		System.out.println(x.toString());
		System.out.println(y.toString());
		System.out.println(z.toString());
		System.out.println(w.toString());
		System.out.println(u.toString());
		System.out.println(x.equals(y));

	}

}
