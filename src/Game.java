import java.util.Scanner;

public class Game {

    public static void guessProgress(int countWord, String getTheWord, String arrayBuilder, int attempt, String wrongLetter) {
        System.out.println("You are guessing (" + countWord + " Letter): " + getTheWord +
                " " + arrayBuilder);

        System.out.println("You have guessed ("+ attempt +") wrong letters: " + wrongLetter);
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
        String wrongLetter = "";

        //Call scrambleWord() method at word Object
        word.scrambleWord();
        guessProgress(word.countWord(), word.getTheWord(), word.finalScramble(), attempt, wrongLetter);

        Scanner scanner = new Scanner(System.in);

        while (attempt < 10) {
            String input = scanner.next();

            int foundAt = theWord.indexOf(input);
            if (foundAt != -1) {
                //System.out.println("we found that character! at index " + foundAt);
                //break;
                word.swapLetter(input, foundAt);
                int secScan = theWord.indexOf(input, foundAt + 1);

                while (secScan != -1) {
                    word.swapLetter(input, secScan);
                    secScan = theWord.indexOf(input, secScan + 1);
                }

                
                System.out.println(secScan);

                guessProgress(word.countWord(), word.getTheWord(), word.finalScramble(), attempt, wrongLetter);
            } else {
                attempt++;
                System.out.println("Incorrect letter!");
                wrongLetter += " " + input;
                guessProgress(word.countWord(), word.getTheWord(), word.finalScramble(), attempt, wrongLetter);
            }
        }
    }
}
