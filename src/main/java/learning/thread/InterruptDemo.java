package learning.thread;

/* A thread can interrupt a 
 * sleeping or
 * waiting thread
 * by using interrupt method of thread class
 * 
 * If we are calling interrupt on the target thread and it is not sleeping or waiting
 * state then there will be no w
 * 
 * 
 * 
 * 
 * 
 * 
 */

public class InterruptDemo {

    public static void main(String[] args) {
        System.out.println("Start of Main Thread");
        SleepThread sl = new SleepThread();
        sl.start();
        
        //main thread interrupts child thread
        sl.interrupt();
        
        System.out.println("End of Main Thread");

    }

}


class SleepThread extends Thread {
    public void run() {
        for (int i = 0 ; i < 10 ; i++ ) {
            System.out.println("I am lazy thread" );
    //           Thread.sleep(2000);

        }
    }
}