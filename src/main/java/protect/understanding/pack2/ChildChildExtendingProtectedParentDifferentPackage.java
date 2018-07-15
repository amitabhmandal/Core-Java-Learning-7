package protect.understanding.pack2;

import protect.understanding.pack1.ProtectedParent;

public class ChildChildExtendingProtectedParentDifferentPackage extends ChildExtendingProtectedParentDifferentPackage {

	public static void main(String[] args) {
		ChildChildExtendingProtectedParentDifferentPackage c1 = new ChildChildExtendingProtectedParentDifferentPackage();
		c1.parentMethod();
		
		ChildExtendingProtectedParentDifferentPackage p1 = new ChildExtendingProtectedParentDifferentPackage();
		//p1.parentMethod(); parent reference used hence compilation error.
		
		
		//Only child reference can be used to access protected parent members.
		
		
		
		ProtectedParent protectedParent = new ProtectedParent();
		//protectedParent.parentMethod();
		
		protectedParent = new ChildExtendingProtectedParentDifferentPackage();
		//protectedParent.parentMethod();
		
		
		protectedParent = new ChildChildExtendingProtectedParentDifferentPackage();
		//protectedParent.parentMethod();
		
		p1 = new ChildChildExtendingProtectedParentDifferentPackage();
		//p1.parentMethod();
	}

}
