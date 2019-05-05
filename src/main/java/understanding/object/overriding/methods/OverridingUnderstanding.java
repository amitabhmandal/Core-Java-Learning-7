package understanding.object.overriding.methods;

public class OverridingUnderstanding {

    public static void main(String[] args) {
        // TODO Auto-generated method stub

    }

}

// +++++++++++++++++++++++++++++++++++++++
// Requirements for the overriding method
// ***************************************

// Rule : The overriding method must have same return type (or subtype) which is allowed in Java 1.5 onwards
// which is also known as covariant types
class CovraintTester {
    public static void main(String[] args) {
        CovariantParent covariantParent1 = new CovariantParent();
        covariantParent1.m1();
        CovariantParent covariantParent2 = new CovariantChild();
        covariantParent2.m1();
        CovariantChild covariantChild = new CovariantChild();
        covariantChild.m1();
    }
}

class CovariantParent {
    public Object m1() {
        System.out.println("CovariantParent method called ");
        return null;
    }
}

class CovariantChild extends CovariantParent {
    public String m1() {
        System.out.println("CovariantChild method called ");
        return null;
    }
}

// Rule : The overriding method must have same argument list.

class ArgumentListTester {
    public static void main(String[] args) {
        Animal covariantParent1 = new Animal();
        covariantParent1.eat("Animal");
        Animal covariantParent2 = new Dog();
        covariantParent2.eat("Dog");
        Dog covariantChild = new Dog();
        covariantChild.eat("Dog");
    }
}

class Animal {

    protected void eat(String food) {
        System.out.println("animal eating code ");
        // animal eating code...
    }
}

class Dog extends Animal {

    protected void eat(String food) {
        System.out.println("Dog eating code ");
    }
}

// Rule : If parent class method is not available for inheritance then it is not overrriding even though it
// is available for over-riding
// Only inherited methods can be overridden.

class CheckingOverridingMethodTester {
    public static void main(String[] args) {
        CheckingOverridingMethodsParent checkingOverridingMethodsParent1 = new CheckingOverridingMethodsParent();
        checkingOverridingMethodsParent1.m1();
        // checkingOverridingMethodsParent1.m3();
        CheckingOverridingMethodsParent checkingOverridingMethodsParent2 = new CheckingOverridingMethodsChild();
        checkingOverridingMethodsParent2.m1();
        checkingOverridingMethodsParent2.m2();
        // checkingOverridingMethodsParent2.m3();
        CheckingOverridingMethodsChild checkingOverridingMethodsChild = new CheckingOverridingMethodsChild();
        checkingOverridingMethodsChild.m1();
        checkingOverridingMethodsChild.m3();
    }
}

class CheckingOverridingMethodsParent {

    public void m1() { // public method being overridden
        System.out.println("CheckingOverridingMethodsParent method called m1");
    }

    protected void m2() { // protected method being overridden
        System.out.println("CheckingOverridingMethodsParent method called m2");
    }

    private void m3() { // private method being overridden
        System.out.println("CheckingOverridingMethodsParent method called m3");
    }

}

class CheckingOverridingMethodsChild extends CheckingOverridingMethodsParent {

    // The CheckingOverridingMethodsChild class overrides both the m1() (public) and m2() (protected) methods
    // from the CheckingOverridingMethodsParent class (regardless of packages where the both classes are declared):

    public void m1() {
        super.m1(); // Use the super keyword to invoke the overridden method from a subclass
        System.out.println("checkingOverridingMethodsChild method called m1");
    }

    protected void m2() {
        System.out.println("checkingOverridingMethodsChild method called m2");
    }

    public void m3() { // since parent class m3 method is not visible in the child class hence it is not over-riding
        System.out.println("CheckingOverridingMethodsParent method called m3");
    }
}
// Rule : Use the super keyword to invoke the overridden method from a subclass.
// It’s very common that a subclass extends a superclass’ behavior rather than re-implementing the
// behavior from scratch. In such case, invoke the superclass’ method in the following form:

// +++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
// Rule : The overriding method must not have more restrictive access modifier
// +++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
// This rule can be understood as follows:
// If the overridden method is has default access, then the overriding one must be default, protected or public.
// If the overridden method is protected, then the overriding one must be protected or public.
// If the overridden method is public, then the overriding one must be only public.

// In other words, the overriding method may have less restrictive (more relaxed) access modifier.

class RestrictiveModifierParent {
    protected void m1() {
        System.out.println("RestrictiveModifierParent m1 method called ");
    }

    protected void m2() {
        System.out.println("RestrictiveModifierParent m2 method called ");
    }
}

class RestrictiveModifierChild extends RestrictiveModifierParent {
    public void m1() {
        System.out.println("RestrictiveModifierChild m1 method called ");
    }

    /* m2() now method has been made default which is more restrictive 
     * than the protected access of the superclass’ version. 
    void m2() {
        System.out.println("RestrictiveModifierChild m2 method called " );
    }
    */

}
// Rule : Overriding and synchronized method
// The synchronized modifier has no effect on the rules of overriding
// The synchronized modifier relates to the acquiring and releasing of a monitor object in
// multi-threaded context, therefore it has totally no effect on the rules of overriding.
// That means a synchronized method can override a non-synchronized one and vice versa

// Overriding and strictfp method
// The strictfp modifier has no effect on the rules of overriding.
// That means the presence or absence of the strictfp modifier has absolutely no effect on the
// rules of overriding: it’s possible that a FP-strict method can override a non-FP-strict one and vice-versa.

// Over-riding constructor
// Constructors cannot be overridden.
// Because constructors are not methods and a subclass’ constructor cannot have same name as a
// superclass’ one, so there’s nothing relates between constructors and overriding

// Overriding and abstract method
// Abstract methods must be overridden by the first concrete (non-abstract) subclass.

interface ParentInterface {
    void m1();
}

// If an abstract class implements the above interface, then it doesn’t require the subclass to
// override the m1() method, as shown in the following AbstractDog class:

abstract class AbstractParentInterface implements ParentInterface {
    protected abstract void m2();
}

// But if a concrete (non-abstract) class, says GrandChildAbstractParentInterface,
// is a subclass of the AbstractParentInterface class or the ParentInterface interface, then it must override
// all the inherited abstract methods, as shown below:

class GrandChildAbstractParentInterface extends AbstractParentInterface {
    public void m1() {

        // Bulldog moves...

    }

    protected void m2() {

        // Bulldog barks...

    }
}

// Rule :Final and static methods cannot be overridden.
// A final method means that it cannot be re-implemented by a subclass, thus it cannot be overridden

class FinalMethodTester {
    public static void main(String[] args) {
        FinalParent finalParent = new FinalParent();
        finalParent.m1();

        FinalParent finalParent1 = new ChildFinalParent();
        finalParent1.m1();

    }
}

class FinalParent {
    final void m1() {
        System.out.println("FinalParent m1() method");
    }

    static void m2() {
        System.out.println("FinalParent static m1() method");
    }
}

class ChildFinalParent extends FinalParent {
    
    //A final method means that it cannot be re-implemented by a subclass, thus it cannot be overridden. 
    //Consider the following example
    /*
    void m1() {
        System.out.println("ChildFinalParent m1() method");
    }
    
    */

    // In case of static method, because a static method is available to all instances of the superclass and
    // its subclasses, so it’s not permissible to re-implement the static method in a particular
    // subclass
    
    /*
    public void m2() {
        System.out.println("FinalParent static m1() method");
    }
    
    */
}

//                                Superclass Instance Method      Superclass Static Method
//Subclass Instance Method        Overrides                       Generates a compile-time error
//Subclass Static Method          Generates a compile-time error  Hides