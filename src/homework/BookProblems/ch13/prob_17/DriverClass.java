package homework.BookProblems.ch13.prob_17;

/**
 * Created by 15Cyndaquil on 4/11/2017.
 */
public class DriverClass {
    public static void main(String[] args){

        Complex firstComplex = new Complex(3.5, 5.5);
        Complex secondComplex = new Complex(-3.5, 1);

        System.out.println(firstComplex.add(secondComplex));
        System.out.println(firstComplex.subtract(secondComplex));
        System.out.println(firstComplex.multiply(secondComplex));
        System.out.println(firstComplex.divide(secondComplex));
        System.out.println(firstComplex.abs());
        System.out.println(firstComplex.toString());
        System.out.println(secondComplex.toString());
        try {
            secondComplex = (Complex) firstComplex.clone();
        }catch (CloneNotSupportedException exc){
            System.out.println("Clone not Supported");
        }
        System.out.println(secondComplex);

    }
}
