package homework.ch13.prob_4;

/**
 * Created by 15Cyndaquil on 4/12/2017.
 */
public class Driver {
    public static void main(String[] args){
        Calendar test = new Calendar(13, new Month("jan"), 2017);
        System.out.println(test.monthToString());
    }
}
