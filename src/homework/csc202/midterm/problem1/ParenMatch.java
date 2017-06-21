package homework.csc202.midterm.problem1;

/**
 * Created by 15Cyndaquil on 6/21/2017.
 */
public class ParenMatch {
    public static final String LEFT  = "([{<";
    public static final String RIGHT = ")]}>";
    public static void main(String[] args){
        //add code to test your checkParen() method

        System.out.println(checkParen("5+7"));
        System.out.println(checkParen("(5+7)"));
        System.out.println(checkParen(")5+7("));
        System.out.println(checkParen("((5+7)*3)"));
        System.out.println(checkParen("<{5+7}*3>"));
        System.out.println(checkParen("[(5+7)*]3"));
        System.out.println(checkParen("(5+7)*3"));
        System.out.println(checkParen("5+(7*3)"));
        System.out.println(checkParen("((5+7)*3"));
        System.out.println(checkParen("[(5+7]*3)"));
        System.out.println(checkParen("[(5+7)*3])"));
        System.out.println(checkParen("([(5+7)*3]"));
    }
    public static boolean checkParen(String s){
        //implement this method to return true if grouping symbols match
        //each other, otherwise return false.
        boolean output = true;
        LLStack left = new LLStack();

        for(int i=0; i<s.length(); i++){
            String subString = s.substring(i, i+1);
            if(RIGHT.contains(subString)){
                int rightIndex = RIGHT.indexOf(subString);
                if(!left.isEmpty()) {
                    if (left.top().equals(LEFT.substring(rightIndex, rightIndex+1))){
                        left.pop();
                    } else {
                        output = false;
                    }
                }else {
                    output = false;
                }
            }else if(LEFT.contains(subString)){
                left.push(new LLNode(subString));
            }
        }

        if(!left.isEmpty()) output=false;

        return output;
    }
}
