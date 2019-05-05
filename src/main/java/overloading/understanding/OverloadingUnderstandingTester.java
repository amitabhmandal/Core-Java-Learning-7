package overloading.understanding;

// What is overloading: 

// If two methods of a class (whether both declared in the same class, or both inherited
// by a class, or one declared and one inherited) have the same name but signatures
// that are not override-equivalent, then the method name is said to be overloaded.

// There is no required relationship between the return types or between the throws
// clauses of two methods with the same name, unless their signatures are overrideequivalent.

// RULE #1 : Compiler promotes to the next level and if whether the match method available
// known as automatic type promotion. This will continue till all promotion continues 
// and when no match is found then it will result in compile time error.

// byte------->short------------>int-------------->long--------------->float----------------->double
// char-------->int------------>long------------>float----------------->double.

public class OverloadingUnderstandingTester {

    // public void charDemo(char a) {
    // System.out.println("char called ");
    //
    // }

    // public void charDemo(int a) {
    // System.out.println("int called");
    //
    // }

    public void charDemo(long a) {
        System.out.println("long called");

    }

    public OverloadingUnderstandingTester() {
        System.out.println("default constructor");

    }

    public OverloadingUnderstandingTester(int i) {
        System.out.println("int constructor");

    }

    public static void main(String[] args) {
        OverloadingUnderstandingTester o1 = new OverloadingUnderstandingTester();
        o1.charDemo('a');

    }

}

class AutomaticPromotionDemo {
    public void show(int a) {
        System.out.println("method1");
    }

    public void show(int a, int b) {
        System.out.println("method2");
    }

    static public void show(float a) {
        System.out.println("method3");
    }

    public static void main(String args[]) {
        AutomaticPromotionDemo a = new AutomaticPromotionDemo();

        a.show(88);
        a.show(9, 7);
        a.show(3.6f);
        a.show('a');// calling show(int a)---->automatic promotion from char to int
    }
}

// RULE #2 : if both methods match then child argument will get high priority
class NullTester {

    public void m1(String Str) {
        System.out.println("string version called");

    }

    public void m1(Object Str) {
        System.out.println("Object version called");

    }

    public static void main(String args[]) {
        NullTester a = new NullTester();
        a.m1(new Object());
        a.m1(new String("abc"));
        a.m1(null); // RULE #2 : if both methods match then child argument will get high priority

    }

}

// RULE #3 : if both methods match and at the same level them will compile time error
class SamelevelTester {

    public void m1(String Str) {
        System.out.println("string version called");

    }

    public void m1(StringBuffer Str) {
        System.out.println(" StringBuffer version called");

    }

    public static void main(String args[]) {
        SamelevelTester a = new SamelevelTester();
        a.m1(new StringBuffer("abc"));
        a.m1(new String("abc"));

        // a.m1(null); //RULE #3 : if both methods match and at the same level them will compile time error

    }

}

// RULE #4 : if both methods match and at the same level them will compile time error
class FloatIntTester {

    public void m1(int i, float f) {
        System.out.println("int float version called");

    }

    public void m1(float f, int i) {
        System.out.println(" float int  version called");

    }

    public static void main(String args[]) {
        FloatIntTester a = new FloatIntTester();
        a.m1(10, 10.5f);
        a.m1(10.5f, 10);
       // a.m1(10, 10);   //RULE #4 : if both methods match and at the same level them will compile time error
        //a.m1(10f, 10f); //RULE #4 : no match found

    }

}

//RULE #5 : when old version compared with new version the old version is going to get the chance
class VarArgTester {

    public void m1(int x) { 
        System.out.println("int  version called");

    }

    public void m1(int ...x) { 
        // var arg method will always get least priority if no other method match is found
        
        System.out.println("var arg  version called");

    }

    public static void main(String args[]) {
        VarArgTester a = new VarArgTester();
        a.m1(); //new version
        a.m1(1); //old version
        a.m1(1, 1); // new version

    }

}


//RULE #6: Parent child . In overloading method resolution is always based on reference type
//         Hence always reference type decides which methods will be called and not on the object type

class Parent{
    
}

class Child extends Parent{
    
}

class ParentChildTester{
    
    public void m1(Parent p) { 
        System.out.println("Parent  version called");

    }
    
    public void m1(Child p) { 
        System.out.println("Child  version called");

    }
    
    public static void main(String[] args) {
        ParentChildTester parentChildTester = new ParentChildTester();
        Parent p = new Parent();
        Child c = new Child();
        Parent p1 = new Child();
        parentChildTester.m1(p);
        parentChildTester.m1(c);
        parentChildTester.m1(p1); // Rule 6 - Reference type decides which method shall be called and not the object
        // type will be able to decide anything.
        
        
        
    }
}