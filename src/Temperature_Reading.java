import java.util.Scanner;

public class Temperature_Reading {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of persons: ");
        int persons = sc.nextInt();

        System.out.print("Enter number of days: ");
        int days = sc.nextInt();

        double[][] temperature = new double[persons][days];

        for (int i = 0; i < persons; i++) {
            System.out.println("\nEnter temperature for Person " + (i + 1));

            for (int j = 0; j < days; j++) {
                System.out.print("Day " + (j + 1) + ": ");
                temperature[i][j] = sc.nextDouble();
            }
        }

        System.out.println("\n--- Temperature Report ---");

        for (int i = 0; i < persons; i++) {

            System.out.println("\nPerson " + (i + 1));

            for (int j = 0; j < days; j++) {

                double temp = temperature[i][j];

                System.out.print("Day " + (j + 1) + " : "
                        + temp + "°C - ");

                if (temp < 37) {
                    System.out.println("Normal");
                }
                else if (temp < 38) {
                    System.out.println("Mild Fever");
                }
                else if (temp < 39) {
                    System.out.println("Fever");
                }
                else {
                    System.out.println("High Fever");
                }
            }
        }
    }
}