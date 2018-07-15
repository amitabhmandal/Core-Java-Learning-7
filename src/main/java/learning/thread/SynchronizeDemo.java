package learning.thread;
/* =======================================
 * Rule #1 : Synchronize Applicable Where 
 * =======================================
 * It is applicable for methods and blocks.
 * Not applicable for classes and variables
 * 
 * If multiple threads are trying to operate simultaenously on the same Java object
 * then there might be a chance of data inconsistency problem.
 * 
 * To overcome this problem we should go for synchronized keyword.
 * 
 * If synchronized is applicable then only one thread is allowed to execute
 * on a method or block so that data inconsistency problem will be resolved.
 * 
 * 
/* ==============================================
 * Rule #2 : Synchronize Advantages/Disadvantages 
 * ==============================================
 * Advantage: We can overcome data inconsistency problem
 * Disadvantage: It increases waiting time of threads and creates performance problems
 * Hence if there is no specific requirement then synchronize keyword should not be used.
 * 
 * 
/* ====================================
 * Rule #3 : Synchronize : How it works
 * ====================================
 * Every object in java has a lock.
 * 
 * To execute the synchronize method it needs to obtain a lock.
 * Once the thread finishes the execution then the lock is released.
 * 
 * Acquiring and Releasing the lock will automatically done by JVM.
 * 
 * 
/* ============================================================
 * Rule #4 : Synchronize : Sync Method calling Non Sync Methods
 * ============================================================
 * 
 * 
/* ============================================================
 * Rule #5 : Synchronize : Re-entrant
 * ============================================================
 * java synchronized keyword is re-entrant in nature it means if a java synchronized method calls another synchronized 
 * method which requires same lock then current thread which is holding lock can enter into that method without acquiring 
 * lock
 * 
/* ============================================================
 * Rule #6 : Synchronize : Null Pointer Exception
 * ============================================================ 
 * Java Synchronization will throw NullPointerException if object used in java synchronized block is null. 
 * For example, in above code sample if lock is initialized as null, the synchronized (lock) will throw NullPointerException
 * 
 * 
/* ========================================================================
 * Rule #6 : Synchronize : Static Methods + Non Static Methods Concurrently
 * ========================================================================
 * It’s possible that both static synchronized and non static synchronized method can run simultaneously or concurrently
 *  because they lock on different object
 *  
/* ========================================================================
 * Rule #8 : Synchronize : Usage with constructor Illegal
 * ========================================================================
 * According to the Java language specification you can not use java synchronized keyword with constructor it’s illegal and 
 * result in compilation error.
 * 
/* ========================================================================
 * Rule #9 : Synchronize : Usage with constructor Illegal
 * ========================================================================
 * Do not synchronize on non final field on synchronized block in Java. because reference of non 
 * final field may change any time and then different thread might synchronizing on different objects i.e. 
 * no synchronization at all. Best is to use String class, which is already immutable and declared final.
 * 
/* ========================================================================
 * Rule #9 : Synchronize : Primitive arguments
 * ======================================================================== 
 * int x =10;
 * synchronized(x) {
 * }
 * Will result into compilation error.
 * Hence synchronized allows object level or class level.
 * 
/* ===========================================================================
 * Rule #9 : Synchronize : can a thread acquire multiple locks simultaneously
 * ===========================================================================
 * 
 * 
/* ===========================================================================
 * Rule #9 : Synchronize : Block vs Method level synchronization
 * =========================================================================== 
 * #1
 * One significant difference between synchronized method and block is that, Synchronized block generally reduce scope of lock. 
 * As scope of lock is inversely proportional to performance, its always better to lock only critical section of code. 
 * One of the best example of using synchronized block is double checked locking in Singleton pattern where 
 * instead of locking whole getInstance() method we only lock critical section of code which is used to create Singleton instance. 
 * This improves performance drastically because locking is only required one or two times.
 * 
 * #2
 * Synchronized block provide granular control over lock, as you can use arbitrary any lock to provide mutual 
 * exclusion to critical section code. On the other hand synchronized method always lock either on current object 
 * represented by this keyword  or class level lock, if its static synchronized method.
 * 
 * #3
 *  Synchronized block can throw throw java.lang.NullPointerException if expression provided to block as parameter
 *   evaluates to null, which is not the case with synchronized methods
 * 
 * #4
 * In case of synchronized method, lock is acquired by thread when it enter method and released when it leaves method, 
 * either normally or 
 * by throwing Exception. On the other hand in case of synchronized block, thread acquires lock 
 * when they enter synchronized block and release when they leave synchronized block.
 * 
 * 
 */

public class SynchronizeDemo {

    public static void main(String[] args) {
        // TODO Auto-generated method stub

    }

}

class Counter {
    private int c = 0;

    public void increment() {
        c++;
    }

    public void decrement() {
        c--;
    }

    public int value() {
        return c;
    }

}
