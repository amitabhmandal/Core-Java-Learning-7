package comparator.comparable;

import java.util.Comparator;

import java.util.TreeSet;

// PENDING QUESTIONs: 
// Why equals method exists inside the Comparator interface?

// comparator present in java.util
// it defines two methods compare and equals
// int compare(T o1, T o2);

//compare method returns 
//-ve if o1 < o2 

// -ve means before
//0 if o1 == o2 
//+ve if o1 > o2

// +ve means after


// boolean equals(Object obj);
/* 65 - A , Z - 90 // 97 - a , 122 - z
Dec  Char                           Dec  Char     Dec  Char     Dec  Char
---------                           ---------     ---------     ----------
  0  NUL (null)                      32  SPACE     64  @         96  `
  1  SOH (start of heading)          33  !         65  A         97  a
  2  STX (start of text)             34  "         66  B         98  b
  3  ETX (end of text)               35  #         67  C         99  c
  4  EOT (end of transmission)       36  $         68  D        100  d
  5  ENQ (enquiry)                   37  %         69  E        101  e
  6  ACK (acknowledge)               38  &         70  F        102  f
  7  BEL (bell)                      39  '         71  G        103  g
  8  BS  (backspace)                 40  (         72  H        104  h
  9  TAB (horizontal tab)            41  )         73  I        105  i
 10  LF  (NL line feed, new line)    42  *         74  J        106  j
 11  VT  (vertical tab)              43  +         75  K        107  k
 12  FF  (NP form feed, new page)    44  ,         76  L        108  l
 13  CR  (carriage return)           45  -         77  M        109  m
 14  SO  (shift out)                 46  .         78  N        110  n
 15  SI  (shift in)                  47  /         79  O        111  o
 16  DLE (data link escape)          48  0         80  P        112  p
 17  DC1 (device control 1)          49  1         81  Q        113  q
 18  DC2 (device control 2)          50  2         82  R        114  r
 19  DC3 (device control 3)          51  3         83  S        115  s
 20  DC4 (device control 4)          52  4         84  T        116  t
 21  NAK (negative acknowledge)      53  5         85  U        117  u
 22  SYN (synchronous idle)          54  6         86  V        118  v
 23  ETB (end of trans. block)       55  7         87  W        119  w
 24  CAN (cancel)                    56  8         88  X        120  x
 25  EM  (end of medium)             57  9         89  Y        121  y
 26  SUB (substitute)                58  :         90  Z        122  z
 27  ESC (escape)                    59  ;         91  [        123  {
 28  FS  (file separator)            60  <         92  \        124  |
 29  GS  (group separator)           61  =         93  ]        125  }
 30  RS  (record separator)          62  >         94  ^        126  ~
 31  US  (unit separator)            63  ?         95  _        127  DEL
*/

public class ComparatorLearning {

    public static void main(String[] args) {
        Object[] array = new Object[3];
        array[0] = "a";
        array[1] = 1;
        array[2] = 4.555;
        for (Object a : array) {
            System.out.println(a);
        }
        // default natural sorting order is ascending order.
        defaultAscendingOrderTree();
        descendingOrderTree();

    }

    public static void descendingOrderTree() {
        TreeSet<Integer> treeSet = new TreeSet<Integer>(new DescendingOrderComparator());
        //TreeSet<Integer> treeSet = new TreeSet<Integer>();
        treeSet.add(10);
        treeSet.add(0);
        treeSet.add(15);
        treeSet.add(5);
        treeSet.add(10);
        treeSet.add(20);
        treeSet.add(11);
        treeSet.add(90);
        // Tree set default printing is left root right
        System.out.println("descendingOrderTree " + treeSet);
    }

    public static void defaultAscendingOrderTree() {
        TreeSet<Integer> treeSet = new TreeSet<Integer>();
        
        //Here JVM shall internally call the default compareTo method present within the Comparable interface present 
        // in java lang interface
        treeSet.add(10);
        treeSet.add(0);
        treeSet.add(15);
        treeSet.add(5);
        treeSet.add(10);
        treeSet.add(20);
        treeSet.add(11);
        treeSet.add(90);
        System.out.println("defaultAscendingOrderTree " + treeSet);

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
