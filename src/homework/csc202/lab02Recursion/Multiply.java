package homework.csc202.lab02Recursion;

/**
 * Created by 15Cyndaquil on 5/25/2017.
 */
public class Multiply {
    public static void main(String[] args){
        System.out.println(multiply(15,-66));
    }

    public static int multiply(int a, int b){
        if(a==0||b==0){
            return 0;
        }else if(a==1){
            return b;
        }else if(b==1){
            return a;
        }else if(a<0&&b<0){
            a=a-a-a;
            b=b-b-b;
            return multiply(a,b);
        }else if(a<0){
            return a+multiply(a, b-1);
        }else{
            return b+multiply(a-1,b);
        }
    }
}
