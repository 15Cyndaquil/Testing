package homework.csc202.lab09ListADTLL;

/**
 * Created by 15Cyndaquil on 6/15/2017.
 */
public class ListLL {
    private Node last;


    public void add(Node data){
        if(isEmpty()){
            last = new Node(data);
            last.setIndex(0);
            last.setNode(last);
        }else{
            Node tmp = last;
            last = new Node(data, last.getNode());
            last.setIndex(tmp.getIndex()+1);
            tmp.setNode(last);
        }
    }

    public Node get(int index){
        if(index>last.getIndex()){
            return last;
        }else {
            Node tmp = last.getNode();
            Node output=null;
            while(tmp!=last){
                System.out.println(tmp.getIndex());
                if(tmp.getIndex()==index){
                    output=tmp;
                }
                tmp = tmp.getNode();
            }
            return output;
        }
    }

    public void insert(Node node, int index){
        if(index>=last.getIndex()){
            add(node);
        }else if(index<=0){
            last.setIndex(last.getIndex()+1);
            Node tmp =last.getNode();
            node.setIndex(index);
            node.setNode(tmp);
            last.setNode(node);
            while(tmp!=last){
                tmp.setIndex(tmp.getIndex()+1);
                tmp = tmp.getNode();
            }
        }
        else {
            Node tmp = new Node(last.getNode());
            Node newNode = new Node(node);
            while(tmp.getIndex()!=index-1){
                tmp = tmp.getNode();
            }
            newNode.setNode(tmp.getNode());
            newNode.setIndex(index);
            tmp.setNode(newNode);
            tmp = newNode;
            while(tmp!=last){
                tmp = tmp.getNode();
                tmp.setIndex(tmp.getIndex()+1);
                System.out.println(tmp.getIndex());
            }
        }
    }

    public void clear(){this.last=null;}
    public int size(){
        return last.getIndex();
    }
    public boolean isEmpty(){return last==null;}
    public boolean isFull(){return false;}
}
