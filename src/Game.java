import java.util.Scanner;

public class Game {
    public static void main(String [] args) {
        //Create new object called word with 'WordSupply' as the type
        WordSupply word = new WordSupply();
        int attempt = 10;
        String theWord = word.getTheWord();

        //Call scrambleWord() method at word Object
        word.scrambleWord();
        System.out.println("You are guessing (" + word.countWord() + " Letter): " + word.getTheWord() +
                " " + word.arrayBuild());

        System.out.println("You have guessed (0) wrong letters.");
        System.out.println("Guess a letter: ");

        Scanner scanner = new Scanner(System.in);

        while (attempt != 0) {
            String input = scanner.next();

            int foundAt = theWord.indexOf(input);
            if (foundAt != -1) {
                System.out.println("we found that character! at index " + foundAt);
                break;
            } else {
                System.out.println("cannot found that character!");
                break;
            }
        }

    }
}
