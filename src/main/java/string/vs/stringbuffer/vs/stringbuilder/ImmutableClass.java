package string.vs.stringbuffer.vs.stringbuilder;

public class ImmutableClass {

    // 1. Mark your class final,

    // We should declare our class final to forbids its extension so no one can extend our class
    // and destroy its immutability. If it is not final then in future someone might extend it and
    // modify the behaviour to change the state.

    // 2. Mark all the fields private,

    // We should mark all the fields private so no one can access them outside of the class.

    // 3. Mark all fields final as well,

    // Mark all the fields final so even we will not be able to change the fields outside of the constructor.

    // 4. Provide an argument constructor with all initialization logic,

    // A constructor is a place to write our object initialization logic because constructor gets
    // called whenever we create an object.

    // So when we want to set our object's state during object creation only, we need to set it
    // in the constructor and that's why we need to have an argument constructor in case of an immutable class.

    // 5. Initialize all mutable fields by deep copying,

    // If our immutable object holds a reference to other immutable objects i.e. String, Integer
    // we do not need to worry because we know they will not allow any change in their state.

    // But if our object holds references to some mutable objects and those mutable objects are
    // also getting referred from somewhere else, in that case, our object's immutability is in danger.

    // In our example, our ImmutableEmployee class holds a reference to Date class which is
    // mutable in nature. In below lines of code we are creating a variable dob which is holding
    // a Date object and then we are passing it to ImmutableEmployee's constructor and creating an object
    // which is being referred from employee.

    // 6. Do not provide setters for your fields,
    // Well, providing setters will allow us to modify the state of the object which we do not want.

    // 7. Return a deep copy of mutable fields from the getters.
    // If we return all mutable fields directly, we will face the same scenario as discussed in point 5 
    // and after executing below code both employee.dob and temp will point to the same object,
    // now if we make any change in temp, employee.dob will also change
    // which again means employee will not remain immutable.

    // So instead of returning mutable fields, we should return their deep copy and as we have done that,
    // we can see in below code employee remains same and immutable at the end.

    public static void main(String[] args) {
        // TODO Auto-generated method stub

    }

}
