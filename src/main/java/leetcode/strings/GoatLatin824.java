package leetcode.strings;

import org.junit.Test;

public class GoatLatin824 {
    @Test
    public void test(){
        String s="I speak Goat Latin";
        System.out.println(toGoatLatin(s));
    }
    public String toGoatLatin(String S) {
        String[] strings=S.trim().split(" ");
         int i=1;
         String r = "";
        for(String string:strings){
            r =r+" "+ traverse(string,i++);
        }
        return r.substring(1);
    }
    public String traverse(String s,int nums){
        switch (s.charAt(0)){
            case 'A':
            case 'E':
            case 'I':
            case 'O':
            case 'U':
            case 'a':
            case 'e':
            case 'i':
            case 'o':
            case 'u':break;
            default: s=s.substring(1)+s.substring(0,1);

        }
        s+="ma";
        while (nums--!=0){
            s+="a";
        }
        return s;
    }

}
