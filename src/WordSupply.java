public class WordSupply {
    private String theWord;
    public String getTheWord() {
        theWord = "Inception";
        return theWord;
    }

    public int countWord() {
        getTheWord();
        return theWord.length();
    }

}
