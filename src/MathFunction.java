public class MathFunction {
    public static void main(String[] args) {

        int a = -25;
        double b = 10.75;
        double c = 10.25;
        double d = 10.6;
        int x = 20;
        int y = 50;
        int base = 2;
        int exponent = 3;
        int number = 25;
        int sign = -15;

        System.out.println("1. Absolute = " + Math.abs(a));

        System.out.println("2. Floor = " + Math.floor(b));

        System.out.println("3. Ceil = " + Math.ceil(c));

        System.out.println("4. Round = " + Math.round(d));

        System.out.println("5. Maximum = " + Math.max(x, y));

        System.out.println("6. Minimum = " + Math.min(x, y));

        System.out.println("7. Power = " + Math.pow(base, exponent));

        System.out.println("8. Square Root = " + Math.sqrt(number));

        System.out.println("9. Random = " + Math.random());

        System.out.println("10. Sign = " + Math.signum(sign));
    }
}
