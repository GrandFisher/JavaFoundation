package offer;


import java.util.*;
public class Tencent {


    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);

        int m = in.nextInt();
        int n = in.nextInt();
        int[] minco = new int[m + 1];
        int[] coin = new int[n];
        int[][] count = new int[m + 1][n];
        int[] max = new int[n];
        int ret = 0;

        int c = 0;
        while (c < n) {//注意while处理多个case
            coin[c] = in.nextInt();
            c++;
        }


        Arrays.sort(coin);
        minco[0] = 0;
        count[0] = new int[n];
        System.out.println(Arrays.toString(count[0]));
        for (int i = 1; i < m + 1; i++) {
            for (int j = n - 1; j >= 0; j--) {
                if (i >= coin[j]) {
                    if (minco[i] == 0) {

                        minco[i] = minco[i - coin[j]] + coin[j];
                        count[i] = count[i - coin[j]].clone();
                        System.out.println("i-coinj " + (i - coin[j]) +   Arrays.toString(count[i - coin[j]]));
                        count[i][j]++;


                        System.out.println("i= " + i);
                        System.out.println(Arrays.toString(count[i]));

                    } else {
                        int temp = minco[i - coin[j]] + coin[j];
                        minco[i] = Math.min(minco[i - coin[j]] + coin[j], minco[i]);
                        if (temp < minco[j]) {
                            count[i] = count[i - coin[j]];
                            count[i][j]++;
                            minco[i] = temp;
                        }
                    }
                    if (count[i][j] > max[j]) {
                        max[j] = count[i][j];
                    }
                }
            }
        }


        System.out.println(Arrays.deepToString(count));
        System.out.println(Arrays.toString(max));

        for (int x : max) {
            ret += x;
        }
        System.out.println(ret);

    }


}
