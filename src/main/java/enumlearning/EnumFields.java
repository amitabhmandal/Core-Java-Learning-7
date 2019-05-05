package enumlearning;

import java.util.ArrayList;

public class EnumFields {

    public static void main(String[] args) {
        System.out.println(enumFields());
    }

    public static ArrayList<String> enumFields() {
        AbbreviationOfDays[] abbreviationOfDays = AbbreviationOfDays.values();
        ArrayList<String> daysList = new ArrayList<String>();
        for (AbbreviationOfDays day : abbreviationOfDays) {
            daysList.add(day.getAbbreviation()
                .toString());
        }
        return daysList;
    }
}

enum AbbreviationOfDays {
    SUNDAY("SUN"), MONDAY("MON"), TUESDAY("TUES"), WEDNESDAY("WED"), THURSDAY("THURS"), FRIDAY("FRI"), SATURDAY("SAT");
    private String abbreviation;

    public String getAbbreviation() {
        return this.abbreviation;
    }

    AbbreviationOfDays(String abbreviation) {
        this.abbreviation = abbreviation;
    }
}