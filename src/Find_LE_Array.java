import java.util.Scanner;

public class Find_LE_Array {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.println("Enter the size of an array:");
        int n = sc.nextInt();

        int[] array1 = new int[n];

        System.out.println("Enter the array elements:");
        for (int i = 0; i < n; i++) {
            array1[i] = sc.nextInt();
        }

        int largest = array1[0];

        for (int i = 1; i < n; i++) {
            if (largest <= array1[i]) {
                largest = array1[i];
            }
        }

        System.out.println("The Largest Element in the array is: " + largest);

        sc.close();
    }
}