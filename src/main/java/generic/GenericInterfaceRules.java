package generic;

public class GenericInterfaceRules {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
interface GenericInterface<T>
{
    void setT(T t);    
 
    T getT();
}

// Rule #1

// Only generic classes can implement generic interfaces. Normal classes can’t implement generic interfaces. 
// For example, above generic interface can be implemented as,


class GenericClass<T> implements GenericInterface<T>
{

	@Override
	public void setT(T t) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public T getT() {
		// TODO Auto-generated method stub
		return null;
	}
 
}

//It will lead to compile time error
/*
class NormalClass implements GenericInterface<T>
{
     //Compile time error
}

*/
// Rule #2
// A normal class can implement a generic interface if type parameter of generic interface is a wrapper class. 
// For example, below implementation of GenericInterface is legal.

interface GenericInterface1<Integer>
{
       //Generic interface with Integer as type parameter
}
 
class NormalClass implements GenericInterface<Integer>
{

	@Override
	public void setT(Integer t) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Integer getT() {
		// TODO Auto-generated method stub
		return null;
	}
       //Normal class implementing generic interface
}

// Rule #3
// Class implementing generic interface at least must have same number and same type of parameters and at 
// most can have any number and any type of parameters.

interface GenericInterfacee<T>
{
    //Generic interface with one type parameter
}
 
class GenericClass1<T> implements GenericInterfacee<T>
{
    //Class with same type parameter
}
 
class GenericClass2<T, V> implements GenericInterfacee<T>
{
    //Class with two type parameters
}

/*
class GenericClasss<T1, T2> implements GenericInterfacee<T3>
{
    //Compile time error, class having different type of parameters
}

*/

// Rule #4
// You can change the type of parameter passed to generic interface while implementing it. 
// When changed, the class which is implementing should have new type as parameter and also, 
// you have to change old type with new type while implementing the methods.


interface GenericInterfacess<T>
{
    void setT(T t);
 
    T getT();
}

//Changing the type of parameter passed to GenericInterface while implementing

class GenericClassess<V> implements GenericInterfacess<V>
{
    V t;
 
    @Override
    public void setT(V t)    //Changing the type of parameter
    {
        this.t = t;
    }
 
    @Override
    public V getT()          //Changing the return type
    {
        return t;
    }
}

// Rule # 5
// Generic interface can have any number of type parameters. 
// Class implementing generic interface at least must have  same type of parameters and at most 
// can have any number of parameters

interface GenericInterfacesss<T1, T2, T3, T4>
{
    //Generic interface with 4 type parameters
}
 
class GenericClasssss1<T1, T2, T3, T4, T5> implements GenericInterfacesss<T1, T2, T3, T4>
{
    //Generic class with 5 type parameters implementing generic interface with 4 type parameters
}

/*
class GenericClasssss12<T1, T2, T3> implements GenericInterfacesss<T1, T2, T3, T4>
{
    //Compile time error, must have same number of type parameters
}
*/

/*
class GenericClasssss13<T1, T2, T5, T6> implements GenericInterfacesss<T1, T2, T3, T4>
{
    //Compile time error. must have same type of parameters
}
*/

// Rule #6
// Class can implement more than one generic interfaces. If implemented, class should have type parameters of both the interfaces.

interface GenericInterface11<T1>
{
    //Generic interface with one type parameter
}
 
interface GenericInterface21<T2, T3>
{
    //Generic interface with two type parameters
}
 
class GenericClasssssss<T2,T1, T3> implements GenericInterface11<T1>, GenericInterface21<T2, T3>
{
    //Class having parameters of both the interfaces
}