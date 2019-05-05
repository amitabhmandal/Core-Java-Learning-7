package enumlearning;

public class DummyTester {

    public static void main(String[] args) {
        DummyTester d1 = new DummyTester();
        
        System.out.println(d1.hashCode());
        System.out.println(d1.getClass().getClassLoader());
        System.out.println(d1.getClass().hashCode());
        
        DummyTester foo = new DummyTester();
        DummyTester bar = new DummyTester();
        
        System.out.println(foo.getClass()==bar.getClass());
        
        System.out.println(d1.getClass().getDeclaredClasses());
    }

}
