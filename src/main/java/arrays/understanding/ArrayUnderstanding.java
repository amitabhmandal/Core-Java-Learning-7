package arrays.understanding;

//IMPORTANT POINTS

// #1. All methods of class objects can be invoked in an Array
// #2. The direct superclass of an array type is Object.
// #3. Every array type implements the interfaces Cloneable and java.io.Serializable.
// #4. byte[] rowvector, colvector, matrix[]; is same as byte rowvector[], colvector[], matrix[][];
// #5. Once an array object is created, its length never changes.
// #6. A single variable of array type may contain references to arrays of different lengths, because an array's length is not part of its type.
// #7. Arrays must be indexed by int values; short, byte, or char values may also be used as index 
//     values because they are subjected to unary numeric promotion and become int values
// #8. An attempt to access an array component with a long index value results in a compile-time error

// #9. All array accesses are checked at run time; an attempt to use an index that is less than zero or greater than or 
//     equal to the length of the array causes an ArrayIndexOutOfBoundsException to be thrown.

// #10. ArrayStoreException: An assignment to an element of an array whose type is A[], where A is a reference type, is 
//      checked at run-time to ensure that the value assigned can be assigned to
//      the actual element type of the array, where the actual element type may be any reference type that is assignable to A.

// #11. If there is insufficient space to allocate the array, evaluation of the array initializer 
//      completes abruptly by throwing an OutOfMemoryError

// #12. An Array of Characters is Not a String. A String object is immutable, that is, its contents never change, 
//      while an array of char has mutable elements.

// #13. Arrays are fixed in size. Arrays can hold homogenous type of data.

// #14. Arrays are indexed collection of fixed number of homogenous data elements. 

// #15. We cannot specify the size of the array during declaration. if we try to specify the size then it will lead to compilation error.

// #16. The size of an array can not be changed once you define it. You can not insert or delete array elements after 
//      creating an array. Only you can change is the value of the elements. This is the main drawback of arrays.

// #17. An array containing super class reference variables can point to sub class objects.

public class ArrayUnderstanding extends Object {

    public static void main(String[] args) {
        arrayVariableAssignments();
        // arrayElementAssignments();
        // arrayLengthConcepts();
        // newOperatorDeclaration();
        // emptyDimensionArrayCreationError();
        // anonymousArrayExample();
        // nullPointerExampleIfArrayNotInitialized();
        // checkingSuperClass();
        // arrayClassObjectsShared();
        // allowedDeclarationType();
        // arrayCreation();
        // arrayDeclarationInitialization();
        // charToIntTypePromotionInCreation();
        // arrayNegativeSizeException();

        // arrayLevelPromotionRules();

    }

    public static void arrayVariableAssignments() {

        // Array Types || Allowed array element types
        // +++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
        //
        // CASE 1
        //
        // Primitive variable arrays || Any types which can be implicitly be promoted to the declared types
        int[] x = { 10, 20, 30, 40 };
        char[] y = { 'a', 'b', 'c', 'd' };

        int[] b = x; // valid case
        
        // The following variable assignment is invalid due to the following reason 
        
        // char element can be promoted to int element type however the char array cannot be promoted to int array
        // char array is an object of [C and int array is an object of [I 
        // hence assignment of the two following classes is incompatible 
        // Also there is no relation between [C and [I hence if there is no relation how can objects of one type be 
        // promoted to another type
        // hence int[] i = char[] ch is not possible.
        // int[] a = y;

        //
        // CASE 2
        //
        // Object type arrays 
        // But in the case of object type arrays child class type array can be promoted to parent class type arrays
        Object[] obj = new Object[3];
        String[] str = new String[3];
        str[0] =  "abc";
        str[1] =  "xyz";
        str[2] =  "pqr";
        
        obj = str;
        for(int i = 0 ; i <  3 ; i++) {
            System.out.println(obj[i]);
        }
        
        //
        // CASE 3
        //
        // When we are assigning one array to another then dimension must match.
        // if any other dimension is provided then we will get compile time error as shown below
        int[] p = {1,2,3};
        int[][] q = {{1}, {1}};
        // p = q;
        
        
        //
        // CASE 4
        // Interface array types || It's implementation class objects are allowed

    }

    public static void arrayLengthConcepts() {
        int[] a = { 1, 2, 3, 4, 5 };
        System.out.println(a.length);

        String str = "amitabh";
        System.out.println(str.length());

        String[] s1 = { "abc", "bqd", "rferf" };
        System.out.println(s1.length);
        System.out.println(s1[0].length());

        int[][] x = { { 1, 2, 3 }, { 4, 5 } };

        // In more than one dimensional array, it is basically an one dimensional array
        // Hence when we are asked to get the size of more than one dimensional array then it shall always
        // represent the base size and not the entire lenght of the array
        System.out.println(x.length);
        // To find the entire length of the N'th dimension array we need to sum up all the array base sizes
        // hence there is no direct formula for it.
    }

    public static void newOperatorDeclaration() {
        int[] i = { 1, 2, 3, 4 }; // This is the correct way

        // i={1,2,3,4}; // Compile time error

        i = new int[] { 1, 2, 3, 4 }; // This is also correct way
    }

    public static void emptyDimensionArrayCreationError() {

        // While creating multi dimensional arrays, you can not specify an array
        // dimension after an empty dimension.

        // int[][][] threeDArray = new int[10][][10]; // Compile Time Error

        // int[][][] threeDArray1 = new int[][10][]; // Compile Time Error

        // int[][][] threeDArray2 = new int[][][10]; // Compile Time Error
    }

    public static void anonymousArrayExample() {
        System.out.println(new int[] { 1, 2, 3 }.length); // Output : 3

        System.out.println(new int[] { 47, 21, 58, 98 }[1]); // Output : 21
    }

    public static void nullPointerExampleIfArrayNotInitialized() {
        UserDefinedType[] arrayOfUserDefinedTypeObjects = new UserDefinedType[10];
        // This statement throws NullPointerException
        // because array elements are not initialized
        arrayOfUserDefinedTypeObjects[1].methodOne();

    }

    public static void arrayDeclarationInitialization() {
        // Declaring, instantiating and Initializing an array in one statement

        double[] arrayOfDoubles = new double[] { 12.56, 45.87, 14.85 };

        // This is also ok.

        int[] arrayOfInts = { 12, 21, 0, 5, 7 };

        int[] i = new int[10 + 5]; // Array size can be an expression resulting an integer

        int[] i1 = new int[(byte) 10]; // byte is auto-widened to int

        // int i3 = new int[10.25]; //Compile Time Error : size can not be double
    }

    public static void arrayLevelPromotionRules() {
        int[] a = { 1, 2, 3, 4 };
        char[] x = { 'a', 'b', 'c' };

        // int[] reference can be assigned to any other variables
        int[] a1 = a;

        // Array level promotion not possible hence char to int not possible at array
        // level. Hence the following will lead to compilation error
        // int[] a2 = x;

        // Thus char to int type promotion possible. char[] to int[] type array not
        // possible
        // Thus int to double type promotion possible. int[] to double[] type array not
        // possible
        // Thus float to int not possible, float[] to int[] not possible
        // String to Object possible, String[] to Object[] possible. Child array is
        // always promoted to Parent array possible

    }

    public static void arrayElementAssignments() {

        // case 1: primitive type arrays where any type can be implicitly promoted to
        // declared type

        int[] x = new int[3];
        x[0] = 1;
        x[1] = 'a';
        x[2] = (byte) 20;
        for (int i = 0; i < 3; i++) {
            System.out.println(x[i]);
        }
        // if we try to assign long then it will lead to compilation error for example
        // if we try to assign long values to int then it will lead to compilation error
        // Widening Primitive Conversion
        // byte to short, int, long, float, or double
        // short to int, long, float, or double
        // char to int, long, float, or double
        // int to long, float, or double
        // long to float or double
        // float to double

        // Thus for a float declared array type then allowed data types are char short int long and byte

        // Thus in case of primitive arrays as in case of array elements we can provide
        // any type
        // which can be implicitly promoted to declared type

        // byte >> short >> int >> long >> float >> double
        // char >> int >> long >> float >> double

        // case 2a: object type arrays
        // we can assign either declared type objects or it's child class objects
        Object[] o1 = new Object[10];
        o1[0] = new Object();
        o1[1] = new String("Amitabh");
        o1[2] = new Integer(10);

        for (int i = 0; i < 3; i++) {
            System.out.println(o1[i]);
        }

        // HENCE IN CASE OF OBJECT TYPE ARRAYS AS ARRAY ELEMENTS WE CAN PROVIDE EITHER DECLARED TYPE OBJECTS
        // OR IT"S CHILD CLASS OBJECTS

        // case 2b: If it an Number class array then we can assign declared type or it's
        // child classes
        Number[] n1 = new Number[10];
        n1[0] = new Integer(10);
        n1[1] = new Float(10);
        n1[2] = new Double(10);

        for (int i = 0; i < 3; i++) {
            System.out.println(n1[i]);
        }

        // If we try to assign String to it then it will lead to compilation error as
        // shown below
        // n1[3] = new String("Amitabh"); //Type mismatch: cannot convert from String to
        // Number or incompatible type

        // case 3: When interfaces then it's implementation classes allowed
        Runnable[] r = new Runnable[10];
        r[0] = new Thread();
        // r[1] = new String(); //Type mismatch: cannot convert from String to Runnable

        // case 4: When abstract class type then it's child classes are allowed. Example
        // Number is an asbtract class

        // Array Types || Allowed array element types
        // +++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
        //
        // CASE 1
        //
        // Primitive arrays || Any types which can be implicitly be promoted to the declared types
        //
        // CASE 2
        //
        // Object type arrays || Either declared type or it's child classes
        //
        // CASE 3
        //
        // Abstract class types || It's child class objects
        //
        // CASE 4
        // Interface array types || It's implementation class objects are allowed

    }

    public static void charToIntTypePromotionInCreation() {
        int[] a = new int['a'];
        // since the type would be promoted hence the size of the array become 97
        System.out.println(a.length);

        // To specify the array size the allowed data types are
        // byte , short , int and if anything else it will lead to compilation error as
        // shown below
        // int[] b = new int[1l];
    }

    public static void arrayNegativeSizeException() {

        // This will not lead to compilation error but lead to
        // java.lang.NegativeArraySizeException exception.
        int[] a = new int[-1]; // Exception in thread "main" java.lang.NegativeArraySizeException
        System.out.println(a.length);

    }

    public static void arrayCreation() {

        // Why arrays are called an object
        int[] arr = new int[3];
        // as we are using new operator and that is how we create objects hence arrays
        // are called objects
        // every array in java is an object
        System.out.println(arr.getClass()
            .getSimpleName()); // int[]
        System.out.println(arr.getClass()
            .getName()); // [I

        int[] a1 = new int[3];
        int[][] a2 = new int[3][3];
        double[] a3 = new double[3];
        short[] a4 = new short[3];
        byte[] a5 = new byte[3];
        boolean[] a6 = new boolean[3];
        long[] a7 = new long[3];
        float[] a8 = new float[3];
        Integer[] a9 = new Integer[3];

        System.out.println(a1.getClass()
            .getName()); // [I
        System.out.println(a2.getClass()
            .getName()); // [[I
        System.out.println(a3.getClass()
            .getName()); // [D
        System.out.println(a4.getClass()
            .getName()); // [S
        System.out.println(a5.getClass()
            .getName()); // [B
        System.out.println(a6.getClass()
            .getName()); // [Z
        System.out.println(a7.getClass()
            .getName()); // [J
        System.out.println(a8.getClass()
            .getName()); // [F
        System.out.println(a9.getClass()
            .getName()); // [Ljava.lang.Integer;

        // at the time of the array initialization we should compulsory specify the size
        // new int[3] we should specify the size else it will lead to compilation error

        // It is legal to have size zero in java
        int[] a = new int[0];
        System.out.println(a);

    }

    public static void allowedDeclarationType() {

        // possible declaration types
        int[] x; // name is clearly from type
        int[] y;
        int z[];

        // recommended type though
        int[] w;

        // two dimensional declaration
        int[][] p;
        int q[][];
        int[][] r;

        int[][] a;
        int[] b[];
        int[] c[];

        // meaning of declarations
        int[] a1, b1; // a1 = 1, b1 = 1
        int[] a2[], b2; // a2=2 , b2=1
        int[] a3[], b3[]; // a3=2 , b3=2
        int[][] a4, b4; // a4=2 , b4=2 // space is ignored hence both are two dimensional arrays
        int[][] a5, b5[];// a5=2 , b5=3
        int[][] a6, b6;// a5=2 , b5=3

        // The following declaration would lead to compilation error
        // Rule is if we want to declare dimension then it is allowed only for the first
        // variable in the declaration
        // if we use it for the second variable onwards (remaining variable)
        // then it will lead to compilation error
        // int[] []a6, []b6; // will lead to compilation error as dimension cannot be
        // declared before the first variable
        //

    }

    public static void checkingSuperClass() {
        int[] ia = new int[3];
        System.out.println("get class name: " + ia.getClass());
        System.out.println("get super class information : " + ia.getClass()
            .getSuperclass());
    }

    public static void arrayClassObjectsShared() {
        int[] ia = new int[3];
        int[] ib = new int[6];
        System.out.println(ia.getClass() == ib.getClass());
        System.out.println("ia has length=" + ia.length);
    }

    public static void arraysAreCloneable() {
        int ia1[] = { 1, 2 };
        int ia2[] = ia1.clone();
        System.out.print((ia1 == ia2) + " ");
        ia1[1]++;
        System.out.println(ia2[1]);
    }

    public static void sharedArraysAfterClone() {
        int ia[][] = { { 1, 2 }, null };
        int ja[][] = ia.clone();
        System.out.print((ia == ja) + " ");
        System.out.println(ia[0] == ja[0] && ia[1] == ja[1]);
    }
}

class Point {
    int x, y;
}

class ColoredPoint extends Point {
    int color;
}

class Test {
    public static void main(String[] args) {
        ColoredPoint[] cpa = new ColoredPoint[10];
        Point[] pa = cpa;
        System.out.println(pa[1] == null);
        try {
            pa[0] = new Point();
        } catch (ArrayStoreException e) {
            System.out.println(e);
        }
    }
}

class UserDefinedType {
    int i;

    void methodOne() {
        System.out.println("From User Defined Type Object");
    }
}