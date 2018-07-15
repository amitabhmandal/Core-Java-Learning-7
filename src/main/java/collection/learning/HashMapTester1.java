package collection.learning;

import java.util.HashMap;

public class HashMapTester1 {

    public static void main(String[] args) {
        String a = "1";
        String b = "11";
        
        HashMap<String, String> hashMap = new HashMap<String, String>();
        System.out.println(hashMap.put(a, "one"));
        System.out.println(hashMap.put(b, "two"));
        
        
        String c= new String ("1");
        String d= new String ("1");
        
        System.out.println(hashMap.put(c, "three"));
        System.out.println(hashMap.put(d, "four"));
        
        
        System.out.println("Final : " + hashMap);
       
        
        

    }

    public static void hashMapDemoWhenEqualsContractNotImplemented() {
        // TODO Auto-generated method stub
        
    }

}
