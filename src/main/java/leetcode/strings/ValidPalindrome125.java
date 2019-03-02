package leetcode.strings;

import org.junit.Test;

/**
 * @author xuan
 * @date 2019-02-27 22:50.
 */

public class ValidPalindrome125 {
    @Test
    public void test(){
        String s="A man, a plan, a canal: Panama";
        System.out.println(isPalindrome(s));
    }

    public boolean isPalindrome(String s) {

        StringBuilder r= new StringBuilder();
        for(char c:s.toCharArray()){
            if(Character.isLetterOrDigit(c)){
                r.append(c);
            }
        }
        System.out.println(r.toString());

        return r.toString().equalsIgnoreCase(new StringBuilder(r).reverse().toString());
    }

}
