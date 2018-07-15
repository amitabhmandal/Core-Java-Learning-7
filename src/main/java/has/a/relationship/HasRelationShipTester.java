package has.a.relationship;


//Has A relationship 

//It can also be defined as composition or aggregation

//No specific keyword required besides the new operator

//It provides the biggest feature as reusability is the biggest advantage

//Difference between composition and aggregation

//Composition Definition:
//Example: University(Container Object) has several departments(Contained Objects).
//If the university is closed then all the departments shall be closed.
//Thus without existing university there is no chance of existing of department
//then the university and department is strongly associated. This is called Composition.
//Strong association between objects is called composition.

//Most important: In composition, container Object holds directly the contained Object


//Aggregation Definition:
//If within the department Object there are several proffessors will work.
//However if the department closes then the proffessors can work somewhere else.
//Hence we can conclude that the department is not strongly connected with the professors.
//This is called Aggregation.
//Thus without existing of Container Object if the contained Object can exist it is called
//Aggregation.

//Most important: In Aggregation, container Object holds just references of contained Object


//Both the relationship provides Re-usability however when to choose what?
//When to go for Is-A Relationship 
//If in our requirement if we require the total functionality of the class then we should go for
//Is-A relationship. For example Student is a Person. Hence student requires all the functionality
//of the person hence it is advisable to go for Is-A relationship

//When to go for Has-A Relationship
//If our requirement requires only to access part of the Object then we should go Has-A 
//relationship.

public class HasRelationShipTester {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
