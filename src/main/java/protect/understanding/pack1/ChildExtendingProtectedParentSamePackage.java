package protect.understanding.pack1;

public class ChildExtendingProtectedParentSamePackage {

    public static void main(String[] args) {
        ProtectedParent p1 = new ProtectedParent();
        p1.parentMethod();

    }

}
