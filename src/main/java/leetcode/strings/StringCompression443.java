package leetcode.strings;

import org.junit.Test;

public class StringCompression443 {

    @Test
    public void test(){
        char[] chars="abbbbbbbbbbbb".toCharArray();
        System.out.println(compress(chars));

    }
    public int compress(char[] chars) {
        int count = 1;
        int p = 1;
        for (int i = 1; i < chars.length; i++) {
            if (chars[i] == chars[i - 1]) {
                count++;
            } else {
                if(count>1){
                   for( char c:String.valueOf(count).toCharArray()) chars[p++]=c;
                }
                chars[p++]=chars[i];
                count=1;
            }
        }
        if(count>1){
            for( char c:String.valueOf(count).toCharArray()) chars[p++]=c;
        }
        System.out.println(chars);
        return p;
    }
}
