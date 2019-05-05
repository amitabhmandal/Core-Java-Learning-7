package learning.synthetic.constructs;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Comparator;

public class SyntheticFieldDemo {
    class NestedClass {
        private String nestedField;
    }

    public String getNestedField() {
        return new NestedClass().nestedField;
    }

    public void setNestedField(String nestedField) {
        new NestedClass().nestedField = nestedField;
    }

    public static void main(String[] args) {
        givenSyntheticField_whenIsSynthetic_thenTrue();
        givenSyntheticMethod_whenIsSynthetic_thenTrue();
        givenBridgeMethod_whenIsBridge_thenTrue();

    }

    public static void givenSyntheticField_whenIsSynthetic_thenTrue() {
        Field[] fields = SyntheticFieldDemo.NestedClass.class.getDeclaredFields();
        // assertEquals("This class should contain only one field",
        // 1, fields.length);

        for (Field f : fields) {
            System.out.println("Field: " + f.getName() + ", isSynthetic: " + f.isSynthetic());
            // assertTrue("All the fields of this class should be synthetic",
            // f.isSynthetic());
        }
    }

    public static void givenSyntheticMethod_whenIsSynthetic_thenTrue() {
        Method[] methods = SyntheticFieldDemo.NestedClass.class.getDeclaredMethods();
        // assertEquals("This class should contain only two methods",
        // 2, methods.length);

        for (Method m : methods) {
            System.out.println("Method: " + m.getName() + ", isSynthetic: " + m.isSynthetic());
            // assertTrue("All the methods of this class should be synthetic",
            // m.isSynthetic());
        }
    }
    
    public static void givenBridgeMethod_whenIsBridge_thenTrue() {
        int syntheticMethods = 0;
        Method[] methods = BridgeMethodDemo.class.getDeclaredMethods();
        for (Method m : methods) {
            System.out.println("Method: " + m.getName() + ", isSynthetic: " +
              m.isSynthetic() + ", isBridge: " + m.isBridge());
            if (m.isSynthetic()) {
                syntheticMethods++;
//                assertTrue("The synthetic method in this class should also be a bridge method",
//                  m.isBridge());
            }
        }
        // assertEquals("There should be exactly 1 synthetic bridge method in this class",
        // 1, syntheticMethods);
    }
}

class BridgeMethodDemo implements Comparator<Integer> {
    @Override
    public int compare(Integer o1, Integer o2) {
        return 0;
    }
}
