package understanding.executor.framework;

import java.util.concurrent.TimeUnit;

public class FirstWay {

    public static void main(String[] args) {
        System.out.println("Main Flow starts");

        // FIRST WAY
        // new FirstTask();
        // new FirstTask();

        // The only difference first task and second task is that we are not going to start the
        // thread as soon as the thread is created

        // SECOND WAY
        // Advantage: This gives more control to the calling code as when to start the thread

        /*
        new SecondTask().start();
        Thread t = new SecondTask();
        t.start();
        
        */

        // ThIRD WAY
        // we will be providing an implementation of runnable interface
        // we will be passing the task definition into the constructor of thirdtask
        // by calling the constructor of thread and passing this reference

        // This is best suited when you wanted to achieve fire and forget scenario
        // We dont have the reference of thread object anyhow
        // So we cannot perform any operation such as join/ wait etc
        // we also dont care whether the thread execution completed successfully or not

        //new ThirdTask();
        //new ThirdTask();

        // Fourth WAY
        //Advantage of using fourth task is that we have control over the thread operations
        //new Thread(new FourthTask()).start();
        //Thread f1 = new Thread(new FourthTask());
        //f1.start();
        
        //FIfth Way 
        //an anonymous implementation of thread class cannot be reused as it is going to
        //create the simple implementation of the thread class
        new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 10; i++) {
                    System.out.println("Fifth Way implementation Tick tick " + i);
                    try {
                        TimeUnit.MILLISECONDS.sleep(200);
                    } catch (InterruptedException e) {
                        // TODO Auto-generated catch block
                        e.printStackTrace();
                    }
                }                
            }
        }).start();
        
        System.out.println("Main Flow Ends");
}

}

    // Runnable implementation and thread class provided by the same class
    class FirstTask extends Thread {
        private static int counter = 0;
        private int id;

        public void run() {
            for (int i = 0; i < 10; i++) {
                System.out.println("First Way implementation < " + id + " >Tick tick " + i);
                try {
                    TimeUnit.MILLISECONDS.sleep(200);
                } catch (InterruptedException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            }
        }

        public FirstTask() {
            this.id = ++counter;
            this.start();
        }
    }

    class SecondTask extends Thread {
        private static int counter = 0;
        private int id;

        public void run() {
            for (int i = 0; i < 10; i++) {
                System.out.println("Second Way implementation < " + id + " >Tick tick " + i);
                try {
                    TimeUnit.MILLISECONDS.sleep(200);
                } catch (InterruptedException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            }
        }

        public SecondTask() {
            this.id = ++counter;
            // this.start();
        }
    }

    // Runnable implementation provided
    // Since it does not have access to the thread class hence we cannot call the start method
    //
    class ThirdTask implements Runnable {
        private static int counter = 0;
        private int id;

        public void run() {
            for (int i = 0; i < 10; i++) {
                System.out.println("Third Way implementation < " + id + " >Tick tick " + i);
                try {
                    TimeUnit.MILLISECONDS.sleep(200);
                } catch (InterruptedException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            }
        }

        public ThirdTask() {
            this.id = ++counter;
            new Thread(this).start();
        }
    }

class FourthTask implements Runnable {
    private static int counter = 0;
    private int id;

    public void run() {
        for (int i = 0; i < 10; i++) {
            System.out.println("Fourth Way implementation < " + id + " >Tick tick " + i);
            try {
                TimeUnit.MILLISECONDS.sleep(200);
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
    }

    public FourthTask() {
        this.id = ++counter;
    }
}