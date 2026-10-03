import java.util.Scanner;

public class Simple_Calculator {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        double num1, num2, result;
        char operator;

        System.out.print("Enter first number: ");
        num1 = sc.nextDouble();

        System.out.print("Enter operator (+, -, *, /): ");
        operator = sc.next().charAt(0);

        System.out.print("Enter second number: ");
        num2 = sc.nextDouble();

        switch (operator) {

            case '+':
                result = num1 + num2;
                System.out.println("Result = " + result);
                break;

            case '-':
                result = num1 - num2;
                System.out.println("Result = " + result);
                break;

            case '*':
                result = num1 * num2;
                System.out.println("Result = " + result);
                break;

            case '/':
                result = num1 / num2;
                System.out.println("Result = " + result);
                break;

            default:
                System.out.println("Invalid operator");
        }

        sc.close();
    }
}
