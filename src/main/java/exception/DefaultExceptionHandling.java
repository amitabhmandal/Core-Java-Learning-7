package exception;

// The instances of the RuntimeException are optional to handle. 
// Consequently, it still leaves a window open for getting the long stack traces at runtime. 
// To handle this, Java provides the UncaughtExceptionHandler interface.

// The Thread class contains this as an inner class. 
// In addition to this interface, Java 1.5 release also introduced a static method 
// setDefaultUncaughtExceptionHandler() in the Thread class.

// The argument of this method is a handler class that implements the UncaughtExceptionHandler interface.

// Furthermore, this interface declares the method uncaughtException(Thread t, Throwable e). 
// It will be invoked when a given thread t terminates due to the given uncaught exception e. 
// The implementing class implements this method and defines the logic for handling these uncaught exceptions.

// Let’s consider the following example that throws an ArithmeticException at runtime. 
// We define the class Handler that implements the interface UncaughtExceptionHandler.

// 
public class DefaultExceptionHandling {

    public static void main(String[] args) {
        Handler globalExceptionHandler = new Handler();
        Thread.setDefaultUncaughtExceptionHandler(globalExceptionHandler);
        new DefaultExceptionHandling().performArithmeticOperation(10, 0);

    }
    
    public int performArithmeticOperation(int num1, int num2) {
        return num1/num2;
    }

}

class Handler implements Thread.UncaughtExceptionHandler {

    public void uncaughtException(Thread t, Throwable e) {
        System.out.println("Unhandled exception caught!");
    }
}