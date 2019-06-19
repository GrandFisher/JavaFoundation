package practiceForInternShip;

import java.util.Arrays;

/**
 * @author xuan
 * @date 2019-06-18 11:16.
 */

public class MergeSort {


    public static void main(String[] args) {
        int[] a = new int[]{1, 4, 2, 5, 3};
        sort(a, 0, a.length - 1);
        System.out.println(Arrays.toString(a));
    }

    public static void sort(int[] arr, int start, int end) {

        if (end <= start) return;
        int mid = start + (end - start) / 2;
        sort(arr, start, mid);
        sort(arr, mid + 1, end);
        merge(arr, start, mid, end);
    }

    private static void merge(int[] arr, int start, int mid, int end) {
        int len = end - start + 1;
        int[] temp = new int[len];
        int i = start, j = mid + 1;
        for (int k = 0; k < len; k++) {
            if (j > end || i <= mid && arr[i] <= arr[j]) {
                temp[k] = arr[i++];
            } else {
                temp[k] = arr[j++];
            }
        }
        for (int k = 0; k < len; k++) {
            arr[start + k] = temp[k];
        }

    }
}
