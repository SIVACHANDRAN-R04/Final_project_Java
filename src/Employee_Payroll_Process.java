import java.util.Scanner;

public class Employee_Payroll_Process {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter Employee Name: ");
        String empname = sc.nextLine();

        System.out.print("Enter Employee ID: ");
        int empid = sc.nextInt();

        sc.nextLine();

        System.out.print("Enter Department: ");
        String empdep = sc.nextLine();

        System.out.print("Enter Designation: ");
        String empdesig = sc.nextLine();

        System.out.print("Enter Years of Experience: ");
        int empyear = sc.nextInt();

        System.out.print("Enter Basic Salary: ");
        double basic = sc.nextDouble();

        double da = basic * 10 / 100;

        double hra = basic * 20 / 100;

        double pf = basic * 12 / 100;

        double gp = basic + da + hra;

        double np = gp - pf;

        System.out.println("\n--- Employee Payroll Details ---");

        System.out.println("Employee Name       : " + empname);
        System.out.println("Employee ID         : " + empid);
        System.out.println("Department          : " + empdep);
        System.out.println("Designation         : " + empdesig);
        System.out.println("Years of Experience : " + empyear);

        System.out.println("Basic Salary        : " + basic);
        System.out.println("DA                  : " + da);
        System.out.println("HRA                 : " + hra);
        System.out.println("PF                  : " + pf);
        System.out.println("Gross Pay           : " + gp);
        System.out.println("Net Pay             : " + np);

        sc.close();
    }

}
