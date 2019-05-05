package instance.flow.concept;

// Identification of instance members from top to bottom
// Execution of instance variables assignments and instance blocks from top to bottom
// execution of constructors

public class InstanceTest {
    int i =10;
    
    {
        System.out.println("First instance block");
        System.out.println("i =" + i);
        m1();
    }
    
    InstanceTest(){
        System.out.println("constructor");
    }

    public static void main(String[] args) {
        InstanceTest i1 = new InstanceTest();
        System.out.println("main");

    }
    
    {
        System.out.println("Second instance block");
        
    }
    
    int j =20;
    
    public void m1() {
        System.out.println("j =" + 20);   
    }

}
