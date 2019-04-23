package leetcode;

import java.util.Arrays;

/**
 * @author xuan
 * @date 2019-04-07 13:57.
 */

public class leet300 {
    public static void main(String[] args) {
        int nums[] = new int[]{-2, -1};
        lengthOfLIS(nums);
    }

    public static int lengthOfLIS(int[] nums) {
        if (nums == null || nums.length < 1) return 0;
        int len = nums.length;
        int[] max = new int[nums.length];

        for (int i = len - 1; i >= 0; i--) {
            for (int j = i + 1; j < len; j++) {
                System.out.println("haha");
                if (nums[i] < nums[j]) {
                    System.out.println(max[j]);
                    max[i] = Math.max(max[j] + 1, max[i]);
                }
            }
        }

        int ret = 0;
        for (int x : max) {
            ret = Math.max(x, ret);
        }
        System.out.println(Arrays.toString(max));
        System.out.println(ret);
        return ret + 1;
    }
}
