package homework.csc202.lab09ListADTLL;

/**
 * Created by 15Cyndaquil on 6/15/2017.
 */
public class Driver {
    public static void main(String[] args){
        Node first = new Node("CSC", 201, "Computer Science I", "Davis");
        Node second = new Node("CSC", 202, "Computer Science II", "Dr. Bai");
        Node third = new Node("CSC", 205, "Computer Organization", "Kanet");
        Node forth = new Node("CSC", 205, "Computer Organization", "Tyler");
        Node fith = new Node("CSC", 205, "Computer Organization", "John");

        ListLL list = new ListLL();
        list.add(first);
        list.add(second);
        list.add(third);
        list.insert(forth,1);
        list.add(fith);

        list.get(0).println();
        list.get(1).println();
        list.get(2).println();
        list.get(3).println();
        list.get(4).println();
    }
}
