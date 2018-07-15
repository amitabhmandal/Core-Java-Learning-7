package learning.thread;

public class ClassVsObjectLock {

    public static void main(String[] args) {
        TestClassVsObjectLock testClassVsObjectLock = new TestClassVsObjectLock();
        
        TestingObjectLockThread testingObjectLockThread = new TestingObjectLockThread(testClassVsObjectLock, "testingObjectLockThread");
        TestingClassLockThread testingClassLockThread = new TestingClassLockThread(testClassVsObjectLock , "testingClassLockThread");
        TestingClassLockThread testingClassLockThread1 = new TestingClassLockThread(testClassVsObjectLock , "testingClassLockThread1");
    
        
        
        testingObjectLockThread.start();
        testingClassLockThread.start();
        testingClassLockThread1.start();
        

    }

}

class TestingObjectLockThread extends Thread {
    TestClassVsObjectLock test;
    String name; 
    public TestingObjectLockThread(TestClassVsObjectLock test, String name) {
        this.test = test;
        this.name = name;
    }
    
    public void run() {
        
        System.out.println(Thread.currentThread().getName() );
        try {
            test.nonStaticSynchronized(name);
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        
    }
    
}

class TestingClassLockThread extends Thread {
    TestClassVsObjectLock test;
    String name;
    public TestingClassLockThread(TestClassVsObjectLock test , String name) {
        this.test = test;
        this.name = name;
    }
    
    public void run() {
        
        System.out.println(Thread.currentThread().getName() );
        try {
            TestClassVsObjectLock.staticSynchronized(name);
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        
    }
    
}

class TestClassVsObjectLock {
    public static synchronized void staticSynchronized(String name) throws Exception{
        for (int i = 0; i < 10; i++) {
            System.out.println("staticSynchronized testing going on = " + name);
            Thread.sleep(2000);
        }

    }
    
    public  synchronized void nonStaticSynchronized(String name) throws Exception{
        for (int i = 0; i < 10; i++) {
            System.out.println("nonStaticSynchronized testing going on " + name );
            Thread.sleep(2000);
        }

    }
    
}
