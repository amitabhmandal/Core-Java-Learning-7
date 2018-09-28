package generic;

import java.util.ArrayList;

public class GenericsMethodUnderstanding {

    public static void main(String[] args) {
        // TODO Auto-generated method stub

    }

    public static void m1(ArrayList<String> al) {

        // Within a generic method we can add only string type objects and null objects
        al.add("abc");
        al.add(null);
        // al.add(1);

    }

    public static void m2(ArrayList<?> al) {
        // within this method we can add only null values
        al.add(null);
    }

    public static void m3(ArrayList<? extends Number> al) {
        // within this method we can add only null values.
        // Here extends can be a class or interface
        Integer i = new Integer(10);
        // al.add(i);
        // Hence besides null if we try to add anything else it will lead to
        // compilation error
    }

    public static void m4(ArrayList<? super Number> al) {
        // Here super can be class or Interface
        // Hence we can call it by passing
        // a) if it is a class 'X' then we can call it by passing class 'X' or it's
        // super type
        // b) if it is an interface 'X' then we can call it by passing interface
        // X or by it's super type or super class of it's implementation class of X
        Integer i = new Integer(10);
        al.add(i);

        // Within this method we can add X type of objects and null.
    }

    //
    public <T> void m5(T tTypeObject) {

        // we can use 'T' anywhere within this method based on our requirement
        // we have to declare type parameter just before return type
        //
    }

    // bounded type example at method level
    public <T extends Number> void m6(T tTypeObject) {

    }

    // bounded type example at method level
    public <T extends Number & Runnable> void m7(T tTypeObject) {

    }

    // bounded type example at method level
    public <T extends Comparable & Runnable> void m8(T tTypeObject) {

    }

    // bounded type example at method level
    public <T extends Number & Comparable & Runnable> void m9(T tTypeObject) {

    }

    // Invalid Example

    /* This is invalid. First we have to take class and then interface. Hence
    public <T extends Runnable & Number> void m10(T tTypeObject) {
       
    }
    ?*/

    // Invalid Example
    /* This is invalid since we cannot extends more than one class.
    public <T extends Number & Thread> void m11(T tTypeObject) {
       
    }*/
}
