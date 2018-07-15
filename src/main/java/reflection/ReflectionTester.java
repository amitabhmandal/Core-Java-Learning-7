package reflection;
/* it is not a technique but an API
 * 
 * It is a class manipulator. 
 * Used to manipulate class and everything.
 * 
 * It is dynamic hence slows down the code. As JVM cannot optimize the code which is dynamic 
 * hence it will make the code run a bit slow in case of reflection API.
 * 
 * Cannot be used with applets because of the security requirement
 * 
 * Since it is able to access private method and private data it should be used sparingly
 * hence recommended to use less as it might even destroy the business logic as well.
 * 
 * 
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

public class ReflectionTester {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}

class EnemyShip {

	private String idcode = "100";

	private String getPrivate() {
		return "how did you get this";

	}

	private String getOtherPrivate(int thisInt, String thatString) {
		return "How did you get here " + thisInt + " " + thatString;

	}

	public EnemyShip(int number, String randString) {
		System.out.println("You sent " + number + " " + randString);

	}
};
