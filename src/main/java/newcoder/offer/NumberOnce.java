package newcoder.offer;

import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedHashMap;

/**
 * @author xuan
 * @date 2019-06-01 16:09.
 */

public class NumberOnce {

    //数组中只出现一次的数字

    public static void main(String[] args) {
        int x=0b100;
        System.out.println(x<<1);
        System.out.println(x>>1);
        System.out.println(1>>x);
        System.out.println(1<<x);

        LinkedHashMap<Character,Integer> l=new LinkedHashMap<>();

        HashMap<Character,Integer> m=new HashMap<>();

//        StringBuilder s=new StringBuilder();


        System.out.println(ReverseSentence(" "));

    }
    public static String ReverseSentence(String str) {
        if(str==null ||str.length()<=1) return str;
        String [] ss=str.trim().split(" ");
        System.out.println(Arrays.toString(ss));
        if(ss.length<=0){
            return str;
        }
        StringBuilder r=new StringBuilder();
        for(String x:ss){
            StringBuilder s=new StringBuilder(x);
            s.reverse();
            r.append(" ");
            r.append(s);
        }
        r.reverse();

        return r.toString().trim();
    }
}
