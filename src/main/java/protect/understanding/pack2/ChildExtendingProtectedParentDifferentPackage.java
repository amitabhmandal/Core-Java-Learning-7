package protect.understanding.pack2;

import protect.understanding.pack1.ChildExtendingProtectedParentSamePackage;
import protect.understanding.pack1.ProtectedParent;

public class ChildExtendingProtectedParentDifferentPackage extends ProtectedParent {

	public static void main(String[] args) {
		
		
		ChildExtendingProtectedParentDifferentPackage c1 = new ChildExtendingProtectedParentDifferentPackage();
		c1.parentMethod();
		
		ProtectedParent p1 = new ProtectedParent();
		//p1.parentMethod(); parent reference used hence compilation error. 

		p1 = new ChildExtendingProtectedParentDifferentPackage();
		// p1.parentMethod(); parent reference used hence compilation error.

	}

}
