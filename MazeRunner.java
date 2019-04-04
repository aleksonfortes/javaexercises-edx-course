import java.sql.SQLOutput;
import java.util.Scanner;

public class MazeRunner {
    static Maze myMap = new Maze();
    static int userMooves = 0;

    public static void main(String[] args) {
        intro();
        while (myMap.didIWin() != true) {
            userMove();
            userMooves++;
            movesMessage(userMooves);
            if(userMooves == 100){
                System.out.println("Sorry, but you didn't escape in time- you lose!");
                break;
            }
        }
        if (myMap.didIWin() == true){
            System.out.println("Congratulations, you made it out alive!");
            System.out.println("and you did it in " + userMooves + " moves.");
        }
    }

    public static void intro() {
        System.out.println("Welcome to Maze Runner!");
        System.out.println("Here is your current position:");
        myMap.printMap();
        System.out.println();
        System.out.println("------------------------------------");
    }

    public static void userMove() {
        Scanner input = new Scanner(System.in);
        System.out.print("Where would you like to move? (R, L, U, D) ");
        String direction = input.next();
        while (!(direction.equals("R") || direction.equals("L")
                || direction.equals("U") || direction.equals("D"))) {
            System.out.print("Please, only choose the options available: (R, L, U, D) ");
            direction = input.next();
        }

        if (direction.equals("R")) {
            if (myMap.canIMoveRight()) {
                myMap.moveRight();
                myMap.printMap();
            } else {
                myMap.printMap();
                System.out.println("Sorry, you’ve hit a wall.");
            }
        } else if (direction.equals("L")) {
            if (myMap.canIMoveLeft()) {
                myMap.moveLeft();
                myMap.printMap();
            } else {
                myMap.printMap();
                System.out.println("Sorry, you’ve hit a wall.");
            }
        } else if (direction.equals("U")) {
            if (myMap.canIMoveUp()) {
                myMap.moveUp();
                myMap.printMap();
            } else {
                myMap.printMap();
                System.out.println("Sorry, you’ve hit a wall.");
            }
        } else if (direction.equals("D")) {
            if (myMap.canIMoveDown()) {
                myMap.moveDown();
                myMap.printMap();
            } else {
                myMap.printMap();
                System.out.println("Sorry, you’ve hit a wall.");
            }
        }

    }

    public static void movesMessage(int moves){
        if(moves == 50) {
            System.out.println("Warning: You have made 50 moves, you have 50 remaining before the maze exit closes.");
        }
        else if (moves == 75) {
            System.out.println("Alert! You have made 75 moves, you only have 25 moves left to escape.");
        }
        else if (moves == 75) {
            System.out.println("DANGER! You have made 90 moves, you only have 10 moves left to escape!!");
        }
        else if (moves == 100)
            System.out.println("Oh no! You took too long to escape, and now the maze exit is closed FOREVER >:[");
    }



}

