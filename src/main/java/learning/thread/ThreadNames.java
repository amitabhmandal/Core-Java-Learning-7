package learning.thread;

public class ThreadNames extends Thread{

    public static void main(String[] args) {
       System.out.println(Thread.currentThread().getName());
       
       ThreadNames t1 = new ThreadNames();
       System.out.println(t1.getName());
       
       ThreadNames t2 = new ThreadNames();
       System.out.println(t2.getName());

    }

}
