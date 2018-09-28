package cloning;

public class CloningExample {

    public static void main(String[] args) {
        ShallowCopyExample first = new ShallowCopyExample(1,2);
        System.out.println("Shallow Copy Example" );
        first.b= 999;
        System.out.println(first);
        System.out.println("a = " + first.a);
        System.out.println("b = " + first.b);
        
        //over here we did not create a new 'second' object but created a reference
        //hence the hashcode of first and second remains to be the same.
        
        //so in this case in heap there will be only one object
        //and in the stack there will be two reference
        // first reference is first
        // second reference is second 
        ShallowCopyExample second = first;
        System.out.println(second);
        System.out.println("a = " + second.a);
        System.out.println("b = " + second.b);
        
        
        //DeepCopy :
        //In this we will create a new 'second' object
        
        //This will result in two objects in the heap and two references in the stack 
        //pointing to different locations in the heap
        //Now we will manually copy one attribute to another as shown below
        ShallowCopyExample third = new ShallowCopyExample();
        third.a  = first.a;
        third.b = first.b;
        System.out.println(third);
        //Disadvantage of using cloning: we will have to copy each attribute one by one
        
        
        
    }

}

class ShallowCopyExample{
    int a;
    int b;
    public ShallowCopyExample() {
    }
    
    public ShallowCopyExample(int a, int b) {
        this.a = a ;
        this.b = b;
    }
}

class DeepCopyExample{
    
}
