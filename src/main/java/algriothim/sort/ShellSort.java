package algriothim.sort;

import java.util.Arrays;

/**
 * @author xuan
 * @date 2019-05-13 16:42.
 */

public class ShellSort {

    public static void main(String[] args) {
        int[] a = new int[]{3, 4, 2, 1, 6, 9};
        shellSort(a);
    }

    /**
     * 就是插入排序的升级版，先按照取余相同的分成若干组数据，对这些数据使用插入排序，依次降低步长
     * @param arr
     */
    public static void shellSort(int arr[]) {
        int len = arr.length;
        //步长
        int number = arr.length / 2;
        int i;
        int j;
        int temp;
        while (number >= 1) {
            for (i = number; i < arr.length; i++) {
                temp = arr[i];
                j = i - number;
                while (j >= 0 && temp < arr[j]) { //需要注意的是，这里array[j] < temp将会使数组从大到小排序。
                    arr[j + number] = arr[j];
                    j = j - number;
                }
                arr[j + number] = temp;
            }
            number = number / 2;
        }
        System.out.println(Arrays.toString(arr));
    }

}
