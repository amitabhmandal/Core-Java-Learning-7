package generic;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

public class LegacyCode {

    public static void main(String[] args) {
       List list = new ArrayList();
       list.add("anc");
       list.add(1);
       list.add(new Object());
       Iterator iterator = list.iterator();
       while(iterator.hasNext()) {
           final Object element = iterator.next();
           System.out.println(element);
       }

    }

}
