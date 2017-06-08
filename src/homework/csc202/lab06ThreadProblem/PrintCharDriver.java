package homework.csc202.lab06ThreadProblem;

/**
 * Created by 15Cyndaquil on 6/8/2017.
 */
public class PrintCharDriver {
    public static void main(String[] args){
       PrintChar a = new PrintChar("A", 1000);
       PrintChar b = new PrintChar("B", 1000);
       PrintChar enter = new PrintChar("\n", 1000);

//       Thread one = new Thread(a);
//       Thread two = new Thread(b);
//
//        one.start();
//        two.start();

        a.start();
        b.start();
        enter.start(a, b);
    }
}
