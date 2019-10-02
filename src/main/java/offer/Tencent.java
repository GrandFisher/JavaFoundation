package offer;


import java.util.*;

public class Tencent {


    public static void main(String[] args) {
//        test1();
//        test2();
        test3();
//        test4();
//        test5();
    }


    public static void test1() {
        Scanner in = new Scanner(System.in);

        int m = in.nextInt();
        in.nextLine();

        for (int i = 0; i < m; i++) {
            int len = in.nextInt();
            in.nextLine();
            String line = in.nextLine();


            int p = line.indexOf("8");
            if (p == -1) {
                System.out.println("NO");
                continue;
            }

            line = line.substring(p);
            if (line.length() < 11) {
                System.out.println("NO");
            } else {
                System.out.println("YES");
            }

        }

    }

    public static void test2() {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        List<Integer> t = new LinkedList<>();

        for (int i = 0; i < n; i++) {
            int num = in.nextInt();
            int time = in.nextInt();
            for (int j = 0; j < num; j++) {
                t.add(time);

            }
        }
        Integer[] a = new Integer[t.size()];
        a = t.toArray(a);

        Arrays.sort(a);
        int max = 0;

        for (int i = 0; i < t.size() / 2; i++) {
            max = Math.max(max, a[i] + a[a.length - i - 1]);
        }
        System.out.println(max);
    }

    public static void test3() {
        Scanner in = new Scanner(System.in);

        int m = in.nextInt();
        in.nextLine();

        for (int i = 0; i < m; i++) {


            List<Integer> t = new LinkedList<>();
            int n = in.nextInt();
            for (int j = 0; j < n; j++) {
                int v = in.nextInt();
                t.add(v);
            }
            Integer[] a = new Integer[t.size()];
            a = t.toArray(a);

            Arrays.sort(a);

            int l = 0, r = a[a.length - 1];
            int cl = 0, cr = 1;
            int j = 0;
            for (j = a.length - 2; j >= 0; j--) {
                if (cl >= a.length / 2 || cr >= a.length / 2) {
                    break;
                }
                if (r > l) {
                    cl++;
                    l += a[j];
                } else {
                    r += a[j];
                    cr++;
                }
            }
            int min = Math.min(l, r);
            int max = Math.max(l, r);
            while (j >= 0) {
                min += a[j];
                j--;
            }

            if (max < min) {
                max = max + min;
                min = max - min;
                max = max - min;
            }
            System.out.println(min + " " + max);

        }
    }

    public static void test4() {
        Scanner in = new Scanner(System.in);

        int n = in.nextInt();
        int k = in.nextInt();


        in.nextLine();
        String line = in.nextLine();
        String[] nums = line.split(" ");

        List<Integer> l = new ArrayList<>(n);
        for (int i = 0; i < n; i++) {
            l.add(Integer.valueOf(nums[i]));
        }
        Collections.sort(l);

        int del = 0;
        int p = 0;
        while (k != 0 && p < l.size()) {
            while (p < l.size() && l.get(p) - del <= 0) {
                p++;
            }
            if (p >= l.size()) break;
            System.out.println(l.get(p) - del);
            del += (l.get(p) - del);
            k--;
        }
        while (k != 0) {
            System.out.println(0);
            k--;
        }

    }

    public static void test5() {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        in.nextLine();
        String[] a1 = in.nextLine().split(" ");
        String[] a2 = in.nextLine().split(" ");

        int r = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                r = r ^ (Integer.valueOf(a1[i]) + Integer.valueOf(a2[j]));
            }

        }
        System.out.println(r);
    }
}
