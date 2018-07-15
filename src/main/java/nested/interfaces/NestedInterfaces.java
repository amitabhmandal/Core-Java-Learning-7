package nested.interfaces;

/* We can declare interfaces as member of a class or another interface
 * 
 * Such an interface is called as member interface or nested interface.
 * 
 * ====================
 * Interface in a class
 * ====================
 * Interfaces (or classes) can have only public and default access specifiers when
 *  declared outside any other class.
 *  
 * This interface declared in a class can either be default, public, protected not private.
 * 
 * While implementing the interface, we mention the interface as c_name.i_name where c_name 
 * is the name of the class in which it is nested and i_name is the name of the interface itself.
 * 
 * We cannot have private interface 
 * 
 * ========================
 * Interface in a Interface
 * ========================
 * An interface can be declared inside another interface also. We mention the interface as i_name1.i_name2 where i_name1 
 * is the name of the interface in which it is nested and i_name2 is the name of the interface to be implemented.
 * 
 * access specifier is public even if we have not written public. 
 * If we try to change access specifier of interface to anything other than public, we get compiler error. 
 * Remember, interface members can only be public..
 * 
 * 
 * Every method present inside an interface is public and static whether we are not defining it.
 * Hence we can implement inner interface implement directly without implementing outer interface.
 * 
 * Similarly, whenever we are implementing outer interface, we are not required to implement inner interface.
 * ie we can implement outer and inner interface independently.
 * 
 * ======================
 * Class inside Interface
 * ======================
 * the inner class is becoming as static inner class inside interface where we can access the members of 
 * inner class like we do in case of static inner class.
 * 
 * If the functionality of the class is closely associated with interface. Then it is highly recommended to declare inside
 * interface.
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 */

interface Test
{
    interface Yes
    {
        void show();
    }
    
    void outerShow();
}
 
class TestingTestYes implements Test.Yes
{
    public void show()
    {
        System.out.println("show method of interface");
    }
}

class TestingTest implements Test
{

    @Override
    public void outerShow(){
        System.out.println("outerShow method of interface");
    }
}

public class NestedInterfaces {

    public static void main(String[] args) {
        OuterClassContainingInterface.PublicInnerInterface publicInnerInterface = new TestingOuterClassContainingPublicInterface();
        publicInnerInterface.showPublicInnerInterface();

        
        OuterClassContainingInterface.ProtectedInnerInterface protectedInnerInterface = new TestingOuterClassContainingPublicProtectedInterface();
        protectedInnerInterface.showProtectedInnerInterface();
        
        Test.Yes obj;
        TestingTestYes t = new TestingTestYes();
        obj = t;
        obj.show();
        
        Test t1 = new TestingTest();
        t1.outerShow();
    }

}

class OuterClassContainingInterface{
    
    public interface PublicInnerInterface{
        void showPublicInnerInterface();
    }
    
    protected interface ProtectedInnerInterface{
        void showProtectedInnerInterface();
    }
    
    
    private interface PrivateInnerInterface{
        void showPrivateInnerInterface();
    }
    
    
    class Testing implements PrivateInnerInterface{

        @Override
        public void showPrivateInnerInterface() {
            // TODO Auto-generated method stub
            
        }
        
    }
}

class TestingOuterClassContainingPublicInterface implements OuterClassContainingInterface.PublicInnerInterface{

    @Override
    public void showPublicInnerInterface() {
        System.out.println("TestingOuterClassContainingPublicInterface: show method of OuterClassContainingInterface.PublicInnerInterface");
        
    }
    
}

class TestingOuterClassContainingPublicProtectedInterface implements OuterClassContainingInterface.ProtectedInnerInterface,
OuterClassContainingInterface.PublicInnerInterface{

    @Override
    public void showProtectedInnerInterface() {
        System.out.println("TestingOuterClassContainingPublicProtectedInterface: show method of OuterClassContainingInterface.ProtectedInnerInterface");
        
    }

    @Override
    public void showPublicInnerInterface() {
        System.out.println("TestingOuterClassContainingPublicProtectedInterface: show method of OuterClassContainingInterface.PublicInnerInterface");
        
    }
    
}
