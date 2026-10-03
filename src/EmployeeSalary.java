import java.util.Scanner;

 class Employee {

    int empId;
    String empName;
    double basicSalary;

    Employee(int empId, String empName, double basicSalary) {
        this.empId = empId;
        this.empName = empName;
        this.basicSalary = basicSalary;
    }

    void displayDetails() {
        System.out.println("Employee ID     : " + empId);
        System.out.println("Employee Name   : " + empName);
        System.out.println("Basic Salary    : " + basicSalary);
    }
}


class Manager extends Employee {

    double bonus = 10000;

    Manager(int empId, String empName, double basicSalary) {
        super(empId, empName, basicSalary);
    }

    void calculateSalary() {

        double salary = basicSalary + bonus;

        displayDetails();
        System.out.println("Bonus           : " + bonus);
        System.out.println("Total Salary    : " + salary);
    }
}


class Developer extends Employee {

    double projectAllowance = 5000;

    Developer(int empId, String empName, double basicSalary) {
        super(empId, empName, basicSalary);
    }

    void calculateSalary() {

        double salary = basicSalary + projectAllowance;

        displayDetails();
        System.out.println("Project Allowance: " + projectAllowance);
        System.out.println("Total Salary     : " + salary);
    }
}


class Intern extends Employee {

    double stipend = 15000;

    Intern(int empId, String empName, double basicSalary) {
        super(empId, empName, basicSalary);
    }

    void calculateSalary() {

        double salary = basicSalary + stipend;

        displayDetails();
        System.out.println("Stipend          : " + stipend);
        System.out.println("Total Salary     : " + salary);
    }
}


public class EmployeeSalary {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter Employee ID: ");
        int id = sc.nextInt();

        sc.nextLine();

        System.out.print("Enter Employee Name: ");
        String name = sc.nextLine();

        System.out.print("Enter Basic Salary: ");
        double salary = sc.nextDouble();

        System.out.println("\nSelect Employee Type");
        System.out.println("1. Manager");
        System.out.println("2. Developer");
        System.out.println("3. Intern");

        System.out.print("Enter your choice: ");
        int choice = sc.nextInt();

        System.out.println("\n----- Employee Details -----");

        if (choice == 1) {

            Manager manager = new Manager(id, name, salary);
            manager.calculateSalary();

        }
        else if (choice == 2) {

            Developer developer = new Developer(id, name, salary);
            developer.calculateSalary();

        }
        else if (choice == 3) {

            Intern intern = new Intern(id, name, salary);
            intern.calculateSalary();

        }
        else {

            System.out.println("Invalid Choice");
        }

        sc.close();
    }
}