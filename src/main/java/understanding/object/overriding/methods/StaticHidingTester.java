package understanding.object.overriding.methods;


// A static method in a subclass may hide another static one in a superclass, and that’s called hiding.

public class StaticHidingTester {

    public static void main(String[] args) {
        StaticChild staticChild = new StaticChild();

    }

}

class StaticParent {
    static void sleep() {
        System.out.println("StaticParent sleeps");
    }
}


// When a static method of the superclass is hidden, it requires the subclass to use a fully qualified 
// class name of the superclass to invoke the hidden method, as shown in the doSomething() method of 
// the StaticChild class below:
class StaticChild extends StaticParent{
    static void sleep() {
        System.out.println("StaticChild sleeps");
    }
    
    
    void doSomething() {
        sleep(); // calling the static sleep of the same class
        StaticParent.sleep(); // calling the static method of the parent class
    }
}
