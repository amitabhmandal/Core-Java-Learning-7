package generic;

import java.util.ArrayList;

public class GenericsVariableDeclarationDemo {

    public static void main(String[] args) {
        //Valid
        ArrayList<String> al1 = new ArrayList<>();
        ArrayList<?> al2 = new ArrayList<String>();
        al2.add(null);
        
        ArrayList<?> al3 = new ArrayList<Integer>();
        ArrayList<? extends Number> al4 = new ArrayList<Integer>();
        Integer i = new Integer(1);
        al4.add(null);
        ArrayList<? super String> al6 = new ArrayList<Object>();

        
        //Invalid
        //ArrayList<? extends Number> al5 = new ArrayList<String>();
       // ArrayList<?> al7 = new ArrayList<?>();
        //ArrayList<?> al8 = new ArrayList<? extends Number>();
       
    }

}
