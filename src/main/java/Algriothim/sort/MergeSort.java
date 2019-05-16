package Algriothim.sort;

import java.util.Arrays;

/**
 * @author xuan
 * @date 2019-05-13 16:20.
 */

public class MergeSort {

    private static int mergeArr[];
    private static int resultArr[];


    public static void main(String[] args) {
        int[] a = new int[]{3, 4, 2, 1, 6, 9};
        mergeSort(a);
    }

    /**
     * 这里可以做一些调用的初始化工作
     * @param arr
     */
    private static void mergeSort(int[] arr) {
        mergeArr = arr;
        resultArr = new int[arr.length];
        int s = 0, e = arr.length - 1;
        mergeSort(s, e);

        System.out.println(Arrays.toString(resultArr));
        System.out.println(Arrays.toString(mergeArr));
    }

    /**
     * 算法区间是闭区间，递归调用，时间复杂度log(n) ,空间复杂度O(n)
     * @param start
     * @param end
     */
    private static void mergeSort(int start,int end) {
        if (end > start) {
            int mid = (end + start) / 2;
            mergeSort(start, mid);
            mergeSort(mid + 1, end);
            merge(start, mid, end);
        }
    }

    /**
     * 算法区间是闭区间，合并赋值给resultArr其实是临时数组，但是最后两个数组都是有序的
     * @param start
     * @param mid
     * @param end
     */
    private static void merge(int start, int mid , int end) {
        int i = start, j = mid + 1;
        int k=0;
        while (i <= mid && j <= end) {
            if (mergeArr[i] < mergeArr[j]) {
                resultArr[k++] = mergeArr[i++];
            } else {
                resultArr[k++] = mergeArr[j++];
            }
        }
        while (i <= mid) {
            resultArr[k++] = mergeArr[i++];
        }
        while (j <= end) {
            resultArr[k++] = mergeArr[j++];
        }

        for(i=0,j=start;j<=end;) {
            mergeArr[j++] = resultArr[i++];
        }
    }
}
