import java.util.Scanner;

public class House_Rent {

    static double calculateRent(double monthlyRent, int months) {
        return monthlyRent * months;
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of houses: ");
        int n = sc.nextInt();

        int[] houseNumber = new int[n];
        double[] monthlyRent = new double[n];
        int[] months = new int[n];
        double[] totalRent = new double[n];

        for (int i = 0; i < n; i++) {

            System.out.println("\nEnter details for House " + (i + 1));

            System.out.print("Enter House Number: ");
            houseNumber[i] = sc.nextInt();

            System.out.print("Enter Monthly Rent: ");
            monthlyRent[i] = sc.nextDouble();

            System.out.print("Enter Number of Months: ");
            months[i] = sc.nextInt();

            totalRent[i] = calculateRent(monthlyRent[i], months[i]);
        }

        System.out.println("\n===== HOUSE RENT DETAILS =====");

        for (int i = 0; i < n; i++) {

            System.out.println("\nHouse Number  : " + houseNumber[i]);
            System.out.println("Monthly Rent  : ₹" + monthlyRent[i]);
            System.out.println("Months        : " + months[i]);
            System.out.println("Total Rent    : ₹" + totalRent[i]);
        }

        sc.close();
    }
}