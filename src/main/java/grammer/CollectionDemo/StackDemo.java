package grammer.CollectionDemo;

import java.util.Stack;

public class StackDemo {

    public static void main(String[] args) {
        Stack<Integer> s=new Stack<>();
        s.push(0);
        s.push(1);
        s.push(2);
        s.push(3);
        System.out.println("栈的大小 "+ s.size());
        System.out.println(s.toString());

        System.out.println("----");
        System.out.println(s.search(0));
        System.out.println(s.get(0));

        System.out.println(s.search(3));
        System.out.println(s.get(3));

        System.out.println(s.contains(0));

        for(int x:s){
            System.out.println("遍历"+x);
        }

    }
}
