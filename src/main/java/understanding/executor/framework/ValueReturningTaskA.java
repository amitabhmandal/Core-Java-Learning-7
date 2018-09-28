package understanding.executor.framework;

import java.util.concurrent.TimeUnit;

public class ValueReturningTaskA implements Runnable {

    private int a;
    private int b;
    private long sleepTime;
    private static int count = 0;
    private int instanceNumber = 0;
    private String taskId;
    private int sum = 0;
    public ValueReturningTaskA(int a, int b, long sleepTime) {
        this.a = a;
        this.b = b;
        this.sleepTime = sleepTime;

        this.instanceNumber = ++count;
        this.taskId = "ValueReturnedTaskA - " + instanceNumber;
    }

    @Override
    public void run() {
        String threadName = Thread.currentThread()
            .getName();
        System.out.println(" ####### [" + threadName + " ] TASK  < " + taskId + " > STARTING #######");
        System.out.println(" [" + threadName + " ] TaskId  < " + taskId + " > Sleeping for " + sleepTime + " millis");
        
        try {
            TimeUnit.MILLISECONDS.sleep(sleepTime);
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        
        sum = a + b;
        System.out.println(" ####### [" + threadName + " ] TASK  < " + taskId + " > ENDING #######");
    }
    
    public int getSum() {
        return sum;
    }
}
