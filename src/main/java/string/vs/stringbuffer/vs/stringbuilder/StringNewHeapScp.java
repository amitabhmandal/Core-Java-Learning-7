package string.vs.stringbuffer.vs.stringbuilder;

import java.lang.reflect.Field;

public class StringNewHeapScp {

    // So if we store all those string objects in normal heap memory, lot's of the heap will be acquired by
    // just string objects only, and the garbage collector will have to run more frequently which will
    // decrease the performance of the application.

    // And that's why we have String Constant Pool and String interning process, whenever we create a
    // string literal JVM first sees if that literal is already present in the constant pool or not and
    // if it is there, the new variable will start pointing to the same object, this process is
    // called String Interning

    // Creating String Literal:: Anything which comes under "" is a string literal e.g. String s1 = "Naresh",
    // by default all string literals interned and goes to SCP.

    // Creating a String object using constructor: If we create a String object using the constructor e.g.
    // String s2 = new String("Naresh"), the object is created in normal heap memory instead of SCP.
    // And that's why creating String object using constructor is not considered a best practice.
    // We can ask s2 to point to SCP instead of normal heap manually by calling intern() method on it
    // i.e. s2.intern().

    // So in order to save memory consumed by string objects, Java allows more than one reference variable
    // to point to the same object if they have the same value. That's why JVM creators have created a
    // separate memory area SCP for string literals and made a rule that if more than one string variable
    // holding same value than they will point to the same object.

    // String a = "Naresh";
    // String b = "Naresh";
    // String c = "Naresh";

    // For above code there will be only one object Naresh will be created and all reference variables
    // a, b, c will point to the same object.

    // In above example string object with value Naresh will get created in SCP only once and all
    // reference a, b, c will point to same object but what if we try to make a change
    // in a e.g. a.replace("a", "").

    // Ideally, a should have value Nresh but b, c should remain unchanged because as an end user
    // we are making the change in a only. And we know a, b, c all are pointing the same object
    // so if we make a change in a, others should also reflect the change.
    
    String a = "Naresh";
    String b = "Naresh";
    String c = "Naresh";
    
    // here a,b and c are all pointing to the same memory address due to String pool concept
    
    // So if we do a = a.replace("a","");
    // then will not change the original a but create a new memory object make changes in it and then 
    // return the reference of a
    

    // But string immutability saves us from this scenario and due to the immutability of string object
    // string object Naresh will never change. So when we make any change in a instead of change in
    // string object Naresh JVM creates a new object assign it to a and then make the change in that object.

    // So String pool is only possible because of String's immutability and if String would not have been
    // immutable, then caching string objects and reusing them would not have a possibility because any
    // variable would have changed the value and corrupted others.
    
    

    public static void main(String[] args) throws Exception {
        StringImmutabilityExample();
    }

    public static void StringImmutabilityExample() throws NoSuchFieldException, SecurityException, IllegalArgumentException, IllegalAccessException {
        String string = "Naresh";

        Class<String> type = String.class;
        Field field = type.getDeclaredField("value");
        field.setAccessible(true);

        char[] value = (char[]) field.get(string);
        value[0] = 'M';

        System.out.println(string);
    }

}
