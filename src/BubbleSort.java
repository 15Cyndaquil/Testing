/**
 * Created by 15Cyndaquil on 6/20/2017.
 */
public class BubbleSort {
    public static void main(String[] args){
        int[] array = new int[999];
        for(int i=0; i<array.length; i++){
            array[i] = (int)(Math.random()*1000)+1;
        }
        bubbleSort(array);
        for(int i=0; i<array.length; i++){
            System.out.print(array[i]+", ");
        }

        System.out.println("Largest: "+array[array.length-1]+" Smallest: "+array[0]);
        System.out.print("Medium: "+medium(array));
    }

    public static void bubbleSort(int[] array){
        for(int n=0; n<array.length; n++) {
            for (int i = 0; i < array.length; i++) {
                if (i + 1 != array.length) {
                    if (array[i] > array[i + 1]) {
                        int tmp = array[i + 1];
                        array[i + 1] = array[i];
                        array[i] = tmp;
                    }
                }
            }
        }
    }

    public static double medium(int[] array){
        int mid = array.length/2;
        if(array.length%2==0){
            return (array[mid-1]+array[mid])/2;
        }else return array[mid];
    }
}
