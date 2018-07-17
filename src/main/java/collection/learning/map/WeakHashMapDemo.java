package collection.learning.map;

import java.util.HashMap;

public class WeakHashMapDemo {

    public static void main(String[] args) {
        operationWithHashMap();

    }

    public static void operationWithHashMap() {
        HashMap m = new HashMap();

        Temp t = new Temp();

        m.put(t, "durga");
        System.out.println(m);

        // this does not have any reference
        t = null;

        System.gc();

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