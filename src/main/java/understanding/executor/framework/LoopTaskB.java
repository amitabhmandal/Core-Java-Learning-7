package understanding.executor.framework;

import java.util.concurrent.TimeUnit;

public class LoopTaskB implements Runnable {
    private static int count = 0;
    private int instanceNumber = 0;
    private String taskid;

    @Override
    public void run() {
        String threadName = Thread.currentThread().getName();
        System.out.println(" ####### [" + threadName + " ] TASK  < " + taskid + " > STARTING #######");
        for (int i = 0; i < 10; i++) {
            System.out.println("[ " + threadName +" ] < " + taskid + " > implementation Tick tick " + i);
            try {
                TimeUnit.MILLISECONDS.sleep(200);
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
        
        System.out.println(" ####### [" + threadName + " ] TASK  < "+ taskid + " > ENDING #######");

    }

    public LoopTaskB() {
        this.instanceNumber = ++count;
        taskid = "LoopTaskB" + instanceNumber;
    }

}
