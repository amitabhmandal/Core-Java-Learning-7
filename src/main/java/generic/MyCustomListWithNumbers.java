package generic;

import java.util.ArrayList;

public class MyCustomListWithNumbers<T extends Number> {
ArrayList<T> list = new ArrayList<T>();
	
	//Here we are using Type as a parameter
	public void addElement(T str) {
		list.add(str);
	}

	public void removeElement(T str) {
		list.remove(str);
	}
	
	public String toString() {
		return list.toString();
	}
	
	
	//Here we are using type as a return value
	public T get(int index) {
		return  list.get(index);
	}
}
