package homework.csc202.treeData;


/**
 * Created by 15Cyndaquil on 6/28/2017.
 * TreeList Tester
 */
public class Tester {
    public static void main(String[] args){
        for(int x=0; x<1; x++) {
            TreeList test = new TreeList();
            for (int i = 0; i < 25; i++) {
                int toAdd = (int) (Math.random() * 100);
                test.add(toAdd);
//                test.add(i);
            }
//            test.add(0);
//            test.add(3);
//            test.add(6);
//            test.add(8);
//            test.add(7);
            test.reOrginize();
            test.print();
            System.out.println();
            test.displayTreeH();
            test.displayTreeV();
        }
    }
}
