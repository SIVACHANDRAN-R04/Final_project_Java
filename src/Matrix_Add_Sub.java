import java.util.Scanner;

public class Matrix_Add_Sub {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of rows: ");
        int rows = sc.nextInt();

        System.out.print("Enter number of columns: ");
        int columns = sc.nextInt();

        int[][] matrix1 = new int[rows][columns];
        int[][] matrix2 = new int[rows][columns];

        int[][] addition = new int[rows][columns];
        int[][] subtraction = new int[rows][columns];

        System.out.println("Enter elements of First Matrix:");
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                matrix1[i][j] = sc.nextInt();
            }
        }

        System.out.println("Enter elements of Second Matrix:");
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                matrix2[i][j] = sc.nextInt();
            }
        }

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {

                addition[i][j] = matrix1[i][j] + matrix2[i][j];

                subtraction[i][j] = matrix1[i][j] - matrix2[i][j];
            }
        }

        System.out.println("\nMatrix Addition:");

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                System.out.print(addition[i][j] + " ");
            }
            System.out.println();
        }

        System.out.println("\nMatrix Subtraction:");

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                System.out.print(subtraction[i][j] + " ");
            }
            System.out.println();
        }
    }
}