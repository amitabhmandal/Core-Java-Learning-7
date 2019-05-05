package learning.interfaces;

//In short these are the rules for interfaces:

// Member variables
// Can be only public and are by default.
// By default are static and always static
// By default are final and always final
// An interface can have constants, these constants are public, static and final(Implicitly).

// Methods 
// Can be only public and are by default. 
// Can NOT be static 
// Can Not be Final
// Interface methods are implicitly public & abstract. (Before Java 8)

// interfaces can not extend a class or implement an Interface.
// An interface can extend another Interface.
// An interface is 100% abstract class(Implicitly). After Java 8 it doesn’t hold true.
// Interfaces can be implemented by any class from any inheritance tree.
// All methods in Interfaces are abstract. (In Java 8 either abstract/ static / default)
// An interface can also have private methods. (Java 9)
// A class implementing an interface can also be an abstract class.
// An abstract class which is implementing an interface need not implement all abstract method.
// A class can Implement more than one Interface.

// A non-abstract class which is implementing an Interface needs to follow some rules.
// 1. This class needs to provide the concrete implementation of all abstract method.
// 2. All rules of Overriding needs to be followed.
// 3. It must maintain the exact signature of a method.

// After Java 9 changes, Interfaces look a lot like Abstract Class, still, there are some differences.
// 1. An abstract class can have variables with different modifiers which is not constant
// 2. Methods in Abstract can have the different signature than just private or public

// Only generic classes can implement generic interfaces. 
// Normal classes can’t implement generic interfaces. 
// For example, above generic interface can be implemented as,

interface GenericInterface<T> {
    void setT(T t);

    T getT();
}

abstract class GenericClass<T> implements GenericInterface<T> {
}

// Not like below. It gives compile time error.

/*
class NormalClass implements GenericInterface<T> {
    // Compile time error
}
*/
// A normal class can implement a generic interface if type parameter of generic
// interface is a wrapper class. For example, below implementation of GenericInterface is legal.

interface GenericInterface1<Integer> {
    // Generic interface with Integer as type parameter
}

abstract class NormalClass1 implements GenericInterface1<Integer> {
    // Normal class implementing generic interface
}

// Class implementing generic interface at least must have same number and same type of
// parameters and at most can have any number and any type of parameters.

interface GenericInterface2<T> {
    // Generic interface with one type parameter
}

class GenericClass1<T> implements GenericInterface2<T> {
    // Class with same type parameter
}

class GenericClass2<T, V> implements GenericInterface2<T> {
    // Class with two type parameters
}

/*
class GenericClass3<T1, T2> implements GenericInterface2<T> {
    // Compile time error, class having different type of parameters
}
*/

public class InterfaceLearning {

    public static void main(String[] args) {
        // TODO Auto-generated method stub

    }

}

// You can change the type of parameter passed to generic interface while implementing it.
// When changed, the class which is implementing should have new type as parameter and also,
// you have to change old type with new type while implementing the methods.

interface GenericInterface4<T> {
    void setT(T t);

    T getT();
}

class GenericClass4<V> implements GenericInterface4<V> {
    V t;

    @Override
    public void setT(V t) // Changing the type of parameter
    {
        this.t = t;
    }

    @Override
    public V getT() // Changing the return type
    {
        return t;
    }
}

// Class can implement more than one generic interfaces.
// If implemented, class should have type parameters of both the interfaces.

interface GenericInterface5<T1> {
    // Generic interface with one type parameter
}

interface GenericInterface6<T2, T3> {
    // Generic interface with two type parameters
}

class GenericClass5<T1, T2, T3> implements GenericInterface5<T1>, GenericInterface6<T2, T3> {
    // Class having parameters of both the interfaces
}

interface BaseColors {
    int RED = 1, GREEN = 2, BLUE = 4;
}

interface RainbowColors extends BaseColors {
    int YELLOW = 3, ORANGE = 5, INDIGO = 6, VIOLET = 7;
}

interface PrintColors extends BaseColors {
    int YELLOW = 8, CYAN = 16, MAGENTA = 32;
}

interface LotsOfColors extends RainbowColors, PrintColors {
    int FUCHSIA = 17, VERMILION = 43, CHARTREUSE = RED + 90;
}

interface Test {

    // 1
    public static final int x1 = 3;

    // 2
    public static int x2 = 3;

    // 3
    static int x3 = 3;

    // 4
    int x4 = 3;

    // 5
    public int f5();

    // 6
    int f6();

    // 7
    // public static int f7();

    // 8
    // private void f8();

    // 9
    // public final void f9();

    // 10
    // private static final int x5 = 3;
}
