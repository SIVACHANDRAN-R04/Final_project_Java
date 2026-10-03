import java.util.Scanner;

interface Cab {

    void bookRide(String customerName);

    void calculateFare(double distance);
}

class Minicab implements Cab {

    public void bookRide(String customerName) {
        System.out.println("Mini Cab booked for " + customerName);
    }

    public void calculateFare(double distance) {
        double fare = distance * 12;
        System.out.println("Mini Cab Fare: ₹" + fare);
    }
}

class Autocab implements Cab {

    public void bookRide(String customerName) {
        System.out.println("Auto Cab booked for " + customerName);
    }

    public void calculateFare(double distance) {
        double fare = distance * 10;
        System.out.println("Auto Cab Fare: ₹" + fare);
    }
}

class SedanCab implements Cab {

    public void bookRide(String customerName) {
        System.out.println("Sedan Cab booked for " + customerName);
    }

    public void calculateFare(double distance) {
        double fare = distance * 18;
        System.out.println("Sedan Cab Fare: ₹" + fare);
    }
}

public class CabBooking {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter Customer Name: ");
        String customerName = sc.nextLine();

        System.out.print("Enter Distance (km): ");
        double distance = sc.nextDouble();

        System.out.println("\n--- Cab Booking ---");
        System.out.println("1. Mini Cab");
        System.out.println("2. Auto Cab");
        System.out.println("3. Sedan Cab");
        System.out.println("4. Exit");

        System.out.print("Enter your choice: ");
        int choice = sc.nextInt();

        Cab cab;

        switch (choice) {

            case 1:
                cab = new Minicab();
                cab.bookRide(customerName);
                cab.calculateFare(distance);
                break;

            case 2:
                cab = new Autocab();
                cab.bookRide(customerName);
                cab.calculateFare(distance);
                break;

            case 3:
                cab = new SedanCab();
                cab.bookRide(customerName);
                cab.calculateFare(distance);
                break;

            case 4:
                System.out.println("Thank you!");
                break;

            default:
                System.out.println("Invalid Choice");
        }

        sc.close();
    }
}