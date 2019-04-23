package leetcode;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

/**
 * @author xuan
 * @date 2019-04-09 14:31.
 */

public class leet454 {
    public static void main(String[] args) {

    }

    public int fourSumCount(int[] A, int[] B, int[] C, int[] D) {
        int res = 0, n = A.length;
        HashMap<Integer, Integer> m = new HashMap<>();
        for (int i = 0; i < n; i++)
            for (int j = 0; j < n; j++) {
                m.put(A[i] + B[j], m.getOrDefault(A[i] + B[j], 0) + 1);
            }

        for (int i = 0; i < n; i++)
            for (int j = 0; j < n; j++) {
                res += m.getOrDefault(-C[i] - D[j], 0);
            }
        return res;
    }

}
