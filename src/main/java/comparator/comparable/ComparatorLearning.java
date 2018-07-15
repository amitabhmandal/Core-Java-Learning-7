package comparator.comparable;

import java.util.Comparator;
import java.util.TreeSet;

public class ComparatorLearning {

    public static void main(String[] args) {
        // defaultAscendingOrderTree();
        // descendingOrderTree();

    }

    public static void descendingOrderTree() {
        TreeSet<Integer> treeSet = new TreeSet<Integer>(new DescendingOrderComparator());
        treeSet.add(10);
        treeSet.add(0);
        treeSet.add(15);
        treeSet.add(5);
        treeSet.add(10);
        treeSet.add(20);
        treeSet.add(11);
        treeSet.add(90);
        System.out.println(treeSet);
    }

    public static void defaultAscendingOrderTree() {
        TreeSet<Integer> treeSet = new TreeSet<Integer>();
        treeSet.add(10);
        treeSet.add(0);
        treeSet.add(15);
        treeSet.add(5);
        treeSet.add(10);
        treeSet.add(20);
        treeSet.add(11);
        treeSet.add(90);
        System.out.println(treeSet);

    }
}

class DescendingOrderComparator implements Comparator<Integer> {

    @Override
    public int compare(Integer o1, Integer o2) {
        if (o1 < o2) {
            return +1;
        } else if (o1 > o2) {
            return -1;
        } else
            return 0;
        
        //This above code can also be replaced with
        
        // return o1.compareTo(o2); // This represents default natural sorting order
        
        // return -o1.compareTo(o2) ; // This represent ascending order
        
        // return +1 ; // will return insertion order and place the elements after
        
        // return -1; // will return reverse of insertion order and place the 
        // elements before
        
        // return 0; // will allow only one element to be inserted and rest will 
        // be marked duplicate hence nothing else will be inserted.
        
        //
    }

}
