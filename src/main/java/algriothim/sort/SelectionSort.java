package algriothim.sort;

import java.util.Arrays;

/**
 * @author xuan
 * @date 2019-05-13 16:44.
 */

public class SelectionSort {
    public static void main(String[] args) {
        int[] a = new int[]{3, 4, 2, 1, 6, 9};
        selectionSort(a);

    }

    /**
     * @param arr
     * @Description 简单的选择排序是不稳定的，需要经过精心设计，变有稳定。
     * 例如 自前向后遍历数据且将数据向后放置时，比较符号应为<= >=;
     * 自后向前遍历数据且将数据向后放置时，比较符号应为<
     * <p>
     * 它比冒泡排序好在减少了交换次数，是一步到位的
     */
    public static void selectionSort(int arr[]) {
        int len = arr.length;
        int minIndex = 0;
        //外循环一般统计次数
        for (int i = 0; i < len - 1; i++) {
            //小的放在后面 反人类的设计
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
            for (int j = minIndex + 1; j < len; j++) {
                if (arr[j] < arr[minIndex]) {
                   minIndex=j;
                }
            }
            int temp = arr[i];
            arr[i] = arr[minIndex];
            arr[minIndex] = temp;
        }

        System.out.println(Arrays.toString(arr));
    }
}
