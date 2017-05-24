package homework.bookProblems.ch19.prob_10;

import java.util.ArrayList;

/**
 * Created by Cyndaquil on 5/1/2017.
 */
public class LargestElement {
    public static <E extends Comparable<E>> void main(String[] args){
        ArrayList<E> list = new ArrayList<>();
        for(int i=0; i<10; i++){
            list.add((E) Double.valueOf((Math.random()*12)));
        }

                for(int i=0; i<10; i++){
                    System.out.print(list.get(i)+", ");
                }
        System.out.println(max(list).toString());
    }

    private static String largestElement(ArrayList<Number> list){
        Number largest = 0;
        for (Number currentMax : list) {
            if (largest.doubleValue() < currentMax.doubleValue()) {
                largest = currentMax;
            }
        }

        return String.valueOf(largest.doubleValue());
    }

    public static <E extends Comparable<E>> E max(ArrayList<E> list){
        E max = list.get(0);
        for (E elements : list) {
                if (elements.compareTo(max) > 0) {
                    max = elements;
                }
        }

        return max;
    }
}
