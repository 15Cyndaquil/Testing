package homework.csc202.listData;

/**
 * Created by 15Cyndaquil on 6/14/2017.
 */
public class ArrayList {
    private String[] data;
    private int index;

    public ArrayList(){
        data = new String[10];
        index=0;
    }

    public ArrayList(int size){
        data = new String[size];
        index=0;
    }

    public void add(String dataToAdd){
        checkSize();
        data[index]=dataToAdd;
        index++;
    }

    public boolean contains(String dataToCheck){
        String tmp = ("");
        for(int i=0; i<index; i++){
            if(data[i].equals(dataToCheck)){
                tmp=dataToCheck;
            }
        }
        return tmp.equals(dataToCheck);
    }

    public void insert(String dataToAdd, int indexToAddTo){
        if(indexToAddTo>=index){
            add(dataToAdd);
        }else {
            for(int i=index; i>indexToAddTo; i--){
                data[i] = data[i-1];
            }
            data[indexToAddTo] = dataToAdd;
            index++;
        }
    }

    public void clear(){index=0;}

    public void remove(int indexToRemove) {
        for (int i = indexToRemove; i < index; i++) {
            data[i]=data[i+1];
        }
        index--;
    }

    public void remove(String dataToRemove){
        while(contains(dataToRemove)) {
        int indexOf = indexOf(dataToRemove);
            if (indexOf != -1) {
                remove(indexOf);
            }
        }
    }

    public void print(){
        for(int i=0; i<index; i++){
            System.out.print(data[i]+" ");
        }
        System.out.print("\n");
    }

    public void println(){
        for(int i=0; i<index; i++){
            System.out.println(data[i]);
        }
    }

    public int size(){return index;}

    public ArrayList copy(){
        ArrayList tmp = new ArrayList();
        for(int i=0; i<size(); i++){
            tmp.add(data[i]);
        }
        return tmp;
    }

    public ArrayList copy(int beginIndex, int endIndex){
        if(endIndex>index){
            endIndex=index;
        }
        if(beginIndex>index){
            beginIndex=index;
        }
        ArrayList tmp = new ArrayList();
        for(int i=beginIndex; i<endIndex; i++){
            tmp.add(data[i]);
        }
        return tmp;
    }

    public String get(int indexToGet){
        if(indexToGet<index){
            return data[indexToGet];
        }else {return null;}
    }

    public boolean isEmpty(){return index==0;}


    private void checkSize(){
        if(index==data.length){
            String[] tmp = new String[data.length*2];
            for(int i=0; i<index; i++){
                tmp[i]=data[i];
            }
            data=tmp;
        }
    }

    private int indexOf(String dataToIndex){
        if(contains(dataToIndex)){
            int tmp = 0;
            for(int i=0; i<index; i++){
                if(data[i].equals(dataToIndex)){
                    tmp=i;
                }
            }
            return tmp;
        }
        return -1;
    }
}
