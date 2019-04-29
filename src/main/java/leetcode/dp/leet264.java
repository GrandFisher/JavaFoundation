package leetcode.dp;

import java.util.LinkedList;
import java.util.Queue;
import java.util.TreeSet;

/**
 * @author xuan
 * @date 2019-04-28 12:16.
 */

public class leet264 {

    public static void main(String[] args) {
        nthUglyNumber(10);
    }

    public static int nthUglyNumber(int n) {
        if (n < 0) return 0;
        int factors[] = new int[]{2, 3, 5};
        Queue<Integer> q = new LinkedList<>();
        q.offer(1);
        TreeSet<Integer> s = new TreeSet<>();
        s.add(1);
        int p = 1;
        while (p <n ) {
            int pre = q.poll();
            for (int j = 0; j < factors.length; j++) {
                int t = pre * factors[j];
                if (!s.contains(t)) {
                    s.add(t);
                    q.offer(t);
                    p++;
                }
            }
        }
        System.out.println(s.toString());
        return s.last();
    }
}
