package modifiers;

/* Variables are of 3 types
 * 1. Local
 * 2. Instance
 * 3. Static/Global
 * 
 * ++++++++++++++++++++++++
 * final instance variables
 * ++++++++++++++++++++++++
 * For instance variables JVM provides default values which helps to initialize the values.
 * 
 * *******
 * RULE #1
 * *******
 * If the instance variable has been declared final then compulsory we have to perform
 * initialization explicitly whether we are using or not and JVM will not provide default
 * values. We should perform the initialization before construction completion
 * 
 * *******
 * RULE #2
 * *******
 * The places where final variables can be declared 
 * 
 * -> At the time of the declaration
 * -> In the instance block. The instance block is initialized before constructor is called.
 * -> Before constructor completion.
 * 

 * 
 * ++++++++++++++++++++++++
 * final static variables
 * ++++++++++++++++++++++++
 * for static variables JVM is going to provide default values. We are not supposed to provide
 * explicit initialization.
 * 
 * If a static variable is declared then compulsory we should provide initialization 
 * explicitly otherwise we will get compile time error and JVM will not provide any default values.
 * 
 * *******
 * RULE #3
 * *******
 * We should complete initialization before class loading.
 * The places where static variables can be initialized before class loading completion.
 * 
 * -> At the time of declaration
 * -> Static initialization block
 * If we try to perform initialization anywhere else we will get compile time error.
 * 
 * 
 * ++++++++++++++++++++++++
 * final local   variables
 * ++++++++++++++++++++++++
 * The variables which are declared inside a  
 *  - > method 
 *  - > block
 *  - > for-loop block
 *  are called local variables.
 *  
 *  local variables are stored inside stack.
 *  
 *  JVM will not provide any default values. We should do compulsory initialization.
 *  
 * *******
 * RULE #4
 * ******* 
 * Before accessing local variables must be initialized. 
 * If not then it will lead to compile time error.
 * 
 * If the variables are declared and not being initialized and not being accessed then it will
 * not lead to any compile time error
 * 
 * Output is Hello
 * public  class InstanceBlockVsConstructor {
    
    public static void main(String[] args) {
    int x;
    System.out.println("Hello");
        
    }
    
}


 * However if the local variable has not been initialized and still being accessed then
 * it will lead to compile time error.  
 *  
 *  public  class InstanceBlockVsConstructor {
    
    public static void main(String[] args) {
    int x;
    System.out.println("Hello" + x);
        
    }
    
}//error: variable x might not have been initialized
    System.out.println("Hello" + x);
                                 ^
 * *******
 * RULE #5
 * ******* 

 *  If local variable has been declared final and not being accessed then it will not lead
 *  to any compilation error
 *  
 *   public  class InstanceBlockVsConstructor {
    
    public static void main(String[] args) {
    final int x;
    System.out.println("Hello" );
        
    }
    
} //Hello will be the output
 *  
 * *******
 * RULE #6
 * ******* 
 * local variables possible access modifier
 * final and if anything else is used then it will lead to compile error.
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

public class FinalVariablesTester {
	int x;

	final int y;
	final static int z;
	static {
		z = 6;
	}
	// RULE - 1
	//
	// if final instance variable has not been initialized then it will lead to
	// compile
	// time error whether we are using or not.
	// The values should be initialized before constructor completion.
	// final int y;

	{
		// y = 0;
	}

	FinalVariablesTester() {
		y = 5;
	}

	public static void main(String[] args) {
		FinalVariablesTester finalVariablesTester = new FinalVariablesTester();
		System.out.println(finalVariablesTester.y);
		System.out.println(FinalVariablesTester.z);
	}

}
