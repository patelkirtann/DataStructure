import java.util.Arrays;
import java.util.Random;

/**
 * Created by kt_ki on 12/14/2016.
 */
public class MergeSort {

    public static void mergeSort_srt(int array[], int lo, int n) {
        int low = lo;

        if (low >= n) {
            return;
        }
        int middle = (low + n) / 2;

        mergeSort_srt(array, low, middle);
        mergeSort_srt(array, middle + 1, n);

        int end_low = middle;
        int start_high = middle + 1;

        while ((lo <= end_low) && (start_high <= n)) {
            System.out.println("\nBOTTOM ARRAY");
            printSmallArray(array, lo, middle);
            System.out.println("\nTOP ARRAY");
            printSmallArray(array, start_high, n);
            printHorzArray(-1, -1, array, 49);

            System.out.println("Is " + array[low] + " < " + array[start_high]
                    + "? " + (array[low] < array[start_high]));

            if (array[low] < array[start_high]) {
                low++;
            } else {
                int Temp = array[start_high];
                System.out.println("Temp: " + Temp);

                for (int k = start_high - 1; k >= low; k--) {
                    System.out.println("array[" + k + "] = " + array[k]
                            + " Stored in array index " + (k + 1));
                    array[k + 1] = array[k];
                }
                System.out.println(Temp + " is stored in index " + low);
                printHorzArray(-1, -1, array, 49);

                array[low] = Temp;
                low++;
                end_low++;
                start_high++;
            }
        }
        printHorzArray(-1, -1, array, 49);
    }

    static void printSmallArray(int theArray[], int lo, int high) {

        int[] tempArray = Arrays.copyOfRange(theArray, lo, high);
        int tempArrayDashes = tempArray.length * 6;

        System.out.println("Array Index Start " + lo + " and End " + high);
        printHorzArray(-1, -1, tempArray, tempArrayDashes);

    }

    static void printHorzArray(int i, int j, int theArray[], int numDashes) {

        for (int n = 0; n < numDashes; n++)
            System.out.print("-");
        System.out.println();

        for (int n = 0; n < theArray.length; n++) {
            System.out.format("| %2s " + " ", n);
        }

        System.out.println("|");

        for (int n = 0; n < numDashes; n++)
            System.out.print("-");
        System.out.println();

        for (int n = 0; n < theArray.length; n++) {
            System.out.print(String.format("| %2s " + " ", theArray[n]));
        }
        System.out.println("|");

        for (int n = 0; n < numDashes; n++)
            System.out.print("-");
        System.out.println();
    }

    public static void main(String[] args) {

        int array[] = new int[10];

        for (int i = 0; i < 10; i++) {
            array[i] = (int) (Math.random() * 10);
        }
        System.out.println("STARTING ARRAY\n");
        printHorzArray(-1, -1, array, 49);
        System.out.println();

        mergeSort_srt(array, 0, array.length - 1);

        System.out.print("FINAL SORTED ARRAY\n");

        printHorzArray(-1, -1, array, 49);

    }
}
