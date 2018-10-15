package arrays.understanding;

public class ParentChildRelationShip {

	//An array containing super class reference variables can point to sub class objects. For example,
	public static void main(String[] args) {

		A[] arrayOfSuperClassReferences = new A[5]; // Defining an array of super class reference variables

		for (int i = 0; i < arrayOfSuperClassReferences.length; i++) {
			arrayOfSuperClassReferences[i] = new B(); // array element pointing to sub class object

			arrayOfSuperClassReferences[i].methodOne(); // accessing member of sub class object
		}
	}

}

class A {
	int i;

	void methodOne() {
		System.out.println("From Class A");
	}
}

class B extends A {
	@Override
	void methodOne() {
		System.out.println("From Class B");
	}
}