import java.util.Scanner; // questions
import java.io.IOException; // checks if theres errors in starting one of the games
import java.util.InputMismatchException; // if theres a letter input 

public class GameStarter {
    public static void main(String[] args) {
        System.out.println(" Choose a game between 1-2 ");
        System.out.println("Game_1: Multiplication Table game");
        System.out.println("Game_2: Flapybirb without gravity..hahaha tamad ");
        Scanner UserInput = new Scanner(System.in);
        while (true) {
            try {
                System.out.print("  Type the game number:   "); // asking what to do
                int number = UserInput.nextInt();

                if (number == 1) {
                    System.out.println("running 1");
                    System.out.print("\u001B[32m");
                    runGame1();
                    break;

                } else if (number == 2) {
                    System.out.println("running 2");
                    System.err.println("to control use S for down and W for up");
                    try {
                        Thread.sleep(6000); // Pause for 3 seconds (3000 milliseconds)
                    } catch (InterruptedException ex) {
                        Thread.currentThread().interrupt();
                    }
                    runGame2();
                    break;

                } else {
                    System.err.println("OI Parang masiyado malaki yung number na nilagay mo 1 or 2 lang!!");
                    System.err.println("Type the game number: 1             ");
                    continue;
                }

            } catch (InputMismatchException e) {
                System.err.println("Invalid input. Please enter a valid integer.");
                System.out.println("UHMMMM you inputed a LETTER TRY AGAIN :P ");

                break;
            }
        }
        UserInput.close();
    }

    private static void runGame1() {
        try {
            ProcessBuilder pb = new ProcessBuilder("java", "Game1.java");
            pb.inheritIO();
            pb.start().waitFor();
        } catch (IOException | InterruptedException e) {
            System.err.println("Error running Game1: " + e.getMessage());
        }
    }

    private static void runGame2() {
        try {
            ProcessBuilder pb = new ProcessBuilder("java", "Game2.java");
            pb.inheritIO();
            pb.start().waitFor();
        } catch (IOException | InterruptedException e) {
            System.err.println("Error running Game1: " + e.getMessage());
        }
    }
}
