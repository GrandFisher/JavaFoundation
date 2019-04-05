package leetcode.strings;

import org.junit.Test;

public class AddBinary67 {
    @Test
    public void test(){
        String a;
        String b;
        a="10100000100100110110010000010101111011011001101110111111111101000000101111001110001111100001101";
        b="110101001011101110001111100110001010100001101011101010000011011011001011101111001100000011011110011";
        System.out.println(addBinary(a,b));
    }
    public String addBinary(String a, String b) {
        String r="";
        int i=a.length()-1;
        int j=b.length()-1;
        int carry=0;
        while (i>=0||j>=0){
            i--;j--;
        }
        return Long.toBinaryString(1);
    }
}
