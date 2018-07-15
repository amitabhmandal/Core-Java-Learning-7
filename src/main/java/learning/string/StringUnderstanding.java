package learning.string;

import java.lang.reflect.Field;

public class StringUnderstanding {

	public static void main(String[] args) throws Exception {

		checkingStringPointsToSameCharText();
		stringNewOperatorVsWithoutNewOperator();
		equalsMethodEqualsOperator();
		immutabilityExplainedWithDifference();

	}

	public static void checkingStringPointsToSameCharText() {

		String s1 = "abc";
		String s2 = "a" + "b " + "c";
		showInternalCharArrayHashCode(s1);
		showInternalCharArrayHashCode(s2);

	}

	public static void showInternalCharArrayHashCode(String s) {
			try {
				final Field value = String.class.getDeclaredField("value");
				value.setAccessible(true);
				System.out.println(value.get(s).hashCode());
			} catch (NoSuchFieldException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (SecurityException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IllegalArgumentException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IllegalAccessException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} 

	}

	public static void stringNewOperatorVsWithoutNewOperator() {
		//This operation will create the String Object in the Heap and the SCP
		//Garbage collector is not allowed to access SCP area. Hence even though object
		//does not contain reference variable it is not elligible for GC.
		//If it is present in SCP area.
		String s1 = new String("Amitabh");
		
		//This operation will create the String in the SCP
		//Object creation in SCP is optional, First it will check is there any Object
		//Already present in SCP, with the required content.
		//If Object already present then existing Object will be reused.
		//If Object not already available then only a new object will be created.
		//This rule is applicable only for SCP but not for the heap.
		String s2 = "Amitabh";

		System.out.println("String new Operator vs without New Operator usage");
		
		//Duplicate String Objects with the same content is always possible in the heap 
		//area but never in the SCP area.
		System.out.println(s1.hashCode());
		System.out.println(s2.hashCode());
		
		//For every string constant one object will be placed in the SCP area
		//For every runtime operation such as concat etc that object will be created in the 
		//heap and not in the string constant pool.
		//
	}

	public static void equalsMethodEqualsOperator() {
		String s1 = new String("Amitabh");
		String s2 = new String("Amitabh");

		System.out.println("Comparing String");

		// equal operator always meant for reference comparison. Hence the two objects
		// s1 & s2
		// would always have different Object hashcodes hence they would be different
		// hence
		// the result would be false.
		System.out.println(s1 == s2);

		// In String class equals method has been overridden for content comparison
		System.out.println(s1.equals(s2));

		StringBuffer sb1 = new StringBuffer("Amitabh");
		StringBuffer sb2 = new StringBuffer("Amitabh");
		System.out.println("Comparing StringBUffer");
		// Always compares the references
		System.out.println(sb1 == sb2);

		// In StringBuffer equals method is not over-ridden hence the defaults equals
		// method of
		// Object class will be used which by default checks the references hence they
		// would
		// return a false as result.
		System.out.println(sb1.equals(sb2));

	}

	public static void immutabilityExplainedWithDifference() {

		String s = new String("amitabh");
		s.concat("mandal");
		// Once String Object is created then it cannot be changed which is shown below
		// When concatentation is being done then a new object is being created.
		// As a reference variable is not being assigned this new value hence
		// we cannot see the newly created Object
		System.out.println("String class s = " + s);

		StringBuffer sb = new StringBuffer("Delta");
		sb.append("Forces");

		// Once stringBuffer Object is created then the object can be changed hence it
		// is mutable
		System.out.println("StringBuffer class sb = " + sb);

	}
}
