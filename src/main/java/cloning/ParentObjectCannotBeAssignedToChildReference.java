package cloning;

public class ParentObjectCannotBeAssignedToChildReference {

    // To understand this we need to understand how Is-A relationship / polymorphism
    // and overriding works

    // When parent child relationship comes into play then it is done in two phases
    // PHASE 1: Compile time wherein it checks whether the reference variable has access to the methods or not
    // PHASE 2: Runtime wherein it actually checks the type of object being passed based on which it will
    // call the object's method[which might be the child class or the parent class]. This is because at
    // Runtime it checks what is the actual object of the class and thereby it will be able to
    // call the runtime object's method in.

    public static void main(String[] args) {
        // Why parent reference can hold child reference

        Parent parent = new Child();
        parent.show();
        parent.work();

        // IMPORTANT CONCEPT: Super class features cascades to child class however the child class features
        // NEVER cascades to super classes
        // parent.childSpecificMethod();

        // Hence if we try to access the child class method by parent class reference method then it will
        // result in compilation as parent class has no way of knowing which methods exists in child class
        // Why child reference cannot hold parent reference

        // THE OTHER THING:

        // if the child reference is allowed to hold parent object

        // then the following things would happen
        // Child child = new Parent();
        // child.childSpecificMethod();
        // child.show();
        // child.work();

        // COMPILATION PHASE :
        // so in this the compiler would check whether the methods called by child reference allowed or not

        // RUN TIME PHASE:
        // in this the run time object would decide which methods can be called hence
        // Howwever we know that the parent does not have any child specific method
        // thus the system would crash
        // hence in Java parent object cannot be assigned to child

    }

}

class Parent {

    public void show() {
        System.out.println("parent class method: show()");
    }

    public void work() {
        System.out.println("parent class method: work()");
    }

}

class Child extends Parent {

    public void show() {
        System.out.println("Child class method: show()");
    }

    public void work() {
        System.out.println("Child class method: work()");
    }

    public void childSpecificMethod() {

        System.out.println("Child class method: childSpecificMethod()");

    }
}