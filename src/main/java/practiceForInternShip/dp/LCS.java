package practiceForInternShip.dp;

/**
 * @author xuan
 * @date 2019-06-19 19:28.
 */

public class LCS {

    public static void main(String[] args) {

    }

    public static int longestCommonSubstring(String A, String B) {
        if (A == null || B == null || A.length() == 0 || B.length() == 0) return 0;
        int[][] m = new int[A.length() + 1][B.length() + 1];
        int max = 0;
        for (int i = 1; i < A.length() + 1; i++) {
            for (int j = 1; j < A.length() + 1; j++) {
                if (A.charAt(i - 1) == B.charAt(j - 1)) {
                    m[i][j] = m[i - 1][j - 1] + 1;
                }
                if (m[i][j] > max) {
                    max = m[i][j];
                }
            }
        }
        return max;
    }

    public static int longestCommonSubsequence(String A, String B) {
        if (A == null || B == null || A.length() == 0 || B.length() == 0) return 0;
        int[][] m = new int[A.length() + 1][B.length() + 1];
        int max = 0;
        for (int i = 1; i < A.length() + 1; i++) {
            for (int j = 1; j < A.length() + 1; j++) {
                if (A.charAt(i - 1) == B.charAt(j - 1)) {
                    m[i][j] = m[i - 1][j - 1] + 1;
                } else {
                    m[i][j] = m[i - 1][j] + m[i][j - 1];
                }
                if (m[i][j] > max) {
                    max = m[i][j];
                }
            }
        }
        return max;
    }


}
