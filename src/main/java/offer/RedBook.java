package offer;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Scanner;

public class RedBook {
    public static void main(String[] args) {
        test1();
//        test2();
//        test3();
//        test4();
    }

    public static void test1() {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[][] a = new int[n][n];
        boolean[][] b = new boolean[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                a[i][j] = in.nextInt();
            }
        }
        ArrayList<HashSet<Integer>> r = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            boolean flag = false;
            for (int j = 0; j < r.size(); j++) {
                HashSet<Integer> t = r.get(j);
                if (t.contains(i)) {
                    flag = true;
                    for (int k = i; k < n; k++) {
                        if (a[i][k] == 1) {
                            t.add(k);
                        }
                    }
                }
            }
            if (flag) continue;
            HashSet<Integer> ne = new HashSet<>();
            ne.add(i);
            for (int k = i; k < n; k++) {
                if (a[i][k] == 1) {
                    ne.add(k);
                }
            }
            r.add(ne);
        }
        System.out.println(r.size());
    }


    public static void test2() {
        Scanner in = new Scanner(System.in);
        String line = in.nextLine();
        int isQueto = 0;
        StringBuilder sb = new StringBuilder();
        for (char c : line.toCharArray()) {
            switch (c) {
                case '(':
                    isQueto++;
                    break;
                case ')':
                    isQueto--;
                    break;
                case '<':
                    if (!(sb.length() == 0) && isQueto == 0) {
                        sb.delete(sb.length() - 1, sb.length());

                    }

                    break;
                default:
                    if (isQueto == 0) {
                        sb.append(c);

                    }

            }
        }

        System.out.println(sb.toString());

    }


    public static void test3() {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] c = new int[n + 1];
        for (int i = 1; i < n + 1; i++) {
            c[i] = in.nextInt();
        }


        StringBuilder sb = new StringBuilder();

        if (n == 1) {
            System.out.println(c[n] + " " + 1);
            return;
        }
        int max = 0;
        if (n == 2) {
            max = Math.max(c[1], c[2]);
            System.out.println(max + " " + 1);
            return;
        }

        int[] v = new int[n + 1];
        int[] num = new int[n + 1];
        num[1] = 1;
        num[2] = 1;
        v[1] = c[1];
        v[2] = c[2];
        for (int i = 3; i < n + 1; i++) {
            if (v[i - 2] == v[i - 3]) {
                v[i] = v[i - 2] + c[i];
                num[i] = Math.min(num[i - 2], num[i - 3]) + 1;
            } else if (v[i - 2] > v[i - 3]) {
                v[i] = v[i - 2] + c[i];
                num[i] = num[i - 2] + 1;
            } else {
                v[i] = v[i - 3] + c[i];
                num[i] = num[i - 3] + 1;
            }

        }

        int p = 0;
        for (int i = 0; i < n + 1; i++) {
            if (v[p] < v[i]) {
                p = i;
            } else if (v[p] == v[i]) {
                if (num[p] > num[i]) {
                    p = i;
                }
            }

        }
        System.out.println(v[p] + " " + num[p]);

    }

    public static void test4() {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[][] m = new int[n + 1][n + 1];
        for (int i = 0; i < n; i++) {
            int x = in.nextInt();
            int y = in.nextInt();
            m[x][y] = 1;
        }
//        int[][] c = new int[n + 1][n + 1];
        for (int i = 1; i < n + 1; i++) {
            m[1][i] = 1;
            m[i][1] = 1;
        }

        for (int i = 2; i < n + 1; i++) {
            for (int j = 2; j < n + 1; j++) {
                m[i][j] = Math.max(m[i - 1][j], m[i][j - 1]) + m[i][j];
            }
        }
        System.out.println(m[n][n]);

    }
}
