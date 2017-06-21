package homework.csc202.midterm.problem2;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * Created by 15Cyndaquil on 6/21/2017.
 */
public class CryptGram {
    private static Letter[] orderedFrequency = new Letter[26];
    private static final String ALPHABET = "abcdefhijklmnopqrstuvwxyzg";

    public static void main(String[] args){
        for(int i=0; i<orderedFrequency.length; i++){
            orderedFrequency[i] = new Letter(ALPHABET.charAt(i), 0);
        }
        File cryptgram = new File("src/homework.csc202.midterm/problem2", "cryptgram.txt");
        createLetterFrequencyFromFile(cryptgram);
        for(int i=0; i<orderedFrequency.length; i++){
            System.out.print(orderedFrequency[i].getChar()+","+orderedFrequency[i].getFrequency()+"; ");
        }
        System.out.println("\n"+encode("Hello my name is Tyler"));
        System.out.println(decode(encode("Hello my name is Tyler")));

    }
    private static void createLetterFrequencyFromFile(File file){

        try{
            Scanner readFile = new Scanner(file);
            while(readFile.hasNext()){
                StringBuilder read = new StringBuilder(readFile.next());
                for(int n=0; n<read.length(); n++){
                    for(int i=0; i<orderedFrequency.length; i++){
                        if(orderedFrequency[i].getChar()==read.substring(n, n+1).toLowerCase().charAt(0)){
                            orderedFrequency[i].incrementFrequency();
                        }
                    }
                }
            }
            bubbleSort(orderedFrequency);
        }catch (FileNotFoundException e){
            e.printStackTrace();
        }
    }

    private static int getFrequencyByChar(char letter){
        int output = 0;
        letter = String.valueOf(letter).toLowerCase().charAt(0);
        for(int i=0; i<orderedFrequency.length; i++){
            if(orderedFrequency[i].getChar()==letter){
                output=orderedFrequency[i].getFrequency();
                break;
            }
        }
        return output;
    }

    private static String encode(String textToBeEncoded){
        StringBuilder output = new StringBuilder(textToBeEncoded.length());
        for(int i=0; i<textToBeEncoded.length(); i++){
            if(!textToBeEncoded.substring(i, i+1).equals(" ")) {
                output.append(orderedFrequency[ALPHABET.indexOf(String.valueOf(textToBeEncoded.charAt(i)).toLowerCase())].getChar());
            }else output.append(" ");
        }
        return output.toString();
    }

    private static String decode(String textToBeDecoded){
        StringBuilder output = new StringBuilder(textToBeDecoded.length());
        StringBuilder key = new StringBuilder(26);
        for(int i=0; i<orderedFrequency.length; i++){
            key.append(orderedFrequency[i].getChar());
        }
        for(int i=0; i<textToBeDecoded.length(); i++){
            String currentChar = textToBeDecoded.substring(i, i+1).toLowerCase();
            if(!currentChar.equals(" ")) {
                output.append(ALPHABET.charAt(key.toString().indexOf(currentChar.charAt(0))));
            }else output.append(" ");
        }
        return output.toString();
    }


    private static void bubbleSort(Letter[] array){
        for(int n=0; n<array.length; n++) {
            for (int i = 0; i < array.length-1; i++) {
                    if (array[i].getFrequency() < array[i + 1].getFrequency()) {
                        Letter tmp = array[i + 1];
                        array[i + 1] = array[i];
                        array[i] = tmp;
                    } else if(array[i].getFrequency() == array[i + 1].getFrequency()){
                        if(array[i].getChar()>array[i+1].getChar()){
                            Letter tmp = array[i + 1];
                            array[i + 1] = array[i];
                            array[i] = tmp;
                        }
                    }
            }
        }
    }
}
