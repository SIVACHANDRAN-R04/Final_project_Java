import java.util.Scanner;

public class Calculating_Month {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter month (jan, feb, mar, ...): ");
        String month = sc.next().toLowerCase();

        System.out.print("Enter year: ");
        int year = sc.nextInt();
        int days=0;

         switch (month) {

            case "jan", "mar", "may", "jul", "aug", "oct", "dec" -> days=31;

            case "apr", "jun", "sep", "nov" -> days=30;

            case "feb"-> {
                if (year % 400 == 0 || (year % 4 == 0 && year % 100 != 0)) {
                    days = 29;
                } else {
                    days = 28;
                }
            }

            default -> days=0;
        };

        if (days == 0) {
            System.out.println("Invalid month");
        } else {
            System.out.println("Month: " + month);
            System.out.println("Number of days: " + days);

            if (month.equals("feb")) {
                if (days == 29) {
                    System.out.println("Leap Year");
                } else {
                    System.out.println("Not a Leap Year");
                }
            }
        }

        sc.close();
    }
}
