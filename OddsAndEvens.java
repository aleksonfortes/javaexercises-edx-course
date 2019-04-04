import java.util.*;

public class OddsAndEvens {
    public static void main(String[] args){
       Scanner input = new Scanner(System.in);
        System.out.println("Let’s play a game called “Odds and Evens”");
        System.out.print("What is your name? ");
        String name = input.nextLine();
        System.out.println("Hi "+name+", which do you choose? (O)dds or (E)vens?");
        String user = input.next();
        if(user.equals("O"))
            System.out.println( name + " has picked odds! The computer will be evens.");
        else
            System.out.println( name + " has picked evens! The computer will be odds.");
        System.out.println("---------------------------------------------------");

        System.out.print("How many “fingers” do you put out? ");
        int userNumber = input.nextInt();
        Random rand = new Random();
        int computerNumber = rand.nextInt(6);
        System.out.println("The computer plays number " + computerNumber +".");
        System.out.println("---------------------------------------------------");

        int sum = userNumber + computerNumber;
        boolean oddOrEvan = sum % 2 == 0;
        System.out.println(userNumber + " + " + computerNumber + " = " + sum);
        System.out.print(sum + " is ...");
        if(oddOrEvan == true) {
            System.out.println("even!");
            if (user.equals("E"))
                System.out.println("That means " + name + " wins! :)");
            else
                System.out.println("That means computer wins! :(");
        }
        else {
            System.out.println("odd!");
            if (user.equals("O"))
                System.out.println("That means " + name + " wins! :)");
            else
                System.out.println("That means computer wins! :(");
        }

        System.out.println("---------------------------------------------------");

    }
}
