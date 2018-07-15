package learning.thread;

import java.util.ArrayList;
import java.util.Arrays;

/*
 * INTERPROCESS COMMUNICATION BETWEEN TWO THREADS 
 * IS DONE BY THE FOLLOWING 3 METHODS
 * 
 * WAIT / NOTIFY / NOTIFYALL
 * 
 *@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@
 * Rule # Two Threads can communicate with each other by using wait/notify/notifyAll
 *@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@
 * Two threads can communicate with each other by using
 * notify() - Wakes up the single thread that is waiting on this object's monitor.
 *      
 * wait() - Tells the current thread to release the lock and go to sleep until some other thread 
 * enters the same monitor and calls notify()
 * 
 * notifyAll() - It wakes up all the threads that called wait() on the same object.
 * 
 * 
 *@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@
 * Rule # Who calls which method
 *@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@
 * Thread who is responsible to receive the update needs to call wait method.
 * Then the thread will enter into waiting state
 * 
 * The thread which is responsible to perform updates, after performing 
 * update it is responsible to call notify method. Then the waiting thread
 * will get the notification and continue with it's execution with those updated items.
 * 
 *@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@
 * Rule # Why notify, notifyAll and wait method present in Object class
 *@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@
 * Object class is correct place to make them available for every object if this 
 * mechanism is not 
 * available via any java keyword like synchronized.
 * 
 * In Java in order to enter critical section of code, Threads needs lock and they wait for lock, 
 * they don't know which threads holds lock instead they just know the lock is hold by some 
 * thread and they should wait for lock instead of knowing which thread is inside the 
 * synchronized block and asking them to release lock. this analogy fits with wait and 
 * notify being on object class rather than thread in Java.
 * 
 * ence, wait() and notify() methods are defined in Object class rather than Thread class.
 * If wait() and notify() were on the Thread instead then each thread would have to know the 
 * status of every other thread and there is no way to know thread1 that thread2 was waiting for 
 * any resource to access.Hence, notify, wait, notifyAll methods are defined in object class in Java.
 * 
 * 
 * 
 * Real Time Example
 * Suppose there is a joint bank account and hence multiple users can use the same account for 
 * transactions through multiple channels.Currently, the account having a balance of 1500/- and 
 * minimum amount balance to remain in the account is 1000/-.Now, the first user is trying to 
 * withdraw an amount of 500/- through ATM and another user is trying to purchase any goods worth 
 * 500/- through swipe machine.Here whichever channel first access the account to perform the 
 * transaction acquires the lock on the account at first and the other channel will wait until 
 * the transaction is completed and the lock on the account is released as there is no way to
 *  know which channel has already acquired the lock and which channel is waiting to acquire a 
 *  lock. Hence lock is always applied on the account itself rather than a channel.Here, we 
 *  can treat account as an object and channel as a thread.

 * Hence we can conclude as :
 * 1. wait() method tells the current thread to release the lock and go to sleep until some 
 * other thread enters the same monitor and calls notify().
 * 2. notify() wakes up the single thread that is waiting on this object's monitor.
 * 3. Acquiring a monitor allows a thread to hold lock on an object and an object has a monitor rather than a Thread.
 * 
 * 
 * Locks are different from threads. The lock is on the data structure being protected. 
 * The threads are the things accessing the data structure. The locks are on the data structure object
 * in order to keep the threads from accessing the data structure in an unsafe way.
 * 
 * Any object can be used as an intrinsic lock (meaning used in conjunction with synchronized). 
 * This way you can guard access to any object by adding the synchronized modifier to the methods 
 * that access the shared data. (Not that it's a good idea, because that allows any thread that can 
 * access the object to acquire its lock, even if it's not calling any methods on it; it's better to 
 * keep the lock as a private member of the data structure being locked, so that access to it is limited.)
 * 
 * wait and notify are called on objects that are being used as locks. The lock is a shared communication point:
 * 
 * When a thread that has a lock calls notifyAll on it, the other threads waiting on that same lock get notified.
 *  When a thread that has a lock calls notify on it, one of the threads waiting on that same lock gets notified.
 *  
 *  
 * When a thread that has a lock calls wait on it, the thread releases the lock and goes dormant until
 *  either a) it receives a notification, or b) it just wakes up arbitrarily (the "spurious wakeup"); 
 *  the waiting thread remains stuck in the call to wait until it wakes up due to one of these 2 reasons, 
 *  then the thread has to re-acquire the lock before it can exit the wait method. 
 *
 *@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@
 * Rule # Difference between synchronize and IPC
 *@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@
 *Synchronized is to provide mutual exclusion and ensuring thread safety of Java 
 *class like race condition.
 * wait and notify are communication mechanism between two thread.
 *
 *
 *@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@
 * Rule # Rules to call Wait/Notify/NotifyAll on any object
 *@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@     
 * If a thread wants to call a wait method on any object then it should be following these
 * rules
 * 1. The thread should be the owner of the object ie 
 * 3. the thread should have lock of that object
 * 2. That is the thread should be inside the synchronized area
 * 
 * Thereby wait, notify and notifyAll we can inside the synchronized area.
 * 
 * If we are not within the synchronized block or synchronized area
 * and call either wait/ notify or notifyAll method 
 * then immediately
 * we are going to get RunTimeException stating 
 * IllegalMonitorStateException.
 *
 *@@@@@@@@@@@@@@@@@@@@@@@@@@@@
 * Rule # What happens when wait is called on object
 *@@@@@@@@@@@@@@@@@@@@@@@@@@@@
 * The following things happen when a thread calls wait() method on any object
 * 1. It immediately releases that particular object
 * 2. It then enters in the WAITing status
 * 3. 
 *
 *
 *@@@@@@@@@@@@@@@@@@@@@@@@@@@@
 * Rule # Method Releases Lock
 *@@@@@@@@@@@@@@@@@@@@@@@@@@@@
 * If a thread calls notify method on any object, it releases the lock of that object
 * but may not immediately.
 * 
 * Except wait, notify and notifyAll there is no other method where thread releases
 * the lock.
 * 
 * Method Name  | Releases Lock
 * yield()      | No
 * sleep()      | No
 * join()       | No
 * wait()       | Yes
 * notify()     | Yes
 * notifyAll()  | Yes
 * 
 *@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@
 * Rule # Wait method is Overloaded in Object Class
 *@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@
 * 
 * Whenever thread is in waiting state then some other thread may interrupt hence it throws IE Exception.
 *
 * public final native void wait(long timeout) throws InterruptedException;
 * 
 * public final void wait(long timeout, int nanos) throws InterruptedException
 * 
 * public final void wait() throws InterruptedException
 * 
 *
 *@@@@@@@@@@@@@@@@@@@@@@@@@@@@
 * Rule # notifyAll method signature
 *@@@@@@@@@@@@@@@@@@@@@@@@@@@@
 * public final native void notifyAll();
 * 
 *
 *@@@@@@@@@@@@@@@@@@@@@@@@@@@@
 * Rule #  notify method signature
 *@@@@@@@@@@@@@@@@@@@@@@@@@@@@
 * public final native void notify();
 * 
 *@@@@@@@@@@@@@@@@@@@@@@@@@@@@
 * Rule #
 *@@@@@@@@@@@@@@@@@@@@@@@@@@@@
 *
 *
 *
 *
 *
 *
 */

public class InterProcessCommunication {

    public static void main(String[] args) throws Exception {
        WaitingNotifyDemo waitingNotifyDemo = new WaitingNotifyDemo();
        // waitingNotifyDemo.start();

        // Over here the sum output can be anything from 0 to 4950 because main thread completes it execution before
        // waitingNotifyDemo gets to get it run method completed.

        // Hence to fix this problem we can use the following options
        // 1. sleep
        // 2. join

        // #1
        // Bad Programming practice hence sleep should not be used
        // Thread.sleep(10000);

        // #2
        // join method is being executed in the main flow hence main thread would enter into wait state unless
        // This is also not recommended as the main method is just waiting for sum of all variables.
        // However if the run method starts executing something else after the running the for loop then
        // main method would have to sit for that to get it completed. Hence join() is also not recommended option.
        // waitingNotifyDemo execution gets completed.

        // waitingNotifyDemo.join();

        // if wait method is not written with synchronized block or method then it will result in the following exception
        /*
         * Exception in thread "main" java.lang.IllegalMonitorStateException
         * at java.lang.Object.wait(Native Method)
         * at java.lang.Object.wait(Object.java:503)
         * at learning.thread.InterProcessCommunication.main(InterProcessCommunication.java:202)
         */
        // waitingNotifyDemo.wait();
        System.out.println("Started = " + Thread.currentThread()
            .getName());
        System.out.println("Total Sum = " + waitingNotifyDemo.total);
        System.out.println("Ended = " + Thread.currentThread()
            .getName());

        // solve(new int[] {-4, 3 ,-9 ,0 ,4 ,1 });
        // staircase(6);
        miniMaxSum(new int[] {1, 2 ,3 ,4 ,5 });

    }

    static void solve(int[] arr) {
        int positive = 0, negative = 0, zero = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == 0) {
                zero++;
            } else if (arr[i] > 0) {
                positive++;
            } else if (arr[i] < 0) {
                negative++;
            }
        }
        System.out.println((double) positive / arr.length);
        System.out.println((float) negative / arr.length);
        System.out.println((float) zero / arr.length);

    }

    static void staircase(int n) {
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= (n - i); j++) {
                System.out.print(' ');
            }

            for (int j = 0; j < i; j++) {
                System.out.print("#");
            }
            System.out.println("");
        }
    }

    static void miniMaxSum(int[] arr) {

        long first = arr[1] + arr[2] + arr[3] + arr[4];
        long second = arr[0] + arr[2] + arr[3] + arr[4];
        long third = arr[0] + arr[1] + arr[3] + arr[4];
        long fourth = arr[0] + arr[1] + arr[2] + arr[4];
        long fifth = arr[0] + arr[1] + arr[2] + arr[3];

        long[] finalArray = { first, second, third, fourth, fifth };

        Arrays.sort(finalArray);
        System.out.println(Arrays.toString(finalArray));
        System.out.println(finalArray[0] + " " + finalArray[4]);

    }

}

class WaitingNotifyDemo extends Thread {
    int total = 0;

    public void run() {
        System.out.println("Started = " + Thread.currentThread()
            .getName());
        for (int i = 0; i < 100; i++) {
            total = total + i;
            // System.out.println(i);
            // this.notify();

        }
        System.out.println("Ended = " + Thread.currentThread()
            .getName());
    }
}
