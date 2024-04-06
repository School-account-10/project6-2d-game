import java.util.InputMismatchException;
import java.util.Scanner;

public class GameStarter {
    public static void main(String[] args) {
        System.out.println("Choose a game between 1-2");
        System.out.println("Game_1: Dino Game But in terminal");
        System.out.println("Game_2: Multiplication Table game");
        Scanner UserInput = new Scanner(System.in);
        while (true) {
            try {
                System.out.print("  Type the game number:   ");
                int number = UserInput.nextInt();

                if (number == 1) {
                    System.out.println("running 1");
                    break;

                } else if (number == 2) {
                    System.out.println("running 2");
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
}
