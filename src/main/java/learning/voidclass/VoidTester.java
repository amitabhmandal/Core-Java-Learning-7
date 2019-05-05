package learning.voidclass;

public class VoidTester {

    /*    
    The Void class according to javadoc exists because of the fact that some time we may need to represent the 
    void keyword as an object. But at the same point we cannot create an instance of the Void class using the new 
    operator.
    This is because the constructor in Void has been declared as private. 
    Moreover the Void class is a final class which means that there is no way we can inherit this class.
    
    So the only purpose that remains for the existence of the Void class is reflection, where we can get the 
    return type of a method as void. The following piece of code will demonstrate this purpose:
    
    */
    public static void main(String[] args) throws NoSuchMethodException, SecurityException {
        @SuppressWarnings("rawtypes")
        Class c1 = Test1.class.getMethod("Testt", null)
            .getReturnType();
        System.out.println(Void.TYPE);
        System.out.println(Void.class);
        System.out.println(c1 == Void.TYPE);
        System.out.println(c1 == Void.class);

    }

}

class Test1 {
    public void Testt() {
    }
}
