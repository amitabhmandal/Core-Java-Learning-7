package generic;

import java.util.ArrayList;

public class WithoutGenericsClassCastException {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}


class WithoutGenericsInJava
{
    public static void main(String[] args)
    {
        ArrayList list = new ArrayList();
 
        list.add("JAVA");
 
        list.add(123);
 
        for (Object object : list)
        {
            //Below statement throws ClassCastException at run time
 
            String str = (String) object;       //Type casting
 
            System.out.println(str);
        }
    }
}

class GenericsInJava
{
    public static void main(String[] args)
    {
        ArrayList<String> list = new ArrayList<String>();
 
        list.add("JAVA");
 
    //  list.add(123);       Compile time error
 
        for (String str : list)
        {
            //No type casting needed. ClasscastException Never occurs
 
            System.out.println(str);
        }
    }
}


// If you use generics, you need not to perform the type casting explicitly. Java compiler applies strong type checking if 
// you use generics in your code and shows errors if the code violates the type safety. Thus removing the risk of ClassCastException.