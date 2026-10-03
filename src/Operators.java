public class Operators {
    public static void main(String[] args) {
        int a=10;
        int b=20;
        System.out.println("Arithmetic operation");
        System.out.println("Addition : "+ (a+b));
        System.out.println("Subtraction : "+ (a-b));
        System.out.println("Multiplication : "+ (a*b));
        System.out.println("Division : "+ (b/a));
        System.out.println("-----------------");

        System.out.println("Relational or Comparison Operators");
        System.out.println("Equal to : "+  (a==b));
        System.out.println("Not equal to : "+(a!=b));
        System.out.println("Greater than : "+(a>b));
        System.out.println("Less than : "+(a<b));
        System.out.println("Greater than or equal to : "+(a>=b) );
        System.out.println("Less than or equal to : "+(a<=b));
        System.out.println("-----------------");

        System.out.println("Logical Operators");
        System.out.println("Logical AND : "+((a>5)&&(b>10)));
        System.out.println("Logical OR : "+((a>10)||(b>10)));
        System.out.println("Logical NOT : "+!(a>5));
        System.out.println("-----------------");

        System.out.println("Assignment Operators");
        int c=30;
        System.out.println(c+=10);
        System.out.println(c-=5);
        System.out.println(c*=2);
        System.out.println(c/=2);
        System.out.println("-----------------");

        System.out.println("Assignment Operators");
        int age = 20;
        String result = age >= 18 ? "Adult" : "Minor";
        System.out.println(result);
        System.out.println("-----------------");


        int d = 10;
        System.out.println("Original value: " + d);

        d++;
        System.out.println("After increment: " + d);

        d--;
        System.out.println("After decrement: " + d);

        System.out.println("Negative value: " + (-d));





    }
}
