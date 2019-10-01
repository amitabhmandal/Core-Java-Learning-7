package enumlearning;

import java.util.ArrayList;

public class EnumsExample {

// Java enums extend the java.lang.Enum class implicitly. Therefore, you cannot extend any other class in enum.

//Enums can implement interfaces. They implicitly implement the Serializable and Comparable interfaces. 
//This means if you need some common functionality along diverse enum types, you can define it with an interface 
// to have the enums provide the method implementations.	

//In Java, enum is a keyword. Enum constructors are always private or default.
// Therefore, you cannot have public or protected constructors in an enum type.

// You cannot create an instance of enum using the new operator.

	public static void main(String[] args) {

		String args1[] = { "joe", "monday", "Monday", "MONDAY" };
		for (String arg : args1) {
			Days day = Days.forNameIgnoreCase(arg);
			System.out.println(arg + " => " + day);
		}

		// enum abstract method usage:
		String str = "Dog";
		Animal animal = Animal.valueOf(Animal.class, str);
		System.out.println(animal + " makes sound: " + animal.sound());

		// Use valueOf() to look up an enum by the name.
		Days day = Days.valueOf(Days.class, "MONDAY");
		System.out.println(day);

		// to look up enum by name by ignoring the case of the argument
		System.out.println(Days.forNameIgnoreCase("Monday"));
		// The method throws an IllegalArgumentException if the name (with the exact
		// case) is not found
		// Days days = Days.valueOf(Days.class, "Monday");
		// System.out.println(days);

		// System.out.println(enums.FIRST.j); // Compile time error : Field j is not
		// visible here

		// enums.FIRST.methodOfFirst(); // Compile time error : methodOfFirst() is not
		// visible here

		enums.FIRST.abstractMethod();

		// System.out.println(enums.SECOND.k); // Compile time error : Field k is not
		// visible here

		// enums.SECOND.methodOfSecond(); // Compile time error : methodOfSecond() is
		// not visible here

		enums.SECOND.abstractMethod();

		// Comparing Enums: == or equals()?
		// Both are correct. In fact, equals() is implemented using ==. 
		// Since == never throws a NullPointerException, one might prefer using that.

		if (day == Days.MONDAY) {
			// code here
		}
		if (day.equals(Days.MONDAY)) {
			// code here
		}
	}

}

//Enum Abstract Method
// An enum type can have abstract methods just like a class. 
// Each enum constant needs to implement the abstract method. An example is as follows:
enum Animal {
	Dog {
		String sound() {
			return "bark";
		}
	},
	Cat {
		String sound() {
			return "meow";
		}
	},
	Lion {
		String sound() {
			return "roar";
		}
	},
	Snake {
		String sound() {
			return "hiss";
		}
	};
	abstract String sound();
};

//If a Java enum contains fields and methods, the definition of fields and 
// methods must always come after the list of constants in the enum.

enum AbbreviationOfDays {
	SUNDAY("SUN"), MONDAY("MON"), TUESDAY("TUES"), WEDNESDAY("WED"), THURSDAY("THURS"), FRIDAY("FRI"), SATURDAY("SAT");
	private String abbreviation;

	public String getAbbreviation() {
		return this.abbreviation;
	}

	// The AbbreviationOfDays enum has an abbreviation field of type String. The
	// constructor takes a String abbreviation and assigns it to the field. The
	// getAbbreviation() method returns the abbreviation field
	AbbreviationOfDays(String abbreviation) {
		this.abbreviation = abbreviation;
	}
}

class EnumFields {
	public ArrayList<String> enumFields() {
		AbbreviationOfDays[] abbreviationOfDays = AbbreviationOfDays.values();
		ArrayList<String> daysList = new ArrayList<String>();
		for (AbbreviationOfDays day : abbreviationOfDays) {
			daysList.add(day.getAbbreviation().toString());
		}
		return daysList;
	}
}

// enum iteration
//The static values() method of the java.lang.Enum class that all enums inherit gives you an array of enum values.
class EnumIteration {
	enum Days {
		SUNDAY, MONDAY, TUESDAY, WEDNESDAY, THURSDAY, FRIDAY, SATURDAY;
	}

	public ArrayList<String> enumIteration() {
		Days[] days = Days.values();
		ArrayList<String> stringDay = new ArrayList<String>();
		for (Days day : days) {
			stringDay.add(day.toString());
		}
		return stringDay;
	}
}

//enum used as a switch statement

class EnumInSwitchStatement {
	public String enumInSwitch(Days day) {
		switch (day) {
		case SUNDAY:
			return "Its Sunday!!";
		case MONDAY:
			return "Its Monday";
		case TUESDAY:
			return "Its Tuesday";
		case WEDNESDAY:
			return "Its Wednesday";
		default:
			return "Rest of the week....";
		}
	}
}

// enum inside a class used as an if-statement

class EnumInIfStatement {
	public String enumInIf(Days day) {
		if (day == Days.SUNDAY) {
			return "Its Sunday :-)";
		} else if (day == Days.MONDAY) {
			return "Its Monday :*--(";
		} else if (day == Days.TUESDAY) {
			return "Its Tuesday :*-(";
		} else if (day == Days.WEDNESDAY) {
			return "Its Wednesday :*(";
		} else if (day == Days.THURSDAY) {
			return "Its Thursday :)";
		} else if (day == Days.FRIDAY) {
			return "Its Friday ;-D";
		} else {
			return "Its Saturday :=D";
		}
	}
}

// Enums can be defined inside a class
class SimpleEnumExample {
	enum Days {
		SUNDAY, MONDAY, TUESDAY, WEDNESDAY, THURSDAY, FRIDAY, SATURDAY;
	}
}

enum Days {
	SUNDAY, MONDAY, TUESDAY, WEDNESDAY, THURSDAY, FRIDAY, SATURDAY;

	static public Days forNameIgnoreCase(String value) {
		System.out.println("Looking without enum case");
		for (Days day : Days.values()) {
			if (day.name().equalsIgnoreCase(value))
				return day;
		}
		return null;
	}
}

enum enums {
	FIRST {
		int j = 10; // Field of FIRST

		void methodOfFirst() {
			System.out.println(j); // Field j can be used within the constant body
		}

		@Override
		void abstractMethod() {
			methodOfFirst(); // methodOfFirst() can be used within the constant body
		}
	},

	SECOND {
		int k = 20; // Field of SECOND

		void methodOfSecond() {
			System.out.println(k); // Field k can be used within the constant body
		}

		@Override
		void abstractMethod() {
			methodOfSecond(); // methodOfSecond() can be used within the constant body
		}
	};

	int i; // this field is available in all constants

	abstract void abstractMethod(); // this method is available in all constants
}