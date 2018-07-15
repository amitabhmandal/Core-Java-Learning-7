package learning.thread;

/*@@@@@@@@@@@@@@@@@@@@@@@@@@
 * CASE 1: Thread Scheduler:
 *@@@@@@@@@@@@@@@@@@@@@@@@@@
 * Role of thread scheduler is to execute the thread.
 * If multiple threads are waiting in the JVM then some sort of scheduling needs to happen to execute the
 * threads which is done by thread scheduler.
 * We are not sure of thread execution order followed by thread scheduler. it Is varied from JVM to JVM.
 * 
 * Hence we cannot expect thread execution order every time order be the same for every run. 
 * 
/*@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@
 * CASE 2: Difference between t.start() and t.run():
 *@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@
 * If t.start() then a seperate thread is created and JVM will be calling the run method.
 * 
 * If t.run() then new thread will NOT be created and the run method will be called just like a normal method run.
 * 
 * 
/*@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@
 * CASE 3: Why thread class needs to start method:
 *@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@
 * Register the thread with Thread scheduler
 * Perform mandatory activities
 * Invoke Run method
 * 
 * Point #1
 * Each thread starts in a separate call stack.
 * Invoking the run() method from main thread, the run() method goes onto the current 
 * call stack rather than at the beginning of a new call stack.
 * 
 * Hence the main thread will be waiting for the run method to get completed as it is 
 * executing in the same thread whereas if thread.start() is called then this new
 * thread will be executed asynchronously and the main thread will not have to wait
 * for it to get over.
 * 
 * Point #2
 * MOREOVER BY CALLING THE START METHOD WE ARE CHANGING THE THREAD STATE FROM 
 * NEW TO RUNNABLE WHICH IS AN INDICATION TO JVM TO START EXECUTING IT.
 * 
 * Point #3.
 * We can call run method as many times as you want.
 * However if we call start method more than once then it will throw 
 * IllegalStateException
 * 
 * 
/*@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@
 * CASE 4: Overloading of run method:
 *@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@
 * Overloading of run method is always possible as shown in the example
 * However JVM will always be calling the public void run() for execution
 * 
 * 
/*@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@
 * CASE 5: No run method exists:
 *@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@
 *If we are not over-riding run method then JVM checks whether 
 *the class has provided a run method or not.
 *
 *If no run method then thread class run method will be executed.
 *However thread class run method does not provide any implementation 
 *hence nothing would happen and no thread execution as intended will not happen.
 *
/*@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@
 * CASE 6: Over-riding start method:
 *@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@
 * If we over-ride start method then over-ridden start method will be called.
 * System will not take part in thread creation as no registration of thread
 * information happens with the thread scheduler hence thread concepts will not
 * come into play.
 * 
 * Thus thread API will not come into play
 * 
/*@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@
 * CASE 7: Over-riding start method:
 *@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 */

public class ThreadInstantiation {

    public static void main(String[] args) {

        System.out.println("Main thread starting");
        // Main thread creates child thread + Thread instantiation
        FirstOption firstOption = new FirstOption();

        // Main thread starting child thread
        firstOption.start();

        System.out.println("Main thread executing");
        // Main thread will continue to execute the code and child thread will branch out
        for (int i = 0; i < 10; i++) {
            System.out.println("Main Thread = " + i);
        }
        System.out.println("Main thread finished executing");
        System.out.println("Inside Main Thread Validating name: " + Thread.currentThread()
            .getName());
        // Inside Main Thread Validating name: main

        Thread t = new Thread(new SecondOption());
        System.out.println("Second thread executing");
        t.start();
        System.out.println("Thread state of Second Thread : " + t.getState());

        OverridingStart o = new OverridingStart();
        o.start();

        /*@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@
         * Rule about Using Start method.
         * @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@
         * It cannot be called multiple times for calling as it is not a legal operation
         * 
         * If we start the method is called multiple times then it will
         * result in java.lang.IllegalThreadStateException
         * 
         * When we use the method start() then following things happen
         * 
         * 1. Causes this thread to begin execution;
         * 2. the Java Virtual Machine calls the run method of this thread
         * 3. The result is that two threads are running concurrently, the current thread
         *    which returns from the call to the start() and the other method which executes
         *    it's run method.
         * 4. In particular, a thread may not be restarted once it has completed
         * 5. This method is not invoked for the main method thread or "system" 
         *    group threads created/set up by the VM.
         * 6. If multiple times start method is called then it throws IllegalStateException because
         *    it checks the status of thread and if it is not a new state.
         *         
         */

    }

}

// Defining a thread
class FirstOption extends Thread {

    // Code within the run method is called Job of a thread
    public void run() {
        System.out.println("Child thread executing");
        for (int i = 0; i < 10; i++) {
            System.out.println("Child Thread = " + i);
        }
        System.out.println("Child Thread finished executing");
        System.out.println("Inside Child Thread Validating name: " + Thread.currentThread()
            .getName());
        // Inside Child Thread Validating name: Thread-0

    }
}

class SecondOption implements Runnable {

    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            System.out.println("Child Thread Second Option = " + i + " " + Thread.currentThread()
                .getName());
        }
        System.out.println("Finished second thread executing");
    }

}

// Overloading run method example:
class OverloadingRun extends Thread {
    public void run() {
        System.out.println("public void run() No Arg method");
        for (int i = 0; i < 10; i++) {
            System.out.println("Child Thread = " + i);
        }
        System.out.println("Inside Child Thread Validating name: " + Thread.currentThread()
            .getName());
        // Inside Child Thread Validating name: Thread-0

    }

    public void run(int a) {
        System.out.println("public void run(int i) thread executing");
        for (int i = 0; i < 10; i++) {
            System.out.println("Child Thread = " + i);
        }
        System.out.println("Inside Child Thread Validating name: " + Thread.currentThread()
            .getName());
        // Inside Child Thread Validating name: Thread-0

    }
}

class OverridingStart extends Thread {
    public void start() {
        System.out.println("Over-riding start method called " + Thread.currentThread().getName());
    }

    public void run() {
        System.out.println("Over-riding run method called  " + Thread.currentThread().getName());
    }
}