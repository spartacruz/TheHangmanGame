public class WordSupply {
    private String theWord;
    private String[] scramble = new String[countWord()];

    //This method generate how many letter have to guess
    public int countWord() {
        getTheWord();
        return theWord.length();
    }

    //This method generate word that have to guess
    public String getTheWord() {
        theWord = "inception";
        return theWord;
    }

    //This method generate an array that contain "_" (underscore), as many as word that have to guess
    public void scrambleWord() {
        for (int i = 0; i < countWord(); i++) {
            scramble[i] = "_";
        }
    }

    //This method helps to concatenate every element of variable: 'scramble' array of String
    public String arrayBuild() {
        StringBuilder builder = new StringBuilder();
        for (String value : scramble) {
            builder.append(value);
        }
        return builder.toString();
    }

}
