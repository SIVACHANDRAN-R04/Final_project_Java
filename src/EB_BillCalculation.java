import java.util.Scanner;

public class EB_BillCalculation {
        public static void main(String[] args) {

            Scanner sc = new Scanner(System.in);

            System.out.print("Enter Consumer Name: ");
            String consumerName = sc.nextLine();

            System.out.print("Enter Consumer ID: ");
            int consumerId = sc.nextInt();
            sc.nextLine();

            System.out.print("Enter Type of Building: ");
            String type = sc.nextLine();

            System.out.print("Enter Current Reading: ");
            int currentReading = sc.nextInt();

            System.out.print("Enter Previous Reading: ");
            int previousReading = sc.nextInt();

            System.out.print("Enter Rate Per Unit: ");
            double rate = sc.nextDouble();

            int units = currentReading - previousReading;

            double bill = units * rate;

            System.out.println("\n----- EB Bill Details -----");

            System.out.println("Consumer Name    : " + consumerName);
            System.out.println("Consumer ID      : " + consumerId);
            System.out.println("Building Type    : " + type);
            System.out.println("Current Reading  : " + currentReading);
            System.out.println("Previous Reading : " + previousReading);
            System.out.println("Units Consumed   : " + units);
            System.out.println("Rate Per Unit    : " + rate);
            System.out.println("EB Bill Amount   : ₹" + bill);

            sc.close();
        }
    }

