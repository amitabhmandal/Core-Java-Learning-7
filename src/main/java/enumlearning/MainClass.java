package enumlearning;

public class MainClass {
	public static void main(String[] args) {
		Enum en = EnumsTest.C;

		MyEnums[] myEnums = new MyEnums[4];

		for (int i = 0; i < myEnums.length; i++) {
			System.out.println(myEnums[i]);
		}
		
		System.out.println(EnumOne.ONE);
	}
}
enum EnumOne
{
    ONE;
     
    {
        System.out.println("ONE");
    }
     
    enum EnumTwo
    {
        TWO;
         
        {
            System.out.println("TWO");
        }
    }
}
 
enum MyEnums {
	FIRST, SECOND, THIRD, FOURTH;
}

enum EnumsTest {
	A, B, C;

	{
		System.out.println(1);
	}

	static {
		System.out.println(2);
	}

	private EnumsTest() {
		System.out.println(3);
	}
}