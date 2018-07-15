package constructor;
/*
 * TO INITIALIZE OBJECT AND NOT TO CREATE OBJECT
 * 
 * Importance of Initilization Block
 * Besides initiliazing object I need to carry out certain default activity for each object
 * such as updating record in the database. Thereby we can use initialization block.
 * 
 * Both constructor and instance block will be executed for every object creation.
 * But instance block first and followed by constructor next.
 * 
 * Example where instance block shall be used compared to constructor
 * 
 * public class InstanceBlockVsConstructor  {
    
    static int count = 0;
    
    InstanceBlockVsConstructor(){
        count++;
    }
    
    InstanceBlockVsConstructor(int i){
        count ++;
    }
    
    InstanceBlockVsConstructor(double d){
        count ++;
    }
    public static void main(String[] args) {
        
        //To count the number of Objects created
        InstanceBlockVsConstructor in1= new InstanceBlockVsConstructor();
        
        InstanceBlockVsConstructor in2= new InstanceBlockVsConstructor();
        
        InstanceBlockVsConstructor in3= new InstanceBlockVsConstructor();
        
        //count code is being repeated everytime a constructor is called.
        //It makes more sense to keep a instance block where in common code will
        //will be kept
        
        //moreover if from constructor another constructor is called 
        //then it will lead to error count value as count will be 
        //incremented twice.
        
        
       
    }
}
 * 
 * RULES FOR CONSTRUCTOR
 * 1. Name of the class and name of the constructor should be same.
 * 2. Return type concept not applicable for constructor even void also.
 * 3. Allowed modifiers for constructor is public protected private and default.
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 */
public class ConstructorTester {

	public static void main(String[] args) {
		System.out.println("Hello World");

	}

}
