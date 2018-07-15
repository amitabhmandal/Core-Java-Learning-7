package learning.thread;

/* public static enum Thread.State
extends Enum<Thread.State>
    A thread state. A thread can be in one of the following states:
    
    NEW
    A thread that has not yet started is in this state.
    
    RUNNABLE
    A thread executing in the Java virtual machine is in this state.
    
    BLOCKED
    A thread that is blocked waiting for a monitor lock is in this state.
    
    WAITING
    A thread that is waiting indefinitely for another thread to perform a particular 
    action is in this state.
    
    TIMED_WAITING
    A thread that is waiting for another thread to perform an action for up to a 
    specified waiting time is in this state.
    
    TERMINATED
    A thread that has exited is in this state.
 * 
 * 
 * 
 * 
 */

class MyThread extends Thread {
    boolean waiting = true;
    boolean ready = false;
    MyThread() {
    }
    public void run() {
       String thrdName = Thread.currentThread().getName();
       System.out.println(thrdName + " starting.");
       
       while(waiting) System.out.println("waiting:"+waiting);
       System.out.println("waiting...");
       startWait();
       try {
          Thread.sleep(1000);
       } catch(Exception exc) {
          System.out.println(thrdName + " interrupted.");
       }
       System.out.println(thrdName + " terminating.");
    }
    synchronized void startWait() {
       try {
          while(!ready) wait();
       } catch(InterruptedException exc) {
          System.out.println("wait() interrupted");
       }
    }
    synchronized void notice() {
       ready = true;
       notify();
    }
 }
 public class ThreadStateDemo {
    public static void main(String args[]) throws Exception {
       MyThread thrd = new MyThread();
       thrd.setName("MyThread #1");
       showThreadStatus(thrd);
       
       thrd.start();
       Thread.sleep(50);
       showThreadStatus(thrd);
       
       thrd.waiting = false;
       Thread.sleep(50);
       showThreadStatus(thrd);
       
       thrd.notice();
       Thread.sleep(50);
       showThreadStatus(thrd);
       
       while(thrd.isAlive())
       System.out.println("alive");
       showThreadStatus(thrd);
    }
    static void showThreadStatus(Thread thrd) {
       System.out.println(thrd.getName()+" Alive:"+thrd.isAlive()+" State:" + thrd.getState() );
    }
 }