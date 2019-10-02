package offer;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class WangYi {
    public static void main(String[] args) {
//        test1();
        test2();
//        test3();
//         test4();
    }

    public static void test1() {
        Scanner in = new Scanner(System.in);
        long m = in.nextLong();
        long n = in.nextLong();
        long a = Math.max(m, n);
        long b = Math.min(m, n);

        while (a % b != 0) {
            long t = b;
            b = a % b;
            a = t;
        }
        long max = b;
        long min = n / b * m;
        System.out.println(max + " " + min);

    }

    private static int max(int a, int b) {
        if (a % b == 0) {
            return b;
        }
        int t = b;
        b = a % b;
        a = t;
        return max(a, b);
    }


    public static void test2() {
        HashMap<Integer, Integer> m = new HashMap<>();
        Scanner in = new Scanner(System.in);
        int num = in.nextInt();
        List<Integer> list = new LinkedList<>();
        while (num != 0) {
            int key = in.nextInt();
            list.add(key);
            if (m.containsKey(key)) {
                if (m.get(key) < 2) {
                    m.put(key, 2);
                } else {
                    list.remove(list.size() - 1);
                }
            } else {
                m.put(key, 1);

            }
            num--;
        }
        System.out.println(list);


    }

    static class Coin {
        int num;
        double val;

        public Coin() {

        }

        public Coin(int num, double val) {
            this.num = num;
            this.val = val;
        }
    }

    public static void test3() {
        Scanner in = new Scanner(System.in);
        int N = in.nextInt();
        int total = in.nextInt();
        in.nextLine();
        List<Coin> coins = new LinkedList<>();
        for (int i = 0; i < total; i++) {
            String line = in.nextLine();
            String params[] = line.split(",");
            int num = Integer.parseInt(params[0]);
            double val = Double.parseDouble(params[1]) * num;
            Coin c = new Coin(num, val);
            coins.add(c);
        }


        double dp[][] = new double[coins.size() + 1][N + 1];
        for (int i = 1; i <= coins.size(); i++) {
            for (int j = 1; j < N + 1; j++) {
                Coin coin = coins.get(i - 1);
                if (j < coin.num) {
                    dp[i][j] = dp[i - 1][j];
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - coin.num] + coin.val);
                }
            }
        }

        System.out.printf("%.4f", dp[coins.size()][N]);


    }

    public static void test4() {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int m = in.nextInt();
        in.nextLine();
        char[][] chars = new char[n][m];
        for (int i = 0; i < n; i++) {
            chars[i] = in.nextLine().toCharArray();
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                char s = chars[i][j];
                for (int k = i; k < n; k++) {
                    for (int l = 0; l < m; l++) {
                        if (k == i) {
                            l = j + 1;
                        }
                        if (s==chars[k][l]){

                        }
                    }
                }
            }
        }

    }


}
