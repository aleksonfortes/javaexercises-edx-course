import java.util.Scanner;

public class FractionCalculator {
    public static void main(String args[]) {
        System.out.println("This program is a fraction calculator");
        System.out.println("it will add, subtract, multiply and divide fractions until you type Q to quit.");
        System.out.println("Please enter your fractions in the form a/b, where a and b are integers.");
        System.out.println("--------------------------------------------------------------------------------");
        //String operation = getOperation();
        //Fraction fraction = getFraction();
        System.out.println(validFraction("-1/1"));
        System.out.println(validFraction("+1"));
        System.out.println(validFraction("+1/-1"));
        System.out.println(validFraction("-1/-1"));
        System.out.println(validFraction("1"));


    }

    public static String getOperation() {
        Scanner input = new Scanner(System.in);
        boolean validation = false;
        System.out.print("Please enter an operation (+, -, /, *, = or Q to quit):");
        String result = input.next();
        while (validation == false) {
            if ("+".equals(result) || "-".equals(result) || "/".equals(result) || "*".equals(result)
                    || "=".equals(result) || "Q".equals(result) || "q".equals(result)) {
                validation = true;
            } else {
                System.out.print("Invalid input (+, -, /, *, = or Q to quit):");
                result = input.next();
            }
        }
        return result;
    }

    public static Fraction getFraction() {
        Scanner input = new Scanner(System.in);
        boolean validation = false;
        System.out.print("Please enter an fraction (a/b) or integer (a):");
        String result = input.next();
        while (validation == false) {
            if (validFraction(result) == true) {
                validation = true;
            } else {
                System.out.print("Invalid fraction. Please enter (a/b) or (a), where a and b are integers and b is not zero:");
                result = input.next();
            }
        }
        return new Fraction(1, 1);
    }

    public static boolean validFraction(String input) {
        return input.matches("^-?[0-9]+(\\/[1-9][0-9]*)?$");
    }
}
