package homework.csc202.lab02Recursion;

/**
 * Created by 15Cyndaquil on 5/25/2017.
 */
public class GCD {
    public static void main(String[] args){
        System.out.println(gcd(-15,66));
    }

    public static int gcd(int a, int b) {
        if (a < 0) {a = a - a - a;}
        if (b < 0) {b = b - b - b;}
        if (a == b) {
            return a;
        } else if (a < b && (b % a == 0)) {
            return a;
        } else if (b < a && (a % b == 0)) {
            return b;
        } else if (a < b) {
            return gcd(a, b - a);
        } else {
            return gcd(a - b, b);
        }
    }
}
