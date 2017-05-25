package homework.csc202.lab02Recursion;

/**
 * Created by 15Cyndaquil on 5/25/2017.
 */
public class NumberPermutation {
    public static void main(String[] args) {
        permutation(3, "");
    }

    public static void permutation(int len, String str) {
        if (len == 1) {
            System.out.println(str + "1");
            System.out.println(str + "3");
            System.out.println(str + "5");
            System.out.println(str + "7");
            System.out.println(str + "9");
        } else {
            permutation(len - 1, str + "1");
            permutation(len - 1, str + "3");
            permutation(len - 1, str + "5");
            permutation(len - 1, str + "7");
            permutation(len - 1, str + "9");
        }
    }

    public static void myPermutation(int len, int str) {
        str++;
        str++;
        if (String.valueOf(str).length() > len) {
        } else if (String.valueOf(str).length() < len) {
            int x = 1;
            str = Integer.valueOf(x);
            while (String.valueOf(str).length() < len) {
                x = x * 10;
                str = Integer.valueOf(x);
            }
            str++;
            System.out.println(str);
            myPermutation(len, str);
        }else{
            System.out.println(str);
            myPermutation(len, str);
        }
    }
}
