import java.util.ArrayList;
import java.util.Collections;

public class MaximumArrayList {
    public static void main(String[] args) {

        ArrayList<Integer> numbers = new ArrayList<>();

        numbers.add(10);
        numbers.add(50);
        numbers.add(20);
        numbers.add(80);
        numbers.add(30);

        int max = Collections.max(numbers);

        System.out.println("ArrayList: " + numbers);
        System.out.println("Maximum Number: " + max);
    }
}