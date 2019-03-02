package leetcode.strings;

import org.junit.Test;

/**
 * @author xuan
 * @date 2019-02-28 14:52.
 */

public class BuddyStrings859 {
    @Test
    public void test(){
       String A="ab";
        String B="ba";
        System.out.println(buddyStrings(A,B));
    }
    public boolean buddyStrings(String A, String B) {
        int first=-1;
        int last=-1;
        int third=-1;
        if(A.length()!=B.length()||A.equals(B)) return false;
        for(int i=0;i<A.length();i++){
            if(A.charAt(i)!=B.charAt(i)){
                third=last;
                last=first;
                first=i;
            }
        }
        if(first==-1||last==-1||third!=-1) return false;
        System.out.println(first+ " "+last);
        System.out.println((last==0?"":B.substring(0,last)));
        System.out.println((last==first-1?"":B.substring(last+1,first)));
        System.out.println(B.substring(first+1));
        B= B.substring(0,last)
                +B.charAt(first)
                +B.substring(last+1,first)
                +B.charAt(last)
                + B.substring(first+1);
//                + ((first==(B.length()-1))?"":B.substring(first+1));
        System.out.println(B);
        if(A.equals(B)) {
            return true;
        }else{
            return false;
        }
    }
}
