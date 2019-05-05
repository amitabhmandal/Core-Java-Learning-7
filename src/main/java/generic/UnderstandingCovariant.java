package generic;

public class UnderstandingCovariant {

    public static void main(String[] args) {
        Integer[] ints = new Integer[] {1,2,3};
        Number[] nums = ints;
        nums[2] = 3.14;

    }

}
