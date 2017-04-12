package minecraft.crafter;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.io.IOException;

import java.net.URL;

import java.util.ArrayList;
import java.util.NoSuchElementException;
import java.util.Scanner;


public class MinecraftItems {
    private static Scanner scan;

    private static ArrayList<StringBuilder> itemIDs;
    private static ArrayList<StringBuilder> itemLocalName;
    private static ArrayList<StringBuilder> itemJavaName;

    public static void setUp() {
        itemIDs = new ArrayList<>();
        itemLocalName = new ArrayList<>();
        itemJavaName = new ArrayList<>();

        orginizeMinecraftIDs();
    }

    private static void urlReader() {

        StringBuilder output = new StringBuilder();

        try {
            URL url = new URL("http://www.minecraftinfo.com/idlist.htm");

            BufferedReader siteInput = new BufferedReader(new InputStreamReader(url.openStream()));

            String inputLine;
            while ((inputLine = siteInput.readLine()) != null) {
                output.append(inputLine).append("\n");
            }
            siteInput.close();
            try {
                PrintWriter writer = new PrintWriter(new File("ItemListHTML.txt"));
                writer.println(output);
                writer.close();
            }catch (FileNotFoundException exc){System.out.println("Writer Fail");}

        }catch(IOException exc){
            System.out.println("Could not connect to URL");
        }
    }

    private static void orginizeMinecraftIDs(){

        urlReader();

        StringBuilder[] output = new StringBuilder[3];
        try {
            scan = new Scanner(new File("ItemListHTML.txt")).useDelimiter("<table");
            scan.next();
            scan.next();
            output[0] = new StringBuilder(scan.next());
            output[1] = new StringBuilder(scan.next());
            output[2] = new StringBuilder(scan.next());
            scan.close();
            output[2].replace(output[2].toString().indexOf("google"), output[2].length(), "");

            setItemLocalName(new StringBuilder(output[0].toString()));
            setItemIDs(new StringBuilder(output[0].toString()));
            setItemJavaName(new StringBuilder(output[0].toString()));

            setItemLocalName(new StringBuilder(output[1].toString()));
            setItemIDs(new StringBuilder(output[1].toString()));
            setItemJavaName(new StringBuilder(output[1].toString()));

            setItemLocalName(new StringBuilder(output[2].toString()));
            setItemIDs(new StringBuilder(output[2].toString()));
            setItemJavaName(new StringBuilder(output[2].toString()));

            setMetaData();
        }catch(FileNotFoundException exc){System.out.println("Reader Fail");}
    }

    private static void setItemLocalName(StringBuilder list){

        scan = new Scanner(list.toString()).useDelimiter("id=");
        list.replace(0, list.length(), "");
        scan.next();
        while(scan.hasNext()){
            list.append(scan.next()).append("\n");
        }
        scan.close();

        scan = new Scanner(list.toString());
        list.replace(0, list.length(), "");
        while(scan.hasNextLine()){
            try {
                Scanner scan2 = new Scanner(scan.nextLine()).useDelimiter("</a");
                scan2.next();
                list.append(scan2.next());
                list.replace(0, list.toString().lastIndexOf(">") + 1, "");
                itemLocalName.add(new StringBuilder(list.toString()));
                list.replace(0, list.length(), "");
                scan2.close();
            }catch (NoSuchElementException exc){System.out.println("Local names always happens once");}
        }
        scan.close();
    }

    private static void setItemIDs(StringBuilder list){

        scan = new Scanner(list.toString()).useDelimiter("id=");
        list.replace(0, list.length(), "");
        scan.next();
        while(scan.hasNext()){
            list.append(scan.next()).append("\n");
        }
        scan.close();

        scan = new Scanner(list.toString()).useDelimiter("\"");
        list.replace(0, list.length(), "");
        while(scan.hasNextLine()){
            try {
                StringBuilder change_ = new StringBuilder(scan.next().substring(2));
                if (change_.toString().contains("_")) {
                    change_.replace(change_.indexOf("_"), change_.indexOf("_") + 1, ":");
                }
                itemIDs.add(change_);
                scan.nextLine();
            }catch (StringIndexOutOfBoundsException exc){System.out.println("ID's always happens once");}
        }
        scan.close();
    }

    private static void setItemJavaName(StringBuilder list) {

        scan = new Scanner(list.toString()).useDelimiter("id=");
        list.replace(0, list.length(), "");
        scan.next();
        while (scan.hasNext()) {
            list.append(scan.next()).append("\n");
        }
        scan.close();

        scan = new Scanner(list.toString());
        list.replace(0, list.length(), "");
        while (scan.hasNextLine()) {
            try {
                StringBuilder line = new StringBuilder(scan.nextLine());
                if (line.toString().contains("</table>")) {
                    line.replace(line.indexOf("</table>"), line.length(), "");
                }
                list.append(line.substring(line.lastIndexOf("class=\""))).append("\n");
            } catch (StringIndexOutOfBoundsException exc) {System.out.println("Java names always happens once");}
        }
        scan.close();

        scan = new Scanner(list.toString());
        while (scan.hasNextLine()) {
            StringBuilder line = new StringBuilder(scan.nextLine());
            if (line.toString().contains("</span>")) {
                itemJavaName.add(new StringBuilder(line.toString().substring(line.indexOf(">") + 1, line.indexOf("</span>"))));
            } else if (line.toString().contains("</tr>")) {
                itemJavaName.add(new StringBuilder(line.toString().substring(line.indexOf("<br/>") + 5, line.indexOf("</tr>"))));
            }
        }
        scan.close();

    }

    private static void setMetaData(){

        for (int i = 0; i < itemJavaName.size(); i++) {
            if (itemJavaName.get(i).toString().contains(":")) {
                if (!itemJavaName.get(i - 1).toString().contains(":")) {
                    itemJavaName.get(i - 1).append(":0");
                }
            }
        }
        for (int i = 0; i < itemIDs.size(); i++) {
            if (itemIDs.get(i).toString().contains(":")) {
                if (!itemIDs.get(i - 1).toString().contains(":")) {
                    itemIDs.get(i - 1).append(":0");
                }
            }
        }
    }

    public static StringBuilder getItemIDs(StringBuilder item){

        StringBuilder output = new StringBuilder("null");

        for(int i=0; i<itemLocalName.size(); i++){
            if(itemLocalName.get(i).toString().equals(item.toString().trim())){
                output = new StringBuilder(itemIDs.get(i).toString());
            }
        }
        return output;
    }

    public static StringBuilder getItemLocalName(StringBuilder item){

        StringBuilder output = new StringBuilder();
        for(int i=0; i<itemLocalName.size(); i++){
            if(itemLocalName.get(i).toString().equals(item.toString().trim())){
                output = new StringBuilder(itemLocalName.get(i).toString());
            }
        }
        return output;
    }

    public static StringBuilder getItemJavaName(StringBuilder item){

        StringBuilder output = new StringBuilder();
        for(int i=0; i<itemLocalName.size(); i++){
            if(itemLocalName.get(i).toString().equals(item.toString().trim())){
                output = new StringBuilder(itemJavaName.get(i).toString());
            }
        }
        return output;
    }

    public static ArrayList<StringBuilder> getItemLocalNameArray(){return itemLocalName;}
}
