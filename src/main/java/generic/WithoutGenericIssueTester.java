package generic;

public class WithoutGenericIssueTester {

    public static void main(String[] args) {
        // TODO Auto-generated method stub

    }

}


//This class cannot work with boolean or integers or a user defined type or some other number.
class ContainerWorkingWithStrings {
    String item1;
    String item2;
    
    public ContainerWorkingWithStrings(String item1, String item2) {
        super();
        this.item1 = item1;
        this.item2 = item2;
    }
    
    public void printItems() {
        System.out.println("Printing contents of container" );
        System.out.println("Item 1 " + item1);
        System.out.println("Item 2 " + item2);
        
    }
}

//Why not defining a class containing object as properties.
//We will keep the rest of the things same.
//No compiler error can be seen as string can be an object
//Hence we can use this class in a generic way for example
//new ContainerWorkingWithObjects(12 , "Hello);
//as 12 and "Hello" are children of the object class.

//Then getting and setting value lands into issues. 
//Hence we need to define a generic types so that we can enforce to the compiler
//that it does compiler checking  when assigning values and fetching values.

//Thus it saves us from providing explicit type casting code.
//
class ContainerWorkingWithObjects {
    Object item1;
    Object item2;
    
    public ContainerWorkingWithObjects(String item1, String item2) {
        this.item1 = item1;
        this.item2 = item2;
    }
    
    
    public void printItems() {
        System.out.println("Printing contents of container" );
        System.out.println("Item 1 " + item1);
        System.out.println("Item 2 " + item2);
        
    }
}

