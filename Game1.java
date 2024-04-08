import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;

public class Game1 {
    public static void main(String[] args) {
        System.out.print("\u001B[32m");
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        System.out.println("Multiplication Table Game");
        System.out.println("To quit, just put 'q'. Example: 1*5= q");
        System.out.println("Choose a number from 1 to 5");

        int chosenNumber = 0;
        try {
            chosenNumber = scanner.nextInt();
            if (chosenNumber < 1 || chosenNumber > 5) {
                System.out.println("Invalid choice. Please choose a number between 1 and 5.");
                return;
            }
        } catch (InputMismatchException e) {
            System.out.println("Invalid input. Please enter a valid number.");
            System.err.println("From 1 to 5 lang diba????");
            return;
        }

        System.out.println("You chose the " + chosenNumber + " times table.");
        System.out.println("Let's start the game!");

        int score = 0;
        for (int i = 0; i < 5; i++) {
            int num1 = chosenNumber;
            int num2 = random.nextInt(10) + 1;

            System.out.print(num1 + " * " + num2 + " = ");
            String userAnswer = scanner.next();

            if (userAnswer.equals("q")) {
                System.out.println("quiting ");
                return;
            }

            try {
                int parsedAnswer = Integer.parseInt(userAnswer);
                int correctAnswer = num1 * num2;
                if (parsedAnswer == correctAnswer) {
                    System.out.println("Correct!");
                    score++;
                } else {
                    System.out.println("Wrong! The correct answer is " + correctAnswer);
                }
            } catch (NumberFormatException ex) {
                System.out.println("Invalid input. Please enter a number or 'q' to quit.");
                return;
            }
        }

        System.out.println("Game Over!");
        System.out.println("Your score: " + score + " out of 5");
    }
}
