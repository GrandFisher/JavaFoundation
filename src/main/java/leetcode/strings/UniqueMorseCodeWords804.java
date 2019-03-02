package leetcode.strings;

import java.util.HashSet;
import java.util.Set;

/**
 * @author xuan
 * @date 2019-02-27 15:36.
 */

public class UniqueMorseCodeWords804 {
    public static void main(String[] args){
        String[] words={"gin", "zen", "gig", "msg"};
        System.out.println(uniqueMorseRepresentations(words));

    }
    private static int uniqueMorseRepresentations(String[] words) {
        String[] Morse = new String[]{".-","-...","-.-.","-..",".","..-.","--.",
                "....","..",".---","-.-",".-..","--","-.",
                "---",".--.","--.-",".-.","...","-","..-",
                "...-",".--","-..-","-.--","--.."};
        Set<String> diff = new HashSet();
        for(String word:words){
            StringBuilder s = new StringBuilder();
            for(char c:word.toCharArray()){
                s.append(Morse[c-'a']);

            }
            diff.add(s.toString());
        }
        return diff.size();
    }

}
