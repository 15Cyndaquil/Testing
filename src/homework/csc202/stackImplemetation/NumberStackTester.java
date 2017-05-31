package homework.csc202.stackImplemetation;

/**
 * Created by 15Cyndaquil on 5/31/2017.
 */
public class NumberStackTester {
    public static void main(String[] args){
        int random = (int) (Math.random()*198);
        int first = (int) (Math.random()*500);
        first = first*2;
        NumberStackImp even = new NumberStackImp();
        even.push(first);
        first = (int) (Math.random()*500);
        first = first*2-1;
        NumberStackImp odd = new NumberStackImp();
        odd.push(first);

        for(int i=0; i<random; i++){
            int input = (int) (Math.random()*1000);

            if(input%2==0){
                even.push(input);
            }else {
                odd.push(input);
            }
        }

        for(int i=0; i<500; i++){
            int input = (int) (Math.random()*5000);

            if(input%2==0){
                even.push(input);
            }else {
                odd.push(input);
            }
        }
        System.out.println("Even:\n"+even.printStack());
        System.out.println("Odd:\n"+odd.printStack());
    }
}
