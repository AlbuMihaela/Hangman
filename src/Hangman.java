import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;


public class Hangman {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        ArrayList<String> words = new ArrayList<>(Arrays.asList("magic", "day", "moon", "programmer", "butterfly", "noise", "village", "troubleshoot"));
        String word = words.get(random.nextInt(words.size()));

        int remainingLives = 6;

        char[] letters = word.toCharArray();
        char[] underlines = new char[letters.length];
        Arrays.fill(underlines, '_');

        printTheWord(underlines);

        while (true) {
            System.out.println("Enter a letter :  (remaining lives = " + remainingLives + ") ");
            char letterEntered = scanner.next().charAt(0);
            boolean wordContainsTheLetter = false;
            for (int i = 0; i < letters.length; i++) {
                if (letterEntered == letters[i]) {
                    underlines[i] = letterEntered;
                    wordContainsTheLetter = true;
                }
            }
            if (!wordContainsTheLetter) {
                remainingLives--;
            }

            if (remainingLives <= 0) {
                System.out.println("Game over!");
                break;
            }

            if (Arrays.equals(letters, underlines)) {
                System.out.println("You win!");
                printTheWord(underlines);
                break;
            }
            printTheWord(underlines);
        }

    }

    private static void printTheWord(char[] underlines) {
        for (char c : underlines) {
            System.out.print(c + " ");

        }
        System.out.println();
    }
}

