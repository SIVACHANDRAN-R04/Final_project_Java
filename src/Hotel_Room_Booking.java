import java.util.Scanner;

public class Hotel_Room_Booking {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int room, type;
        int price = 0;

        System.out.println("===== HOTEL ROOM BOOKING =====");

        System.out.println("1. Single Room");
        System.out.println("2. Double Room");

        System.out.print("Select Room: ");
        room = sc.nextInt();

        switch (room) {

            case 1:
                System.out.println("\n--- Single Room ---");
                System.out.println("1. AC - ₹1500");
                System.out.println("2. Non-AC - ₹1000");

                System.out.print("Select Type: ");
                type = sc.nextInt();

                switch (type) {
                    case 1:
                        price = 1500;
                        System.out.println("AC Single Room Selected");
                        break;

                    case 2:
                        price = 1000;
                        System.out.println("Non-AC Single Room Selected");
                        break;

                    default:
                        System.out.println("Invalid Type");
                }
                break;

            case 2:
                System.out.println("\n--- Double Room ---");
                System.out.println("1. AC - ₹2000");
                System.out.println("2. Non-AC - ₹1500");

                System.out.print("Select Type: ");
                type = sc.nextInt();

                switch (type) {
                    case 1:
                        price = 2000;
                        System.out.println("AC Double Room Selected");
                        break;

                    case 2:
                        price = 1500;
                        System.out.println("Non-AC Double Room Selected");
                        break;

                    default:
                        System.out.println("Invalid Type");
                }
                break;

            default:
                System.out.println("Invalid Room");
        }

        if (price != 0) {
            System.out.println("Room Price: ₹" + price);
            System.out.println("Room Booked Successfully!");
        }

        sc.close();
    }
}
