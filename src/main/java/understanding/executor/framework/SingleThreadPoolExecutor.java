package understanding.executor.framework;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

//IMPORTANT CONCEPTS ABOUT SINGLE THREAD POOL EXECUTOR
//1. In SingleThreadPoolExecutor everything is the same as FixedThreadPoolExecutor the only
//   difference the size of thread pool is 1
//2. However the pool size of 1 gives it some special properties
//3. As the usage of single executor is similar to the previous two executors that we have 
//   discussed so far.
//4. Once we submit 3 tasks for execution then we can see that the tasks are not being 
//   executed concurrently, but by 1 by 1. Thus it will be like serializing tasks
//5. However if there are multiple concurrent running tasks in your application that use the 
//   same resource then the reads and writes on the same resource needs to be synchronized
//6. However if you use a single thread executor then the tasks need not be synchronized
//7. Hence the best use case of singleThread executor is when we have the need of single
//   resource and we need to serialize the task
public class SingleThreadPoolExecutor {

    public static void main(String[] args) {
        System.out.println("Main thread starts here");
        ExecutorService service = Executors.newSingleThreadExecutor();
        service.execute(new LoopTaskA());
        service.execute(new LoopTaskA());
        service.execute(new LoopTaskA());
        
        System.out.println("Main thread ends here");
        
        service.shutdown();

    }

}
