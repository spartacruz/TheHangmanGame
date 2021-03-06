import java.util.Locale;
import java.util.Scanner;

public class Game {

    //Constructor
    public Game() {
        startPlay();
    }

    private void startPlay() {
        //Create new object called word with 'WordSupply' as the type
        WordSupply word = new WordSupply();
        int attempt = 0;
        String theWord = word.getTheWord();
        String wrongLetter = "";
        int correctLetter = 0;

        //Call scrambleWord() method at word Object
        word.scrambleWord();
        guessProgress(word.countWord(), word.getTheWord(), word.finalScramble(), attempt, wrongLetter);
        Scanner scanner = new Scanner(System.in);
        while (attempt < 10) {
            String input = scanner.next().toLowerCase(Locale.US);

            if (input.matches("[a-zA-Z]")) {
                int foundAt = theWord.indexOf(input);
                int duplicateWrong = 0;
                duplicateWrong = wrongLetter.indexOf(input);

                if (duplicateWrong == -1) {
                    if (foundAt != -1) {
                        if (!word.finalScramble().contains(input)) {
                            word.swapLetter(input, foundAt);
                            int secScan = theWord.indexOf(input.toLowerCase(Locale.US), foundAt + 1);
                            correctLetter++;

                            while (secScan != -1) {
                                word.swapLetter(input, secScan);
                                secScan = theWord.indexOf(input, secScan + 1);
                                correctLetter++;
                            }

                            guessProgress(word.countWord(), word.getTheWord(), word.finalScramble(), attempt, wrongLetter);
                        } else {
                            System.out.println("You have already input this letter. Please try another one.");
                            guessProgress(word.countWord(), word.getTheWord(), word.finalScramble(), attempt, wrongLetter);
                        }

                    } else {
                        attempt++;
                        System.out.println("Incorrect letter!");
                        wrongLetter += " " + input;
                        guessProgress(word.countWord(), word.getTheWord(), word.finalScramble(), attempt, wrongLetter);
                    }
                } else {
                    System.out.println("You have already input this letter. Please try another one.");
                    guessProgress(word.countWord(), word.getTheWord(), word.finalScramble(), attempt, wrongLetter);
                }

            } else {
                System.out.println("Incorrect Input. Please input a letter.");
                guessProgress(word.countWord(), word.getTheWord(), word.finalScramble(), attempt, wrongLetter);
            }

            if (correctLetter == word.countWord()) {
                System.out.println("\nYassss\nYOU WIN!");
                System.out.println("\nYou have guessed '" + word.getTheWord() + "' correctly.");
                break;
            }
        }
    }

    private void guessProgress(int countWord, String getTheWord, String arrayBuilder, int attempt, String wrongLetter) {
        System.out.println("You are guessing (" + countWord + " Letter): " + getTheWord +
                " " + arrayBuilder);
        System.out.println("You have guessed (" + attempt + "/10) wrong letters: " + wrongLetter);
        if (attempt < 10) {
            System.out.println("Guess a letter: ");
        } else {
            System.out.println("\nSorry, you lose!\nThe answer is '" + getTheWord + "'");
        }
    }

    public static void main(String[] args) {
        Game game = new Game();
    }
}