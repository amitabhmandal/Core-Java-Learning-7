package exception;

/*
 * Definition of Exception
 * Any unwanted unexpected event that disturbs the normal flow of the program is called exception
 * 
 * 
 * Exception Handling: Purpose
 * If something goes wrong then we should not miss anything and continue normally like
 * that we should be able to handle. That is the sole purpose of exception handling.
 * 
 * For instance if exception happens then Database connection should be successfully close it.
 * If we are not able to close it then we are going to loose the database connection. 
 * 
 * Thus we need to find a graceful termination of the transaction so that nothing is lost.
 * 
 * Defining alternative way to continue rest of the program normally.
 * 
 * Exception handling does not mean repairing.
 * 
 * If an exception occurs the method in which the exception occurs is responsible for creating
 * the exception object by including the following information
 * Name of Exception               : ArithematicException
 * Description of Exception        : Division by Zero
 * Location of Exception           : doMoreStuff()/doStuff()/ ie the stack trace
 * 
 * Once the exception Object has been prepared the method hands over the exception object to
 * JVM. Then JVM shall try to find out whether the location of exception has the capability 
 * to handle the exception or not. Basically the method invoking the exception has the ability
 * to handle the exception or not.
 * 
 * If the method invoking the exception does not have exception handling code then JVM
 * shall terminate the method abnormally and the remaining lines of code of the method
 * shall not be executed and removes the activation-record/stack-frame from the stack and moves
 * onto it's calling method.
 * 
 * If none of the methods are capable of handling the exception then JVM will pass it onto 
 * the Default Exception handler which publish the following information
 * Name of Exception
 * Exception Description
 * Location of the Exception.
 * 
 * And terminate the program abnormally.
 * 
 * Throwable has two(Exception & Error) child classess 
 * Exception - If the program can recover from the exception by providing some error handling
 * mechanism then it is called exception
 * 
 * Error - If the program cannot recover from the exception then it is classified as error.
 * 
 * Checked and unchecked exception(difference)
 * 
 * Whether it is checked or unchecked all exceptions occur at runtime.
 * There is no chance of any exception occuring at compile time.
 * 
 * Checked exception: The exceptions which are checked by compiler, for smooth execution
 * of the program at runtime. These exceptions by default are considered to be checked exception.
 * Checked Exception must be caught by using try-catch block or by using throws Keyword.
 * 
 * 
 * Unchecked Exception: The exceptions which are not checked by compiler whether handled by 
 * programmer or not is called unchecked exception. 
 * 
 * 
 * RuntimeExceptions and it's child classes and Errors and it's child classes
 *  are example of Unchecked Exception.
 * 
 * Rest of exceptions which includes Exception, Throwable are all checked Exceptions. 
 * 
 * 
 * The only possible partially checked exceptions are
 * 1. Exception
 * 2. Throwable 
 * 
 * Fully checked Exceptions: 
 * A checked exception is said to be fully checked if and only if all it's child classes are
 * checked exceptions.
 * Example: IOException, InterruptedException.
 * 
 * 
 * The code which may raise exception is called Risky Code and is put inside try-catch block.
 * 
 * Without try catch if an exception occurs then it will lead to abnormal terminal exception.
 * This may lead to loss of resources or other important activities.
 * 
 * 
 * With try-catch block the code executes an alternative flow. Thus we can carry out some
 * default activities thus safe guarding resources. Hereby when try-catch is used then
 * then program ends with normal execution. 
 * 
 * 
 * We need to have a try with catch or try with finally. We simply cannot only have a try
 * block. It will lead to compilation error.
 * 
 * Only try not allowed
 * Only catch not allowed
 * Only finally not allowed
 * 
 * If try is there then it immediately need to be followed with a catch block. No 
 * other statement should exist else it will lead to compilation error.
 * 
 * Try-finally-catch is an invalid order. finally should come  in the last.
 * 
 * Try-catch-Other-Statement-Catch is invalid combination. Try-catch-catch is valid hence
 * no other statement should appear.
 * 
 * Try-catch-OtherStatement-Finally. Other statement should not exists between the catch and
 * finally should exists.
 * 
 * Valid Combination
 *  try{
            try{
                System.out.println("Hello World");
            }
            catch(Exception e){
                System.out.println("Hello World");
            }
        } catch(Exception e){
            System.out.println("Hello World");
        }
 * 
 * Invalid combination
 *         try{
            try{
                System.out.println("Hello World");
            }
            
        } catch(Exception e){
            System.out.println("Hello World");
        }
 * 
 * 
 * Valid combination
 *         try{
            try{
                System.out.println("Hello World");
            }
            
            finally{
                
            }
            
        } catch(Exception e){
            System.out.println("Hello World");
        }
 * 
 * Valid combination
 *         try{
            System.out.println("Hello World");

            
        } catch(Exception e){
                        try{
                System.out.println("Hello World");
            }
            
            finally{
                
            }
        }
 * 
 * 
 * Valid combination:
 *   try{
            System.out.println("Hello World");

            
        } catch(Exception e){
                        try{
                System.out.println("Hello World");
            }
            
            finally{
                
            }
        }
        finally{
                    try{
            System.out.println("Hello World");

            
        } catch(Exception e){
                        try{
                System.out.println("Hello World");
            }
            
            finally{
                
            }
        }
        }
        
        
        
 *
 * Multiple finally for a try not allowed      
 *       
 * For try - catch - finally block curly braces are mandatory. Even though they might 
 * have single statements they need to be included within the curly braces.
 * 
 * 
 * Throw vs Throws Differences
 * 
 * Throw KeyWord - Programmer create exception object and hand it to JVM programatically.
 * Steps included. 
 * Created Exception Object Manually. Handed it over to the JVM manually.
 * we dont need to have a try-catch-finally block to execute throw statement.
 * It can be present anywhwere in the code for example:    
	public static void main(String[] args) {
		throw new ArithmeticException("/ by zero");
	} This code is valid.
 
 * Where do we need to create Exception Object Explicitly?
 * If we want to throw User Defined Exception or Customized Exception then it is best suited
 *       
 *  This will lead to NPE: since for static Object references default value is NULL
 *  public class StaticFlowTester {
    static ArithmeticException e;
    public static void main(String[] args) {
       throw e;
    }
}     
 * 
 * The following code will lead to NPE:
 * public class StaticFlowTester {
    static ArithmeticException e;
    public static void main(String[] args) {
       throw null;
    }
}
 * 
 * Difference between the following two codes:
 * CASE A
 * public class StaticFlowTester {
    static ArithmeticException e;
    public static void main(String[] args) {
       throw new ArithmeticException("Division by zero");
       System.out.println("Hello");
    }
}      
 * This will lead to compilation Error as after throw execution Statements shall not be executed
 * "Unreachable Statement"
 * 
 * CASE B
 * public class StaticFlowTester {
    static ArithmeticException e;
    public static void main(String[] args) {
       //throw new ArithmeticException("Division by zero");
       System.out.println(10/0);
       System.out.println("Hello");
    }
}       
 * The above code will lead to Runtime Exception of ArithematicException. WHerein CASE A
 * we were getting compilation Error.       
 *       
 * For the throw keyword to work the type of Object should be Throwable else it will lead 
 * to compilation error: "incompatible types: StaticFlowTester cannot be converted to Throwable
       throw new StaticFlowTester();"
 * public class StaticFlowTester {
    static ArithmeticException e;
    public static void main(String[] args) {
       throw new StaticFlowTester();
    }
}
 *  
 *       
 * The following code shall be executed successfully as      
 * StaticFlowTester extends RuntimeException which is child of Throwable
 *       
 * public class StaticFlowTester extends RuntimeException{
    static ArithmeticException e;
    public static void main(String[] args) {
       throw new StaticFlowTester();
    }
}      
 *       
 * 
 * THROWS USAGE:      
 * To delegate responsibility of exception handling to the caller method. 
 * Caller can be JVM or maybe another method.
 * 
 * Usage of throws keyword does not prevent abnormal termination. Recommended to use try-catch
 * compared to throws keyword.
 * Throws keyword required only for checked exceptions. 
 * 
 * Usage of throws keyword for unchecked
 * exceptions there is no use or impact.
 * 
 * Throws keyword required to convince compiler and usage of throws keyword does not
 * prevent abnormal termination of the program.
 * 
 * The following code will not compile even though the calling method is handling
 * the InterruptedException 
 * public class ThrowsTester {
    public static void main(String[] args) throws InterruptedException{
       doMoreStuff();
    }
    
    public static void doMoreStuff() {
        Thread.sleep(1000);
    }
}
 * The InterruptedException needs to be handled by the method where it is occuring.
 * In the above program if we remove atleast one throws Statement then the code will not compile
 *  
 *       
 *       
 * We can use throws keyword for methods and constructors but not for classes.
 * 
 *       
 * Throws keyword can be used for Throwable types hence the following code will lead
 * to compilation error
 * 
 * public class ThrowsTester  {
    public static void main(String[] args) throws ThrowsTester {
    }
    
}

incompatible types: ThrowsTester cannot be converted to Throwable
    public static void main(String[] args) throws ThrowsTester
 *  
 *       
 * To make the above code right the following code needs to be executed
 * public class ThrowsTester extends Exception  {
    public static void main(String[] args) throws ThrowsTester {
    }
    
} The code will now compile successfully.      
 *  
 *       
 *       
 * The following code will not compile 
 * public class ThrowsTester  {
    public static void main(String[] args) {
        throw new Exception();
    }
}  unreported exception Exception; must be caught or declared to be thrown
        throw new Exception();      
 * Exception is a checked exception hence compiler will scream to be handled or use throws 
 * throws Keyword      
 *       
 * 
 *       
 *       
 * The following code will compile successfully 
 * 
 * public class ThrowsTester  {
    public static void main(String[] args) {
        throw new Error();
    }
}      
 * Error is an unchecked exception hence it is not necessary for to be handled or to be
 * used throws Keyword      
 *       
 *       
 * If there is no chance of raising a checked exception then there is no point in writing
 * a catch block. Thereby the following code will not compile as the following checked 
 * exception is never detected.
 * 
 * import java.io.*;
public class ThrowsTester  {
    public static void main(String[] args) {
        try{
            System.out.println("Hello");
        }catch(IOException e){
            
        }
    }
}exception IOException is never thrown in body of corresponding try statement
        }catch(IOException e){
         ^
1 error      
 * 
 *       
 *       
 * Similarly the following code will not compile properly.
 * public class ThrowsTester  {
    public static void main(String[] args) {
        try{
            System.out.println("Hello");
        }catch(InterruptedException e){
            
        }
    }
}exception InterruptedException is never thrown in body of corresponding try statement
        }catch(InterruptedException e){
         ^
1 error      
 *       
 *       
 * Exception Handling 5 keywords: try-catch-finally-throw-throws      
 *
 * 
 *       
 * *********************************************      
 * Customized Exception or Use Defined Exception      
 * *********************************************      
 * To meet programmers defined exception is called customized or User Defined Exception
 * 
 *       
 * -------------------     +++++++++++++++++++++++++++++++++++++++++++++ 
 * Java 7 New features --> Try with Resource + Multi Catch Block
 * -------------------     +++++++++++++++++++++++++++++++++++++++++++++ 
 * 
 *  Try with resources
 *  in the Old style - whatever resources we opened up as part of try block we should close
 *  it in the finally block. This leads to increase in complexity. Also the developer might
 *  forget to close the resource which leads to additional wastage of single resource.
 *  
 *   Old Style Try Catch Finally without Resource
 *   
 *   
 *   public class OldTryWithoutResource  {
    public static void main(String[] args) {
        try{
            BufferReader br = new BufferReader(new FileReader("abc.txt"));
        }catch(IOException e){
            
            
        }
        finally{
            if(br !=null){
                br.close();
            }
        }
    }
}
 *   Try with Resource
 *   --> Increase readability
 *   --> No need finally block required    
 *   --> Whatever resources we open as part of Try block will be closed automatically
 *   we will not need to close it anymore.
 *  	 --> length of the code is going to reduce.
 *   
 *   Resource - can be fileReader/ Database Connection / Network Connection etc
 *   
 *  ------------------- NEW SYNTAX OF TRY RESOURCE -------------------
 *  public class OldTryWithoutResource  {
    public static void main(String[] args) {
        try(BufferReader br = new BufferReader(new FileReader("abc.txt")))
        {
            System.out.println("Hello");
        }catch(IOException e){
            
            System.out.println("No Need of finally");
        }
    }
}     
 *   General syntax of the Try Resource
 *   try (R1 ; R2 ; R3 ..)
 *   {
 *   }
 *   catch(Exception e){
 *   }   
 *       
 *       
 *   All Resources should be auto-closeable resource. Resources are said to be autocloseable 
 *   implement java.lang.AutoCloseable Interface     
 *       
 *   All try resources are implicity final. If we try to assign anything else to it then it will
 *   lead to compilation error as shown below:
 *   
 *   public class OldTryWithoutResource  {
    public static void main(String[] args) {
        try(BufferedReader br = new BufferedReader(new FileReader("abc.txt")))
        {
            br = new BufferedReader(new FileReader("xyz.txt"));
            System.out.println("Hello");
        }catch(IOException e){
            
            System.out.println("No Need of finally");
        }
    }
} error: auto-closeable resource br may not be assigned
            br = new BufferedReader(new FileReader("xyz.txt"));
 *      
 *      
 *  Until 1.6v try should be followed by catch or finally. Only try is invalid and will 
 *  lead to compiler problems.
 *  
 *  From 1.7v try with resource is valid syntax. 
 *      
 * -------------------     
 * Multi Catch Block
 * -------------------     
 * Until 1.6v multiple different exceptions having same handling code. For every exception
 * type we have to write a seperate catch block. This leads to increases the length of the code
 * and reduces readability.
 * 
 * In 1.7 version introduced multi catch block. According to this we can write a single catch
 * block that can handle multiple different type of exceptions.
 * 
 * In multi catch block between exceptions there should be no parent child relationships.
 * All the exceptions should be different. If there is a parent-child relationship then
 * there is no point of keeping child as parent can handle the child exception as well 
 * hence child exception redundant.
 * 
 * -------------------     
 * Rethrowing Exception
 * -------------------      
 * To convert an exception type into another exception type
 * For Example ArithematicException can be rethrown into NullPointerException.
 * 
 *       
 */

public class ExceptionHandlerTester {
	public static void main(String[] args) {
		// doStuff();
		throw new ArithmeticException("/ by zero");
		//ExceptionMethodDifferences exceptionMethodDifferences = new ExceptionMethodDifferences();
		//exceptionMethodDifferences.divisionByZero();

	}

	public static void doStuff() {
		doMoreStuff();
	}

	public static void doMoreStuff() {
		System.out.println("Hello World");
		System.out.println(10 / 0);
	}

}

class ExceptionMethodDifferences {

	public void divisionByZero() {
		try {
			System.out.println(10 / 0);
		} catch (ArithmeticException e) {
			e.printStackTrace();
			// THESE METHODS DESCRIPTION ARE PRESENT IN THE THROWABLE CLASS

			// gives you name of Exception
			// Exception description
			// Stack Trace ie location of exception

			System.out.println(e.getMessage());
			// Will give you description of the exception

			System.out.println(e);
			// Will give you the name of the exception along with the description of
			// exception

			System.out.println(e.toString());
			// Will give you the name of the exception along with the description of
			// exception
			System.out.println(e.getCause());

		}

	}
}
