package offer;

import java.util.Arrays;
import java.util.Scanner;

public class SoHu {
    public static void main(String[] args) {
//        test1();
        test2();
    }

    public static void test1() {
    }

    public static void test2() {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int m = in.nextInt();
        int[] p = new int[n];

        for (int i = 1; i < m + 1; i++) {
            int l = in.nextInt();
            int r = in.nextInt();
            Arrays.fill(p, l, r + 1, i);
        }
        int sum = 0;
        for (int i = 0; i < n; i++) {
            sum += i * p[i] % 100000009;
        }
        System.out.println(sum);

    }

    public static void test3() {
    }

}
