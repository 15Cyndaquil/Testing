package homework.bookProblems.ch1.prob_4;

/**
 * Created by 15Cyndaquil on 5/3/2017.
 */
public class DispTable {
    public static void main(String[] args){
        System.out.println("a    a^2    a^3");
        for(int i=1; i<5; i++){
            System.out.print(i+"    ");
            String a = String.valueOf((i*i));
            if(a.length()==2){
                System.out.print(a+"     ");
            }else {
                System.out.print(a+"      ");
            }
            a = String.valueOf((i*i*i));
            System.out.print(a+"\n");

        }
    }
}
