package generic;

/*
We have seen that while creating objects to generic classes we can pass any derived type as type parameters. 
Many times it will be useful to limit the types that can be passed to type parameters. For that purpose, 
bounded types or bounded type parameters are introduced in generics. 
Using bounded types, you can make the objects of generic class to have data of specific derived types.


For example, If you want a generic class that works only with numbers (like int, double, float, long …..) then declare 
type parameter of that class as a bounded type to java.lang.Number class. Then while creating objects to that 
class you have to pass only Number types or it’s subclass types as type parameters.

Here is the syntax for declaring Bounded type parameters.

<T extends SuperClass>

This specifies that ‘T’ can only be replaced by ‘SuperClass’ or it’s sub classes. 

Remember that extends clause is an inclusive bound. 
                                   +++++++++
                                   
That means bound includes ‘SuperClass’ also.

==================================
Using Interface As An Upper Bound :
==================================
You can also use interface type along with class type as an upper bound to type parameters. As in java, any class can 
extend only one class and can implement multiple interfaces, this also applies while declaring the bound to type parameters. 
That means a bounded parameter can extend only one class and one or more interfaces. While specifying bounded 
parameters that has a class and an interface or multiple interfaces, use & operator as a delimiter.

class GenericClass <T extends AnyClass & FirstInterface & SecondInterface>
{   
 
}




*/


public class GenericBoundedTypesTester {

	public static void main(String[] args) {
		//Creating object by passing Number as a type parameter
		 
        GenericClass12<Number> gen1 = new GenericClass12<Number>(123);
 
        //Creating object by passing Integer as a type parameter
 
        GenericClass12<Integer> gen2 = new GenericClass12<Integer>(new Integer(456));
 
        //Creating object by passing Double as a type parameter
 
        GenericClass12<Double> gen3 = new GenericClass12<Double>(new Double(23.589));
 
        //Creating object by passing Long as a type parameter
 
        GenericClass12<Long> gen4 = new GenericClass12<Long>(new Long(12));
 
        //While Creating object by passing String as a type parameter, it gives compile time error
 
        //GenericClass12<String> gen5 = new GenericClass12<String>("I am string"); 

        
        
      //Passing Integer[] array while calling printNumbers()
        
        GenericClass12.printNumbers(new Integer[] {new Integer(10), new Integer(20), new Integer(30), new Integer(40)} );
 
        //Passing Double[] array while calling printNumbers()
 
        GenericClass12.printNumbers(new Double[] {new Double(21.45), new Double(20.45), new Double(34.87), new Double(48.36)} );
 
        //Passing String[] array while calling printNumbers(), it gives compile time error
 
        //GenericClass12.printNumbers(new String[] {"one", "Two", "Three", "Four"});  
	}

}

class GenericClass12<T extends Number>    //Declaring Number class as upper bound of T
{
    T t;
 
    public GenericClass12(T t)
    {
        this.t = t;
    }
 
    public T getT()
    {
        return t;
    }
    
    public static <T extends Number> void printNumbers(T[] t)
    {
        for (int i = 0; i < t.length; i++)
        {
            System.out.println(t[i]);
        }
    }
}