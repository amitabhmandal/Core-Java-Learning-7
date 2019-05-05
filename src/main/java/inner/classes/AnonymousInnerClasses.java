package inner.classes;

// IMPORTANT POINTS ABOUT ANONYMOUS INNER CLASSES

// It is an inner class without a name and for which only a single object is created.

// WHERE IT SHOULD BE USED 

// An anonymous inner class can be useful when making an instance of an object with 
// certain “extras” such as overloading methods of a class or interface, without having 
// to actually subclass a class.

// Anonymous inner class are mainly created in two ways:

// option 1 : Class (may be abstract or concrete)
// option 2 : Interface

// 

public class AnonymousInnerClasses {

    public static void main(String[] args) {
        // TODO Auto-generated method stub

    }

}

// Types of anonymous Inner classes
// Type 1: Using Anonymous Inner class that extends a Class
class FirstTypeAnonymousInnerClass {

    public void getThread() {
        Thread t = new Thread() {
            public void run() {
                System.out.println("Child Thread");
            }
        };
        t.start();
        System.out.println("Main Thread");
    }

}

//Types of anonymous Inner classes
//Type 2: Using Anonymous Inner class that implements a interface
class SecondTypeAnonymousInnerClass {
    public void getThread() {
        Runnable r = new Runnable() 
        { 
            public void run() 
            { 
                System.out.println("Child Thread"); 
            } 
        }; 
        Thread t = new Thread(r); 
        t.start(); 
        System.out.println("Main Thread");
    }
    
}

//Types of anonymous Inner classes
//Type 3: Anonymous Inner class that defines inside method/constructor argument
class ThirdTypeAnonymousInnerClass {
    public void getThread() {
        Thread t = new Thread(new Runnable() 
        { 
            public void run() 
            { 
                System.out.println("Child Thread"); 
            } 
        }); 
          
        t.start(); 
          
        System.out.println("Main Thread"); 
    }
    
}
