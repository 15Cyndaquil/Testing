package homework.bookProblems.ch1.prob_7;

import java.util.ArrayList;

/**
 * Created by 15Cyndaquil on 5/30/2017.
 */
public class ApproximatePI {
    private static int aLong = Short.MAX_VALUE*1000;
//    Integer.MAX_VALUE
    public static void main(String[] args){
//        System.out.println(4*(1.0-(1.0/3.0)+(1.0/5.0)-(1.0/7.0)+(1.0/9.0)-(1.0/11.0)));
        int count = 0;
        Double odd = 3d;
        double[] array = new double[aLong*2];
        for(int i=0; i<aLong; i++){
            PIThread neg = new PIThread((-odd), count++, array);
            neg.start();
            odd += 2;
            PIThread pos = new PIThread(odd, count++, array);
            pos.start();
            odd += 2;
        }

        PISumationThread sumation = new PISumationThread(array);
        sumation.start();


    }
}
