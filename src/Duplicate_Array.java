import java.util.Scanner;

public class Duplicate_Array {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.println("Enter the size of an array:");
        int n = sc.nextInt();

        int[] array = new int[n];

        System.out.println("Enter the array elements:");
        for (int i = 0; i < n; i++) {
            array[i] = sc.nextInt();
        }
        int count=0;

        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {

                if (array[i] == array[j]) {
                    System.out.println("Duplicate elements:"+array[i]);
                    count++;
                    break;
                }

            }
        }
        if(count==0)
        System.out.println("There Is No Duplicate elements");

        sc.close();
    }
}