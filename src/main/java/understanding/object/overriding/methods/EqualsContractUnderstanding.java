package understanding.object.overriding.methods;

public class EqualsContractUnderstanding {

    public static void main(String[] args) {
        Integer i1 = new Integer(1);
        Integer i2 = new Integer(2);
        
        System.out.println(" i1 == i2 " + (i1 == i2));
        System.out.println(" i1 equals i2 " + (i1.equals(i2)));

    }

}
