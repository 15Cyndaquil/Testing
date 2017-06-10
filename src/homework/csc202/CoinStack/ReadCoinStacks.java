package homework.csc202.CoinStack;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * Created by Cyndaquil on 6/1/2017.
 */
public class ReadCoinStacks {
    private static CoinStack penny;
    private static CoinStack nickel;
    private static CoinStack dime;
    private static CoinStack quarter;

    public static void main(String[] args){


        File coins = new File("src/homework/csc202/CoinStack", "coins.txt");
        File coins2 = new File("src/homework/csc202/CoinStack", "coins2.txt");
        File coins3 = new File("src/homework/csc202/CoinStack", "coins3.txt");

        readFile(coins);
        readFile(coins2);
        readFile(coins3);
    }

    private static void readFile(File file){
        penny = new CoinStack();
        nickel = new CoinStack();
        dime = new CoinStack();
        quarter = new CoinStack();
        try{
            Scanner scanFile = new Scanner(file);
            while(scanFile.hasNextLine()){
                Scanner scanLine = new Scanner(scanFile.nextLine());
                while(scanLine.hasNextInt()){
                    addCoin(scanLine.nextInt());
                }
            }
            System.out.println(file.getName().substring(0, file.getName().length()-4));
            System.out.println(PrintCoinStacks.print(penny, nickel, dime, quarter));
        }catch(FileNotFoundException e){
            System.out.println(e);
        }
    }

    private static void addCoin(int data){
        Coin coin = new Coin(data);
        if(coin.getValue()==1){
            penny.push(coin);
        }else if(coin.getValue()==5){
            nickel.push(coin);
        }else if(coin.getValue()==10){
            dime.push(coin);
        }else if(coin.getValue()==25){
            quarter.push(coin);
        }
    }
}
