package collection.learning.set;

import java.util.Comparator;
import java.util.Iterator;
import java.util.TreeSet;

public class TreeSetInsertionOrderPreserveDemo {

    public static void main(String[] args) {
        MyComparator comparator = new MyComparator();
        
        TreeSet<Student> set = new TreeSet<Student>(comparator);
        set.add(new Student(121, "Santosh", 85));
        set.add(new Student(231, "Cherry", 71));
        set.add(new Student(417, "David", 82));
        set.add(new Student(562, "Praveen", 91));
        set.add(new Student(231, "Raj", 61));         //Duplicate element
        set.add(new Student(458, "John", 76));
        set.add(new Student(874, "Peter", 83));
        set.add(new Student(231, "Hari", 52));       //Duplicate element
        set.add(new Student(568, "Daniel", 89));
      //Iterating through TreeSet
        
        Iterator<Student> it = set.iterator();
         
        while (it.hasNext())
        {
            System.out.println(it.next());
        }

    }

}

class Student {
    int id;

    String name;

    int perc_Of_Marks_Obtained;

    public Student(int id, String name, int perc_Of_Marks_Obtained) {
        this.id = id;

        this.name = name;

        this.perc_Of_Marks_Obtained = perc_Of_Marks_Obtained;
    }

    @Override
    public String toString() {
        return id + " : " + name + " : " + perc_Of_Marks_Obtained;
    }
}

class MyComparator implements Comparator<Student>
{
    @Override
    public int compare(Student s1, Student s2)
    {
        
        //Only one insertion allowed
        return 0;
        
        //reverse insertion order
        //return -1;
        
        //preserving insertion order
        //return +1;
        
        /*
        if(s1.id == s2.id)
        {
            return 0;
        }
        else
        {
            return s2.perc_Of_Marks_Obtained - s1.perc_Of_Marks_Obtained;
        }*/
        
    }
}