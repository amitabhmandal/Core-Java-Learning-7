package iterable.iterator.understanding;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

// POINT 1: 
//    This is defined in java.lang package and was introduced with Java 5

// POINT 2:
//    The Iterable is defined as a generic type; Iterable<T>, where 
//    T type parameter represents the type of elements returned by the iterator.
//    These classes can thus have their internal elements iterated via the Java for-each loop.

// POINT 3: 
//    An object that implements this interface allows it to be the target of the “foreach” statement.
//    The Collection interface extends Iterable, so all subtypes of Collection also implement the Iterable interface. 
//    For instance, both the Java List and Set interfaces extend the Collection interface, and 
//    thereby also the Iterable interface

// POINT 4: 
//    The for-each loop is used for iterating over arrays, collections etc. Collection classes and classes 
//    where iterations are useful implement this interface.

// POINT 5: 
//    Before the iterable’s for-each loop was introduced, 
//    a way to iterate is to use the for(;;) loop or to use an Iterator.
//    typically the Iterator could be acquired by invoking a collection object’s iterator() method. 
//    The iterator has been in Java since Java 1.2.

// POINT 6: 
//    The Iterable interface has one method to override: Iterator<T> iterator(). This method must return a 
//    Java Iterator which can be used to iterate the elements of the object implementing the Iterable interface.
//    Obtaining the Iterator happens behind the scenes, so you don't see that done.
//    The Java compiler takes care of generating the code for that, when you use a Iterable with the for-each loop.

// POINT 7: 
//    If you are writing some code that needs to iterate a collection lots of times in a tight loop, 
//    let's say iterate a Java List thousands of times per second, iterating the List via the 
//    Java for-each loop is slower than iterating the list via a standard for-loop as seen here: () .
//    for(int i=0; i<list.size(); i++) {
//       Object obj = list.get(i);
//    }
//    The reason the for-each loop is slower is, that each iteration will call the List iterator() method, 
//    which will create a new Iterator object. Creating a new object thousands, perhaps even millions of 
//    times per second does have a small performance penalty compared to just iterating the 
//    List using a standard for-loop.


public class IterableUnderstanding {

    public static void main(String[] args) {
        List<String> stringList = new ArrayList<>();
        stringList.add("a");
        stringList.add("b");
        stringList.add("c");
        for (String s : stringList) {
            System.out.println(s);
        }
    }
}

class IterableBeforeAlternativeOptionOne {
    public static void main(String[] args) {
        List<String> stringList = new ArrayList<>();
        stringList.add("a");
        stringList.add("b");
        stringList.add("c");
        for (int i = 0; i < stringList.size(); i++) {
            System.out.println(stringList.get(i));
        }
    }
}

class IterableBeforeAlternativeOptionTwo {
    public static void main(String[] args) {
        List<String> stringList = new ArrayList<>();
        stringList.add("a");
        stringList.add("b");
        stringList.add("c");
        Iterator<String> iter = stringList.iterator();
        while (iter.hasNext()) {
            System.out.println(iter.next());
        }
    }
}

class MyIterable<T> implements Iterable<T> {
    private List<T> list;

    public MyIterable(T[] t) {
        list = Arrays.asList(t);
        Collections.reverse(list);
    }

    @Override
    public Iterator<T> iterator() {
        return list.iterator();
    }
}

class MyIterableTester {
    public static void main(String[] args) {
        Integer[] ints = { 1, 2, 3 };
        MyIterable<Integer> myList = new MyIterable<>(ints);
        for (Integer i : myList) {
            System.out.println(i);
        }
    }
}
