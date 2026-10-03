import java.util.Scanner;

class UserAuthentication {

    String correctEmail = "java@gmail.com";
    String correctPassword = "1234";

    long correctPhone = 1234567892;
    int correctOtp = 1234;

    String correctSocialId = "JAVA1234";


    void login(String email, String password) {

        System.out.println("\n--- Email Login ---");

        if (email.equals(correctEmail) && password.equals(correctPassword)) {

            System.out.println("Email Verified");
            System.out.println("Password Verified");
            System.out.println("Login Successful");

        } else {

            System.out.println("Invalid Email or Password");
            System.out.println("Access Denied");
        }
    }


    void login(long phone, int otp) {

        System.out.println("\n--- Phone Login ---");

        if (phone == correctPhone && otp == correctOtp) {

            System.out.println("Phone Verified");
            System.out.println("OTP Verified");
            System.out.println("Login Successful");

        } else {

            System.out.println("Invalid Phone Number or OTP");
            System.out.println("Access Denied");
        }
    }


    void login(String socialId) {

        System.out.println("\n--- Social Login ---");

        if (socialId.equals(correctSocialId)) {

            System.out.println("Social ID Verified");
            System.out.println("Login Successful");

        } else {

            System.out.println("Invalid Social ID");
            System.out.println("Access Denied");
        }
    }
}


public class UserAuthenticationProgram {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        UserAuthentication user = new UserAuthentication();

        System.out.println("USER AUTHENTICATION");

        System.out.println("\n1. Email and Password");
        System.out.println("2. Phone and OTP");
        System.out.println("3. Social ID");

        System.out.print("\nEnter your choice: ");
        int choice = sc.nextInt();

        sc.nextLine();

        if (choice == 1) {

            System.out.print("Enter Email: ");
            String email = sc.nextLine();

            System.out.print("Enter Password: ");
            String password = sc.nextLine();

            user.login(email, password);

        }
        else if (choice == 2) {

            System.out.print("Enter Phone Number: ");
            long phone = sc.nextLong();

            System.out.print("Enter OTP: ");
            int otp = sc.nextInt();

            user.login(phone, otp);

        }
        else if (choice == 3) {

            System.out.print("Enter Social ID: ");
            String socialId = sc.nextLine();

            user.login(socialId);

        }
        else {

            System.out.println("Invalid Choice");
        }

        sc.close();
    }
}