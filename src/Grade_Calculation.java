import java.util.Scanner;

public class Grade_Calculation {


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

            // Calculate Total
            int total = mark1 + m2 + m3;

            // Calculate Average
            double avg = total / 3.0;

            // Calculate Grade
            String grade;

            if (avg > 90) {
                grade = "O Grade";
            }
            else if (avg >= 75 && avg < 90) {
                grade = "A Grade";
            }
            else if (avg >= 50 && avg < 75) {
                grade = "B Grade";
            }
            else if (avg >= 35) {
                grade = "Pass";
            }
            else {
                grade = "Fail";
            }


            System.out.println("\n=================================================");
            System.out.println("              STUDENT DETAILS");
            System.out.println("=================================================");

            System.out.printf("%-20s : %-15s%n", "Student Name", stname);
            System.out.printf("%-20s : %-15d%n", "Student ID", stid);
            System.out.printf("%-20s : %-15d%n", "Mark 1", mark1);
            System.out.printf("%-20s : %-15d%n", "Mark 2", m2);
            System.out.printf("%-20s : %-15d%n", "Mark 3", m3);
            System.out.printf("%-20s : %-15d%n", "Total", total);
            System.out.printf("%-20s : %-15.2f%n", "Average", avg);
            System.out.printf("%-20s : %-15s%n", "Grade", grade);

            System.out.println("=================================================");

            sc.close();
        }
    }
