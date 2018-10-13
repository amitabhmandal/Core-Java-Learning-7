package collection.learning;

import java.util.Stack;

public class SttackLearning {

    public SttackLearning() {
        // TODO Auto-generated constructor stub
    }

    public static void main(String[] args) {
       Stack stack = new Stack();
       stack.push("A");
       stack.push("B");
       stack.push("C");
       System.out.println(stack);
       System.out.println(stack.search("A"));
       System.out.println(stack.search("Z"));
    }

}
