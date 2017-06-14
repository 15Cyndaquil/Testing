package homework.csc202.listData;

/**
 * Created by 15Cyndaquil on 6/14/2017.
 */
public class ListDriver {
    public static void main(String[] args){
        ArrayList test = new ArrayList();

        for(int i=0; i<11; i++){
            test.add(String.valueOf(i));
        }
        test.print();
        test.remove(0);
        test.print();
        test.remove("10");
        test.print();
        System.out.println(test.get(5));
        System.out.print(test.contains("11"));
        System.out.println(test.contains("1"));
        test.insert("20", 2);
        test.insert("20", 20);
        test.print();
        System.out.println(test.size());
        ArrayList copy = test.copy();
        copy.print();
        copy.remove(0);
        test.print();
        copy.print();
        copy.remove("20");
        copy.print();
        System.out.println(copy.get(0));
        System.out.println(copy.isEmpty());
        copy.insert("Hello", copy.size());
        copy = copy.copy(5,20);
        copy.print();
        copy.clear();
        copy.print();
    }
}
