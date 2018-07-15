package learning.polymorphism;
//Overrding concept

import inheritance.parent.ModifierChild;
import inheritance.parent.ModifierParent;

//Whatever methods parent by default is always to the child through inheritance
//If child class not satisfied with parent class implementation then the child is allowed
//to redefine that method based on it's requirement

//The parent class method which is overridden is called over-ridden method
//The child class method which is overiding the parent method is called overriding method.

//Based on the runtime object the method resolution will happen hence it is called 
//runtime polymorphism or dynamic binding or late binding

//In overriding everything is determined by run time object which is the actual object assigned
//to the reference type.

//Rules for Overriding
//Method names must be same and argument types must be same. Hence we can method signatures should
//be same. However in overloading method signatures should be different.

//method signature(name + argument)

//Return Types : Must be same. But in 1.5v co-variant return types are allowed. Which means
//return types can be same type or it's child classes.
//Covariant return types is allowed only for Objects and not for primitive types. 

//modifiers rules
//private methods of parent are not available to the child. Hence overriding concept is not available
//for private method.

//final methods of parent cannot be overriden in child. If child tries to over-ride parent
//final method then it will lead to compilation error. 

//While overriding we can reduce the scope of the modifier. If we reduce the scope of the 
//modifier then it will lead to compilation error. we can increase the scope but not surely
//decrease it.
//private << default << protected << public

//Overriding Rules for Exception
//if child class method throws any checked exception then it is mandatory that the parent class
//should throw the same checked exception or it's parent exception else it would result in
//compilation error.

//There are no rules for unchecked exception, we can write it anywhere.

//Static method of parent class cannot be overridden in child as non-static.

//if we try to overide then it will lead to compilation error.
public class OverridingTest {

	public static void main(String[] args) {
		// case 1: Parent Object being assigned to Parent reference
		// In this case always parent methods be called.
		Parent parent = new Parent();
		parent.display();

		// case 2: Child Object being assigned to Child reference
		Child child = new Child();
		child.paint();

		// Here if the child has not overridden the parent class display method in the
		// child
		// then the parent class display shall be called as the parent class display is
		// always
		// available to the child.
		child.display();

		// case 3: Child Object being assigned to Parent reference

		// In compilation Phase compiler shall check whether the display method exists
		// in the parent
		// class or not. If it finds then it will not raise any compilation errors.

		// In the run time phase, JVM will check the object type being assigned to the
		// reference
		// type and based on the object it will try to call's it method which has been
		// overridden
		// in the child class. hence display of the child class shall be called.

		// However if the child class does not have the overridden method then it will
		// always
		// default to the parent class display method as by default all the methods of
		// the parent
		// class is always found in the child class.
		Parent parentReference = new Child();
		parentReference.display();

		// case 4:
		// Covariant Example: Covariant is only applicable for objects and not for child
		CovariantParent covariantParent = new CovariantChild();
		covariantParent.display();

		// case 5: private methods of parent can be declared in child as well however it
		// is not
		// over-riding.
		// modifier example: Private method of parent cannot be overriden in the child
		// as
		// the parent private method is not accessible from the child.

		// However we can declare the same private method within the child. Although it
		// is not
		// overriding.

		ModifierParent modifierParent = new ModifierParent();

		// Private methods can only be accessed from within the class
		// modifierParent.modifier();
		ModifierChild modifierChild = new ModifierChild();
		// Private methods of Parent are never available to the child
		// If it is never available then there is no chance of over-riding.
		modifierChild.display();
		// Private methods can be accessed from within the class.
		// modifierChild.modifier();

		// case 6: Final methods of Parent cannot be overriden in child.
		// If child tries to override the final parent methods then it will lead to
		// compilation
		// error
		FinalParent finalParent = new FinalParent();
		finalParent.display();

		// Child cannot override final methods of parent.
		FinalChild finalChild = new FinalChild();
		// finalChild.display();

		// case 7: Parent class abstract method should always be overriden
		AbstractParent abstractParent = new ChildAbstractParent();
		abstractParent.display();

		// case 8: Non Abstract class parent method as abstract method in Child.
		NonAbstractParent NonAbstractParent = new ChildChildNonAbstractParent();

		NonAbstractParent.display();

		// case 9: Static method of parent class cannot be overridden in child as
		// non-static.
		// if we try to overide then it will lead to compilation error.

		// case 10: Non Static method of parent class cannot be overridden in child as
		// static.
		// if we try to overide then it will lead to compilation error.
		
		//case 11: Method Hiding Static Parent & Static Child
		
		//All rules of method hiding are exactly same as overiding except the following 
		//differences.
		//In method hiding Method resolution is done by compiler based on reference type
		//In Method overriding method resolution is done by JVM based on run time object
		
		//In Method hiding both parent and child methods should be static
		//In over-riding parent and child method should be non static
		
		//In method hiding is also known as compile time polymorphism or static binding
		//or early binding
		//In method over-riding is also know as dynamic binding or late binding or run time
		//polymorphism
		MethodHidingStaticParent methodHidingStaticParent = new MethodHidingStaticParent();
		methodHidingStaticParent.m1();
		methodHidingStaticParent = new MethodHidingStaticChild();
		methodHidingStaticParent.m1();
		
		MethodHidingStaticChild methodHidingStaticChild = new MethodHidingStaticChild();
		methodHidingStaticChild.m1();
		
		//case 12: Over-riding with respect to Var-Args Method
		//if the method signature is not matching then it is not over-riding but overloading
		//hence parent version method shall be called even child object is being assigned to 
		//the parent reference. 
		//If we want to see the child version method to be called then it needs to be 
		//over-ridden by the same method signature which shall be the var-arg argument.
		ParentVarArg parentVarArg = new ParentVarArg();
		parentVarArg.m1(10);
		parentVarArg = new ChildVarArg();
		parentVarArg.m1(10);
		
		ChildVarArg childVarArg = new ChildVarArg();
		childVarArg.m1(10);
		
		
		//case 13: Over-riding with respect to variables.
		//With respect to variables there is no over-riding. It does not depend on the 
		//run time object but depends on the reference type. This reference type is decided in
		//the time of compilation. It does not matter whether the variables are static or non
		//static it does not matter.
		ParentVariable parentVariable = new ParentVariable();
		System.out.println(parentVariable.x);
		
		ChildVariable childVariable = new ChildVariable();
		System.out.println(childVariable.x);
		
		parentVariable = new ChildVariable();
		System.out.println(parentVariable.x);
		
		
		
	}

}

//case 13: Over-riding with respect to variables

class ParentVariable {
	int x = 888;
	
}

class ChildVariable extends ParentVariable{
	int x = 999;
}
//case 12: 

class ParentVarArg{
	public void m1(int...x) {
		System.out.println("Parent Var Arg method called");
	}
	
}

class ChildVarArg extends ParentVarArg{
	public void m1(int  x) {
		System.out.println("Child Non Var Arg method called");
	}
	
}
//case 11: 
class MethodHidingStaticParent {
	public static void m1() {
		System.out.println("Static Parent");
	}
	
}

class MethodHidingStaticChild extends MethodHidingStaticParent{
	public static void m1() {
		System.out.println("Static Child");
	}
}


class Parent {
	public void display() {
		System.out.println("Parent Display called");
	}
}

class Child extends Parent {

	// This display can be commented out to check whether the parent class display
	// shall be
	// called if this method is not overridden.
	public void display() {
		System.out.println("Child Display called");
	}

	public void paint() {
		System.out.println("Child paint called");
	}

}

class CovariantParent {
	public Object display() {
		System.out.println("Covariant Parent Display called");
		return null;
	}
}

class CovariantChild extends CovariantParent {

	// This display can be commented out to check whether the parent class display
	// shall be
	// called if this method is not overridden.

	// return type can be same as parent type or it's child classes but can never be
	// parent
	// of parent

	// Co-variant return type objects only applicable for Objects and not for
	// Primitive data types
	// If primitive data types is used then it will lead to compilation error.
	public String display() {
		System.out.println("Covariant Child Display called");
		return "Hello";
	}

}

class FinalParent {
	public final void display() {
		System.out.println("final Parent Display called");
	}
}

class FinalChild extends FinalParent {
	// Child cannot override final method of parents. It will lead to compilation
	// error.

	// public void display() {
	// System.out.println("final Parent Display called");
	// }

}

// case 7: Abstract methods of Parent should always be overridden.
// Abstract keyword should be declared before the class keyword.
abstract class AbstractParent {
	public abstract void display();

}

class ChildAbstractParent extends AbstractParent {

	@Override
	public void display() {
		System.out.println("Abstract method of Parent over-ridden");

	}

}

// case 8: NonAbstractParent can have abstract method in Child
// Advantage of Using Abstract in Child is to stop providing the parent
// implementation in
// the child classes.
class NonAbstractParent {
	public void display() {
		System.out.println("Non Abstract Parent");
	};

}

abstract class AbstractChildNonAbstractParent extends NonAbstractParent {

	@Override
	public abstract void display();

}

class ChildChildNonAbstractParent extends AbstractChildNonAbstractParent {

	@Override
	public void display() {
		System.out.println("Child of AbstractChildNonAbstractParent");

	}

}

// case 9: static method in parent class cannot be overriden in child class as
// non-static
class StaticParent {
	public static void m1() {

	}
}

class NonStaticChild extends StaticParent {

	// Static parent method cannot be overridden in child as non static method. If
	// we remove these comments then it will lead to compilation error.
	// public void m1() {
	//
	// }
}

// case 10: Non static method of parent cannot be overriden by static method of
// child class
// It will lead to compilation error
class NonStaticParent {
	public void m1() {

	}
}

class StaticChild extends NonStaticParent {
	// non static method in parent cannot be overridden in child by static method.
	// It will
	// lead to compilation error in child.
	// public static void m1() {
	// }
}


