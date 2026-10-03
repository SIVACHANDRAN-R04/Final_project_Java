import java.util.Scanner;

public class Search_Array {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.println("Enter the size of an array:");
        int n = sc.nextInt();

        int[] array = new int[n];

        System.out.println("Enter the array elements:");
        for (int i = 0; i < n; i++) {
            array[i] = sc.nextInt();
        }

        System.out.println("Enter the number to search:");
        int search = sc.nextInt();

        int index = -1;

        for (int i = 0; i < n; i++) {
            if (array[i] == search) {
                index = i;
                break;
            }
        }

        if (index != -1) {
            System.out.println("Number found at index position: " + index);
        } else {
            System.out.println("Number not found in the array");
        }

        sc.close();
    }
}