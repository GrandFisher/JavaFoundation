package algriothim.sort;

import java.util.Arrays;

/**
 * @author xuan
 * @date 2019-04-06 15:58.
 */

public class BubbleSort {

    public static void main(String[] args) {
        int[] a = new int[]{3, 4, 2, 1, 6, 9};
//        bubbleSort(a);
//        selectionSort(a);
//        insertionSort(a);
//        shellSort(a);
//        quickSort(a);

    }


    public static void bubbleSort(int arr[]) {
        int len = arr.length;
        for (int i = 0; i < len - 1; i++) {
            //符合人类习惯，其实和第二种差别不大
            //大的在后，自小到大
            for (int j = 0; j < len - 1 - i; j++) {
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }

        System.out.println(Arrays.toString(arr));

        arr = new int[]{1, 3, 2, 4};
        len = arr.length;
        for (int i = 0; i < len - 1; i++) {
            //大的在前，自大到小
            for (int j = len - 1; j >= 1 + i; j--) {
                if (arr[j] > arr[j - 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j - 1];
                    arr[j - 1] = temp;
                }
            }
        }

        System.out.println(Arrays.toString(arr));
    }
}