package inner.classes;

// Local Inner Classes are the inner classes that are defined inside a block.

// Generally, this block is a method body.

// Sometimes this block can be a for loop, or an if clause.

// Local Inner classes are not a member of any enclosing classes

// They belong to the block they are defined within, due of which 
// local inner classes cannot have any access modifiers associated with them
// However, they can be marked as final or abstract

// Local inner class must be instantiated in the block they are defined in.

// ** Rules of Local Inner Class:
// 1. The scope of local inner class is restricted to the block they are defined in.
// 2. Local inner class cannot be instantiated from outside the block where it is created in
// 3. Till JDK 7,Local inner class can access only final local variable of the enclosing block. 
//    However From JDK 8, it is possible to access the non-final local variable of enclosing block in 
//    local inner class.
// 4. A local class has access to the members of its enclosing class.
// 5. Local inner classes can extend an abstract class or can also implement an interface.

// Declaring a Local Inner class: A local inner class can be declared within a block. 
// This block can be either a method body, initialization block, for loop or even an if statement.

// Accessing Members: A local inner class has access to fields of the class enclosing it as 
// well as the fields of the block that it is defined within. These classes, however, can access 
// the variables or parameters of the block that encloses it only if they are declared as final or 
// are effectively final. A variable whose value is not changed once initialized is called as effectively 
// final variable. A local inner class defined inside a method body, have access to it’s parameters.

public class LocalClasses {

    public static void main(String[] args) {
        // TODO Auto-generated method stub

    }

}

// Declaration inside an if statement
class OuterIfInner {
    public int data = 10;

    public int getData() {
        return data;
    }

    public static void main(String[] args) {
        final OuterIfInner outer = new OuterIfInner();

        if (outer.getData() < 20) {
            // Local inner class inside if clause
            class Inner {
                public int getValue() {
                    System.out.println("Inside Inner class");
                    return outer.data;
                }
            }

            Inner inner = new Inner();
            System.out.println(inner.getValue());
        } else {
            System.out.println("Inside Outer class");
        }
    }
}

// Java code to demonstrate that inner
// classes cannot be declared as static
class OuterNonStatic {
    private int getValue(final int data) {
//        static class OuterNonStaticInner {
//            private int getData() {
//                System.out.println("Inside inner class");
//                if (data < 10) {
//                    return 5;
//                } else {
//                    return 15;
//                }
//            }
//        }

//        OuterNonStaticInner inner = new OuterNonStaticInner();
//        return inner.getData();
        return 0;
    }

    public static void main(String[] args) {
        OuterNonStatic outer = new OuterNonStatic();
        System.out.println(outer.getValue(10));
    }
}

class OuterLocal {
    private void myMethod() {
        class OuterLocalInner {
            private void innerMethod() {
                System.out.println("Inside inner class");
            }
        }
    }

    public static void main(String[] args) {
        OuterLocal outer = new OuterLocal();
        // The above program causes compilation error because the scope of inner classes are restricted to the
        // block they are defined in.
        // OuterLocalInner inner = new OuterLocalInner();
        // System.out.println(inner.innerMethod());
    }
}
