public class Swaping_without_temp {
    public static void main(String[] args) {
        int a=10;
        int b=15;

        a=a+b; //25
        b=a-b; //25-15 = 10
        a=a-b; //25-10 = 15

        System.out.println("The value of a : "+a);

        System.out.println("The value of b : "+b);

    }
}
