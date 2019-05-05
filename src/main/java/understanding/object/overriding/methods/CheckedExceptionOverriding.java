package understanding.object.overriding.methods;

import java.io.FileNotFoundException;
import java.io.IOException;

// The overriding method must not throw new or broader checked exceptions


public class CheckedExceptionOverriding {

    public static void main(String[] args) {
        // TODO Auto-generated method stub

    }

}

class Father {
    
    protected void move() throws IOException {
        // Father moving code...
    }
    
    protected void sing() throws IOException {
        // Father moving code...
    }
    
    protected void dance() throws IOException {
        // Father moving code...
    }
}

class Child extends Father{
    //FileNotFoundException is a subclass of the FileIOException:
    protected void move() throws FileNotFoundException {
        // Child moving code...
    }
    
    //The following example shows an illegal overriding attempt because 
    //the InterruptedException is a new and checked exception
//    protected void sing() throws IOException, InterruptedException {
//        // Child moving code...
//    }
    
    //And in the example below, the child class won’t compile because its dance() method throws 
    //Exception which is superclass (broader) of the IOException
//    protected void dance() throws Exception{
//        // Child moving code...
//    }
//    
    
}


