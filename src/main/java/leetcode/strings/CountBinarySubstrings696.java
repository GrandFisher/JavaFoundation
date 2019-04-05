package leetcode.strings;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class CountBinarySubstrings696 {
    @Test
    public void test(){
        countBinarySubstrings("00110");
    }
    public int countBinarySubstrings(String s) {
        List<Integer> integerList=new ArrayList<Integer>();
        char[] chars=s.toCharArray();
        int r=0;
        integerList.add(1);
        for(int i=1;i<chars.length;i++)
        {
            if(chars[i]==chars[i-1]){
                integerList.set(integerList.size()-1, integerList.get(integerList.size()-1)+1);
            }else {
                integerList.add(1);
            }
        }
        for(int i=1;i<integerList.size();i++){
            if(integerList.get(i)>integerList.get(i-1)){
                r+=integerList.get(i-1);
            }else {
                r+=integerList.get(i);
            }

        }
        System.out.println(r);;
        return r;
    }
}
