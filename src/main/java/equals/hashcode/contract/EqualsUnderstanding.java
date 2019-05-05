package equals.hashcode.contract;

public class EqualsUnderstanding {
    public static void main(String[] args) {
        
        // == operator meant for reference comparison OR address comparison
        // equals method meant for content comparison
        
        String s1 = new String("abc"); // new address space created
        String s2 = new String("xyz");
        String s3 = new String("xyz");
        String s4 = "xyz";
        String s5 = "xyz";
        System.out.println("s1 == s2 " + s1 == s2);
        System.out.println("s1.equals(s2) " + s1.equals(s2));
        System.out.println("s2.equals(s3) " + s2.equals(s3));
        System.out.println("s2 == s3 " + s2 == s3);
        System.out.println("s4 == s5 " + s4 == s5);
        System.out.println("s4.equals(s5) " + s4.equals(s5));
        
        // == operator comparison with null is always false
        
        System.out.println("s1 == null " + (s1 == null));
        
        // null == null comparison results in always true
        System.out.println( "null == null " + (null == null));
        
        // equality operators can be applied everywhere 
        // boolean
        // primitives
        // objects conditions [ there should be some relation 
        // between reference type else it will result in compile time error]
        
        
        //******************************************************************
        // EQUALS METHOD
        //******************************************************************
        //Equals method present in the object class is meant for reference comparison 
        // if we want to content comparison then we need to over-ride the method in the child class.
        
        
        // When do we need to override equals method?
        // It is when a class has a
        // notion of logical equality that differs from mere object identity and a
        // superclass has not already overridden equals.
        
        // What is a value classes
        // Value classes are classes which represent some values such as Integer or String.
        // Over here when we want to check
        
        // A programmer who compares references to value
        // objects using the equals method expects to find out whether they are
        // logically equivalent, not whether they refer to the same object
        
        //******************************************************************
        // EQUALS METHOD RELATION WITH REFERENCE OPERATOR
        //******************************************************************
        
        // CASE 1: IF R1 == R2 is TRUE then R1.equals(R2) is always TRUE
        // CASE 2: IF R1 == R2 is FALSE then R1.equals(R2) maybe true(when equals method has been overridden) and 
        //         FALSE when equals method has not been overridden
        // CASE 3: IF R1.equals(R2) is TRUE then R1 == R2 maybe true (if equals method had not been overridden) and 
        //         false if not overridden
        // CASE 4: IF R1.equals(R2) false then R1 == R2 is always FALSE
        
        StringBuffer sb1 = new StringBuffer("1");
        StringBuffer sb2 = new StringBuffer("1");
        String str1 = new String ("1");
        System.out.println("str1.equals(sb1) " + str1.equals(sb1)); 
        
        //INTERESTING CONCLUSION WHEN COMPARED WITH NULL BOTH == operator and equals method will return null
        System.out.println("sb1 == null " + (sb1 == null));
        System.out.println("sb1.equals(null) " + sb1.equals(null));
        
        //When we want to use == operator then the reference type must have some sort of relation 
        // either R1 or R2 must be of same type
        // either R1 must be parent of R2
        // either R1 must be child of R2 
        // else it will result in compilation error ie incomparable types.
        
        String s11 = new String("amitabh");
        String s21 = new String("amitabh");
        
        System.out.println( "s11.equals(s21) " + s11.equals(s21) );
        System.out.println( "s11.hashCode() == s21.hashCode() " + (s11.hashCode() == s21.hashCode() ));
        
        //Thus from the above we can conclude that the equals and hashcode methods have been overridden in the case
        //of string for content comparison
        
        StringBuffer sb11 = new StringBuffer("amitabh");
        StringBuffer sb21 = new StringBuffer("amitabh");
        
        System.out.println( "sb11.equals(s21) " + sb11.equals(sb21) );
        System.out.println( "sb11.hashCode() == sb21.hashCode() " + (sb11.hashCode() == sb21.hashCode() ));
        
        // Thus from the above we can conclude that the equals method is not overridden for content comparison 
        // and hashcode methods has also not been overridden in the case
        // of string for content comparison
    }

}
