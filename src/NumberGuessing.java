import java.util.Scanner;

public class NumberGuessing {

        public static void main(String[] args) {

            Scanner sc = new Scanner(System.in);

            int number = (int)(Math.random() * 100) + 1;
            int attempts = 5;
            int count=attempts;
            int i=1;

            System.out.println("Guess the number between 1 and 100");

//
//            for (int i = 1; i <= attempts; i++) {
            while(true) {
                System.out.println("You have " + count-- + " attempts.");

                System.out.print("Enter your guess: ");
                int guess = sc.nextInt();

                if (guess == number) {
                    System.out.println("Correct! You guessed the number.");
                    break;
                } else if (guess < number) {
                    System.out.println("your number is too low.");
                } else {
                    System.out.println("your number is too high");
                }

                if ( i==attempts) {
                    System.out.println("Your attempts are over.");
                    System.out.println("The correct number is: " + number);
                    break;
                }
//            }
                i++;
            }

            sc.close();
        }
    }
