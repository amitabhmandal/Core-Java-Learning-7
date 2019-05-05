package learning.synthetic.constructs;

import java.util.Calendar;
import static java.lang.System.out;

public final class DemonstrateSyntheticMethods {

    public static void main(String[] args) {
        DemonstrateSyntheticMethods.NestedClass nested = new DemonstrateSyntheticMethods.NestedClass();
        out.println("String: " + nested.highlyConfidential);
        out.println("Int: " + nested.highlyConfidentialInt);
        out.println("Calendar: " + nested.highlyConfidentialCalendar);
        out.println("Boolean: " + nested.highlyConfidentialBoolean);
    }

    private static final class NestedClass {
        private String highlyConfidential = "Don't tell anyone about me";
        private int highlyConfidentialInt = 42;
        private Calendar highlyConfidentialCalendar = Calendar.getInstance();
        private boolean highlyConfidentialBoolean = true;
    }
}

/*
public final class DemonstrateSyntheticMethods {
    public DemonstrateSyntheticMethods() {
    }

    public static void main(String[] args) {
        DemonstrateSyntheticMethods.NestedClass nested = new DemonstrateSyntheticMethods.NestedClass(null);
        System.out.println("String: " + DemonstrateSyntheticMethods.NestedClass.access$1(nested));
    }
}

*/

/*
public final class DemonstrateSyntheticMethods {
    public DemonstrateSyntheticMethods() {
    }

    public static void main(String[] args) {
        DemonstrateSyntheticMethods.NestedClass nested = new DemonstrateSyntheticMethods.NestedClass(null);
        System.out.println("String: " + DemonstrateSyntheticMethods.NestedClass.access$1(nested));
        System.out.println("Int: " + DemonstrateSyntheticMethods.NestedClass.access$2(nested));
        System.out.println("Calendar: " + DemonstrateSyntheticMethods.NestedClass.access$3(nested));
        System.out.println("Boolean: " + DemonstrateSyntheticMethods.NestedClass.access$4(nested));
    }
}*/