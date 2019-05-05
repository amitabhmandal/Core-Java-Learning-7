package interfaceinformation;

public class InterfaceExtendsUnderstanding {

    public static void main(String[] args) {
        I1 i1 = null;
        i1.equals(null);

    }

}

interface I1 {
    String toString();
}

class A implements I1 {

}

interface A1 {
}

class InterfaceAndObjectClass {
    public static void main(String[] args) {
        A1 a = null;
        a.equals(null);
        a.hashCode();
        a.toString();
    }
}