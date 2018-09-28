package threadgroup.understanding;

//Thread Local Understanding

//Thread local can be used to define thread scope. That is local variables with respect to that thread
//It provides thread local variables
//It maintains values per thread basis.
//Each thread local object maintains a seperate value like user id/ transaction id etc for each thread
//that accesses that object
//Thread can access it's local value, can manipulate it's value and even can remove it's value
//In every part of the code which is executed by the thread we can access it's local variable
//
//Example: Consider a servlet which invokes some business methods. We have a requirement to generate 
//a unique transaction id for each and every record. 
//And we have to pass this transaction id to the business method. For this requirement we can use thread
//local to maintain a seperate transaction id for every request

//Thread local hence is used to define thread scope variables

//It is introduced in 1.2v
//and enhanced in 1.5v
//It can be associated with thread scope.
//Total code which is eexecuted by the thread has access to corresponding thread local variables
//A thread can access it's own local variables and can't access other threads local variables.
//
public class ThreadLocalUnderstanding {

    public static void main(String[] args) {
        
        ThreadLocal tl = new ThreadLocal();
        System.out.println("Thread Local Get operation : " + tl.get());
        
        tl.set("xyzz");
        System.out.println("Thread Local Get operation : " + tl.get());
        tl.remove();
        System.out.println("Thread Local Get operation : " + tl.get());
        tl.remove();
        MyThread mt1 = new MyThread ("A");
        MyThread mt2 = new MyThread ("B");
        MyThread mt3 = new MyThread ("C");
        mt1.start ();
        mt2.start ();
        mt3.start ();
    }

}

class MyThread extends Thread {
    private static ThreadLocal tl = new ThreadLocal() {
        protected synchronized Object initialValue() {
            return new Integer(sernum++);
        }
    };
    private static int sernum = 100;

    MyThread(String name) {
        super(name);
    }

    public void run() {
        for (int i = 0; i < 10; i++)
            System.out.println(getName() + " " + tl.get());
    }
}