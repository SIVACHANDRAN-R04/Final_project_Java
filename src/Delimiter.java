
import java.util.Scanner;

public class Delimiter {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the Name,City,Course");

        sc.useDelimiter("[,\n]");

        String name = sc.next();
        String city = sc.next();
        String course = sc.next();

        System.out.println("Name: " + name);
        System.out.println("City: " + city);
        System.out.println("Course: " + course);

        sc.close();
    }
}