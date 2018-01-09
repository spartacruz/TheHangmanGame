import java.util.Scanner;

public class Game {

    public static void guessProgress(int countWord, String getTheWord, String arrayBuilder, int attempt) {
        System.out.println("You are guessing (" + countWord + " Letter): " + getTheWord +
                " " + arrayBuilder);

        System.out.println("You have guessed ("+ attempt +") wrong letters.");
        if (attempt < 10){
            System.out.println("Guess a letter: ");
        } else {
            System.out.println("\n\nSorry, you lose!\nThe answer is '" + getTheWord + "'");
        }
    }

    public static void main(String [] args) {
        //Create new object called word with 'WordSupply' as the type
        WordSupply word = new WordSupply();
        int attempt = 0;
        String theWord = word.getTheWord();

        //Call scrambleWord() method at word Object
        word.scrambleWord();
        guessProgress(word.countWord(), word.getTheWord(), word.arrayBuild(), attempt);

        Scanner scanner = new Scanner(System.in);

        while (attempt < 10) {
            String input = scanner.next();

            int foundAt = theWord.indexOf(input);
            if (foundAt != -1) {
                System.out.println("we found that character! at index " + foundAt);
                break;
            } else {
                attempt++;
                System.out.println("Incorrect letter!");
                guessProgress(word.countWord(), word.getTheWord(), word.arrayBuild(), attempt);
            }
        }
    }
}
