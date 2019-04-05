package leetcode.strings;

import org.junit.Test;

/**
 * @author xuan
 * @date 2019-03-05 12:30.
 */

public class DetectCapital520 {
    @Test
    public void test(){
        System.out.println(detectCapitalUse("GFFFFf"));
    }
    public boolean detectCapitalUse(String word) {
        if(!Character.isUpperCase(word.charAt(0))){
            for(char c:word.toCharArray()){
                if(Character.isUpperCase(c)) return false;
            }
        }else{
            if(word.length()>1){
                boolean flag=false;
                boolean flagu=false;
                for(char c:word.substring(1).toCharArray()){
                    System.out.println(c);
                    if(Character.isUpperCase(c))
                    {
                        flag=true;
                        if(flagu) return false;
                    }else{
                        System.out.println("如果为小");
                        System.out.println(flag);
                        flagu=true;
                        if(flag) return false;
                    }
                }
            }
        }
        return true;
    }
}
