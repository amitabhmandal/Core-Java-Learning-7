package clone.understanding;

public class PersonNotImplementingCloneable {

    public static void main(String[] args) throws CloneNotSupportedException {
        Person person = new Person();
        person.clone();

    }

}

class Person {
    private String name;
    
    public Person clone() throws CloneNotSupportedException{
        return null;
        
    }
}
