package homework.csc202.lab06ThreadProblem;

/**
 * Created by 15Cyndaquil on 6/8/2017.
 */
public class PrintChar implements Runnable {
    private String aChar;
    private int anInt;
    private Thread thread;
    private volatile boolean exit=false;

    public PrintChar(String aChar, int anInt){
        this.aChar = aChar;
        this.anInt = anInt;
        thread = new Thread(this);
    }


    @Override
    public void run() {
            for (int i = 0; i < anInt; i++) {
                try {
                    if (aChar.equals("\n")) {
                        Thread.sleep((int) (Math.random() * 3) + 40);
                        System.out.print(aChar);
                    } else {
                        Thread.sleep((int) (Math.random() * 3));
                        System.out.print(aChar);
                    }
                } catch (InterruptedException e) {
                }
            }

    }

    public void start(){
        thread.start();
    }
    public void start(PrintChar a, PrintChar b){
        thread.start();
        while (a.thread.isAlive()&& b.thread.isAlive()){

        }
        thread.stop();
    }

    private void stop(){
        exit=true;
    }

    private boolean isExit(){return exit;}
}
