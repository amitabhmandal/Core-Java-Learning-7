package inheritance.parent;

public class ModifierChild extends ModifierParent{
	public void display() {
		System.out.println("Modifier Child Display called");
	}
	
	private void modifier() {
		System.out.println("Child modifier called");
	}
}
