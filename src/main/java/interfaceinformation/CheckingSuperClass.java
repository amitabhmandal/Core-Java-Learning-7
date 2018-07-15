package interfaceinformation;

import java.lang.reflect.Method;

public class CheckingSuperClass {

    public static void main(String[] args) {
        String str = new String("Hi");
        Class strClass = str.getClass();
        System.out.println("Super class of String: " + strClass.getSuperclass());

        Object obj = new Object();
        Class objClass = obj.getClass();
        System.out.println("Super class of Object: " + objClass.getSuperclass());

        Class classClass = objClass.getClass();
        System.out.println("Super class of Class: " + classClass.getSuperclass());
        
        System.out.println("Information about Interface : " );
        
        Method[] methods =  hello.class.getDeclaredMethods();
        System.out.println("Methods found : " + methods.length);
        
        for(Method m : methods) {
            System.out.println();
        }
        
        hello e1 = new helloWorld();
        hello e2 = new helloWorld();
        System.out.println(e1.equals(e2));

    }

}


interface hello {
    
    void display();
    
}

class helloWorld implements hello{

    @Override
    public void display() {
        // TODO Auto-generated method stub
        
    }
    
}