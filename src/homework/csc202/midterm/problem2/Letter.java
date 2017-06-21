package homework.csc202.midterm.problem2;

/**
 * Created by 15Cyndaquil on 6/21/2017.
 */
public class Letter implements Comparable<Letter>{
    private char letter;
    private int frequency;
    public Letter(char letter, int frequency){
        this.letter=letter;
        this.frequency=frequency;
    }

    public int compareTo(Letter letter){
        if(frequency != letter.frequency)
            return frequency-letter.frequency;
        else
            return (int)this.letter - (int)letter.letter;
    }
    public char getChar(){ return letter;}
    public int getFrequency(){ return frequency;}
    public void incrementFrequency(){
        frequency++;
    }
}