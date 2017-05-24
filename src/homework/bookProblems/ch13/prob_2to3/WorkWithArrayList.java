package homework.bookProblems.ch13.prob_2to3;

import java.util.ArrayList;

/**
 * Created by 15Cyndaquil on 4/12/2017.
 */
public class WorkWithArrayList {

    public static void shuffle(ArrayList<Number> list){
        ArrayList<Number> rand = new ArrayList<Number>();
        ArrayList<Number> shuffle = (ArrayList<Number>) list.clone();
        for(int i=0; i<list.size(); i++){
            boolean go = true;
            while(go) {
                int randomNum = (int) (Math.random() * list.size());
                if(!rand.contains(randomNum)){
                    rand.add(randomNum);
                    go = false;
                }
            }
        }
        for(int i=0; i<list.size(); i++){
            list.set(i, shuffle.get(rand.indexOf(i)));
        }

    }

    public static void sort(ArrayList<Number> list){
        Number sort[] = new Number[list.size()];
        for(int i=0; i<list.size(); i++){
            int place = 0;
            for(int x=0; x<list.size(); x++){
                if(list.get(i).doubleValue()>list.get(x).doubleValue()){
                    place++;
                }
            }
            sort[place] = list.get(i);
        }
        list.removeAll(list);
        for(int i=0; i<sort.length; i++){
            list.add(sort[i]);
        }
    }
}
