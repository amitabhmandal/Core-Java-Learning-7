package learning.flowcontrol;

import java.util.ArrayList;
import java.util.Iterator;

// loop control                                                 

// 1.  while loops
// 2. do while loops
// 3. enhanced for 
// 4. for loops

// *************************************************************************************************
// TRADITIONAL FOR LOOP
// *************************************************************************************************
// NOTE 1: Traditional for loop syntax
/*
    for (initialization; condition; update) {
    statements;
    }
*/

// NOTE 1 : For loop is sub divided into 
//             Initialization statements [can be multiple] / ONLY ONCE
// 
//             Termination condiiton     [CAN ONLY BE ONE]
//             Update clause             [can be multiple]

// NOTE 2: Rules about INITIALIZATION BLOCK
// RULE 1: you can’t declare variables of different types in an initialization block
//         The following code is invalid 
//         for (int j=10, long longVar = 10; j <= l; ++j)

// RULE 2: initialize multiple variables in its initialization block, but the variables it declares should be of the same type
//         for (int ctr = 1, num = 100000; ctr <= 5; ++ctr)
//         Since only int type variables are declared hence it is a valid statement

// RULE 3: It’s a common programming mistake to try to use the variables defined in a for’s initialization
//         block outside the for block
//         Hence the following code is invalid since we are trying to access the variable 'ctr' outside the for loop
/*
            int tableOf = 25;
            for (int ctr = 1; ctr <= 5; ++ctr) {
            System.out.println(tableOf * ctr);
            }
            ctr = 20;
*/

//NOTE 3: Rules about TERMINATION BLOCK

// RULE 1: The termination condition is evaluated once for each iteration before executing the statements defined 
//         within the body of the loop.

// RULE 2: The for loop terminates when the termination condition evaluates to false:

// RULE 3: The termination code is first checked before the body of the for loop executes.

// RULE 4: If the termination condition evaluates to false then the flow of control is transferred to the outside of the 
//         code

// RULE 5: define multiple statements in the update clause, including calls to other methods
//         LIMITATION: They will execute in the order in which they appear

// NOTE 4: Optional parts of a for statement
// All three parts of a for statement—that is, initialization block, termination condition and update clause—are optional.
// But you must specify by mentioning it with a semi colon as which part is not needed to 

// NOTE 5: A missing termination condition implies an infinite loop.

//*************************************************************************************************
//ENHANCED FOR LOOP
//*************************************************************************************************
//NOTE 1: Regular Loop problem. We have to specify the start and end position even though if we have to iterate the 
//        entire loop
//NOTE 2: Iterating through a collection of primitive values: 
// primitive values are passed by value to the loop variable in an enhanced for loop

//NOTE 3: Iterating through a collection of Objects.
// When you iterate through a collection of objects, the value of the collection is passed by reference to the 
// loop variable

//NOTE 4: Limitation of enhanced for loop
// 
//        CAN’T BE USED TO INITIALIZE AN ARRAY AND MODIFY ITS ELEMENTS
//
//        CAN’T BE USED TO DELETE OR REMOVE THE ELEMENTS OF A COLLECTION
//
//        CAN’T BE USED TO ITERATE OVER MULTIPLE COLLECTIONS OR ARRAYS IN THE SAME LOOP
//        Use the for-each loop to iterate over arrays and collections. Don’t use it to initialize, modify, or filter them
// Although it’s perfectly fine for you to iterate through nested collections or arrays
//using a for loop, you can’t iterate over multiple collections or arrays in the same foreach
//loop because the for-each loop allows for the creation of only one looping variable.
//Unlike the regular for loop, you can’t define multiple looping variables in a foreach
//loop.

class EnhancedForLoop {

    public static void enhancedForLoopRemoveLimitation() {
        ArrayList<StringBuilder> myList = new ArrayList<>();
        myList.add(new StringBuilder("One"));
        myList.add(new StringBuilder("Two"));
        for (StringBuilder val : myList)
            System.out.println(val);
        for (StringBuilder val : myList)
            val = null;
        for (StringBuilder val : myList)
            System.out.println(val);
    }

    public static void enhancedforLoopLimitation() {
        // Although you can define a counter outside the enhanced
        // for loop and use it to initialize and modify the array elements, this approach defeats
        // the purpose of the for-each loop.
        int[] myArray = new int[5];
        for (int i = 0; i < myArray.length; ++i) {
            myArray[i] = i;
            if ((myArray[i] % 2) == 0)
                myArray[i] = 20;
        }

        for (int my : myArray) {
            System.out.println(my);
        }

    }

    public static void oldForLoop() {
        ArrayList<String> myList = new ArrayList<String>();
        myList.add("Java");
        myList.add("Loop");
        for (Iterator<String> i = myList.iterator(); i.hasNext();)
            System.out.println(i.next());
    }

    public static void enhancedLoopForPrimitive() {
        int total = 0;
        int primeNums[] = { 2, 3, 7, 11 };
        for (int num : primeNums) {
            total += num;
            num = num + 1;
            System.out.println(num);
        }
        for (int num : primeNums) {
            System.out.println(num);
        }
    }

    public static void enahancedForLoopForObjects() {
        StringBuilder myArr[] = { new StringBuilder("Java"), new StringBuilder("Loop") };
        for (StringBuilder val : myArr)
            System.out.println(val);
        for (StringBuilder val : myArr)
            val.append("Oracle");
        for (StringBuilder val : myArr)
            System.out.println(val);
        System.out.println("*******");
        for (StringBuilder val : myArr)
            System.out.println(val);
        for (StringBuilder val : myArr)
            val = new StringBuilder("Oracle");
        for (StringBuilder val : myArr)
            System.out.println(val);
    }

    public static void enhancedLoop() {
        ArrayList<String> myList = new ArrayList<String>();
        myList.add("Java");
        myList.add("Loop");
        for (String val : myList)
            System.out.println(val);
    }
}

public class LoopControl {

    public static void main(String[] args) {
        EnhancedForLoop.enhancedForLoopRemoveLimitation();
        EnhancedForLoop.enhancedforLoopLimitation();
        EnhancedForLoop.enhancedLoopForPrimitive();
        EnhancedForLoop.enahancedForLoopForObjects();
        TraditionalForLoop.traditionalDemo();
        TraditionalForLoop.optionalLoopStatements();

    }

}

class TraditionalForLoop {

    public static void traditionalDemo() {
        int tableOf = 25;
        boolean side = false;
        for (int ctr = 1; ctr < 1; ctr++, side = true) {
            System.out.println(tableOf * ctr);
        }

        System.out.println(side);
    }

    public static void optionalLoopStatements() {
        int a = 10;
        for (; a < 5; ++a) {
            System.out.println(a);
        }

        // Removing the semicolon that marks the end of the initialization block prevents the
        // code from compiling:
        /*
        for ( a < 5; ++a) {
            System.out.println(a);
        }*/
    }
}
