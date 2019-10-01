package generic;

import java.util.ArrayList;
import java.util.List;

public class StatiChecker {
	public static void increment(int i) {
		i++;
	}

	public static void stringAdd(String i) {
		i.concat("ajkhkdjshd");
	}	
	
	static <X extends List> void duplicate(X list) {
		list.addAll(list);
	}

	public static void main(String[] args) {
		int a = 6;
		increment(a);
		System.out.println(a);
		
		String sts = "fdfdd";
		stringAdd(sts);
		System.out.println(sts);
		
		ArrayList<Integer> number = new ArrayList<Integer>();
		number.add(Integer.valueOf(1));
		number.add(Integer.valueOf(2));
		number.add(Integer.valueOf(3));
		
		duplicate(number);
		System.out.println(number);

	}

}
