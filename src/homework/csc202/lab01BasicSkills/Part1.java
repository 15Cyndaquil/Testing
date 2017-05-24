package homework.csc202.lab01BasicSkills;

/**
 * Created by 15Cyndaquil on 5/24/2017.
 */
public class Part1 {
    public static void main(String[] args){
        int[][] array = new int[3][3];

        for(int i=0; i<3; i++){
            for(int x=0; x<3; x++){
                array[i][x] = (int) (Math.random()*3);
            }
        }

        print(array);
    }

    public static void print(int[][] array){
        for(int i=0; i<3; i++){
            System.out.print("-------------\n|");
            for(int x=0; x<3; x++){
                System.out.print(xOrO(array[i][x])+"|");
            }
            System.out.print("\n");
        }
        System.out.print("-------------");
    }

    public static String xOrO(int arrayINT){
        if(arrayINT==1){
            return " X ";
        }else if(arrayINT==0){
            return " O ";
        }else {
            return "   ";
        }
    }
}
