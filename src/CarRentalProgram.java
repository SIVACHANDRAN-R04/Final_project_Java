import java.util.Scanner;

class CarRental {

    String carName;
    double hourlyRate;
    double dailyRate;
    double driverCharge;

    CarRental(String carName, double hourlyRate,
              double dailyRate, double driverCharge) {

        this.carName = carName;
        this.hourlyRate = hourlyRate;
        this.dailyRate = dailyRate;
        this.driverCharge = driverCharge;
    }

    void rentCar(double hours) {

        double total = hours * hourlyRate;

        System.out.println("\n--- Hourly Rental ---");
        System.out.println("Car Name     : " + carName);
        System.out.println("Hours        : " + hours);
        System.out.println("Total Amount : " + total);
    }

    void rentCar(int days) {

        double total = days * dailyRate;

        System.out.println("\n--- Daily Rental ---");
        System.out.println("Car Name     : " + carName);
        System.out.println("Days         : " + days);
        System.out.println("Total Amount : " + total);
    }

    void rentCar(int days, boolean withDriver) {

        double total = days * dailyRate;

        if (withDriver) {
            total = total + (days * driverCharge);
        }

        System.out.println("\n--- Rental Details ---");
        System.out.println("Car Name     : " + carName);
        System.out.println("Days         : " + days);
        System.out.println("Driver       : " + (withDriver ? "Yes" : "No"));
        System.out.println("Total Amount : " + total);
    }
}


public class CarRentalProgram {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        CarRental car = new CarRental(
                "Toyota",
                500,
                3000,
                1000
        );

        System.out.println("CAR RENTAL SYSTEM");

        System.out.println("\n1. Rent for Hours");
        System.out.println("2. Rent for Days");
        System.out.println("3. Rent for Days with/without Driver");

        System.out.print("Enter your choice: ");
        int choice = sc.nextInt();

        if (choice == 1) {

            System.out.print("Enter number of hours: ");
            int hours = sc.nextInt();

            car.rentCar(hours);

        }
        else if (choice == 2) {

            System.out.print("Enter number of days: ");
            int days = sc.nextInt();

            car.rentCar(days);

        }
        else if (choice == 3) {

            System.out.print("Enter number of days: ");
            int days = sc.nextInt();

            System.out.print("Do you need a driver? (true/false): ");
            boolean withDriver = sc.nextBoolean();

            car.rentCar(days, withDriver);

        }
        else {

            System.out.println("Invalid Choice");
        }

        sc.close();
    }
}