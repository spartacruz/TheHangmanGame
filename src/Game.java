
public class Game {
    public static void main(String [] args) {
        //Create new object called word with 'WordSupply' as the type
        WordSupply word = new WordSupply();

        //Call scrambleWord() method at word Object
        word.scrambleWord();
        System.out.println("You are guessing (" + word.countWord() + " Letter): " + word.getTheWord() +
                " " + word.arrayBuild());

        System.out.println("You have guessed (0) wrong letters.");
        System.out.println("Guess a letter: ");
    }
}
