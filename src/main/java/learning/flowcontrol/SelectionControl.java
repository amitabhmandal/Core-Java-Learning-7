package learning.flowcontrol;

// Selection Statements 

// If- else
// ternary operator
// switch statements

// NOTE 1: condition must evaluate to a boolean or Boolean value
// NOTE 2: In Java then is not a java keyword hence it should not be used               
// NOTE 3: The if-else-if-else is an if-else construct in which the else part defines another if construct.
// NOTE 4: boolean expression used as a condition for the if construct can also include an assignment operation
// NOTE 5: Using if(testValue==true) is the same as using if(testValue).
//         if(testValue==false) is the same as using if(!testValue)
// NOTE 6: there’s no limit on the number of levels of nested if and if-else constructs
// NOTE 7: In case of Multi if statement blocks Start working from the inside out, with the 
//         innermost if-else statement, matching
//         each else with its nearest unmatched if statement.
// NOTE 8: A ternary construct can be compared to a compact if-else construct, used to assign a value to a variable
//         depending on a boolean expression.

// NOTE 9: A method that returns a value can also be used to initialize a variable in a ternary construct:
// NOTE 10: All three parts of a ternary operator are mandatory:
//          The boolean expression
//          The value returned if the boolean expression evaluates to true
//          The value returned if the boolean expression evaluates to false

// NOTE 11: The value returned by a ternary operator must be assigned to a variable or the code won’t compile
// NOTE 12: watch out for compatibility of the value that’s returned by a ternary operator
//          and the variable to which it’s assigned

// NOTE 13: A switch statement can define multiple case labels within its switch block but only a single default label.
// NOTE 14: The default label executes when no matching value is found in the case labels.
// NOTE 15: A break statement is used to exit a switch statement, after the code completes its execution for a matching case.
// NOTE 16: If the break statement is missed then after the matching case all the statements will be executed including
//          the default statement
// NOTE 17: Difference between IF and SWITCH
// If can accept boolean or Boolean 
// SWITCH can accept as input parameter 
//  enum, int, char , byte, short , String
// Wrapper classes including Character, Byte, Short, 

// NOTE 18: For nonprimitive types, that is, String and wrapper types, the switch argument must
//          not be null, which would cause a NullPointerException to be thrown

// NOTE 19: Values passed to the label case of a switch statement MUST BE COMPILE TIME CONSTANTS
//          else it will be a compile time error

// NOTE 20: if you don’t assign a value to a final variable with its declaration, it isn’t considered a compile-time constant:

// NOTE 21: CASE VALUES SHOULD BE ASSIGNABLE TO THE ARGUMENT PASSED TO THE SWITCH STATEMENT

// NOTE 22: NULL ISN’T ALLOWED AS A CASE LABEL

// NOTE 23: ONE CODE BLOCK CAN BE DEFINED FOR MULTIPLE CASES

// NOTE 24: 

public class SelectionControl {

    public static void main(String[] args) {
        nullCaseNotAllowedInSwitch();
        switchContainingMultipleCases();
        switchIfValueNotAssignedToFinalVariableNotCompileTimeConstant();
        switchLabelsMustBeCompileTimeConstant();
        switchArgumentCannotBeNull();
        invalidSwitchArguments();
        noSwitchMatch();
        simpleSwitchStatement();
        nestedTernary();
        compilationIssuesWithTernary();
        ternarySimpleCase();
        ternaryConstruct();
        booleanConditionAssignment();
        assignmentNotComparison();
    }

    public static void caseAssignableValuesPassed() {
        byte myByte = 10;
        switch (myByte) {
        // CASE VALUES SHOULD BE ASSIGNABLE TO THE ARGUMENT PASSED TO THE SWITCH STATEMENT
        case 1/*.2*/:
            System.out.println(1);
            break;
        }
    }

    public static void nullCaseNotAllowedInSwitch() {

        String name = "Paul";
        switch (name) {
        case "Paul":
            System.out.println(1);
            break;
        // NULL ISN’T ALLOWED AS A CASE LABEL
        // case null:
        // System.out.println("null");
        }

    }

    public static void switchContainingMultipleCases() {
        int score = 10;
        // ONE CODE BLOCK CAN BE DEFINED FOR MULTIPLE CASES
        switch (score) {
        case 100:
        case 50:
        case 10:
            System.out.println("Average score");
            break;
        case 200:
            System.out.println("Good score");
        }
    }

    public static void switchIfValueNotAssignedToFinalVariableNotCompileTimeConstant() {
        final int a = 10;
        final int b = 20;
        final int c;
        c = 30;
        switch (a) {
        case b /*+ c*/:
            System.out.println(b + c);
            break;
        }
    }

    public static void switchLabelsMustBeCompileTimeConstant() {
        // Note that b+c in the preceding code defined at B can’t be determined at the time of
        // compilation and isn’t allowed. But 10*7 defined at c is a valid case label value.
        int a = 10, b = 20, c = 30;
        switch (a) {
        /*case b + c: // since this is not a compile time constant hence it will reduce to compile time error
            System.out.println(b + c);
            break;*/
        case 10 * 7:
            System.out.println(10 * 7512 + 10);
            break;
        }

        final int p = 10;
        final int q = 20;
        final int r = 30;

        switch (p) {
        case q + r: // since it is a compile time constant hence constant expressions allowed
            System.out.println(b + c);
            break;
        }

    }

    public static void switchArgumentCannotBeNull() {
        Integer value = null;
        switch (value) {
        default:
            System.out.println("value is not 10");
            break;
        case 10:
            System.out.println("value is 10");
            break;
        }
    }

    public static void invalidSwitchArguments() {
        // switch arguments cannot be double, long or float
        double history = 20;
        // switch (history) {
        // ..code
        // }
    }

    public static void noSwitchMatch() {
        String day = new String("SUN");
        switch (day) {
        case "MON":
        case "TUE":
        case "WED":
        case "THU":
            System.out.println("Time to work");
            break;
        case "FRI":
            System.out.println("Nearing weekend");
            break;
        case "SAT":
        case "SUN":
            System.out.println("Weekend!");
            break;
        default:
            System.out.println("Invalid day?");
        }
    }

    public static void simpleSwitchStatement() {
        int marks = 20;
        switch (marks) {
        case 10:
            System.out.println(10);
            // break;
        case 20:
            System.out.println(20);
            // break;
        case 30:
            System.out.println(30);
            // break;
        default:
            System.out.println("default");
            // break;
        }
    }

    public static void nestedTernary() {
        int bill = 2000;
        int qty = 10;
        int discount = (bill > 1000) ? (qty > 11) ? 10 : 9 : 5;
        System.out.println(discount);
    }

    public static void compilationIssuesWithTernary() {

        long bill = 2000;
        // Won’t compile; bill-100 is of type long
        // int discount = (bill > 2000)? bill-100 : bill - 50;

        // look out for conversions between primitive and wrapper classes

        // The following code won’t compile because Integer can’t be assigned to Long and vice versa:
        // Long discount = (5000 > 2000)? new Integer(10) : new Integer(15);

    }

    public static void ternaryConstruct() {
        int bill = 2000;
        int discount = (bill > 2000) ? getSpecDisc() : getRegDisc();
        System.out.println(discount);
    }

    static int getRegDisc() {
        return 11;
    }

    static int getSpecDisc() {
        return 15;
    }

    public static void ternarySimpleCase() {
        int bill = 2000;
        int discount = (bill > 2000) ? 15 : 10;
        System.out.println(discount);
    }

    public static void assignmentNotComparison() {
        boolean allow = false;
        if (allow = false)
            System.out.println("value is true");
        else
            System.out.println("value is false");

        if (allow = true)
            System.out.println("value is true");
        else
            System.out.println("value is false");
    }

    public static void missingBlockUnderstanding() {
        int score = 40;
        boolean testValue = false;
        // This is valid even though it does not have an then statement and else statement
        if ((score = score + 10) > 110)
            ;

        // The following is also valid even though the then statement is {} literally doing nothing
        if (testValue == true) {
        } else
            System.out.println("value is false");

        // the following code will not compile if then statement is missed
        /*
        if (testValue == true)
            else
            System.out.println("value is false");
         */

    }

    public static void booleanConditionAssignment() {
        String result = "1";
        int score = 10;
        if ((score = score + 10) == 100) // score 20
            result = "A";
        else if ((score = score + 29) == 50) // score 49
            result = "B";
        else if ((score = score + 200) == 10) // score 249
            result = "C";
        else
            result = "F";
        System.out.println(result + ":" + score); // F : score 249
    }

}
