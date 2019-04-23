package offer;

import java.util.Arrays;
import java.util.Scanner;

public class MeiTuan {

    //小王是一个喜欢健身的人，他每天都会围着一个n*n的场地外侧跑步，他是一个有强迫症的人，每跑(n+1)个单位长度，
    // 他就要在地上做一个标记，当他在一个点重复标记的时候，他就会结束一天的锻炼，显然当n一定时，
    // 他每天打标记的数量也是一定的，请你计算出来他每天打多少个标记。(最后一次重复标记也要计数)
    //    第一行包含一个正整数t，表示询问的数量。(1<=t<10000)
    //    第二行包含t个整数，中间用空格隔开，每个整数表示一个询问所给出的n。0<=|ai|<=1000。
    //    输出应该有t行，每行仅包含一个正整数，第i行的正整数表示对与第i个询问的答案。
    // 2
    // 4 8
    // 17
    // 33
    public static void main(String[] args) {
         count();
    }

    private static void count(){
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        int[] blockNum = new int[t + 1];
        for (int i = 1; i < t + 1; i++) {
            blockNum[i] = in.nextInt();
        }

        for (int i = 1; i < t + 1; i++) {
            System.out.println(countTags(blockNum[i]));
        }
    }

    private static int countTags(int n) {

        int len = (n + 1)* 4 - 4;

        int[] block = new int[len];
        int i = 0;
        block[i]++;
        while (true) {
            i = (i + n + 1) % (len);

            block[i]++;
            if (block[i] > 1)
                break;
        }
        int sum = 0;

        for (int x : block) {
            sum += x;

        }
        return sum;
    }



        private static int cnt = 0;
        private static int[] next;

//输入第一行包含一个字符串s， (1 ≤ |s| ≤ 10^5).
//
//输入第二行包含一个字符串t， (1 ≤ |t| ≤ 10^5).
//
//保证|s|*|t|<=10^7 
//    输出仅包含一个大于等于0的整数，表示最多匹配的数量。
//ababa
//aba


    private  static void  stringse(){
        Scanner in = new Scanner(System.in);
        String S= in.nextLine();
        String T= in.nextLine();
        KMPSearch(S,T);
        System.out.println(cnt);
    }
        private static void KMPSearch(String S, String T) {
            getNextPlus(T);
            int i = 0;
            int j = 0;
            int Slen = S.length();
            int Tlen = T.length();
            while (i < Slen && j < Tlen) {
                if (j == -1 || S.charAt(i) == T.charAt(j) ||T.charAt(j)=='?'||S.charAt(i)=='?') {
                    i++;
                    j++;
                } else {
                    j = next[j];

                }
                if (j == Tlen) {
                    cnt++;
                    j=0;
                }

            }


        }

//        private static void getNext(String T) {
//            next = new int[T.length()];
//            int Tlen = T.length();
//            next[0] = -1;
//            int k = -1;
//            int j = 0;
//            while (j < Tlen - 1) {
//                if (k == -1 || T.charAt(j) == T.charAt(k)) {
//                    k++;
//                    j++;
//                    next[j] = k;
//                } else {
//                    k = next[k];
//                }
//            }
//        }
        //优化
        private static void getNextPlus(String T) {
            next = new int[T.length()];
            int Tlen = T.length();
            next[0] = -1;
            int k = -1;
            int j = 0;
            while (j < Tlen - 1) {
                if (k == -1 || T.charAt(j) == T.charAt(k)|| T.charAt(j)=='?'||T.charAt(k)=='?') {
                    k++;
                    j++;
                    if (T.charAt(j) != T.charAt(k)||T.charAt(j)!='?'||T.charAt(k)!='?') {
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
