package string.vs.stringbuffer.vs.stringbuilder;

public class StringVsStringBuffer {

    // StringObjects are immutable

    // StringBuffer is immutable

    public static void main(String[] args) {
        
        // CASE 1: IMMUTABILITY
        // Here we cannot use append
        String str = new String("Amitabh");
        // since strings are immutable objects hence using concat method does not change the original
        // reference variable str but creates a new reference variable
        // as the new reference variable is not being used for any other reference variable
        // hence it is elligible for garbage collection but the old reference variable
        //
        str.concat("mandal");
        // The concat method is only available in the String class and not in the String Buffer class
        System.out.println(str);

        // here we cannot use concat

        StringBuffer sb = new StringBuffer("Amitabh");
        // Here we are using append method which is present in the String Buffer class and not in the String class
        // so when append operation is performed then 
        // it changes the original sb reference variable
        // thus the new values are added to the original reference variable
        // 
        sb.append("mandal");
        System.out.println(sb);

        
        // CASE 2: .EQUALS METHOD vs == operator
        
        // == operator always meant for reference comparison
        
        // Object class equals method is always meant for reference comparison which is similar to address 
        // comparison which is same as the == operator
        
        // Object class equals method is overridden in the String class and not in the StringBuffer class
        // hence String class equals method is overridden for content comparison however the StringBuffer
        // equals method always uses the objects class equals method which defaults to reference comparisons
        
        String str1 = new String("Amitabh");
        String str2 = new String("Amitabh");
        
        System.out.println("Str1 == Str2 " + (str1 == str2)); // False
        System.out.println("str1.equals(str2) "+ str1.equals(str2)); // true
        
        StringBuffer sb1 = new StringBuffer("Amitabh"); 
        StringBuffer sb2 = new StringBuffer("Amitabh");
       
        System.out.println("sb1 == sb2 " + (sb1 == sb2)); // false
        System.out.println("sb1.equals(str2) "+ sb1.equals(sb2)); // false
        
        
        
    }

}
