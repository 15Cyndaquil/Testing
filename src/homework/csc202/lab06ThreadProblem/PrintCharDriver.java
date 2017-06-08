package homework.csc202.lab06ThreadProblem;

/**
 * Created by 15Cyndaquil on 6/8/2017.
 */
public class PrintCharDriver {
    public static void main(String[] args){
       PrintChar a = new PrintChar("A".charAt(0), Integer.MAX_VALUE);
       PrintChar b = new PrintChar("B".charAt(0), Integer.MAX_VALUE);

       Thread one = new Thread(a);
       Thread two = new Thread(b);

        one.start();
        two.start();
    }
}
