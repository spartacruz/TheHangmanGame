public class WordSupply {
    private String theWord;
    private String[] scramble = new String[countWord()];

    public int countWord() {
        getTheWord();
        return theWord.length();
    }

    public String getTheWord() {
        theWord = "Inception";
        return theWord;
    }

    public void scrambleWord() {
        for (int i = 0; i < countWord(); i++) {
            scramble[i] = "_";
        }
    }

    public String arrayBuild() {
        StringBuilder builder = new StringBuilder();
        for (String value : scramble) {
            builder.append(value);
        }
        return builder.toString();
    }

}
