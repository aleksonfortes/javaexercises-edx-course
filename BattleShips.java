import java.util.Scanner;

public class BattleShips {
    public static void main(String args[]) {
        String[][] ocean = startTheGame();
        Boolean gameOver = false;

        printOcean(ocean);
        ocean = placePlayerShips(ocean);
        printOcean(ocean);
        ocean = placeComputerShips(ocean);
        while (gameOver == false) {
            battlePlayerTurn(ocean);
            printOcean(ocean);
            battleComputerTurn(ocean);
            printOcean(ocean);
            gameOver = isGameOver(ocean);
        }
    }

    public static Boolean isGameOver(String[][] arrayIn) {
        String[][] ocean = arrayIn;
        Boolean result = false;
        int computerShips = 0;
        int playerShips = 0;

        for (int row = 0; row < 10; row++) {
            for (int col = 0; col < 10; col++) {
                if (("2").equals(ocean[row][col]))
                    computerShips++;
                else if (("@").equals(ocean[row][col]))
                    playerShips++;
            }
        }
        System.out.println("Your ships: " + playerShips + " | Computer ships: " + computerShips);
        System.out.println("----------------------------------------");
        if (playerShips == 0 || computerShips == 0) {
            result = true;
            if (computerShips == 0)
                System.out.println("Hooray! You win the battle. :)");
            else
                System.out.println("Ohhh! You lose the battle. :(");
        }
        return result;
    }

    public static String[][] battleComputerTurn(String[][] arrayIn) {
        String[][] arrayOut = arrayIn;
        System.out.println("COMPUTER'S TURN!");
        Boolean missilPlayed = false;
        while (missilPlayed == false) {
            int x = (int) (Math.random() * 10);
            int y = (int) (Math.random() * 10);
            if (("@").equals(arrayOut[x][y])) {
                System.out.println("The Computer sunk one of your ships!");
                arrayOut[x][y] = "x";
                missilPlayed = true;
            } else if (("2").equals(arrayOut[x][y])) {
                arrayOut[x][y] = "!";
                System.out.println("The Computer sunk one of its own ships.");
                missilPlayed = true;
            } else {
                arrayOut[x][y] = ".";
                System.out.println("Computer missed.");
                missilPlayed = true;
            }
        }
        System.out.println();
        return arrayOut;
    }

    public static String[][] battlePlayerTurn(String[][] arrayIn) {
        String[][] arrayOut = arrayIn;
        Scanner input = new Scanner(System.in);
        System.out.println("YOUR TURN!");
        Boolean missilPlayed = false;
        while (missilPlayed == false) {
            System.out.print("Enter X coordinate:");
            int x = input.nextInt();
            System.out.print("Enter Y coordinate:");
            int y = input.nextInt();
            if (x > 9 || x < 0 || y > 9 || y < 0)
                System.out.println("The coordinates must be between 0 and 9.");
            else if (("@").equals(arrayOut[x][y])) {
                System.out.println("Oh no, you sunk your own ship. :(");
                arrayOut[x][y] = "x";
                missilPlayed = true;
            } else if (("2").equals(arrayOut[x][y])) {
                System.out.println("Boom! You sunk the ship!");
                arrayOut[x][y] = "!";
                missilPlayed = true;
            } else {
                arrayOut[x][y] = "-";
                missilPlayed = true;
            }
        }
        System.out.println();
        return arrayOut;
    }

    public static String[][] placeComputerShips(String[][] arrayIn) {
        String[][] arrayOut = arrayIn;
        System.out.println("Computer is deploying ships.");
        for (int times = 1; times <= 5; times++) {
            Boolean shipOk = false;
            while (shipOk == false) {
                int x = (int) (Math.random() * 10);
                int y = (int) (Math.random() * 10);
                if (("@").equals(arrayOut[x][y]))
                    shipOk = false;
                else if (("2").equals(arrayOut[x][y]))
                    shipOk = false;
                else {
                    arrayOut[x][y] = "2";
                    System.out.println(times + ". ship DEPLOYED.");
                    shipOk = true;
                }
            }
        }
        System.out.println("----------------------------------------");
        System.out.println();
        return arrayOut;
    }

    public static String[][] placePlayerShips(String[][] arrayIn) {
        String[][] arrayOut = arrayIn;
        Scanner input = new Scanner(System.in);
        for (int times = 1; times <= 5; times++) {
            Boolean shipOk = false;
            while (shipOk == false) {
                System.out.print("Enter X coordinate for your ship " + times + ":");
                int x = input.nextInt();
                System.out.print("Enter Y coordinate for your ship " + times + ":");
                int y = input.nextInt();
                if (x > 9 || x < 0 || y > 9 || y < 0)
                    System.out.println("The coordinates must be between 0 and 9.");
                else if (("@").equals(arrayOut[x][y]))
                    System.out.println("There is a ship in these coordinates.");
                else {
                    arrayOut[x][y] = "@";
                    shipOk = true;
                }
            }
        }
        System.out.println();
        return arrayOut;
    }

    public static void printOcean(String[][] ocean) {
        System.out.println("  0123456789  ");
        for (int row = 0; row < 10; row++) {
            System.out.print(row + "|");
            for (int col = 0; col < 10; col++) {
                if (("2").equals(ocean[row][col]))
                    System.out.print(" ");
                else if ((".").equals(ocean[row][col]))
                    System.out.print(" ");
                else
                    System.out.print(ocean[row][col]);
            }
            System.out.println("|" + row);
        }
        System.out.println("  0123456789  ");
        System.out.println();
    }

    public static String[][] startTheGame() {
        String[][] arrayOut = new String[10][10];
        for (int row = 0; row < 10; row++) {
            for (int col = 0; col < 10; col++) {
                arrayOut[row][col] = " ";
            }
        }
        System.out.println("**** Welcome to Battle Ships game! ****");
        System.out.println("Right now, the sea is empty.");
        System.out.println();
        return arrayOut;
    }
}
