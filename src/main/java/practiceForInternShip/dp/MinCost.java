package practiceForInternShip.dp;

public class MinCost {

    public static void main(String[] args) {
        String A = "ccbbbcba";
        String B = "cbbaacbc";
        int n = A.length();
        int m = B.length();
        int c0 = 2, c1 = 2, c2 = 6;
        int r = findMinCost(A, n, B, m, c0, c1, c2);
        System.out.println(r);
    }

    public static int findMinCost(String A, int n, String B, int m, int c0, int c1, int c2) {
        // write code here
        if (A == null || B == null) return 0;
        int dp[][] = new int[n + 1][m + 1];
        int max = 0;
        int insert = 0, del = 0, mod = 0, oldi = -1, oldj = -1;
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                if (A.charAt(i - 1) == B.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                    int lenA = i - 1 - oldi - 1;
                    int lenB = j - 1 - oldj - 1;
                    System.out.println("------");
                    System.out.println(oldi + " " + oldj);
                    System.out.println(i + " " + j);
                    System.out.println(lenA + " " + lenB);
                    System.out.println("------");
                    if (lenA > lenB) {
                        del += lenA - lenB;
                        mod += lenB;
                    } else {
                        insert += lenB - lenA;
                        mod += lenA;
                    }
                    oldi = i - 1;
                    oldj = j - 1;
                } else {
                    dp[i][j] = Math.max(dp[i][j - 1], dp[i - 1][j]);
                }
                max = Math.max(dp[i][j], max);
            }
        }
        if (c2 > c0 + c1) {
            insert += mod;
            del += mod;
            mod = 0;
        }

        if (c1 > c0 + c2) {
            insert += del;
            mod += del;
            del = 0;
        }
        if (c0 > c1 + c2) {
            del += insert;
            mod += insert;
            insert = 0;
        }
        System.out.println(insert + " " + del + " "+ mod);
        return c0 * insert + c1 * del + c2 * mod;

    }
}
