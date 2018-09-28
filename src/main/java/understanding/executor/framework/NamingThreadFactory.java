package understanding.executor.framework;

import java.util.concurrent.ThreadFactory;

public class NamingThreadFactory implements ThreadFactory {

    private static int count = 0;
    private static String name = "MyThread-";

    @Override
    public Thread newThread(Runnable r) {

        Thread t = new Thread(r, name + ++count);
        return t;
    }

}
