/**
 * Created by 15Cyndaquil on 6/20/2017.
 */
public class BinarySearch {
    public static void main(String[] args){
        int[] array = new int[100];

        for(int i=0; i<array.length; i++){
            array[i] = i;
        }
//        for(int i=0; i<array.length; i++){
            System.out.println("Index of: "+binarySearch(80, array, array.length, 0));
//        }


    }

    public static int binarySearch(int toLook, int[] array, int top, int bot) {
        int mid = ((top-bot)/2);
        mid = top-mid;
        if(toLook==array[mid]){
            return mid;
        }else{
            if(toLook>array[mid]){
                System.out.println(mid+", "+top);
                return binarySearch(toLook, array, top, mid);
            }else {
                return binarySearch(toLook, array, top, 0);
            }
        }
    }
}
