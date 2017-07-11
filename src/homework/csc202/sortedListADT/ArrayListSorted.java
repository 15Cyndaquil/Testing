package homework.csc202.sortedListADT;

/**
 * Created by Cyndaquil on 6/26/2017.
 */
public class ArrayListSorted {
    private Course[] data;
    private int index;

    public ArrayListSorted(){
        data = new Course[10];
        index=0;
    }
    public void add(Course dataToAdd){
        checkSize();
        data[index]=dataToAdd;
        index++;
        sort();
    }
    public boolean contains(Course dataToCheck){
        int index = binarySearch(dataToCheck, data, size(), 0);
        if(index==-1){
            return false;
        }else return true;
    }
    public void clear(){index=0;}
    public void remove(int indexToRemove) {
        for (int i = indexToRemove; i < index; i++) {
            data[i]=data[i+1];
        }
        index--;
    }
    public void remove(Course dataToRemove){
        while(contains(dataToRemove)) {
            int indexOf = indexOf(dataToRemove);
            if (indexOf != -1) {
                remove(indexOf);
            }
        }
    }
    public void print(){
        for(int i=0; i<index; i++){
            Course cur = data[i];
            System.out.print(cur.getTitle()+cur.getNumber()+"-"+i+" "+cur.getTitleFull()+" "+cur.getProfessor());
        }
        System.out.print("\n");
    }
    public void println(){
        for(int i=0; i<index; i++){
            Course cur = data[i];
            System.out.println(cur.getTitle()+cur.getNumber()+"-"+i+" "+cur.getTitleFull()+" "+cur.getProfessor()+" "+cur.getValue());
        }
    }
    public int size(){return index;}
    public ArrayListSorted copy(){
        ArrayListSorted tmp = new ArrayListSorted();
        for(int i=0; i<size(); i++){
            tmp.add(data[i]);
        }
        return tmp;
    }
    public ArrayListSorted copy(int beginIndex, int endIndex){
        if(endIndex>index){
            endIndex=index;
        }
        if(beginIndex>index){
            beginIndex=index;
        }
        ArrayListSorted tmp = new ArrayListSorted();
        for(int i=beginIndex; i<endIndex; i++){
            tmp.add(data[i]);
        }
        return tmp;
    }
    public Course get(int indexToGet){
        if(indexToGet<index){
            return data[indexToGet];
        }else {return null;}
    }
    public boolean isEmpty(){return index==0;}
    private void checkSize(){
        if(index==data.length){
            Course[] tmp = new Course[data.length*2];
            for(int i=0; i<index; i++){
                tmp[i]=data[i];
            }
            data=tmp;
        }
    }
    private int indexOf(Course dataToIndex){
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
    private void sort(){
        for(int n=0; n<size(); n++) {
            for (int i=0; i<size(); i++) {
                if (i+1!=size()) {
                    if (data[i].compare(data[i+1])==1) {
                        Course tmp = data[i+1];
                        data[i+1] = data[i];
                        data[i] = tmp;
                    }
                }
            }
        }
    }
    private static int binarySearch(Course toLook, Course[] array, int top, int bot) {
        int mid = bot + ((top - bot) / 2);
        if (toLook.compare(array[mid])==0) {
            return mid;
        } else if (top-mid==1){
            if(toLook.compare(array[top])==0){
                return top;
            }else if(toLook.compare(array[bot])==0){
                return bot;
            }else return -1;
        } else {
            if (toLook.compare(array[mid])==1) {
                return binarySearch(toLook, array, top, mid);
            } else {
                return binarySearch(toLook, array, mid, bot);
            }
        }
    }
}
