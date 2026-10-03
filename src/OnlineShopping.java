import java.util.Scanner;

class Product {

    int productId;
    String productName;
    double price;

    Product(int productId, String productName, double price) {
        this.productId = productId;
        this.productName = productName;
        this.price = price;
    }

    void displayProduct() {
        System.out.println("Product ID   : " + productId);
        System.out.println("Product Name : " + productName);
        System.out.println("Price        : " + price);
    }
}


class Electronic extends Product {

    String warranty;

    Electronic() {
        super(101, "Laptop", 55000);
        warranty = "2 Years";
    }

    void displayElectronic() {
        displayProduct();
        System.out.println("Warranty     : " + warranty);
    }
}


class Clothing extends Product {

    String size;

    Clothing() {
        super(102, "T-Shirt", 799);
        size = "L";
    }

    void displayClothing() {
        displayProduct();
        System.out.println("Size         : " + size);
    }
}


class Food extends Product {

    String expiryDate;

    Food() {
        super(103, "Milk", 60);
        expiryDate = "30-09-2026";
    }

    void displayFood() {
        displayProduct();
        System.out.println("Expiry Date  : " + expiryDate);
    }
}



public class OnlineShopping {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        Electronic electronic = new Electronic();
        Clothing clothing = new Clothing();
        Food food = new Food();

        System.out.println("ONLINE SHOPPING");

        System.out.println("\n1. Electronic");
        System.out.println("2. Clothing");
        System.out.println("3. Food");

        System.out.print("\nEnter your choice: ");
        int choice = sc.nextInt();

        if (choice == 1) {

            System.out.println("\n--- Electronic Product ---");
            electronic.displayElectronic();

        }
        else if (choice == 2) {

            System.out.println("\n--- Clothing Product ---");
            clothing.displayClothing();

        }
        else if (choice == 3) {

            System.out.println("\n--- Food Product ---");
            food.displayFood();

        }
        else {

            System.out.println("Invalid Choice");
        }

        sc.close();
    }
}