package encryptMessage;

import com.sun.xml.internal.fastinfoset.util.StringArray;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * Created by Cyndaquil on 6/19/2017.
 */
public class Ciphertext {
    private static final String[] MESS_PLACE = {"a","b","c","d","e","f","g","h","i","j","k","l","m","n","o","p","q","r","s","t","u","v","w","x","y","z"};

    public static void main(String[] args){
        readInput();
    }

    public static String encryptMessage(int[] secretKeys, String message){
        ArrayList messPlace = new ArrayList();
        for(int i=0; i<MESS_PLACE.length; i++){
            messPlace.add(MESS_PLACE[i]);
        }
        StringBuilder output = new StringBuilder("");

        for(int i=0; i<message.length(); i++){
            int outputIndex = secretKeys[i]+messPlace.indexOf(message.substring(i, i+1));
            while(outputIndex>26){
                outputIndex+=-26;
            }
            output.append(messPlace.get(outputIndex));
        }
        return output.toString();
    }

    private static void readInput(){
        String message;
        int numOfSecKeys;
        boolean go = true;

        numOfSecKeys = 0;

        Scanner input = new Scanner(System.in);
        if(go&&input.hasNextInt()) {
            numOfSecKeys = input.nextInt();
        }else {
            go = false;
        }
        int[] secKeys = new int[numOfSecKeys];


        for(int i=0; i<numOfSecKeys; i++){
            if(go&&input.hasNextInt()){
                int intInput = input.nextInt();
                if(!(intInput>=1&&intInput<=100)){
                    go=false;
                }else {
                    secKeys[i] = intInput;
                }
            }else {
                go=false;
            }
        }

        if(go&&input.hasNext()){
            message = input.next();
        }else {
            go = false;
            message = "";
        }

        if(go&&input.hasNextInt()){
            int intInput = input.nextInt();
            if(intInput!=-1){
            }else {
                System.out.println(encryptMessage(secKeys, message));
            }
        }

    }
}
