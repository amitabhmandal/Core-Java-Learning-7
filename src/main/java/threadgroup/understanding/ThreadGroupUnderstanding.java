package threadgroup.understanding;

//https://docs.oracle.com/javase/7/docs/api/java/lang/ThreadGroup.html

///https://www.geeksforgeeks.org/java-lang-threadgroup-class-java/
//https://www.tutorialspoint.com/java/lang/java_lang_threadgroup.htm
//https://www.javatpoint.com/threadgroup-in-java
//https://stackoverflow.com/questions/1323408/get-a-list-of-all-threads-currently-running-in-java
//http://nadeausoftware.com/articles/2008/04/java_tip_how_list_and_find_threads_and_thread_groups#Gettingalistofallthreads
//https://stackoverflow.com/questions/47611884/how-to-get-a-the-name-of-the-threadgroup-a-current-thread-is-in
//https://stackoverflow.com/questions/46959700/displaying-all-thread-groups-and-threads-currently-running-in-jvm
//https://stackoverflow.com/questions/15624296/how-to-find-and-stop-all-currently-running-threads
//http://nadeausoftware.com/articles/2008/04/java_tip_how_list_and_find_threads_and_thread_groups
//

//IMPORTANT POINTS
// 1. Thread group is a java class present in java.lang package
// 2. It is direct child class of Object class
// 3. A group of threads is called thread group which is based on functionality we can group 
//    threads into a single unit.
//    Advantage of grouping thread is that we can do thread management very easily. Thus common
//    operations becomes very easy. That is for example, set the maxPriority of all the sub 
//    group threads very easily.
//    Thread group can also contain sub-thread groups
// 4. Every thread in java belongs to some thread group
// 5. Basic of thread Group 
//    At the top of the figure's structure is the system thread group. The JVM-created system 
//    group organizes JVM threads that deal with object finalization and other system tasks, 
//    and serves as the root thread group of an application's hierarchical thread-group 
//    structure. Just below system is the JVM-created main thread group, which is system's 
//    subthread group (subgroup, for short). main contains at least one thread—the JVM-created 
//    main thread that executes byte-code instructions in the main() method.
//    
//    Below the main group reside the subgroup 1 and subgroup 2 subgroups, 
//    application-created subgroups (which the figure's application creates). 
//    Furthermore, subgroup 1 groups three application-created threads: thread 1, thread 2, 
//    and thread 3. In contrast, subgroup 2 groups one application-created thread: my thread.
//
//    
public class ThreadGroupUnderstanding {

    public static void main(String[] args) {

        // Main method
        // Main thread
        // Main thread Group

        // main method is called by main thread. Main thread belongs to main group

        // In java Every group is a child of System group either directly or indirectly

        // System group contains several system level threads like finalizer aka garbage collector thread,
        // reference handler thread , signal dispatcher thread
        //
        System.out.println("Current Thread Group : " + Thread.currentThread()
            .getThreadGroup());
        System.out.println("Current Thread Parent Group : " + Thread.currentThread()
            .getThreadGroup()
            .getParent()
            .getName());

        System.out.println("Current Thread Parent Group Active Count: " + Thread.currentThread()
            .getThreadGroup()
            .getParent()
            .activeCount());

        System.out.println("Current Thread Parent Group Active Group Count: " + Thread.currentThread()
            .getThreadGroup()
            .getParent()
            .activeGroupCount());

        // Root is the system group

        // For the main thread group contains several threads such as main thread
        // etc

        // From the main thread group we can create sub thread group

        // Thread group is present in java.lang package
        // It is direct child class of object.

        // Constructors for ThreadGroup #Constructor ##1

        String name = "DummyGroup";
        // The parent group of DummyGroup will be the thread which is executing this line
        ThreadGroup g = new ThreadGroup(name);

        // Parent thread group of DummyGroup is main since the main thread is executing this line
        System.out.println("Parent thread group of DummyGroup is  " + g.getParent()
            .getName());

        // Constructors for ThreadGroup #Constructor ##2
        String secondName = "DummySecondGroup";

        // This constructor defines the name of the
        ThreadGroup g1 = new ThreadGroup(g, secondName);
        System.out.println("Parent thread group of DummySecondGroup is  " + g1.getParent()
            .getName());

        // activeCount demo
        // Returns an estimate of the number of active threads in this thread group and its subgroups.
        // Recursively iterates over all subgroups in this thread group.

        // The value returned is only an estimate because the number of threads may change
        // dynamically while this method traverses internal data structures, and might be affected
        // by the presence of certain system threads. This method is intended primarily for
        // debugging and monitoring purposes.

        ThreadGroup gfg = new ThreadGroup("parent thread group");

        ActiveCountDemo t1 = new ActiveCountDemo("one", gfg);
        System.out.println("Starting one");
        ActiveCountDemo t2 = new ActiveCountDemo("two", gfg);
        System.out.println("Starting two");

        // checking the number of active thread
        System.out.println("number of active thread: " + gfg.activeCount());

        // activeGroupCount demo
        // Returns an estimate of the number of active groups in this thread group and its subgroups.
        // Recursively iterates over all subgroups in this thread group.
        // The value returned is only an estimate because the number of thread groups may change
        // dynamically while this method traverses internal data structures.
        // This method is intended primarily for debugging and monitoring purposes.

        ThreadGroup gfg_child = new ThreadGroup(gfg, "child");

        ActiveGroupCountDemo t11 = new ActiveGroupCountDemo("one", gfg);
        System.out.println("Starting one");
        ActiveGroupCountDemo t21 = new ActiveGroupCountDemo("two", gfg);
        System.out.println("Starting two");

        // checking the number of active thread
        System.out.println("number of active thread group: " + gfg.activeGroupCount());
        maxPriorityDemo();
    }

    public static void maxPriorityDemo() {
        System.out.println("Displaying max priority demo start");
        ThreadGroup tg = new ThreadGroup("A");
        System.out.println("tg maximum priority = " + tg.getMaxPriority());
        Thread t1 = new Thread(tg, "X");
        System.out.println("t1 priority = " + t1.getPriority());
        t1.setPriority(Thread.NORM_PRIORITY + 1);
        System.out.println("t1 priority after setPriority() = " + t1.getPriority());
        tg.setMaxPriority(Thread.NORM_PRIORITY - 1);
        System.out.println("tg maximum priority after setMaxPriority() = " + tg.getMaxPriority());
        System.out.println("t1 priority after setMaxPriority() = " + t1.getPriority());
        Thread t2 = new Thread(tg, "Y");
        System.out.println("t2 priority = " + t2.getPriority());
        t2.setPriority(Thread.NORM_PRIORITY);
        System.out.println("t2 priority after setPriority() = " + t2.getPriority());
        System.out.println("Displaying max priority demo end");
    }

}

class ActiveGroupCountDemo extends Thread {
    ActiveGroupCountDemo(String threadname, ThreadGroup tgob) {
        super(tgob, threadname);
        start();
    }

    public void run() {

        for (int i = 0; i < 1000; i++) {
            try {
                Thread.sleep(10);
            } catch (InterruptedException ex) {
                System.out.println("Exception encounterted");
            }
        }
        System.out.println(Thread.currentThread()
            .getName() + " finished executing");
    }
}

class ActiveCountDemo extends Thread {
    ActiveCountDemo(String threadname, ThreadGroup tgob) {
        super(tgob, threadname);
        start();
    }

    public void run() {

        for (int i = 0; i < 1000; i++) {
            try {
                Thread.sleep(10);
            } catch (InterruptedException ex) {
                System.out.println("Exception encounterted");
            }
        }
    }
}
