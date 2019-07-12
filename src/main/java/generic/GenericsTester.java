package generic;

import java.util.ArrayList;

public class GenericsTester {

    public static void main(String[] args) {
        ArrayList items = new ArrayList();
        items.add(1);
        items.add(2);
        items.add(3);
        items.add(14);
        items.add("tome");
        printDoubled(items);

    }

    public static void printDoubled(ArrayList n) {
        for (Object o : n) {
            System.out.println((Integer) o * 2);

            // If we dont use casting then it will lead to the following compilation error
            // as follows The operator * is undefined for the argument type(s) Object,
            // int hence we have to use type casting
            // System.out.println( o * 2);
        }
    }

}
