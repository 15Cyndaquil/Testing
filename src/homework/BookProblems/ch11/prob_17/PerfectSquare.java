package homework.BookProblems.ch11.prob_17;

public class PerfectSquare {
    public static void main(String[] args) {

        final int runTimes = 100;

        for (int i = 0; i < runTimes; i++) {
            int m = (int) (Math.random() * 1000);
            int n = 1;
            double root = Math.sqrt(m * n);

            while (Math.floor(root)!=root) {
                root = Math.sqrt(m * ++n);
            }

            System.out.println("Inputed int: "
                    +m+", Smallest int for perfect square: "
                    +n+", m*n = "+(m*n));
        }
    }
}
