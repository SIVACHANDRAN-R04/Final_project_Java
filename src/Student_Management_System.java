import java.util.Scanner;

public class Student_Management_System {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter Student Name: ");
        String stname = sc.nextLine();

        System.out.print("Enter Student ID: ");
        int stid = sc.nextInt();

        System.out.print("Enter Mark 1: ");
        int mark1 = sc.nextInt();

        System.out.print("Enter Mark 2: ");
        int m2 = sc.nextInt();

        System.out.print("Enter Mark 3: ");
        int m3 = sc.nextInt();

        int total = mark1 + m2 + m3;
        double avg = total / 3.0;

        System.out.println("\n--- Student Details ---");
        System.out.println("Student Name : " + stname);
        System.out.println("Student ID   : " + stid);
        System.out.println("Mark 1       : " + mark1);
        System.out.println("Mark 2       : " + m2);
        System.out.println("Mark 3       : " + m3);
        System.out.println("Total        : " + total);
        System.out.println("Average      : " + avg);

        sc.close();
    }
}
