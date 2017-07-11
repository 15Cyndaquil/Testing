/**
 * Created by 15Cyndaquil on 6/20/2017.
 */
public class BinarySearch {
    public static void main(String[] args) {
        int[] array = new int[100];

        for (int i = 0; i < array.length; i++) {
            array[i] = i;
        }
        for(int i=0; i<array.length; i++){
        System.out.println("Index of: " + binarySearch(i, array));
        }


    }

    public static int binarySearch(int toLook, int[] array) {
        return binarySearch(toLook, array, array.length, 0);
    }

    private static int binarySearch(int toLook, int[] array, int top, int bot) {
        int mid = bot + ((top - bot) / 2);
        if (toLook == array[mid]) {
            return mid;
        } else if (top - mid == 1) {
            return -1;
        } else {
            if (toLook > array[mid]) {
                return binarySearch(toLook, array, top, mid);
            } else {
                return binarySearch(toLook, array, mid, bot);
            }
        }
    }
}
