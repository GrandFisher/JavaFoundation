package offer;

import java.util.Scanner;

public class Pinduoduo {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int m = in.nextInt();
        int k = in.nextInt();
        //int[][] a=new int[n+1][m+1];
        int max = m, min = n;
        if (n > m) {
            max = n;
            min = m;
        }
        m = max;
        n = min;
        int lines = 2 * n - 1;
        int i = 1;
        int l = n - 1;
        int count = 0;
        for (; i <= lines; i++) {
            if (i < n) {
                if (k <= i) {
                    count = i;
                    break;
                }
                k -= i;
            } else if (i > lines - l) {
                if (k <= i) {
                    count = n;
                    break;
                }
                k -= n;
            } else {
                if (k <= lines - i + 1) {
                    count = lines - i + 1;
                    break;
                }
                k -= (lines - i + 1);
            }
        }

        int sum = i + 1;
        int r[] = new int[count];
        count = 0;
        for (int j = 1; j < sum; j++, count++) {
            r[count] = j * (sum - j);
        }


        System.out.println(r[k]);
    }

    public static void test1(String[] args) {
        Scanner in = new Scanner(System.in);
        String line = in.nextLine();
        String[] a = line.split(";");
        int n = Integer.valueOf(a[1]);

        String[] numbers = a[0].split(",");

        int[] r = new int[numbers.length];
        for (int i = 0; i < r.length; i++) {
            r[i] = Integer.valueOf(numbers[i]);
        }

        int even = 0, odd = r.length - 1;
        while (even < odd) {
            while (r[even] % 2 == 0) {
                even++;
            }
            while (r[odd] % 2 == 1) {
                odd--;
            }
            if (even < odd)
                swap(r, even, odd);
        }

        sort(r, 0, odd);
        sort(r, even, r.length - 1);


        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < n; i++) {
            sb.append(r[i]);
            sb.append(",");
        }
        sb.deleteCharAt(sb.length() - 1);
        System.out.println(sb.toString());
    }

    private static void sort(int[] num, int start, int end) {
        if (start >= end) {
            return;
        }
        int p = partition(num, start, end);
        sort(num, start, p - 1);
        sort(num, p + 1, end);

    }

    private static int partition(int[] num, int start, int end) {
        int temp = num[start];
        int p = start;
        for (int i = start + 1; i <= end; i++) {
            if (num[i] > temp) {
                p++;
                swap(num, p, i);
            }

        }
        swap(num, p, start);
        return p;

    }

    private static void swap(int[] num, int i, int j) {
        int t = num[i];
        num[i] = num[j];
        num[j] = t;
    }
}
