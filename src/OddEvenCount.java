public class OddEvenCount {
    public static void main(String[] args) {

        int oddCount = 0;
        int evenCount = 0;

        for (int i = 1; i <= 50; i++) {

            if (i % 2 == 0) {
                System.out.println(i + " is Even");
                evenCount++;
            } else {
                System.out.println(i + " is Odd");
                oddCount++;
            }
        }

        System.out.println("-------------------");
        System.out.println("Even Count = " + evenCount);
        System.out.println("Odd Count = " + oddCount);
    }
}