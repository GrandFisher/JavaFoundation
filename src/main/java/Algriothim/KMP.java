package Algriothim;

/**
 * @author xuan
 * @date 2019-04-22 23:49.
 */

public class KMP {
    private static int cnt = 0;
    private static int[] next;

    public static void main(String[] args) {
        String S = "abcabc";
        String T = "cab";
        System.out.println(KMPSearch(S,T));
    }

    private static int KMPSearch(String S, String T) {
        getNext(T);
        int i = 0;
        int j = 0;
        int Slen = S.length();
        int Tlen = T.length();
        while (i < Slen && j < Tlen) {
            if (j == -1 || S.charAt(i) == T.charAt(j)) {
                i++;
                j++;
            } else {
                j = next[j];
            }
        }
        if (j == Tlen) return i - j;
        else return -1;

    }

    private static void getNext(String T) {
        next = new int[T.length()];
        int Tlen = T.length();
        next[0] = -1;
        int k = -1;
        int j = 0;
        while (j < Tlen - 1) {
            if (k == -1 || T.charAt(j) == T.charAt(k)) {
                k++;
                j++;
                next[j] = k;
            } else {
                k = next[k];
            }
        }
    }
    //优化
    private static void getNextPlus(String T) {
        next = new int[T.length()];
        int Tlen = T.length();
        next[0] = -1;
        int k = -1;
        int j = 0;
        while (j < Tlen - 1) {
            if (k == -1 || T.charAt(j) == T.charAt(k)) {
                k++;
                j++;
                if (T.charAt(j) != T.charAt(k)) {
                    next[j] = k;
                } else {
                    next[j] = next[k];
                }
            } else {
                k = next[k];
            }
        }
    }

}