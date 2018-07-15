package protect.understanding.pack1;

public class ChildExtendingProtectedParentSamePackage extends ProtectedParent {

	public static void main(String[] args) {
		ProtectedParent p1 = new ProtectedParent();
		p1.parentMethod();

		p1 = new ChildExtendingProtectedParentSamePackage();
		p1.parentMethod();
		
		ChildExtendingProtectedParentSamePackage c1 = new ChildExtendingProtectedParentSamePackage();
		c1.parentMethod();
		
	}

}
