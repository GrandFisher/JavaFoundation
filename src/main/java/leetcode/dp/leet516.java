package leetcode.dp;

import java.util.Arrays;

/**
 * @author xuan
 * @date 2019-04-26 19:09.
 */

public class leet516 {

    public static void main(String[] args) {
        System.out.println(new leet516().longestPalindromeSubseq("cbbd"));
    }

    public int longestPalindromeSubseq(String s) {
        if (s == null || s.length() == 0) return 0;
        int[][] ret = new int[s.length()][s.length()];
        int max = 0;
        for (int i = 0; i < s.length(); i++) {
            ret[i][i] = 1;
            for (int j = i - 1; j >= 0; j--) {
                if (s.charAt(i) == s.charAt(j)) {
                    ret[j][i] = ret[j + 1][i - 1] + 2;
                } else {
                    ret[j][i] = Math.max(ret[j + 1][i], ret[j][i - 1]);
                }
            }
        }
        System.out.println(Arrays.deepToString(ret));
        return ret[0][s.length() - 1];
    }
}
