package Algriothim.sort;

import java.util.Arrays;

/**
 * @author xuan
 * @date 2019-05-13 16:40.
 */

public class QuickSort {

    private static int arrS[];
    public static void main(String[] args) {
        int[] a = new int[]{3, 4, 2, 1, 6, 9};
        quickSort(a);
    }


    public static void quickSort(int [] arr) {
        arrS = arr;
        int len = arrS.length;
        int i = 0, j = len - 1;
        quickSort(i, j);

        System.out.println(Arrays.toString(arrS));
    }


    private static void quickSort(int i,int j) {
        if (i >= j) return;
        int pos = quickSortDigging(i, j);
        quickSort(i, pos - 1);
        quickSort(pos + 1, j);
    }

    private static int quickSortDigging(int left,int right) {
        int i = left, j = right;
        int temp = arrS[left];
        while (i < j) {
            while (i < j && arrS[j] >= temp) {
                j--;
            }
            arrS[i] = arrS[j];
            while (i < j && arrS[i] < temp) {
                i++;
            }
            arrS[j] = arrS[i];
        }
        arrS[i] = temp;
        return i;
    }
}
