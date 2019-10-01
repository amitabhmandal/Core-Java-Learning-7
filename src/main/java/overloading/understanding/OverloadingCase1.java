package overloading.understanding;


//for overloading if exact match method is not available then we will not get any compile time error immediately
//First it will promote argument to the next level
//and check whether matched method is available or not
// if matched method is available then it will be considered and if matched method is not available 
// then it will promote argument to the next level this process will be continued until all possible promotions
// Still if that matched method is not available then we will get compile time error

public class OverloadingCase1 {

	public static void main(String[] args) {
		m1(1);
		m1('a');
		m1(1.2f);
		m1((short) 4);
		m1(1l);
		m1((byte) 1);
		

	}
	
	public static void m1(double d) {
		System.out.println("double method called" +d);
	}

}
