package algriothim.sort;

import java.util.Arrays;

import static algriothim.sort.SelectionSort.selectionSort;

/**
 * @author xuan
 * @date 2019-05-13 16:43.
 */

public class InsertionSort {
    public static void main(String[] args) {
        int[] a = new int[]{3, 4, 2, 1, 6, 9};
        selectionSort(a);
    }

    /**
     * 稳定 o(n^2)
     * @param arr
     */
    public static void insertionSort(int arr[]) {
        int len = arr.length;
        int j;
        for (int i = 1; i < len ; i++) {
            int temp = arr[i];
            j = i - 1;
            while (j >= 0 && temp < arr[j]) {
                arr[j + 1] = arr[j];
                j--;
            }
            arr[j+1]=temp;
        }
        System.out.println(Arrays.toString(arr));
    }
}
