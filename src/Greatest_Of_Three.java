import java.util.Scanner;

public class Greatest_Of_Three {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter the First number : ");
        int a=sc.nextInt();
        System.out.println("Enter the Second number : ");
        int b=sc.nextInt();
        System.out.println("Enter the Third number : ");
        int c=sc.nextInt();

        if (a>b&&a>c) {
            System.out.println(a+ " is the greater number");
        }
        else if (b>c) {
            System.out.println(b+ " is the greater number");
        }
        else {
            System.out.println(c+ " is the greater number");
        }

    }


    }

