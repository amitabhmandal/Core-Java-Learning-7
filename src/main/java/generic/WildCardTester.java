package generic;

import java.util.ArrayList;

/*
WILD CARDS ARE USED WITH METHODS ONLY


Wildcard arguments means unknown type arguments

They just act as placeholder for real arguments to be passed while calling method.

They are denoted by question mark (?). 

One important thing is that the types which are used to declare wildcard arguments must be generic types. 

Wildcard arguments are declared in three ways.

1) Wildcard Arguments With An Unknown Type

2) Wildcard Arguments with An Upper Bound

3) Wildcard Arguments with Lower Bound



*/

public class WildCardTester {

	public static void main(String[] args) {
		// Wildcard Arguments With An Unknown Type :
		
		//Wildcard Arguments With An Upper Bound :
		
		

		// ArrayList Containing Integers

		ArrayList<Integer> a1 = new ArrayList<>();

		a1.add(10);

		a1.add(20);

		a1.add(30);

		processElements(a1);

		// Arraylist containing strings

		ArrayList<String> a2 = new ArrayList<>();

		a2.add("One");

		a2.add("Two");

		a2.add("Three");

		processElements(a2);
		
		callingWildCardsWithUpperBounds();
		

	}

	public static void callingWildCardsWithUpperBounds() {
		//ArrayList Containing Integers
		 
        ArrayList<Integer> a1 = new ArrayList<>();
 
        a1.add(10);
 
        a1.add(20);
 
        a1.add(30);
 
        processElements1(a1);
 
        //Arraylist containing Doubles
 
        ArrayList<Double> a2 = new ArrayList<>();
 
        a2.add(21.35);
 
        a2.add(56.47);
 
        a2.add(78.12);
 
        processElements1(a2);
 
        //Arraylist containing Strings
 
        ArrayList<String> a3 = new ArrayList<>();
 
        a3.add("One");
 
        a3.add("Two");
 
        a3.add("Three");
 
        //This will not work
 
       // processElements1(a3);     //Compile time error
	}
	
	
	static void callingWildCard
	// Wildcard Arguments With An Unknown Type :
	static void processElements3(ArrayList<?> a) {
		for (Object element : a) {
			System.out.println(element);
		}
	}
	
	
	// Wildcard Arguments With An Upper Bound :
    static void processElements1(ArrayList<? extends Number> a)
    {
        for (Object element : a)
        {
            System.out.println(element);
        }
    }
    
    // Wildcard Arguments With Lower Bound :
    static void processElements2(ArrayList<? super Integer> a)
    {
        for (Object element : a)
        {
            System.out.println(element);
        }
    }

}
