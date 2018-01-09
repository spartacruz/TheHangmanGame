public class Game {
    public static void main(String [] args) {
        WordSupply word = new WordSupply();
        System.out.println("You are guessing (" + word.countWord() + " Letter): "+ word.getTheWord());

        System.out.println("You have guessed (0) wrong letters.");
        System.out.println("Guess a letter: ");
    }
}
