public class Type_Casting {
    public static void main(String[] args) {

    int num = 100;
    double value = num;

    System.out.println("Widening Casting:");
    System.out.println("int value = " + num);
    System.out.println("double value = " + value);

    double price = 99.99;
    int newPrice = (int) price;

    System.out.println("\nNarrowing Casting:");
    System.out.println("double value = " + price);
    System.out.println("int value = " + newPrice);

    int number = 65;
    char letter = (char) number;

    System.out.println("\nint to char:");
    System.out.println("int value = " + number);
    System.out.println("char value = " + letter);

    char ch = 'A';
    int ascii = ch;

    System.out.println("\nchar to int:");
    System.out.println("char value = " + ch);
    System.out.println("int value = " + ascii);
}

}
