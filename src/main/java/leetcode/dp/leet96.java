package leetcode.dp;

/**
 * @author xuan
 * @date 2019-05-01 23:28.
 */

public class leet96 {
    public static void main(String[] args) {
        numTrees(3);
    }

    public static int numTrees(int n) {
        int[] r=new int[n+1];
        int i;
        r[0]=1;
        for(i=1;i<n+1;i++){
            for(int j=0;j<i;j++){
                r[i]=r[i]+(r[i-1-j]*r[j]);
            }
        }
        System.out.println(r[i-1]);
        return r[i-1];
    }
}
