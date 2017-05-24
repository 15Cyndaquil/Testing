package homework.bookProblems.ch13.prob_2to3;

import java.util.ArrayList;

/**
 * Created by 15Cyndaquil on 4/12/2017.
 */
public class Driver {
    public static void main(String[] args){
        ArrayList<Number> test = new ArrayList<Number>();
        for(int i=0; i<100; i++){
            test.add(i);
        }

        WorkWithArrayList.shuffle(test);

        for(int i=0; i<100; i++){
            System.out.println(test.get(i));
        }

        WorkWithArrayList.sort(test);

        for(int i=0; i<100; i++){
            System.out.println(test.get(i));
        }
    }
}
