package generic;

import java.util.ArrayList;

/*
 * @@@@@@@@@@@@@@@@@@@
 * PURPOSE OF GENERICS 
 * @@@@@@@@@@@@@@@@@@@
 * To provide Type Safety to collections 
 * and resolve Type casting problems
 * 
 * +++++++
 * CASE 1:
 * @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@
 * What is the type Safety problem it solves
 * @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@
 * Whenever we need a particular type of Object then it is better to go for Array concept
 * as it is type safe.
 * 
 * Example:
 * String[] s = new String[1000];
 * s[0] = "Durga";
 * s[1] = new Integer (10) ; // not allowed. Incompatible types compilation error
 * 
 * +++++++
 * CASE 2:
 * @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@
 * What is the type Casting problem it solves
 * @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@
 * We have to forcefully provide typecasting needs to be provided because there is no
 * gaurantee to the type of elements present inside collections.
 * 
 * In comparison arrays provides this type safety hence there is no need of type casting that 
 * needs to be done.
 * 
 * 
 * ======================
 * Properties of Generics
 * ======================
 * Generics concept introduced in Java 1.5
 * 
 * 
 * =====================================================
 * Difference Between ArrayList a = new ArrayList();
 * ArrayList<String> a = new ArrayList<String>();
 * =====================================================
 * ArrayList a = new ArrayList()  | ArrayList<String> a = new ArrayList<String>();
 *                                | 
 * Non Generic Version            | generic version
 * Not type safe                  | Type safe
 * Type casting required          | No type casting required
 * 
 * =========================================================
 * Base Type : ArrayList<String> a = new ArrayList<String>();
 * Here ArrayList is called the Base type
 * String is called the Parameter type
 * ==========================================================
 * 
 * IMPORTANT RULE>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>
 * Polymorphism is only applicable for the base type and not
 * for the paramter type.
 * Hence 
 * ArrayList<String> a = new ArrayList<String>(); // Valid
 * List<String> a = new ArrayList<String>();      // Valid
 * Collection<String> a = new ArrayList<String>();// Valid
 * ArrayList<Object> a = new ArrayList<String>(); // Invalid
 * 
 * The above line is invalid as the parameter type has been changed from 
 * String to Object which is not allowed.
 * Hence it will be a compiler error.
 * >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>> 
 * 
 * IMPORTANT RULE>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>
 * In collection we can take any reference type : class or interface
 * but never an primitve type
 * Hence ArrayList<int> a = new ArrayList<int>() not allowed
 * @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@
 * 
 * GENERICS DEFINITION:
 * In generics we are associating a type parameter to the class.
 * Such type of parameterized classes is called generics classes or template classes.
 * ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^
 * GENERICS APPLICABLE FOR ANY KIND OF CLASS OR INTERFACE
 * 
 * We can apply generics concept in any kind of class or interfaces
 * hence it is not necessary that we can only use it for collection
 * 
 * Example 
 * class Account<T> {
 * 
 * }
 * 
 * Account<Gold> account = new Account<Gold>();
 * Account<Silver> account = new Account<Silver>(); 
 * 
 * //////////////////////////////////////
 * WHY BOUNDED TUPE PARAMETERS ARE NEEDED
 * //////////////////////////////////////
 * 
 *  We can create generic type by passing any type of reference(class or interface)
 *  
 *  However the operations we need to perform on the type is governed by the 
 *  type parameter being passed into it.
 *  
 *  For example addition of two numbers is possible which means 
 *  operation here is : Addition 
 *  Type is : Number
 *  
 *  However we cannot add two student. it does not make sense.
 *  Hence operation : Add
 *  Type is : Student.
 *  
 *  Thus Generics can only work in the range which is governed by type which 
 *  can resolve to operations.
 *  
 *  Thus we need to bound the types.
 * &&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&
 * Rules for Bound Type:
 * 
 * class Test<T>
 * 
 * Allowed Bounded Type Syntax
 * class Test<T extends Number>         // Number or child classes
 * class Test<T implements Runnable>    // Invalid : implements not allowed.
 *                                      But extends can be used for interfaces
 * class Test<T super String>           // Invalid : super not a valid keyword for bounded type
 * 
 * Hence syntax for Bounded Type
 * class Test <T extends X> Hence X can be class or interface.
 * If X is class type then we can pass X or it's child class
 * If X is interface then we can pass X reference or it's implementation classes.
 * 
 * 
 * Example 1: 
 * class Test<T extends Number> {
 * }
 * 
 * Hence 
 * Test<Integer> t = new Test<Integer>();               //Valid declaration
 * Test<String> t = new Test<String>(); //Invalid: String not a valid child of Integer
 *
 * Example 2: 
 * class Test<T extends Runnable> {
 * } 
 * 
 * Test<Thread> t       = new Test<Thread>();           // Valid
 * Test<Runnable> t     = new Test<Runnable>();         // Valid
 * Test<Integer> t      = new Test<Integer>();          // Invalid
 * 
 * We can define bounded types as well by
 * ++++++++++++++++
 * MOST IMPORTANTLY >> Bounded Types in combination also
 * ++++++++++++++++
 * class Test<T extends Number & Runnable>{
 * 
 * }
 * 
 * It means that the bounded type should be a child class of Number and should implement
 * Runnable interface
 * 
 * ++++++++++++++++
 * MOST IMPORTANTLY >> More than one Interface can be extended
 * ++++++++++++++++
 * class Test<T extends Runnable & Comparable> {
 * }
 * 
 * ++++++++++++++++
 * MOST IMPORTANTLY >> One class and More than one Interface can be extended
 * ++++++++++++++++
 * class Test<T extends Number & Runnable & Comparable> {
 * }
 * 
 * ++++++++++++++++
 * MOST IMPORTANTLY >> One class and One interface. Class should always come first else
 *                     COMPILE TIME ERROR
 * ++++++++++++++++
 * class Test<T extends Runnable & Number> { // INVALID : COMPILER ERROR. CLASS SHOULD COME 
 *                                                        FIRST
 * } 
 * 
 * ++++++++++++++++
 * MOST IMPORTANTLY >> MULTIPLE CLASSES NOT ALLOWED: ELSE IT WILL LEAD TO COMPILE TIME ERROR
 *                     COMPILE TIME ERROR
 * ++++++++++++++++ 
 * class Test<T extends Thread & Number> { // INVALID : COMPILER ERROR. MULTIPLE CLASSES NOT
 *                                                      ALLOWED
 * } 
 * 
 * 
 * ++++++++++++++++++++++++++++++++++++
 * TYPE PARAMETER NAMING RULES
 * ++++++++++++++++++++++++++++++++++++
 * T means - Type Parameter  // Convention but not mandatory
 * 
 * class Test<A, B> Two type parameters are allowed // Hence any number of parameters allowed
 * 
 * class HashMap<K , V> . It means K - Should be Key and V should be Value.
 * 
 * All these type parameters should be seperated with comma
 * 
 * ++++++++++++++++++++++++++++++++++
 * GENERIC METHOD WILD CARD PARAMETER: We can use super contrary to Class Type Parameters.
 * ++++++++++++++++++++++++++++++++++
 * If we declare 
 * public static void m1(ArrayList<?> l){
 * }
 * 
 * Then the above signature can be used to handle any type of method call
 * such as 
 * m1(ArrayList<Integer>)
 * m1(ArrayList<Double>)
 * m1(ArrayList<String>)
 * m1(ArrayList<Student>)
 * 
 * any type can be send in.
 * 
 * Possible signatures in Wild Card Method in generics
 * =========
 * Option 1:
 * =========
 * public static void m1(ArrayList<String> al) 
 * 
 * HOW TO CALL: By passing any String ArrayList
 * WHAT ACTION CAN BE PERFORMED INSIDE THE METHOD:
 * We can add Strings
 * We can add null.
 * If we are adding any other type then we can get compile time error
 * 
 * al.add("Amitabh"); // Valid
 * al.add(10);        // Invalid
 * al.add(null);      // Valid
 * 
 * =========
 * Option 1:
 * =========
 * public static void m1(ArrayList<?> al) 
 * 
 * HOW TO CALL: By passing any type ie String, Integer, Student etc
 * WHAT ACTION CAN BE PERFORMED INSIDE THE METHOD:
 * 
 * Since we dont know what is being passed in. Hence within the method we 
 * are not sure what things should be allowed. 
 * Thus we cannot ADD anything inside the method as allowing to add value 
 * from within the method will not allow the method to be type.
 * Hence from within the method we can add only NULL and nothing else.
 * 
 * al.add("Amitabh"); // Invalid
 * al.add(10);        // Invalid
 * al.add(null);      // Valid. null is valid value for any type hence allowed.
 * 
 * Advantage: Suitable for Read only operation. No write should be performed.
 * 
 * 
 * =========
 * Option 2:
 * =========
 * public static void m1(ArrayList<? extends X> al) where X can be class or interface.
 * If X is class then it should be X or it's child classes
 * if X is interface then it should be X or it's implementation classes.
 * 
 * HOW TO CALL: X can be child classes or implementation classes
 * WHAT ACTION CAN BE PERFORMED INSIDE THE METHOD:  
 * within this method we can add only Null and nothing else because we dont know 
 * the type of X exactly. 
 * 
 * Hence best suited for Read only operations.
 *   
 * =========
 * Option 3:
 * =========
 * public static void m1(ArrayList<? super X> al) where X can be class or Interface.
 * NOTE >> Here super can be used at method level but not at class level.
 * 
 * HOW TO CALL: X can be class or interface{}.
 * If X is a class then we can call by passing X or it's super classes 
 * If X is an interface then we can call by passing X or it's super class of implementation 
 * class of X.
 * 
 * Hence Runnable is X, then parameters that can be passed in is
 * Runnable 
 * Super class of implementation class of X ie Thread super classes which is Object.
 *  
 * WHAT ACTION CAN BE PERFORMED INSIDE THE METHOD:
 * Within the method we can add 
 * al.add(X) //valid
 * al.add(null) // valid
 * nothing else can be added within the method.
 * 
 * Invalid Declarations
 * ArrayList<?> al = new ArrayList<? extends Number>(); // Invalid
 * ArrayList<?> al = new ArrayList<?>();                // Invalid
 * 
 * ? cannot appear on the right hand side in the declaration
 * 
 * +++++++++++++++
 * GENERIC METHOD: just before the return type ex:  public <T>void m1(T obj)
 * +++++++++++++++
 * 
 * Requirement: We don't want generic classes but generic method.
 * Hence generics does not need to be declared at class level but at method level.
 * 
 * At method level we have to declare the type parameter before the return type.
 * 
 * public <T>void m1(T obj){
 * }
 * 
 * +++++++++++++++^^^^^^^^^^^
 * GENERIC METHOD: PROPERTIES
 * +++++++++++++++^^^^^^^^^^^
 * we can provide bounded types.
 * All the bounded rules for Class Parameter bound type is applicable.
 * 
 * 
 * 
 * 
 * +++++++++++++++^^^^^^^^^^^&&&&&&&&&&&&
 * COMMUNICATION WITH NON GENERIC METHODS 
 * +++++++++++++++^^^^^^^^^^^&&&&&&&&&&&&
 * 
 * +++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
 * Why can’t we write code as List<Number> numbers = new ArrayList<Integer>();?
 * +++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
 * List<Long> listLong = new ArrayList<Long>();
 * listLong.add(Long.valueOf(10));
 * List<Number> listNumbers = listLong; // compiler error
 * listNumbers.add(Double.valueOf(1.23));
 * 
 * As you can see from above code that IF generics would have been supporting 
 * sub-typing, we could have easily add a Double to the list of Long that would 
 * have caused ClassCastException at runtime while traversing the list of Long.
 * 
 * +++++++++++++++++++++++++++++++++++++++++++++++++++
 * Why can’t we create generic array? or write code as 
 * List<Integer>[] array = new ArrayList<Integer>[10];
 * +++++++++++++++++++++++++++++++++++++++++++++++++++
 * We are not allowed to create generic arrays because array carry type information of 
 * it’s elements at runtime. This information is used at runtime to throw 
 * ArrayStoreException if elements type doesn’t match to the defined type. 
 * Since generics type information gets erased at compile time by Type Erasure, 
 * the array store check would have been passed where it should have failed. 
 * Let’s understand this with a simple example code.
 * 
 * List<Integer>[] intList = new List<Integer>[5]; // compile error
 * Object[] objArray = intList;
 * 
 * List<Double> doubleList = new ArrayList<Double>();
 * doubleList.add(Double.valueOf(1.23));
 * objArray[0] = doubleList; // this should fail but it would pass because at 
 * runtime intList and doubleList both are just List
 * 
 * Arrays are covariant by nature i.e S[] is a subtype of T[] whenever S is a 
 * subtype of T but generics doesn’t support covariance or sub-typing as we saw 
 * in last question. So if we would have been allowed to create generic arrays, 
 * because of type erasure we would not get array store exception even though 
 * both types are not related.
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 */
public class GenericsDemo {

    public static void main(String[] args) {
        checkingParentArrayReferenceContainingChild();
        typeSafetyProblemExample();
        typeCastingProblemExample();

        creatingGenericClass();

        ArrayList l = new ArrayList<String>();
        l.add(10);
        l.add("Amitabh");
        System.out.println(l);
    }

    public static void creatingGenericClass() {
        Account<String> account = new Account<String>("Amitabh");
        account.show();
        System.out.println(account.getObject());

        Account<Double> doub = new Account<Double>(10.5);
        doub.show();
        System.out.println(doub.getObject());

    }

    public static void typeSafetyAndTypeCastingProblemSolvedWithGenerics() {
        ArrayList<Parent> withGenerics = new ArrayList<Parent>();
        withGenerics.add(new Parent()); // allowed

        // When we have specified the type of ArrayList needs to be Parent then it
        // will not allow Integer to be added into the list
        // thus providing type safety

        // withGenerics.add(new Integer(10)); // Not allowed

        // No need to provide type casting as by providing type safety we have ensured
        // the type of object it can hold and hence compiler will not have any complains
        System.out.println(withGenerics.get(0));

    }

    public static void typeCastingProblemExample() {
        ArrayList withoutGenericsArrayList = new ArrayList();
        withoutGenericsArrayList.add(1);
        withoutGenericsArrayList.add("Amitabh");
        withoutGenericsArrayList.add(new Parent());
        // The first element can be of any type hence i have to explictly provide
        // type casting so that the compiler problems can be resolved.
        // Thus Type casting becomes mandatory
        // THis is a huge headache to developer.
        String name1 = (String) withoutGenericsArrayList.get(1);

    }

    public static void typeSafetyProblemExample() {

        // In the ArrayList without generics we can add anything into the reference
        // type.

        // This is a huge problem as while retreiving objects from the arrayList
        // then we are not sure which type of objects are present in the list

        // Hence this will lead to run time exception which is ClassCastException.
        // Hence collections are not type safe.
        // Hence we cannot give gaurantee for the type of elements present inside collection

        // Exception in thread "main" java.lang.ClassCastException: java.lang.Integer cannot be cast to java.lang.String
        // at generic.GenericsDemo.checkingNativeCollectionObject(GenericsDemo.java:59)
        // at generic.GenericsDemo.main(GenericsDemo.java:37)
        ArrayList withoutGenericsArrayList = new ArrayList();
        withoutGenericsArrayList.add(1);
        withoutGenericsArrayList.add("Amitabh");
        withoutGenericsArrayList.add(new Parent());

        System.out.println(withoutGenericsArrayList.get(0));
        System.out.println(withoutGenericsArrayList.get(1));
        System.out.println(withoutGenericsArrayList.get(2));

        // This will lead to type safety problem as we are not sure which type of
        // object we are fetching
        // String s1 = (String)withoutGenericsArrayList.get(0);
        // String s2 = (String)withoutGenericsArrayList.get(1);
        // String s3 = (String)withoutGenericsArrayList.get(2);

    }

    public static void checkingParentArrayReferenceContainingChild() {
        Parent[] parent = new Parent[10];
        parent[0] = new Parent();
        parent[1] = new Child();

        for (Parent p : parent) {
            System.out.println(p);
        }
    }
}

class Parent {

}

class Child extends Parent {

}

class Account<T> {
    T firstAccount;

    public Account(T obj) {
        this.firstAccount = obj;

    }

    public void show() {

        // Hence if T = String then class name = java.lang.String
        // Hence if T = Integer then class name = java.lang.Integer

        System.out.println("The type of Class name : " + firstAccount.getClass()
            .getName());
    }

    public T getObject() {
        return this.firstAccount;
    }
}

class BoundTypeParameterGeneric<T extends Number> {
    T first, second;

    public BoundTypeParameterGeneric(T a, T b) {
        this.first = a;
        this.second = b;
    }

    public T operationsAdd(T a, T b) {
        // If the type parameter <T> is not bound then addition operation is meaningless
        // as it is only applicable for Number types
        T value = null; // a + b;
        return value;
    }

    public T operationsSub(T a, T b) {
        // If the type parameter <T> is not bound then substraction operation is meaningless
        // as it is only applicable for Number types
        T value = null; //a - b;
        return value;
    }

    public T operationsMul(T a, T b) {
        // If the type parameter <T> is not bound then multiplication operation is meaningless
        // as it is only applicable for Number types

        T value = null; //a * b;
        return value;
    }

    public T operationsDiv(T a, T b) {
        // If the type parameter <T> is not bound then division operation is meaningless
        // as it is only applicable for Number types
        T value = null;// a / b;
        return value;
    }
}

class Bound<T extends A> {

    private T objRef;

    public Bound(T obj) {
        this.objRef = obj;
    }

    public void doRunTest() {
        this.objRef.displayClass();
    }
}

class A {
    public void displayClass() {
        System.out.println("Inside super class A");
    }
}

class B extends A {
    public void displayClass() {
        System.out.println("Inside sub class B");
    }
}

class C extends A {
    public void displayClass() {
        System.out.println("Inside sub class C");
    }
}

class BoundedClass {
    public static void main(String a[]) {

        // Creating object of sub class C and
        // passing it to Bound as a type parameter.
        Bound<C> bec = new Bound<C>(new C());
        bec.doRunTest();

        // Creating object of sub class B and
        // passing it to Bound as a type parameter.
        Bound<B> beb = new Bound<B>(new B());
        beb.doRunTest();

        // similarly passing super class A
        Bound<A> bea = new Bound<A>(new A());
        bea.doRunTest();

    }
}