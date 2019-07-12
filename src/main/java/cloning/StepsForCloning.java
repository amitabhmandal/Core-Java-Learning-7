package cloning;

public class StepsForCloning {
    
    // Following are the method requirements for cloning
    
    // CHANGE #1. Since the return method of clone method is object hence the return type should be 
    // downcasted to the reference type else it will result in compilation error: incompatible types
    // found object required given reference type
    
    // CHANGE #2. Object class clone method throws CloneNotSupportedException
    // which needs to be handled. We can handle it by using throws keyword or by using try-catch block
    
    // CHANGE #3.

    public static void main(String[] args) {
        SampleClone a1 = new SampleClone();
        a1.a = 10;
        a1.b = 10;
        
        System.out.println(a1);
        
       // SampleClone b1 = (SampleClone) a1.clone();

    }

}

class SampleClone {
    int a;
    int b;
    @Override
    public String toString() {
        return "SampleClone [a=" + a + ", b=" + b + "]";
    }

    
}
