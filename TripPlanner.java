import java.sql.Time;
import java.util.Scanner;

public class TripPlanner {
    public static void main(String[] args){
        greeting();
        travelTimeAndBudget();
        timeDifference();
        countryArea();
    }

    public static void greeting(){
        Scanner input = new Scanner(System.in);
        System.out.println("Welcome to Vacation Planner!");
        System.out.print("What is your name? ");
        String name = input.nextLine();
        System.out.print("Nice to meet you " + name + ", where are you travelling to? ");
        String destiny = input.nextLine();
        System.out.println("Great! " + destiny + " sounds like a great trip.");
    }

    public static void travelTimeAndBudget(){
        Scanner input = new Scanner(System.in);
        System.out.print("How many days are you going to spend travelling? ");
        int days = input.nextInt();
        System.out.print("How much money, in USD, are you planning to spend on your trip? ");
        double money = input.nextDouble();
        System.out.print("What is the three letter currency symbol for your travel destination? ");
        String currency = input.next();
        System.out.print("How many "+ currency + " are there in 1 USD? ");
        double convertionTax = input.nextDouble();
        double usdPerDay = (money / days);
        usdPerDay = (int)(usdPerDay * 100);
        System.out.println();
        System.out.println("If you are travelling for " + days + " days that is the same as " +
            (days * 24) + " hours or " + (days * 24 * 60) + " minutes.");
        System.out.println("If you are going to spend " + money + " USD that means per day you can spend up to " +
            (usdPerDay / 100) + " USD.");
        double convertion = (convertionTax * money);
        convertion = (int)(convertion * 100);
        double convertionPerDay = (convertionTax * money / days);
        convertionPerDay = (int)(convertionPerDay * 100);
        System.out.println("Your total budget in " + currency + " is " + (convertion / 100) + " " +
            currency + ", which per day is " + (convertionPerDay / 100) + " " + currency);
    }

    public static void timeDifference(){
        Scanner input = new Scanner(System.in);
        System.out.print("What is the time difference, in hours, between your home and your destination? ");
        int timeDiff = input.nextInt();
        System.out.println("That means that when it is midnight at home it will be " + timeDiff +
            ":00 in your travel destination and when it is noon at home it will be " + (timeDiff + 12) + ":00");
    }

    public static void countryArea(){
        Scanner input = new Scanner(System.in);
        System.out.print("What is the square of your destination country in Km2? ");
        double squareInKm = input.nextDouble();
        double squareInMiles = squareInKm * 0.38610;
        squareInMiles = (int) (squareInMiles * 100);
        System.out.println("In miles2 that is " + (squareInMiles / 100.0));
    }
}

