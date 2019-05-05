package enumlearning;

//BASED LINE: 

// the common sense rule in Java is that objects always get compared with objA.equals(objB) 
// and primitives get compared with primA == primB.

// The reason for this is that .equals() checks content equality while == checks reference equality.

// Because there is only one instance of each enum constant, it is permissible to use the == operator in 
// place of the equals method when comparing two object references if it is known that at least one of 
// them refers to an enum constant. 
// (The equals method in Enum is a final method that merely invokes super.equals on its argument 
// and returns the result, thus performing an identity comparison.)

// The excerpt from the specification shown above implies and then explicitly states that it is 
// safe to use the == operator to compare two enums because there is no way that there can be more 
// than one instance of the same enum constant.

/*
It is a compile-time error to attempt to explicitly instantiate an enum type. 
The final clone method in Enum ensures that enum constants can never be cloned, and the special 
treatment by the serialization mechanism ensures that duplicate instances are never created as a 
result of deserialization. Reflective instantiation of enum types is prohibited. 
Together, these four things ensure that no instances of an enum type 
exist beyond those defined by the enum constants
*/

/*
There are four reasons that I believe using == to compare Java enums is almost always preferable 
to using the "equals" method:

1. The == on enums provides the same expected comparison (content) as equals
2. The == on enums is arguably more readable (less verbose) than equals
3. The == on enums is more null-safe than equals
4. The == on enums provides compile-time (static) checking rather than runtime checking

*/

public class EnumEqualityUnderstanding {

    public static void main(String[] args) {
        Stationary s1 = Stationary.PENCIL;
        Stationary s2 = Stationary.RUBBER;
        System.out.println(s1 == s2);

    }

}

enum Stationary {
    PENCIL, PEN, RUBBER;
}