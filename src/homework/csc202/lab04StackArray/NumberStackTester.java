package homework.csc202.lab04StackArray;

import java.util.ArrayList;

/**
 * Created by 15Cyndaquil on 6/1/2017.
 */
public class NumberStackTester {
    public static void main(String[] args){
        ArrayIntStack even = new ArrayIntStack(700);
        ArrayIntStack odd = new ArrayIntStack(700);
        int randInt = (int)((Math.random()*200)+1);
        for(int i=0; i<randInt; i++){
            int randInput = (int)(Math.random()*1000+1);
            if(randInput%2==0){
                even.push(randInput);
            }else {
                odd.push(randInput);
            }
        }
        for(int i=0; i<500; i++){
            int randInput = (int)(Math.random()*5001);
            if(randInput%2==0){
                even.push(randInput);
            }else {
                odd.push(randInput);
            }
        }

        System.out.println("Even:\n"+even.printStack()+"\n");
        System.out.println("Odd:\n"+odd.printStack()+"\n");
    }
}
