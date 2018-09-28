package understanding.executor.framework;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

// IMPORTANT CONCEPTS ABOUT NAMING THREADS
// 1. WHY DO YOU WANT TO NAME THREADS?
//    BY default JDK names threads as Thread-0, thread-1 and so forth. These names are not very
//    descriptive and does not help us when debugging the application. 
//    If we assign some names then we can easily identify and that can help us understand 
//    multi-threaded application flow thereby allowing us to efficiently debug it.
// 2. Let us see how to name normal threads
//    OPTION -1 
//    From within the task which is running 
//    OPTION -2 
//    At the time when we create the thread class object
//    OPTION -3 
//    At the time when we create the thread class object
public class NamingThreads {
    
    public static void main(String[] args) throws InterruptedException{
        String threadName = Thread.currentThread().getName();
        System.out.println("Main thread starts here " + threadName);
        
        ExecutorService service = Executors.newCachedThreadPool(new NamingThreadFactory());
        service.execute(new LoopTaskB());
        service.execute(new LoopTaskB());
        service.execute(new LoopTaskB());
        service.execute(new LoopTaskB());
        
        TimeUnit.SECONDS.sleep(15);
        service.execute(new LoopTaskB());
        service.execute(new LoopTaskB());
        service.execute(new LoopTaskB());
        service.execute(new LoopTaskB());
        service.execute(new LoopTaskB());
        
        System.out.println("Main thread ends   here" + threadName);
        service.shutdown();
    }

}
