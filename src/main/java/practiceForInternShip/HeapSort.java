package practiceForInternShip;

import java.util.Arrays;

/**
 * @author xuan
 * @date 2019-06-18 11:43.
 */

public class HeapSort {


    public static void main(String[] args) {
        int[] a=new int[]{8,2,3,1,5,6,9};
        sort(a);
        System.out.println(Arrays.toString(a));
    }

    private static void sort(int arr[]){
        heapFy(arr);
        int len=arr.length-1;
        for (int i = len; i > 0 ; i--) {
            swap(arr,0,i);
            shiftDown(arr,0,i);
        }


    }

    private static void heapFy(int[] arr){
        for (int i = arr.length/2-1; i >= 0; i--) {
            shiftDown(arr,i,arr.length);
        }
    }



    private static void shiftDown(int[] arr,int i,int length) {
        int l = 2 * i + 1;
        int r = 2 * i + 2;
        int p = i;

        if (l < length && arr[l] > arr[p]) {
            p = l;
        }
        if (r < length && arr[r] > arr[p]) {
            p = r;
        }
        if(p!=i){
            swap(arr,i,p);
            shiftDown(arr,p,length);
        }

    }

    private static void swap(int[] arr,int i,int j) {
        int t = arr[i];
        arr[i] = arr[j];
        arr[j] = t;
    }


    private static void shiftUp(int[] arr,int i) {
        while (i > 0) {
            if (arr[i] > arr[(i - 1) / 2]) {
                swap(arr, i, (i - 1) / 2);
                i = (i - 1) / 2;
            } else {
                break;
            }
        }
    }

}
