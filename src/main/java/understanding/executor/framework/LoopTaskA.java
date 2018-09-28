package understanding.executor.framework;

import java.util.concurrent.TimeUnit;

public class LoopTaskA implements Runnable {
    private static int count = 0;
    private int id = 0;

    @Override
    public void run() {
        System.out.println(" ####### TASK  < " + id + " > STARTING #######");
        for (int i = 0; i < 10; i++) {
            System.out.println("Thread < " + id + " > implementation Tick tick " + i);
            try {
                TimeUnit.MILLISECONDS.sleep(200);
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
        
        System.out.println(" ####### TASK  < " + id + " > ENDING #######");

    }

    public LoopTaskA() {
        this.id = ++count;
    }

}
