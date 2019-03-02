package leetcode.strings;

/**
 * @author xuan
 * @date 2019-02-27 22:14.
 */

public class ReverseWordsinaStringIII557 {
    public String reverseWords(String s) {
        StringBuilder r= new StringBuilder();
        StringBuilder rt= new StringBuilder();
        for (String s1:s.split(" ")){
            for(char c:s1.toCharArray()){
                rt.insert(0, c);
            }
            r.append(rt);
            r.append(" ");
        }
        return r.toString();
    }
}
