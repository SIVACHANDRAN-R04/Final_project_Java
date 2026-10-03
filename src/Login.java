import java.util.Scanner;

public class Login {
    public static void main(String[] args) {
        String name1="siva";
        int pass=1234;
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter your name");
        String name=sc.next();
        System.out.println("Enter your password");
        int password=sc.nextInt();
        if(name.equals(name1)&& pass==password){
            System.out.println("Your succesfully loged in");

        }
        else{
            System.out.println("Your not loged in");
        }
    }
}
