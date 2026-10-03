import java.util.Scanner;

public class EB_Bill_6Months {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int totalUnits = 0;
        double totalBill = 0;

        for (int month = 1; month <= 6; month++) {

            System.out.print("Enter units for Month " + month + ": ");
            int units = sc.nextInt();

            double bill;

            if (units <= 100) {
                bill = units * 2;
            }
            else if (units <= 200) {
                bill = (100 * 2) + ((units - 100) * 3);
            }
            else {
                bill = (100 * 2) + (100 * 3) + ((units - 200) * 5);
            }

            System.out.println("Month " + month + " Bill = ₹" + bill);

            totalUnits = totalUnits + units;
            totalBill = totalBill + bill;
        }

        System.out.println("----------------------");
        System.out.println("Total Units = " + totalUnits);
        System.out.println("Total Bill for 6 Months = ₹" + totalBill);

        sc.close();
    }
}
