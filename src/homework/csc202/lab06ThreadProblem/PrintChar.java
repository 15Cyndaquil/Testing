package homework.csc202.lab06ThreadProblem;

/**
 * Created by 15Cyndaquil on 6/8/2017.
 */
public class PrintChar implements Runnable {
    private char aChar;
    private int anInt;

    public PrintChar(char aChar, int anInt){
        this.aChar = aChar;
        this.anInt = anInt;
    }
    @Override
    public void run() {
        for(int i=0; i<anInt; i++){
            System.out.print(aChar);
            try {
                Thread.sleep((long) (Math.random() * 3));
            }catch (InterruptedException e){
                System.out.println(e.getMessage());
            }
        }
    }
}
