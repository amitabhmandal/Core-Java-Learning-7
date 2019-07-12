package string.vs.stringbuffer.vs.stringbuilder;

import java.lang.reflect.Field;

public class WhyStringFinal {

    // Whenever we talk about String class in Java we say it is immutable in nature and all
    // string literals are stored in String Constant Pool (SCP).
    // ===============

    // Prior to Java 7 String Constant Pool belongs to Permanent Generation area of heap which means
    // Garbage Collector will not touch it in normal scenarios.
    // But from Java 7 onwards string constant pool is not part of Perm Gen but
    // live with out in heap which means now unused String objects will get garbage collected.

    // String is Effective Immutable not Completely Immutable
    // String objects are immutable and can't be modified but we can modify them by using
    // Java reflection API. Every string object holds a char[] array as a private variable
    // which actually holds every character from our string

    // Due to the private nature of the char[] array, we cannot access it from outside of string object
    // and none of the string methods modifies it.

    // But we can access this char[] array via reflection and then modify it, And that's why instead of
    // calling String immutable we can call it Effective Immutable.

    // So String is made final to not allow others to extend it and destroy its immutability.

    // Why String Is Immutable

    // 1. The existence of String Constant Pool
    // In order provide a business functionality, every application creates too many string objects
    // and in order to save JVM from first creating lots of string objects and then garbage
    // collecting them. JVM stores all string objects in a separate memory area called String
    // constant pool and reuses objects from that cached pool.

    // Whenever we create a string literal JVM first sees if that literal is already present in
    // constant pool or not and if it is there, the new variable will start pointing to the same
    // object in SCP this process is called String Interning.

    String a = "Naresh";
    String b = "Naresh";
    String c = "Naresh";

    // In above example string object with value Naresh will get created in SCP only once and
    // all variables a, b, c will point to the same object but what if we try to make change
    // in a e.g. a.replace("a", "").

    // Ideally a should have value Nresh but b, c should remain unchanged because as the end user
    // we are making change in a only. And as a developer we know a, b, c all are pointing the
    // same object so if we make a change in a, others should also reflect the change.

    // But String's immutability saves us from this scenario and due to which object Naresh will
    // never change. So when we make any change in a, JVM will create a new object assign it to a,
    // and then make the change to that object instead of changing object Naresh.

    // So having a string pool is only possible because of String's immutability and if String
    // would not have been immutable, then caching string objects and reusing them would not
    // have been a possibility because any variable would have changed the value and
    // corrupted others.

    // 2. Thread Safety
    // An object is called thread-safe when multiple threads are operating on it but none of them is able to
    // corrupt its state and object holds the same state for every thread at any point in time.

    // As we know an immutable object cannot be modified by anyone after its creation which makes every immutable
    // object thread safe by default. We do not need to apply any thread safety measures to it such as
    // creating synchronized methods.

    // So due to its immutable nature string object can be shared by multiple threads and even if it is
    // getting manipulated by many threads it will not change its value.

    // 3. Security
    // In every application, we need to pass several secrets e.g. user's user-name\passwords,
    // connection URLs and in general, all of this information is passed as string objects.

    // Now suppose if String would not have been immutable in nature then it could cause serious
    // security threats to the application because these values will be allowed to get changed
    // and if it is allowed then these might get changed due to wrongly written
    // code or by any other person who has access to our variable references.

    // 4. Class Loading

    // As discussed in Creating objects through Reflection in Java with Example,
    // we can use Class.forName("class_name") method to load a class in memory which
    // again calls other methods to do so and even JVM uses these methods to load classes.

    // But if you see clearly all of these methods accepts the class name as a
    // string object so Strings are used in java class loading and String's
    // immutability makes sure that correct class is getting loaded by ClassLoader.

    // Suppose if String would not have been immutable and we are trying to load
    // java.lang.Object which get changed to org.theft.OurObject in between and
    // now all of our objects have a behavior which someone can use to do unwanted things.

    // 5. HashCode Caching

    // If we are going to perform any hashing related operations on our object we must override the
    // hashCode() method and try to generate an accurate hashcode by using the state of the object.
    // If object's state is getting changed which means its hashcode should also change.

    // Because String is immutable so the value one string object is holding will never get changed
    // which means its hashcode will also not change which gives String class an opportunity
    // to cache its hashcode during object creation.

    // Yes, String object caches its hashcode at the time of object creation which makes it a great
    // candidate for hashing related operations because hashcode doesn't need to be calculated again
    // and again which save us some time and this is why String is the
    // most suitable candidate to be used as HashMap keys.

    // Disadvantages of String Immutability
    // 1. PermGen Space Error
    // Due to the immutability of String, string object can't be changed and whenever we make a
    // change on it, JVM creates a new string object. So if there are 10000 string object in an
    // application and every string object is getting manipulated 10 times then we are left
    // with 110000 string objects.

    // And as we know strings are stored in a separate constant pool which is part of Permanent
    // Generation, which usually occupies very limited memory as compared to young and old
    // generations. Having too many String literals will quickly fill this space, resulting
    // in java.lang.OutOfMemoryError: PermGen Space error

    // 2. Keeping passwords in memory for a long time
    // In general, passwords are stored as strings and strings are stored in the constant pool
    // which is exempted from normal garbage collection cycles. So our password might remain in
    // memory for very long time and someone can take advantage of it.

    // This is the reason standards suggest to hold password in an char[] array instead of
    // the string object.

    // 3. String is not extensible
    // Making String final is part of making it immutable but it also becomes a disadvantage
    // because it limits its extensibility and we cannot extend String to provide more functionality.

    // For some developers, it becomes a problem when they require some extra behavior for their
    // string objects but it's not a disadvantage and it can be tacked by creating a utility
    // method which accepts the string as a parameter.

    public static void main(String[] args) throws Exception {
        String name = "Naresh";
        System.out.println(name.length());
        System.out.println(name.isEmpty());
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
