package homework.csc202.lab12TreeImplementation;

/**
 * Created by 15Cyndaquil on 6/28/2017.
 */
public class lab12Tester {
    public static void main(String[] args){
        MyTree test = new MyTree();
        for(int i=0; i<100; i++){
            int toAdd = (int) (Math.random()*100);
            System.out.print(toAdd+", ");
            test.add(toAdd);
        }
        System.out.print("\n");
        test.displayTree();
        test.printInorder();
        System.out.println(test.size());


        test.remove(10);
        test.printInorder();
        System.out.println(test.size());
//        test.reOrginize();
//        test.printInorder();
//        System.out.println(test.size());
    }
}
