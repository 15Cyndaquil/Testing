package homework.csc202.textAnalyzer;

/**
 * Created by 15Cyndaquil on 7/5/2017.
 */
public abstract class TextAnalyzerAbstract{

    private String text;

    public TextAnalyzerAbstract(String text){
        setText(text);
    }

    public String getText(){
        return text;
    }
    public void setText(String text){
        this.text = text;
    }

    public abstract int length(); // return the length of the text
    public abstract int numberOfVowels(); //return the number of vowels in the text
    public abstract int numberOfUppercase(); // return the number of uppercase letters in the text
    public abstract int numberOfLatinAlphabetic();
}