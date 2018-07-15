package staticflow.concept;

//Rules how static flow is executed
// STEP 1 : Identification of Static members from top to bottom [1 to 6]

// STEP 2 : Execution of static variables assignments and static blocks from top to bottom
//[7 to 12]

// STEP 3 : Execution of Main methods
//[13 to 15]

//[RIWO State]
//If a variable is just identified by the JVM and original value not yet assigned then
//the variable is said to be in the RIWO state = Read Indirectly Write Only State

//If a variable is in Read Indirectly write only state then we cannot perform direct read
//but we can perform indirect read.

//If we are trying to read directly then we will get compile time error saying that the 
//"Illegal Forward Reference"

public class StaticFlowTester {
	static int i = 10 ;                              //-----------------1(Identification)
												     //-----------------7(Assignment)
	static {                                         //-----------------2(Identification)
		m1();                                        //-----------------8(Execution)
		//within a static block if we read a variable it is called direct read
		System.out.println("First static block " );  //-----------------10(Execution)
	}
	public static void main(String[] args) {         //-----------------3(Identification)
		m1();                                        //-----------------13(Execution)
		System.out.println("main method");           //-----------------15(Execution)
		
	}
	

	public static void m1() {                        //-----------------4(Identification)
		System.out.println("j = " + j);              //-----------------9(Execution)
		//within a static method if we read a variable it is called indirect read
													//-----------------14(Execution)
	}
	
	static {                                         //-----------------5(Identification)
		System.out.println("second static block " ); //-----------------11(Execution)
	}
	
	static int j = 20;                               //-----------------6(Identification)
													//-----------------12(Assignment)
}
