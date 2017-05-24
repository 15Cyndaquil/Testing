package homework.csc202.lab01BasicSkills;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * Created by 15Cyndaquil on 5/24/2017.
 */
public class WordCount {
    public static void main(String[] args){
        File file = new File("src/homework/csc202/lab01BasicSkills","wordCount.txt");
        String word;

        Scanner scan = new Scanner(System.in);
        System.out.println("Enter word to search for:");
        word = scan.next();
        scan.close();

        System.out.println("Number of times that word is in file: "+count(file, word));
    }

    public static int count(File file, String word){
        int output = 0;
        try{
            Scanner scan = new Scanner(file);
            while(scan.hasNextLine()){
                Scanner eachWord = new Scanner(scan.nextLine()).useDelimiter(" ");
                while(eachWord.hasNext()){
                    StringBuilder wordFromFile = new StringBuilder(eachWord.next());
                    if(wordFromFile.indexOf(word)!=-1){
                        if(wordFromFile.toString().equalsIgnoreCase(word)){
                            output++;
                        }
                    }
                }
            }
            return output;
        }catch (FileNotFoundException e){
            System.out.println(e);
            output =-1;
        }
        return output;
    }
}
