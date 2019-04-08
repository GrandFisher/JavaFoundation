package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * @author xuan
 * @date 2019-04-06 20:19.
 */

public class leet78 {


    public static void main(String[] args) {
        int[] nums =new int[]{1,2,3};
        subsets(nums);
    }

    public static List<List<Integer>> subsets(int[] nums) {
        Integer[] numsI=new Integer[nums.length];
        for (int i=0;i<nums.length;i++){
            numsI[i]=nums[i];
        }
        List<List<Integer>> lists = new ArrayList<>();
        lists.add(new ArrayList<>(0));
        for (int i = 1; i < nums.length; i++) {
            for (int j = 0; j < nums.length; j++) {

                Integer[] temp=Arrays.copyOfRange(numsI,j,j+i);
                List<Integer> t=new ArrayList<>(Arrays.asList(temp));
                lists.add(t);
            }
        }


        System.out.println(lists.toString());
        return lists;
    }



}
