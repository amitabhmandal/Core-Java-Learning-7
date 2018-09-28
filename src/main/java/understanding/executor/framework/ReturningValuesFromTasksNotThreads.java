package understanding.executor.framework;

//Returning values 

// 1. Whenever we have run a task in a different thread it has run in a seperate thread without
//    returning any value in the main thread
// 2. Can we return values from threads?
//    Returning values from threads is not possible as thread is just a construct which 
//    drive program execution. WE CAN RETURN VALUES FROM TASKS AND NOT THREADS!!
// 3. No language level suppport in which normal threads can be used to return values from 
//    threads however it can only be done through executors.
// 4. 

public class ReturningValuesFromTasksNotThreads {

    public static void main(String[] args) {
        String currentThread = Thread.currentThread().getName();
        
        System.out.println("[ " + currentThread + " ] Main thread starts here ");
        ValueReturningTaskA v1 =  new ValueReturningTaskA(1,2, 1000);
        Thread t = new Thread(v1);
        t.start();
        System.out.println(v1.getSum());
        System.out.println("[ " + currentThread + " ] Main thread ends   here ");

    }

}
