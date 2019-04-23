package sort;

import java.util.Arrays;

/**
 * @author xuan
 * @date 2019-04-06 15:58.
 */

public class Sort {

    public static void main(String[] args) {
        int[] a = new int[]{1, 3, 2, 4};
//        bubbleSort(a);
//        selectionSort(a);
        insertionSort(a);
        shellSort(a);
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

    /**
     * @param arr
     * @Description 简单的选择排序是无序的，需要经过精心设计，变有序。
     * 例如 自前向后遍历数据且将数据向后放置时，比较符号应为<= >=;
     * 自后向前遍历数据且将数据向后放置时，比较符号应为<
     * <p>
     * 它比冒泡排序好在减少了交换次数，是一步到位的
     */
    public static void selectionSort(int arr[]) {

        int len = arr.length;
        int minIndex = 0;
        for (int i = 0; i < len - 1; i++) {
            //小的在后 反人类的设计
            minIndex = 0;
            //因为是一个一个比，所以范围小于len，每次确定一个位置，第i次确定了i个
            for (int j = minIndex + 1; j < len - i; j++) {
                if (arr[j] < arr[minIndex]) {
                    minIndex = j;
                }
            }
            int temp = arr[minIndex];
            arr[minIndex] = arr[len - i - 1];
            arr[len - i - 1] = temp;
        }
        System.out.println(Arrays.toString(arr));


        arr = new int[]{1, 3, 2, 4, 8, 7, 6};
        len = arr.length;
        for (int i = 0; i < len - 1; i++) {
            //小的在前，符合人类
            minIndex = i;
            for (int j = i + 1; j < len; j++) {
                if (arr[j] < arr[minIndex]) {
                    int temp = arr[j];
                    arr[j] = arr[minIndex];
                    arr[minIndex] = temp;
                }
            }
        }

        System.out.println(Arrays.toString(arr));
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

    /**
     * 就是插入排序的升级版，先按照取余相同的分成若干组数据，对这些数据使用插入排序，依次降低步长
     * @param arr
     */
    public static void shellSort(int arr[]) {
        int len=arr.length;
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

    public static void quickSort(int arr[]) {
        int len=arr.length;



    }


}
