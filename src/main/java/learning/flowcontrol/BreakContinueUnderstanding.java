package learning.flowcontrol;

// Understanding Break Continue statements

// The break statement is used to exit—or break out of—the for, for-each, do, and
// do-while loops, as well as switch constructs. Alternatively, the continue statement
// can be used to skip the remaining steps in the current iteration and start with the
// next loop iteration.

// The difference between these statements can be best demonstrated with an
// example. You could use the following code to browse and print all the values of a
// String array

public class BreakContinueUnderstanding {

    public static void main(String[] args) {
        breakDemo();
        continueDemo();

    }

    public static void breakDemo() {
        String[] programmers = { "Paul", "Shreya", "Selvan", "Harry" };
        for (String name : programmers) {
            if (name.equals("Shreya"))
                break;
            System.out.println(name);
        }
    }

    public static void continueDemo() {
        String[] programmers = { "Paul", "Shreya", "Selvan", "Harry" };
        for (String name : programmers) {
            if (name.equals("Shreya"))
                continue;
            System.out.println(name);
        }
    }

}
