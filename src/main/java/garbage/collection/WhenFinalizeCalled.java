package garbage.collection;

public class WhenFinalizeCalled {
    
    public WhenFinalizeCalled() {
        System.out.println("constructor called");
    }

    public static void main(String[] args) {
        System.out.println("Start of Main");
        
        String str = new String("Hello World");
        
        System.out.println("Length of String = " + str.length());
        
        str= null;
        
        WhenFinalizeCalled wFc = new WhenFinalizeCalled();
        wFc = null;
        
        System.gc();
        
        
        System.out.println("End of Main");

    }

    //We can call finalize() method explicitly then it will be executed like a normal method call
    //and object will not be destroyed.
    //However before destroying an object garbage collector calls finalize method explicitly.
    
    //calling finalize method does not mean object is destroyed. However it really means that any clean up
    //activity that needs to be done by the object will be done  by calling the finalize method.
    
    protected void finalize() {
        //This finalize method is called WhenFinalizeCalled Object is destroyed and not when String object 
        // is destroyed
        System.out.println("Finalize Method called");
    }
}
