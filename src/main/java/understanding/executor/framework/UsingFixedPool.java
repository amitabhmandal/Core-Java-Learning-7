package understanding.executor.framework;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class UsingFixedPool {

    public static void main(String[] args) {
        System.out.println("Main thread starts here");
        
        ExecutorService service = Executors.newFixedThreadPool(3);
        
        service.execute(new LoopTaskA());
        service.execute(new LoopTaskA());
        service.execute(new LoopTaskA());
        
        //what happens if we start more tasks when the thread pool size is of 3
        //when we submit a new task then the 4 task shall continue to wait
        //until the queue is empty
        service.execute(new LoopTaskA());
        
        //But at all times the total number of concurrent executing tasks never exceeded 3
        
        System.out.println("Main thread ends here");
        //never forget to shutdown the executor service else when application is going to be
        //shut down else it is going to cause a memory leak
        service.shutdown();
        
        //What happens if we submit a task when the service has already been shut down
        //It will throw RejectedExecutionException exception as the service had been shut down
        //hence it will not accept 
        service.execute(new LoopTaskA());
        /*
        Exception in thread "main" java.util.concurrent.RejectedExecutionException: Task understanding.executor.framework.LoopTaskA@5f0ee5b8 rejected from java.util.concurrent.ThreadPoolExecutor@4b0bc3c9[Shutting down, pool size = 3, active threads = 3, queued tasks = 1, completed tasks = 0]
            at java.util.concurrent.ThreadPoolExecutor$AbortPolicy.rejectedExecution(ThreadPoolExecutor.java:2048)
            at java.util.concurrent.ThreadPoolExecutor.reject(ThreadPoolExecutor.java:821)
            at java.util.concurrent.ThreadPoolExecutor.execute(ThreadPoolExecutor.java:1372)
            at understanding.executor.framework.UsingFixedPool.main(UsingFixedPool.java:30)
        */
        service.shutdown();

    }

}
