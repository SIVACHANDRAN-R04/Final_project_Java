import java.util.Scanner;

public class Area_Menu {

    static void circle(Scanner sc) {
        System.out.print("Enter radius: ");
        double radius = sc.nextDouble();

        double area = Math.PI * radius * radius;

        System.out.println("Area of Circle = " + area);
    }

    static void rectangle(Scanner sc) {
        System.out.print("Enter length: ");
        double length = sc.nextDouble();

        System.out.print("Enter width: ");
        double width = sc.nextDouble();

        double area = length * width;

        System.out.println("Area of Rectangle = " + area);
    }

    static void square(Scanner sc) {
        System.out.print("Enter side: ");
        double side = sc.nextDouble();

        double area = side * side;

        System.out.println("Area of Square = " + area);
    }

    static void triangle(Scanner sc) {
        System.out.print("Enter base: ");
        double base = sc.nextDouble();

        System.out.print("Enter height: ");
        double height = sc.nextDouble();

        double area = 0.5 * base * height;

        System.out.println("Area of Triangle = " + area);
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int choice;

        do {
            System.out.println("\n===== AREA CALCULATOR =====");
            System.out.println("1. Circle");
            System.out.println("2. Rectangle");
            System.out.println("3. Square");
            System.out.println("4. Triangle");
            System.out.println("5. Exit");

            System.out.print("Enter your choice: ");
            choice = sc.nextInt();

            switch (choice) {

                case 1:
                    circle(sc);
                    break;

                case 2:
                    rectangle(sc);
                    break;

                case 3:
                    square(sc);
                    break;

                case 4:
                    triangle(sc);
                    break;

                case 5:
                    System.out.println("Program ended.");
                    break;

                default:
                    System.out.println("Invalid choice.");
            }

        } while (choice != 5);

        sc.close();
    }
}