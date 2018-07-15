package exception;

import java.util.HashMap;
import java.util.Map;

/* ALWAYS OVER-RIDE HASHCODE WHEN YOU OVER-RIDE EQUALS
 * 
 * 
 * If we are over-riding equals method for logical equivalence then we should also over-ride
 * hashcode method else it will return buggy output when hashing related collections which 
 * includes Hashtable, HashMap, and HashSet
 * 
 * CONTRACT #1
 * Whenever it is invoked on the same object more than once during an execution
 * of an application, the hashCode method must consistently return the
 * same integer, provided no information used in equals comparisons on the
 * object is modified. This integer need not remain consistent from one execution
 * of an application to another execution of the same application
 * 
 * CONTRACT #2
 * If two objects are equal according to the equals(Object) method, then calling
 * the hashCode method on each of the two objects must produce the same
 * integer result.
 * 
 * CONTRACT #3
 * It is not required that if two objects are unequal according to the equals(Object)
 * method, then calling the hashCode method on each of the two objects
 * must produce distinct integer results. However, the programmer should be
 * aware that producing distinct integer results for unequal objects may improve
 * the performance of hash tables.
 * 
 * EQUALS Method provides two instances are logically equal
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 */

public class EqualsHashCodeContractTester {

    public static void main(String[] args) {
        System.out.println("Understanding HashCode contract");

        Map<PhoneNumber, String> m = new HashMap<PhoneNumber, String>();

        // Two instance of PhoneNumber involved

        // First instance of Phone Number for Insertion into Map
        m.put(new PhoneNumber(707, 867, 5309), "Jenny");

        // Second Instance of Phone Number for is used for (attempted) retrieval
        System.out.println(m.get(new PhoneNumber(707, 867, 5309)));

        // The PhoneNumber class’s failure to override
        // hashCode causes the two equal instances to have unequal hash codes, in violation
        // of the hashCode contract.

        // Hence the above fetch will return Null.

        // Therefore the get method is likely to look for the phone
        // number in a different hash bucket from the one in which it was stored by the put
        // method

        // Even if the two instances happen to hash to the same bucket, the get
        // method will almost certainly return null, as HashMap has an optimization that
        // caches the hash code associated with each entry and doesn’t bother checking for
        // object equality if the hash codes don’t match.

        // Fixing this problem is as simple as providing a proper hashCode method for
        // the PhoneNumber class.

        // The worst possible legal hash function - never use!
        // @Override public int hashCode() { return 42; }

        // Do not be tempted to exclude significant parts of an object from the hash
        // code computation to improve performance
        
        //When we dont over-ride the hashcode when using collections like map then it uses system 
        //generated hashcode which happens to be different even when the object attributes are the same
    }

}

final class PhoneNumber {
    private final short areaCode;
    private final short prefix;
    private final short lineNumber;

    public PhoneNumber(int areaCode, int prefix, int lineNumber) {
        rangeCheck(areaCode, 999, "area code");
        rangeCheck(prefix, 999, "prefix");
        rangeCheck(lineNumber, 9999, "line number");
        this.areaCode = (short) areaCode;
        this.prefix = (short) prefix;
        this.lineNumber = (short) lineNumber;
    }

    private static void rangeCheck(int arg, int max, String name) {
        if (arg < 0 || arg > max)
            throw new IllegalArgumentException(name + ": " + arg);
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + areaCode;
        result = prime * result + lineNumber;
        result = prime * result + prefix;
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof PhoneNumber))
            return false;
        PhoneNumber pn = (PhoneNumber) o;
        return pn.lineNumber == lineNumber && pn.prefix == prefix && pn.areaCode == areaCode;
    }

}