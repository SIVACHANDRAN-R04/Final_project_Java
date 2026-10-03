import java.util.Scanner;

public class Employee_Payroll {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of employees: ");
        int employees = sc.nextInt();

        System.out.print("Enter number of months: ");
        int months = sc.nextInt();

        double[][] salary = new double[employees][months];

        for (int i = 0; i < employees; i++) {

            System.out.println("\nEnter salary for Employee " + (i + 1));

            for (int j = 0; j < months; j++) {

                System.out.print("Month " + (j + 1) + ": ");
                salary[i][j] = sc.nextDouble();
            }
        }

        double highestSalary = salary[0][0];
        int highestEmployee = 0;
        int highestMonth = 0;

        for (int i = 0; i < employees; i++) {

            for (int j = 0; j < months; j++) {

                if (salary[i][j] > highestSalary) {

                    highestSalary = salary[i][j];
                    highestEmployee = i;
                    highestMonth = j;
                }
            }
        }

        System.out.println("\n--- Employee Payroll ---");

        System.out.println("Highest Salary : ₹" + highestSalary);
        System.out.println("Employee       : " + (highestEmployee + 1));
        System.out.println("Month          : " + (highestMonth + 1));
    }
}