package practiceForInternShip;

import java.util.Arrays;

/**
 * @author xuan
 * @date 2019-06-17 22:42.
 */

public class QuickSort {

    public static void main(String[] args) {
        int[] a = new int[]{6, 4, 3, 2, 5};
        sort(a, 0, a.length - 1);
        System.out.println(Arrays.toString(a));
    }

    private static void sort(int[] arr, int start, int end) {
        if (end <= start) return;
        int pivot = partition1(arr, start, end);
        sort(arr, start, pivot - 1);
        sort(arr, pivot + 1, end);
    }

    private static int partition(int[] arr, int start, int end) {
        //优化 三位取中法和随机取中法
        int temp = arr[start];
        int p = start;
        for (int i = start + 1; i < end; i++) {
            if (arr[i] < temp) {
                p++;
                swap(arr, p, i);
            }
        }
        swap(arr, p, start);
        return p;
    }

    private static int partition1(int[] arr, int start, int end) {
        int temp = arr[start];
        int left = start;
        int right = end;
        while (left < right) {
            while (left < right && arr[right] >= temp) {
                right--;
            }
            if (left == right) break;
            swap(arr, left, right);

            while (left < right && arr[left] <= temp) {
                left++;
            }
            if (left == right) break;
            swap(arr, left, right);
        }

        return right;
    }

    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
