package homework.csc202.stackImplemetation;

/**
 * Created by 15Cyndaquil on 6/1/2017.
 */
public class NumberStackTester {
    public static void main(String[] args){
        int randInt = (int)((Math.random()*500+1)*2);
        LLIntStack even = new LLIntStack();
        LLIntStack odd = new LLIntStack();

        even.push(randInt);
        randInt = (int)((Math.random()*500+1)*2-1);
        odd.push(randInt);

        randInt = (int)((Math.random()*200)+1);
        for(int i=0; i<randInt; i++){
            int randInput = (int)(Math.random()*1000+1);
            if(randInput%2==0){
                even.push(randInput);
            }else {
                odd.push(randInput);
            }
        }
        for(int i=0; i<500; i++){
            int randInput = (int)(Math.random()*5001);
            if(randInput%2==0){
                even.push(randInput);
            }else {
                odd.push(randInput);
            }
        }

        System.out.println("Even:\n"+even.printStack()+"\n");
        System.out.println("Odd:\n"+odd.printStack()+"\n");
    }
}
