package homework.bookProblems.ch1.prob_7;

import java.util.ArrayList;

/**
 * Created by 15Cyndaquil on 5/30/2017.
 */
public class ApproximatePI {
    public static void main(String[] args){
        System.out.println(4*(1.0-(1.0/3.0)+(1.0/5.0)-(1.0/7.0)+(1.0/9.0)-(1.0/11.0)));
        double pi = 1;
        double odd = 3;
        for(int i=0; i<Long.MAX_VALUE; i++){
            pi = pi-(1.0/odd);
            odd = odd+2;
            pi = pi+(1.0/odd);
            odd = odd+2;
        }
        System.out.println(4.0*pi);
    }
}
