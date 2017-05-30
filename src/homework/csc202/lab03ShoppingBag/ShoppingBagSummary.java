package homework.csc202.lab03ShoppingBag;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * Created by 15Cyndaquil on 5/30/2017.
 */
public class ShoppingBagSummary {
    public static void main(String[] args){

        File file = new File("src/homework/csc202/lab03ShoppingBag","data.txt");
        ShoppingBag bag;

        try{
            Scanner scanFile = new Scanner(file);
            Scanner scanLine = new Scanner(scanFile.nextLine());
            bag = new ShoppingBag(scanLine.nextFloat(), scanLine.nextInt());
            scanLine.close();
            while(scanFile.hasNextLine()){
                scanLine = new Scanner(scanFile.nextLine());
                StringBuilder itemName = new StringBuilder("");
                while(!scanLine.hasNextInt()){
                    itemName.append(scanLine.next());
                }
                Item item = new Item(itemName.toString(), scanLine.nextInt(), scanLine.nextFloat());
                bag.push(item);
                scanLine.close();
            }
            System.out.println(bag.bagSummary());
        }catch (FileNotFoundException e){
            System.out.println("File Not Found");
        }
    }
}
