package arrays.understanding;

public class DepthOfInheritanceClass {

	public static void main(String[] args) {
		DepthOfInheritanceClass inspectclass = new DepthOfInheritanceClass();
		try {
			inspectclass.printDetailsSuperClass(Class.forName("java.io.BufferedWriter"), 0);
			inspectclass.printDetailsInterfaces(Class.forName("java.io.BufferedWriter"), 0);
		} catch (ClassNotFoundException e) {
			System.out.println("Printing exception");
			e.printStackTrace();
		}

	}

	public void printDetailsSuperClass(Class clstype, int classdepth) {
		// Print the class name passed from main

		System.out.println("Class depth is: " + classdepth + " Class Name is: " + clstype.getName());

		// Recurse to get super class details
		if (clstype.getSuperclass() != null) {
			// Get all the details
			printDetailsSuperClass(clstype.getSuperclass(), classdepth + 1);
		}
	}

	public void printDetailsInterfaces(Class clstype, int classdepth) {
		// Print the class name passed from main
		System.out.println("Class depth is: " + classdepth + " Class Name is: " + clstype.getName());
		// Recurse to get super class details
		if (clstype.getSuperclass() != null) {
			// Get all the details
			printDetailsInterfaces(clstype.getSuperclass(), classdepth + 1);
		}
		// Get all the interfaces that the input class implements.
		Class[] interfacesimp = clstype.getInterfaces();
		System.out.println("Printing the implemented interfaces");
		for (int i = 0; i < interfacesimp.length; i++) {
			printDetailsInterfaces(interfacesimp[i], classdepth + 1);
		}
	}
}
