package understanding.object.overriding.methods;

public class InstanceVariableTester {

    //this code proves the fact that override is only seen in methods and not in instance variables
    public static void main(String[] args) {
        InstanceParent i1= new InstanceParent();
        
        System.out.println(i1.x);
        InstanceParent i2 = new InstanceChild();
        System.out.println(i2.x); 
        
        InstanceChild i3= new InstanceChild();
        System.out.println(i3.x);
        

    }

}


class InstanceParent {
    int x=9999;
    
    
}

class InstanceChild extends InstanceParent{
    int x=8888;
    
}