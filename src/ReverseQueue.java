import java.util.*;

public class ReverseQueue {
    public static void main(String[] args) {

        Queue<Integer> queue = new LinkedList<>();

        queue.add(10);
        queue.add(20);
        queue.add(30);
        queue.add(40);
        queue.add(50);

        System.out.println("Original: " + queue);

        List<Integer> list = new ArrayList<>(queue);

        Collections.reverse(list);

        System.out.println("Reversed: " + list);
    }
}