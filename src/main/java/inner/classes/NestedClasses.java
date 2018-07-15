package inner.classes;

/*
 * ***********
 * Definition:
 * ***********
 * 
 * 
 * It is possible to define a class within another class, such classes are known as 
 * nested classes.
 * 
 * *********************************
 * Advantage of Using Nested Classes
 * *********************************
 * Compelling reasons for using nested classes include the following:
 * 
 * Reason #1
 * It is a way of logically grouping classes that are only used in one place: 
 * If a class is useful to only one other class, then it is logical to embed it in that class and keep the two together. 
 * Nesting such "helper classes" makes their package more streamlined.
 * 
 * Reason #2
 * It increases encapsulation: Consider two top-level classes, A and B, where B needs access to members of A that would 
 * otherwise be declared private. By hiding class B within class A, A's members can be declared private and B can access them. 
 * In addition, B itself can be hidden from the outside world.
 * 
 * Reason #3
 * It can lead to more readable and maintainable code: 
 * Nesting small classes within top-level classes places the code closer to where it is used.
 * 
 * It helps in code optimization.
 * It requires less code to write.
 * It has nested classes which are used to develop more readable and maintainable code.
 * It logically group classes and interfaces in one place only.
 * It can access all the members (data members and methods) of outer class including private.
 * 
 * Without existing of Map object there is no chance of existing Entry object hence Entry interface is declared
 * inside the Map interface object.
 * Thus we can have interface inside interface.
 * 
 * THE REALTIONSHIP BETWEEN THE OUTER AND INNER OBJECT IS NOT A IS-A RELATIONSHIP BUT HAS-A RELATIONSHIP.
 * HAS-A RELATION IS ALSO KNOWN AS COMPOSITION OR AGGREGATION which are types of Associations.
 * 
 * 
 * 
 * Nested classes are divided into two categories:
 * 
 * static nested class : Nested classes that are declared static are called.
 *  
 * As with class methods and variables, a static nested class is associated with its outer class.
 * And like static class methods, a static nested class cannot refer directly to instance variables or methods 
 * defined in its enclosing class: it can use them only through an object reference.
 * 
 * A static nested class interacts with the instance members of its outer class (and other classes) 
 * just like any other top-level class.
 * 
 *  In effect, a static nested class is behaviorally a top-level class that has been nested in 
 *  another top-level class for packaging convenience.
 *  
 *  Static nested classes are accessed using the enclosing class name:
 *  OuterClass.StaticNestedClass
 *  
 *  For example, to create an object for the static nested class, use this syntax:
 *  
 *  OuterClass.StaticNestedClass nestedObject =
     new OuterClass.StaticNestedClass();
 * 
 * 
 * +++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
 * inner class : An inner class is a non-static nested class.
 * +++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
 * As with instance methods and variables, an inner class is associated with an instance of its enclosing class and has 
 * direct access to that object's methods and fields.
 * 
 * They can have all types of access modifiers in their declaration
 * 
 * Just like instance variables and methods, inner classes are associated with an instance of the enclosing class
 * 
 * They have access to all members of the enclosing class, regardless of whether they are static or non-static
 * 
 * They can only define non-static members
 * 
 * To instantiate an inner class, we must first instantiate its enclosing class.
 * 
 * 
 * 
 * Also, because an inner class is associated with an instance, it cannot define any static members itself.
 * 
 * Objects that are instances of an inner class exist within an instance of the outer class. Consider the following classes:

    class OuterClass {
        ...
        class InnerClass {
            ...
        }
    }
 * 
 * An instance of InnerClass can exist only within an instance of OuterClass and has direct access to 
 * the methods and fields of its enclosing instance.
 * 
 * To instantiate an inner class, you must first instantiate the outer class. Then, create the inner object within the outer object with this syntax:

 * OuterClass.InnerClass innerObject = outerObject.new InnerClass();
 * 
 * There are two special kinds of inner classes: local classes and anonymous classes.
 * 
 * -------------------------------------------------------------
 * Why we cannot have static members inside nested inner classes.
 * -------------------------------------------------------------
 * Without existing outer class object there is no chance of existing inner class object.
 * Inner class is always related to the instance. Inner class cannot be accessed directly.
 * Hence we cannot declare any static members inside inner class including main method.
 * 
 * 
 * 
 * 
 * 
 * Nested Inner class 
 * *******
 * Rule #1
 * *******
 * The scope of a nested class is bounded by the scope of its enclosing class. 
 * Thus in above example, class NestedClass does not exist independently of class OuterClass.
 * 
 * *******
 * Rule #1
 * ******* 
 * A nested class has access to the members, including private members, 
 * of the class in which it is nested.
 * However, reverse is not true i.e. the enclosing class 
 * does not have access to the members of the nested class.
 * 
 * *******
 * Rule #1
 * *******
 * A nested class is also a member of its enclosing class.
 * As a member of its enclosing class, a nested class can be declared private, 
 * public, protected, or package private(default).
 * 
 * As with class methods and variables, a static nested class is associated with its 
 * outer class. And like static class methods, a static nested class cannot refer 
 * directly to instance variables or methods defined in its enclosing class: 
 * it can use them only through an object reference.
 * 
 * 
 * *******
 * Rule #1
 * *******
 * Difference between static and inner(non-static nested) classes
 * 
 * Static nested classes do not directly have access to other members(non-static variables 
 * and methods) of the enclosing class because as it is static, it must access the 
 * non-static members of its enclosing class through an object. That is, it cannot 
 * refer to non-static members of its enclosing class directly. 
 * Because of this restriction, static nested classes are seldom used.
 * 
 * Non-static nested classes (inner classes) has access to all members(static and 
 * non-static variables and methods, including private) of its outer class and may refer 
 * to them directly in the same 
 * way that other non-static members of the outer class do.
 * 
 * *******
 * Rule #1
 * *******
 * we can’t have static method in a nested inner class because an inner class is 
 * implicitly associated with an object of its outer class so it cannot define any 
 * static method for itself. For example the following program doesn’t compile.
 * 
 * class Outer {
   void outerMethod() {
      System.out.println("inside outerMethod");
   }
   class Inner {
      public static void main(String[] args){
         System.out.println("inside inner class Method");
      }
   }
}
 * compiler error: 
 * Illegal static declaration in inner class Outer.Inner
      public static void main(String[] args){
                         ^
  modifier 'static' is only allowed in constant variable declarations
 * 
 * *******
 * Rule #1
 * *******
 * Within the inner class, the keyword this holds a reference to the current object but 
 * if inner class needs to access the 
 * current outer class object then precede the keyword this with the outerclass name.
 * 
 * Using this in inner class:
 * 
 * class Outer 
	{
	    private int a = 10;
	    class Inner 
	    {
	        private int a = 20;
	        public void myMethod() 
	        {
	            System.out.println(this.a);
	        }
	    }
	} Output : 20
 * 
 * Using this in outerclass:

	class Outer
	{
	    private int a = 10;
	    class Inner 
	    {
	        private int a = 20;
	        public void myMethod()
	        {
	            System.out.println(Outer.this.a);
	        }
	    }
	}
 * Output : 10
 * 
 * ********************************************************
 * Rule #   How to Access Inner Class from different places
 * ********************************************************
 * class Outer{
 *      class Inner{
 *         public void m1(){
 *              System.out.println("Inside Inner Class m1");
 *              }
 *          }
 * }
 * 
 * class OutsideOuter{
 *      public void m1(){
 *              new Outer().new Inner().m1();
 *      }
 * }
 *              
 *       
 * Accessing Inner Class from
 * 1. Static Area of outer class
 *     new Outer().new Inner().m1();
 *     
 * 2. Inside instance method of outer class
 *      new Inner().m1();
 *      
 * 3. From outside of Outer Class
 *      new Outer().new Inner().m1();
 *      
 * 
 * 
 * ********************************************************
 * Rule #  Inner Class can Access Outer Class Members
 * ********************************************************
 * Through Inner class instance we can access 
 * Outer class all members which includes static and non static members without any issues.
 * 
 * 
 * *****************************************
 * Rule #  Allowed modifiers for Inner Class
 * *****************************************
 * Inner Classes modifier allowed are as followed
 * [Outer Class Allowed modifier : public / strictfp / abstract / final and default] 
 * 
 * Hence along with the outer class modifier, inner class can have private / protected and static.
 * 
 * 
 * *****************************************
 * Rule #  Nesting of Inner Class is possible
 * *****************************************
 * 
 * 
 * @@@@@@@@@@@@@@@@@@@@@@@@@@
 * Method Local inner classes
 * @@@@@@@@@@@@@@@@@@@@@@@@@@
 * 
 * *******
 * Rule #1
 * *******
 * Inner class can be declared within a method of an outer class. 
 * In the following example, Inner is an inner class in outerMethod().
 * 
 * 
 * 
 * *******
 * Rule #1
 * *******
 * It is 
 * 
 * *******
 * Rule #1
 * *******
 * 
 * 
 * *******
 * Rule #1
 * *******
 * 
 * *******
 * Rule #1
 * *******
 * 
 * 
 * 
 * *******
 * Rule #1
 * *******
 * 
 * Anonymous Inner Class in Java
 * *******
 * Rule #1
 * *******
 * It is an inner class without a name and for which only a single object is created.
 * 
 * in Java there are only two anonymous functionalities. Anonynous Inner Classes and anonymous arrays
 * 
 * anonymous inner class can be useful when making an instance of an object with 
 * certain “extras” such as overloading methods of a class or interface, 
 * without having to actually subclass a class.
 * 
 * A class that have no name is known as anonymous inner class in java. 
 * It should be used if you have to override method of class or interface.
 * A local inner class without name is known as anonymous inner class.
 * An anonymous class is defined and instantiated in a single statement. 
 * 
 * Anonymous inner class can be of 3 types 
 * 1. always extend a class or 
 * 2. implement an interface or 
 * 3. that is defined inside arguments.
 * 
 * It is not possible to define a constructor for an anonymous class. 
 * Anonymous inner classes are accessible only at the point where it is defined
 * 
 * Defining an anonymous class extending a class
 * Example
 * Student student = new Student()
 * {
 * 
 * }
 * 
 * In this above example the opening and closing of brackets represent an anonymous which extends Student.
 * Hence it extends a child class of student without name.
 * 
 * Most importantly. We are creating a child object with a parent reference.
 * 
 * Second Example: 
 * Runnable runnable = new Runnable(){
 * 
 * 
 * };
 * 
 * Here I am writing a class that implements a runnable interface without name.
 * And for that anonymous class we have the parent interface as the reference.
 * The name of the anonymous inner class is 
 * 
 * ObjectName$1.class ie ObjectName represents the name of the outer class which contains the anonymous inner class.
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 * *********
 * Advantage:
 * *********
 * Anonymous inner classes are useful in writing implementation classes for 
 * listener interfaces in graphics programming.
 * 
 * Anonymous inner class are mainly created in two ways:

 * Class (may be abstract or concrete) Interface
 * 
 * The syntax of an anonymous class expression is like the invocation of a constructor, 
 * except that there is a class definition contained in a block of code.
 * 
 * // Test can be interface,abstract/concrete class
	Test t = new Test() 
	{
	   // data members and methods
	   public void test_method() 
	   {
	      ........
	      ........
	    }   
	};
 * 
 * 
 * Difference between Normal Java Class And Anonymous Inner Class
 * 
 * Point #1
 * Normal Java class can extend only one class at a time
 * 
 * Anonymous Inner class only one class at time.
 * 
 * Point #2
 * Normal Java class can implement any number of Interfaces simultaneously.
 * Anonymous Inner class can implement only one interface at a time.
 * 
 * Point #3
 * Normal Java class can extend a class and implement any number of interface simultanously.
 * But anonymous inner class can extend a class or can implement an interface but not both simultaneously.
 * 
 * Point #4
 * Normal Java class can have constructors and overloaded versions of it.
 * But anonymmous inner class does not have a name hence no constructor possible. Hence in anonymous inner class we can use 
 * parent constructor.
 * 
 * Point #5
 * If the requirement is standard and several times then should use normal top level class.
 * If the requirement is temporary and required only once then use should anonymous inner class.
 * 
 * 
 * 
 * @@@@@@@@@@@@@@@@@@@@@
 * Static Nested classes
 * @@@@@@@@@@@@@@@@@@@@@
 * Sometimes we can declare inner class with static modifier.
 * 
 * For Example 
 * class Test {
 *      int x;
 *      static int y;
 * }
 * Analysis:
 * For int x == Without existing of Test class Object there is no chance of existing instance variable x 
 * 
 * For static int y = Without existing of Test class object there is chance of existing int 'y'. Hence it is class level variable
 * and no where related to instance level.
 * 
 * For example:
 * class Outer {
 *      class Inner {
 *      }
 * }
 * 
 * In this above example there is no chance of existing Inner class object without the existing of Outer class Object.
 * Hence it is strongly coupled to the outer class Object.
 * 
 * For example: 
 * class Outer {
 *      static class Nested {
 *      }
 * }
 * In the above example Nested can exist without the Outer class. Hence static Nested class Object is not strongly associated
 * with the Outer class.
 * 
 * From regular normal inner classes we can access both static and non static members of outer class directly. However from 
 * Static nested classes we can access only static members. If we try access instance members of outer class from static
 * nested classes it will result in compile time error.
 * 
 * =================================================================
 * Difference between Normal Inner Classes and static Nested Classes
 * =================================================================
 * 
 * Difference #1
 * Normal Inner Class: Inner class is strongly associated with the outer class object
 * Static Nested Class: Not strongly associated with the outer class object
 * 
 * Normal Inner Class: Within the normal inner class we cannot declare static members
 * Static Nested Class: Within static class we can declare instance and static members
 * 
 * Normal Inner Class: We can access static and instance members of outer class from inner classs
 * Static Nested Class: We can access only static members of outer class.
 * 
 * Normal Inner Class:
 * Static Nested Class: 
 */

class MyThread 
{
    public static void main(String[] args)
    {
        //Here we are using Anonymous Inner class
        //that define inside argument, here constructor argument
        Thread t = new Thread(new Runnable()
        {
            public void run()
            {
                System.out.println("Child Thread");
            }
        });
         
        t.start();
         
        System.out.println("Main Thread");
    }
}


class Boss{
    
    public void earns() {
        System.out.println("Salary is ");
    }
    
}

public class NestedClasses {

    public static void main(String[] args) {
        OuterClass.StaticNestedClass nestedObject = new OuterClass.StaticNestedClass();

        nestedObject.display();

        OuterClass outerObject = new OuterClass();
        OuterClass.InnerClass innerObject = outerObject.new InnerClass();

        innerObject.display();

        OuterClass x = new OuterClass();
        x.outerMethod();

        // Testing shadow resources.
        ShadowTest shadowTest = new ShadowTest();
        ShadowTest.FirstLevel fl = shadowTest.new FirstLevel();
        fl.methodInFirstLevel(23);

        
        //Example of Anonymous Class extending a class.
        Boss employee = new Boss() {
            public void earns() {
                System.out.println("Manager working");
            }
        };
        //This will print manager working .. 
        employee.earns();
        
        //Name of the inner anonymous inner class.
        
        System.out.println(employee.getClass().getName());
        
        Nested n = new Nested();
        System.out.println("Nested class name: " + n.getClass().getName());
        Nested.staticNestedMethod();
        
        
    }
    
    static class Nested{
        
        public static void staticNestedMethod() {
            System.out.println("Accessing Nested Class method");
            
        }
        
    }

}

class OuterClass {
    // static member
    static int outer_x = 10;

    // instance(non-static) member
    int outer_y = 20;

    // private member
    private static int outer_private = 30;

    // static nested class
    static class StaticNestedClass {
        void display() {
            // can access static member of outer class
            System.out.println("outer_x = " + outer_x);

            // can access display private static member of outer class
            System.out.println("outer_private = " + outer_private);

            // The following statement will give compilation error
            // as static nested class cannot directly access non-static membera
            // System.out.println("outer_y = " + outer_y);
            
            displayDisplay();

        }
        
        void displayDisplay() {
            System.out.println("within displayDisplay method");
        }
    }

    // inner class
    class InnerClass {
        void display() {
            // can access static member of outer class
            System.out.println("outer_x = " + outer_x);

            // can also access non-static member of outer class
            System.out.println("outer_y = " + outer_y);

            // can also access private member of outer class
            System.out.println("outer_private = " + outer_private);

        }
    }

    // Method Local inner classes
    // Inner class can be declared within a method of an outer class.
    // In the following example, Inner is an inner class in outerMethod().

    void outerMethod() {
        System.out.println("inside outerMethod");
        // Inner class is local to outerMethod()
        class Inner {
            void innerMethod() {
                System.out.println("inside innerMethod");
            }
        }
        Inner y = new Inner();
        y.innerMethod();
    }

}

class ShadowTest {

    public int x = 0;
    static int y= 20;

    class FirstLevel {

        public int x = 1;

        void methodInFirstLevel(int x) {
            System.out.println("x = " + x);
            System.out.println("this.x = " + this.x);
            System.out.println("ShadowTest.this.x = " + ShadowTest.this.x);
            System.out.println("ShadowTest.y        " + ShadowTest.y);
        }
    }
}