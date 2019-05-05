package operators;

// byte + byte = int 

// byte + short = int 

// short + short = int 

// byte + long = long 

// long + double = double 

// float + long = float 

// char + char = int 

// chat + float = float 

// byte >> short >> int >> long >> float >> double 

// char >> int >> long >> float >> double 

public class OperandConcatenationTester {

    public static void main(String[] args) {

        System.out.println('a' + 'b');
        System.out.println('a' + 0.89);
        System.out.println('a' + 'b');
    }

}
