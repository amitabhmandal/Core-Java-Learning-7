package enumlearning;

// WHY WAS ENUM CREATED *** 

// Enums in Java 5+ are basically classes that have a predefined set of instances. 
// They are intended as a replacement for, say, a collection of integer constants. 
// They are preferably to constants as they can enforce type safety.

// So instead of:

/*
public class Suit {
    public final static int SPADES = 1;
    public final static int CLUBS = 2
    public final static int HEARTS = 3;
    public final static int DIAMONDS = 4;
  }
  
*/

// you have

/*
public enum Suit {
    SPADES, CLUBS, HEARTS, DIAMONDS
  }
  
*/

/*
public class MyEnum {

    // Object instantiated at declaration
    public static final MyEnum ONE = new MyEnum();
    public static final MyEnum TWO = new MyEnum();
    public static final MyEnum THREE = new MyEnum();

    // Notice a private constructor 
    // There is no way outside MyEnum class call it
    private MyEnum() { ... }


}
So a MyEnum as a enum would be

public enum MyEnum {
    ONE,
    TWO,
    THREE;
}
Both are similar

*/

/*
 * ++++++++++++++++
The advantages are:
+++++++++++++++++++

Type safety. You can declare a function argument, return type, class member or local variable to be a 
particular Enum type and the compiler will enforce type safety;


Enums are basically classes. They can implement interfaces, have behaviour and so on.

Enums remove “magic numbers,” numbers that don’t really mean anything on their own. 
By replacing those numbers with actual values, your code makes more sense and follows better coding principles.

Also, enums prevent incorrect values from being passed to a function. 
Consider that you have a method that takes an int value. This method will execute if we pass any int value. 
But if you want to restrict the values the method takes as inputs, you should ideally use enums. 
This is what is called type safety. Enums let you control the required set of inputs


Enums can implement interfaces. They implicitly implement the Serializable and Comparable interfaces. 
This means if you need some common functionality along diverse enum types, you can define 
it with an interface to have the enums provide the method implementations.

*/

// POINT #1  An enum can define a main method. This means that you can define an enum
// as an executable Java application.

// POINT #2 The enum constant list must be defined as the first item in an enum, before the
// declaration or definition of methods and variables.

// POINT #3 The enum constant list might not be followed by a semicolon, if the enum
// doesn’t define any methods or variables.

// POINT #4 When an enum constant overrides an enum method, the enum constant creates
// an anonymous class, which extends the enum.

// POINT #5 An enum constant can define a constant specific class body and use it to override
// existing methods or define new variables and methods.

// POINT #6 An enum implicitly extends java.lang.Enum, so it can’t extend any other class.
// But a class can’t explicitly extend java.lang.Enum. An enum can implement
// interface(s).

// POINT #7 An enum can never be instantiated using the keyword new.

// POINT #8 You can define multiple constructors in your enums.

// POINT #9 An enum can’t define a constructor with public or protected access level.

// POINT #10 An enum can define an abstract method. Just ensure to override it for all your
// enum constants.

// POINT #11 The enum method values() returns a list of all the enum constants.

// POINT #12 An enum can be defined as a top-level enum, or as a member or another class
// or interface. It can’t be defined local to a method.

// POINT #13  You can use the “==” operator to compare enum constants effectively, since enum constants are final.

// POINT #14 Enums can implement interfaces. They implicitly implement the Serializable and Comparable interfaces. 
// This means if you need some common functionality along diverse enum types, you can define it with an interface 
// to have the enums provide the method implementations.

// POINT #15 Instance of Enum in Java is created when any Enum constants are first called or referenced in code.

// POINT #16 An enum can be declared outside or inside a class, but NOT in a method.

// POINT #17 An enum declared outside a class must NOT be marked static, final , abstract, protected , or private

// POINT #18 enum constants can send arguments to the enum constructor, using the syntax BIG(8), 
// where the int literal 8 is passed to the enum constructor.

// POINT #19 enum constructors can have arguments, and can be overloaded.

// POINT #20 enum constructors can NEVER be invoked directly in code. 
// They are always called automatically when an enum is initialized.

// POINT #21 each enum is an instance of enum type itself. 
// JVM internally adds ordinal and value methods to this class which we can call while working with enum.

/*
final class Direction extends Enum<Direction>
{
    public final static Direction EAST = new Direction();
    public final static Direction WEST = new Direction();
    public final static Direction NORTH = new Direction();
    public final static Direction SOUTH = new Direction();
}

*/

// POINT #21 The ordinal() method returns the order of an enum instance. It represents the sequence in the 
// enum declaration, where the initial constant is assigned an ordinal of '0'. 
// It is very much like array indexes.

// POINT #22 The enum values() method returns all the enum values in an enum array
/*
enum values()
Direction[] directions = Direction.values();
 
for (Direction d : directions) {
    System.out.println(d);
}
*/

// POINT #22 The enum valueOf() method helps to convert string to enum instance.
/*
enum valueOf()
Direction east = Direction.valueOf("EAST");
         
System.out.println(east);
*/

// POINT #23 
// By default, enums don’t require constructor definitions and their default values are always 
// the string used in the declaration. Though, you can give define your own constructors to initialize 
// the state of enum types.

// POINT #24 Also, all enum types in Java are singleton by default.

// POINT #25 As noted all enums extends java.lang.Enum, so enum cannot extend any other class 
// because Java does not support multiple inheritance this way. But enums can implement any number of interfaces.

// POINT #26 if an enum is a member of a class, it’s implicitly static

// POINT #27 for enum constants, equals() and "==" evaluates to same result, and can be used interchangeably

// POINT #28 you can use enum in switch statement like int or char primitive data type

// POINT #29 enums can be imported by using 
// import static Direction.EAST 
// OR 
// import static Direction.*

// POINT #30 If enums are declared as top level then the applicable modifiers are 
// for a normal top level class the following modifiers are allowed
// public
// default
// final 
// abstract 
// strictfp

// for an inner class the following modifiers are allowed 
// private
// protected
// static

// Hence for top level enum the following modifiers are allowed
// public 
// default 
// strictfp
// as enums are final implicitly hence abstract cannot be used with final, hence abstract not allowed

// Hence for an enum defined within a class or interface etc 
// the following modifiers are applicable 
// private + protected + static in additional to the modifiers which are allowed as top level 
// enum which includes public , default and strictfp

public enum EnumTester {
    VANILLA("white"), STRAWBERRY("pink"), WALNUT("brown"), CHOCOLATE("dark brown");

    private enum Day {
        SUNDAY, MONDAY, TUESDAY, WEDNESDAY, THURSDAY, FRIDAY, SATURDAY;

        // To lookup an enum by string ignoring the case, you can add a static method to the enum class and use it as shown.
        static public Day forNameIgnoreCase(String value) {
            for (Day day : Day.values()) {
                if (day.name()
                    .equalsIgnoreCase(value))
                    return day;
            }
            return null;
        }
    };

    String color;

    EnumTester(String color) {
        this.color = color;
    }

    public static void main(String[] args) {
        System.out.println(VANILLA); // line1
        System.out.println(CHOCOLATE); // line2

        Direction north = Direction.NORTH;
        System.out.println(north);
        System.out.println(north.getAngle());
        System.out.println(north.ordinal());
        System.out.println(north.getDirection());
        System.out.println(north.printDirection());

        int num1 = 10;
        int num2 = 2;
        Operator operator = Operator.DIVIDE;
        int result = operator.execute(num1, num2);
        System.out.println("result: " + result);

        // Use valueOf() to look up an enum by the name.

        // The method throws an IllegalArgumentException if the name (with the exact case) is not found.
        Day day = Day.valueOf(Day.class, "MONDAY");
        Day day1 = Day.forNameIgnoreCase("Monday");

        System.out.println(day1);
        System.out.println(day);
    }
}

enum Direction {

    // enum fields
    EAST(0) {
        @Override
        public String printDirection() {
            String message = "You are moving in east. You will face sun in morning time.";
            return message;
        }
    },
    WEST(180) {
        @Override
        public String printDirection() {
            String message = "You are moving in west. You will face sun in evening time.";
            return message;
        }
    },
    NORTH(90) {
        @Override
        public String printDirection() {
            String message = "You are moving in north. You will face head in daytime.";
            return message;
        }
    },
    SOUTH(270) {
        @Override
        public String printDirection() {
            String message = "You are moving in south. Sea ahead.";
            return message;
        }
    };
    public abstract String printDirection();

    // constructor
    private Direction(final int angle) {
        this.angle = angle;
    }

    // internal state
    private int angle;

    public int getAngle() {
        return angle;
    }

    // Adding a concrete method in enum is similar to add same method in any other class.
    // You can use any access specifier e.g. public, private or protected.
    // You can return values from enum methods or simply use them to perform internal logic.
    // enum - non-abstract method

    // You can enforce a contract for all enums to be created in this way. It can serve as template for enum creation.

    protected String getDirection() {
        String message = "You are moving in " + this + " direction";
        System.out.println(message);
        return message;
    }

}

// Enum decompiled process

/*
public final enum  class EnumTester extends Enum {

    public static final enum EnumTester VANILLA;
    public static final enum EnumTester STRAWBERRY;
    public static final enum EnumTester WALNUT;
    public static final enum EnumTester CHOCOLATE;
    String color;
    private static final EnumTester[] ENUM$VALUES;

    static 
    private EnumTester (String, int, String)
    public static void main(String[])
    public static EnumTester[] values()
    public static EnumTester valueOf(String)

}
*/

enum Operator {
    ADD {
        @Override
        int execute(final int num1, final int num2) {
            return num1 + num2;
        }
    },
    SUBTRACT {
        @Override
        int execute(final int num1, final int num2) {
            return num1 - num2;
        }
    },
    MULTIPLY {
        @Override
        int execute(final int num1, final int num2) {
            return num1 * num2;
        }
    },
    DIVIDE {
        @Override
        int execute(final int num1, final int num2) {
            if (num2 != 0) {
                return num1 / num2;
            } else {
                System.out.println("Can't divide by zero.");
            }
            return 0;
        }
    };
    abstract int execute(int num1, int num2);
}