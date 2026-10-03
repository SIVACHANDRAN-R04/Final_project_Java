public class String_methods {
    public static void main(String[] args) {

            String str = "Hello Java";
            String str1 = "Hello";
            String str2 = "Java";

            System.out.println("1. Length = " + str.length());

            System.out.println("2. Character = " + str.charAt(1));

            System.out.println("3. Uppercase = " + str.toUpperCase());

            System.out.println("4. Lowercase = " + str.toLowerCase());

            System.out.println("5. Concatenation = " + str1.concat(str2));

            System.out.println("6. Equals = " + str1.equals(str2));

            System.out.println("7. Equals Ignore Case = " +
                    str1.equalsIgnoreCase("hello"));

            System.out.println("8. Contains = " + str.contains("Java"));

            System.out.println("9. Substring = " + str.substring(6));

            System.out.println("10. Replace = " +
                    str.replace("Java", "World"));
        }
    }

