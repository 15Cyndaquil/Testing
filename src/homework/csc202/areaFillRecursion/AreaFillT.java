package homework.csc202.areaFillRecursion;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * Created by Cyndaquil on 5/25/2017.
 */
public class AreaFillT {
    static int ROW;
    static int COL;
    static String[][] area;

    public static void main(String[] args){
        File file = new File("src/homework/csc202/areaFillRecursion", "area.txt");
        try{
            Scanner scanLine = new Scanner(file);
            Scanner scanNextInt = new Scanner(scanLine.nextLine());
            ROW = scanNextInt.nextInt();
            COL = scanNextInt.nextInt();
            scanNextInt.close();
            area = new String[ROW][COL];
            int row=0;
            int col=0;
            while(scanLine.hasNextLine()){

                Scanner scanNext = new Scanner(scanLine.nextLine());
                while (scanNext.hasNext()){
                    String str = scanNext.next();
                    for(int i=0; i<str.length(); i++){
                        area[row][col] = String.valueOf(str.charAt(i));
                        col++;
                    }

                }
                scanNext.close();
                row++;
                col=0;
            }
            scanLine.close();

            for(int x=0; x<ROW; x++){
                for(int y=0; y<COL; y++){
                    System.out.print(area[x][y]);
                }
                System.out.print("\n");
            }
        }catch (FileNotFoundException e){}

       fillRecursion(0,0,"");

        System.out.println("After Filling");
        for( int x=0; x<ROW; x++){
            for( int y=0; y<COL; y++){
                System.out.print(area[x][y]);
            }
            System.out.print("\n");
        }
    }

    public static void fillRecursion(int row, int col, String str){
        if(str.equals("")){
            str = area[row][col];
            area[row][col] = "*";
        }

        if(area[row][col].equals("*")){
            if (row + 1 < ROW) {
                if(area[row+1][col].equals(str)) {
                    area[row+1][col] = "*";
                    fillRecursion(row + 1, col, str);
                }
            }
            if (row - 1 != -1) {
                if(area[row-1][col].equals(str)) {
                    area[row-1][col] = "*";
                    fillRecursion(row - 1, col, str);
                }
            }
            if (col + 1 < COL) {
                if(area[row][col+1].equals(str)) {
                    area[row][col+1] = "*";
                    fillRecursion(row, col + 1, str);
                }
            }
            if (col - 1 != -1) {
                if(area[row][col-1].equals(str)) {
                    area[row][col-1] = "*";
                    fillRecursion(row, col - 1, str);
                }
            }
        }
    }
}