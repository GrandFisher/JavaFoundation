package offer;

import java.util.*;

public class test1 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int len=in.nextInt();
        String str=in.next();
        Stack<Character> s=new Stack<>();

        for(char c:str.toCharArray()){

            if(s.empty()||s.peek()!=c){
                s.push(c);
            }else {
                s.pop();
            }
        }

        System.out.println(s.size());
    }
}
