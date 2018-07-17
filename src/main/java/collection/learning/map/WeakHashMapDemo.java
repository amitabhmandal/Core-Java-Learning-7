package collection.learning.map;

import java.util.HashMap;
import java.util.WeakHashMap;

public class WeakHashMapDemo {

    public static void main(String[] args) {
        operationWithHashMap();
        operationWithWeakHashMap();
    }

    public static void operationWithWeakHashMap() {
        System.out.println("Executing WeakHashMap Demo");
        WeakHashMap m = new WeakHashMap();

        Temp t = new Temp();

        m.put(t, "durga");
        System.out.println(m);

        // this does not have any reference
        t = null;

        // logical conclusion even through temp object does not have any reference
        // however since it is associated with weakHashMap object hence it is
        // elligible for garbage collection hence temp object shall be destroyed
        // and nothing shall be printed
        System.gc();
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        System.out.println(m);

    }

    public static void operationWithHashMap() {
        System.out.println("Executing HashMap Demo");
        HashMap m = new HashMap();

        Temp t = new Temp();

        m.put(t, "durga");
        System.out.println(m);

        // this does not have any reference
        t = null;

        // logical conclusion even through temp object does not have any reference
        // however since it is associated with HashMap object hence it is not
        // elligible for garbage collection
        System.gc();
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        System.out.println(m);

    }

}

class Temp {

    public String toString() {
        return "temp";
    }

    public void finalize() {
        System.out.println("Finalize method called");
    }
}