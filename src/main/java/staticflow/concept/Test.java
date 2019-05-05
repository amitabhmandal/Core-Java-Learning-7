package staticflow.concept;

public class Test {
    static int x = 10;

    static {
        System.out.println("Hello World");
        System.out.println(x);
    }

    public static void main(String[] args) {
        System.out.println("Inside main");

    }
    

}
