package leetcode.strings;

import org.junit.Test;

public class RotatedDigits788 {
    @Test
    public void Test(){
        rotatedDigits(10);
    }

    public int rotatedDigits(int N) {
        int r=0;
        for(int i=1;i<=N;i+=10){
            r+=isValid(String.valueOf(i));
        }
        return r;
    }
    public int isValid(String s){
        System.out.printf(s);
        if(s.contains("3")||s.contains("4")||s.contains("7")) return 0;
        if(s.contains("2")||s.contains("5")||s.contains("6")||s.contains("9"))
            return 1;
        return 0;

    }
}
