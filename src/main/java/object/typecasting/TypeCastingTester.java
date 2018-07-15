package object.typecasting;
//General Rules for TypeCasting of Objects.

//We can use parent reference to hold child objects.
//Example: Object o = new String("abc");

//We can interface reference to hold implemented class Objects
//ex: Runnable r = new Thread();

//Format for Type Casting
//A b = (c) d;
//A --> Class or Interface name
//b --> Name of Reference variable
//c --> Class or Interface Name
//d --> Name of reference variable

//Compiler is going to check two things
//1 --> Is the conversion from d to c is legal by checking whether there is some relation or not.
//2 --> Is the conversion from c to a is legal by checking whether there is some relation or not.
//If any of the condition is not legal then it shall flag error.

//Rule =1 //Compile time checking
//if conversion from d to c is not legal then following error shall be flagged
//"inconvertible types found 'd' required 'c' 

//Rule = 2 //Compile time checking
//c must be same type of 'A' or derived type of 'A' else it would lead to compilation error
//"incompatible types found 'C' type required 'A' type

//Rule = 3//JVM Run time checking
//Run time Object type of 'D' must be either same or derived type of 'C'
//otherwise we will get run time exception saying ClassCastException
public class TypeCastingTester {

	public static void main(String[] args) {
		//Valid typecasting
		Object o = new String("abc");
		StringBuffer sb = (StringBuffer)o;
		System.out.println(sb);
		
		//Invalid Typecasting
		String s = new String("Abc");
		//StringBuffer sb1 = (StringBuffer)s;
		//System.out.println(sb1);
		

	}

}
