package understanding.executor.framework;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

//SALIENT FEATURES OF USING CACHED THREAD POOL EXECUTOR
// 1. creates as many threads as required for executing the submitted tasks
// 2. If a task is submitted to it and a thread is available then that thread is used to run 
//    the task
// 3. However if all the threads are busy executing previously submitted tasks then a new
//    thread is created and the new task is executed by that thread.
// 4. There is no concept of task queue here. As soon as the task is submitted it is executed 
//    by the executor.
// 5. When the thread has finished executing its task it becomes available and is resued 
//    for the next task that is submitted to the executor
// 6. The difference between fixed thread pool executor and cached thread pool executor
//    is that in a fixed thread pool executor the number of threads is fixed however in 
//    cached thread pool executor it is not fixed.
// 7. So if the number of tasks exceed the number of threads in the fixed thread pool then 
//    the extra tasks have to wait in a task to fill the time some thread finishes executing
//    a previous task and becomes available to execute another task in the queue.
// 8. However in a case thread pool executed there is no limit on the number of threads 
//    that can be created by the pool. As many threads are required are created by the 
//    the executor to run concurrently so that no task has to wait for execution
// 9. That is why there is no concept of a wait queue in cached thread pool executor
// 10.We know in cached Thread Pool we can reuse the threads which has been completed it tasks
//    however to reuse those threads we need to understand naming of threads. 

public class UsingCachedThreadPoolExecutor {

    public static void main(String[] args) {
        System.out.println("Main thread starts here");
        ExecutorService service = Executors.newCachedThreadPool();
        service.execute(new LoopTaskA());
        service.execute(new LoopTaskA());
        service.execute(new LoopTaskA());
        service.execute(new LoopTaskA());
        service.execute(new LoopTaskA());
        service.execute(new LoopTaskA());
        service.execute(new LoopTaskA());
        
        System.out.println("Main thread ends here");
        
        service.shutdown();
        
        /*
        Exception in thread "main" java.util.concurrent.RejectedExecutionException: Task understanding.executor.framework.LoopTaskA@1f26ecd2 rejected from java.util.concurrent.ThreadPoolExecutor@3485def8[Shutting down, pool size = 4, active threads = 4, queued tasks = 0, completed tasks = 0]
            at java.util.concurrent.ThreadPoolExecutor$AbortPolicy.rejectedExecution(ThreadPoolExecutor.java:2048)
            at java.util.concurrent.ThreadPoolExecutor.reject(ThreadPoolExecutor.java:821)
            at java.util.concurrent.ThreadPoolExecutor.execute(ThreadPoolExecutor.java:1372)
            at understanding.executor.framework.UsingCachedThreadPoolExecutor.main(UsingCachedThreadPoolExecutor.java:40)
        */
        service.execute(new LoopTaskA());

    }

}
