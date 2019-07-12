package protectedunderstanding;

//You use protected when

//Your class is designed for inheritance - 

//You expect the users of your library to inherit from the class that you are designing. 
//Very often the class will be abstract.

//The class provides special functionality to its derived classes that must not be visible to other classes - 
//You know that derived classes must have access to information that would otherwise be private, or

//The derived classes must provide functionality to the base class - See Template Method Pattern for 
//information about this use of protected methods.
//Note that protected methods are similar to public methods in the sense that once you put them in, 
//they need to stay in for as long as you support your library. 
//Unlike private methods that you can freely remove, protected methods 
//remain a part of the interface of your class.
public class Protect {

    public static void main(String[] args) {
       StringBuilder sb = new StringBuilder();
       sb.append(new String("abc"));
       
       StringBuilder MY_OBJ= "Hello";

    }

}
