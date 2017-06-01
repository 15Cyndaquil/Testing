package test;

import java.util.ArrayList;
import java.util.Collections;

/**
 * Created by Cyndaquil on 5/29/2017.
 */
public class Sudoku {
    private static ArrayList<Integer> check = new ArrayList<>();

    public static void main(String[] args){

        int[][] fullBoard = new int[9][9];

        for(int i=0; i<9; i++){
            check.add(0);
        }

        int rowCord = 0;
        int colCord = 0;
        for(int i=1; i<10; i++){
            fullBoard[rowCord++][colCord] = i;
            fullBoard[rowCord++][colCord] = i;
            fullBoard[rowCord++][colCord] = i;
            rowCord = rowCord-3;
            colCord++;
        }

        System.out.println(checkSquare(fullBoard, 0, 0));
    }

    public static boolean checkSquare(int[][] fullBoard, int rowCord, int colCord){
        if(rowCord==1){
            rowCord=3;
        }else if(rowCord==2){
            rowCord=6;
        }
        if(colCord==1){
            colCord=3;
        }else if(colCord==2){
            colCord=6;
        }

        for(int i=0; i<9; i++){
            check.set(i, fullBoard[rowCord++][colCord]);
            check.set(i, fullBoard[rowCord++][colCord]);
            check.set(i, fullBoard[rowCord++][colCord]);
            rowCord = rowCord-3;
            colCord++;
        }
        Collections.sort(check);
        int checks = 0;
        for(int i=0; i<9; i++){
            if(check.get(i)==(i+1)){
                checks++;
            }
        }
        System.out.println(checks);
        if(checks==9){
            return true;
        }else {
            return false;
        }
    }
}
