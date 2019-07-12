package arrays.understanding;


public class ArrayInterviewQuestion {
	public static void main(String[] args) {
		test1();
	}

	public static void test1() {
		int[] i = new int[0];
		System.out.println(i[0]);
	}

	public static void test2() {
		int[] a = new int[3];
		a[1] = 50;
		Object o = a;
		int[] b = (int[]) o;
		b[1] = 100;
		System.out.println(a[1]);
		((int[]) o)[1] = 500;
		System.out.println(a[1]);
	}
}
