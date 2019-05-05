package understanding.object.overriding.methods;

//var arg is not same as int argument. this is not override but overloading

public class VarargOverrideTester {

    public static void main(String[] args) {
        VarArgParent v1= new VarArgParent();
        v1.m1(1);
        
        VarArgParent v2= new VarArgChild();
        v2.m1(1);

    }

}

class VarArgParent{
    
    void m1(int ...x) {
        System.out.println("Parent method");
    }
    
}

class VarArgChild extends VarArgParent{
    
    void m1(int x) {
        System.out.println("Child method method");
    }
    
}