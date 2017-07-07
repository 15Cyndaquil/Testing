package homework.csc202.textAnalyzer;

/**
 * Created by 15Cyndaquil on 7/5/2017.
 */
public class TextAnalyzer extends TextAnalyzerAbstract {
    private final String VOWELS = "AEIOU";
    private final String ALPHABET_UPPER = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";

    public TextAnalyzer(String text) {super(text);}


    @Override
    public int length() {return getText().length();}

    @Override
    public int numberOfVowels() {
        int count=0;
        for(int i=0; i<length(); i++){
            if(VOWELS.contains(getText().substring(i, i+1).toUpperCase())){
                count++;
            }
        }
        return count;
    }

    @Override
    public int numberOfUppercase() {
        int count=0;
        for(int i=0; i<length(); i++){
            if(ALPHABET_UPPER.contains(getText().substring(i, i+1))){
                count++;
            }
        }
        return count;
    }

    @Override
    public int numberOfLatinAlphabetic() {
        int count=0;
        for(int i=0; i<length(); i++){
            if(ALPHABET_UPPER.contains(getText().substring(i, i+1).toUpperCase())){
                count++;
            }
        }
        return count;
    }
}
