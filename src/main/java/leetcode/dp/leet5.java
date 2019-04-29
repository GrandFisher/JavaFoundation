package leetcode.dp;

import java.util.Arrays;

/**
 * @author xuan
 * @date 2019-04-26 16:48.
 */

public class leet5 {

    public static void main(String[] args) {
        leet5 l = new leet5();
        String s = "bababbbb";
        System.out.println(l.longestPalindrome(s));
    }


    private int x, y;
    private int[][] ret;

    public String longestPalindrome(String s) {
        if (s == null || s.length() == 0) return s;
        ret = new int[s.length()][s.length()];
        for (int i = 0; i < s.length(); i++) {
            ret[i][i] = 1;
        }
        for (int i = 0; i < s.length() - 1; i++) {
            if (s.charAt(i) == s.charAt(i + 1)) {
                ret[i][i + 1] = 1;
                if (1 > y - x) {
                    x = i;
                    y = 1 + i;
                }
            }
        }
        find(s);
        return s.substring(x, y + 1);
    }

    private void find(String s) {
        for (int i = 2; i < s.length(); i++) {
            for (int j = 0; j < s.length() - i; j++) {
                if (ret[j + 1][j + i - 1] == 1 && s.charAt(j) == s.charAt(j + i)) {
                    ret[j][j + i] = 1;
                    if (i > y - x) {
                        x = j;
                        y = j + i;
                    }
                }
            }
        }
    }
}
