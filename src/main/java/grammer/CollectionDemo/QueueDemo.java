package grammer.CollectionDemo;

import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

public class QueueDemo {
    public static void main(String[] args) {
        Queue<Integer> q = new LinkedList<>();

        q.offer(1);
        System.out.println(q.size());
        System.out.println(q.peek());
        System.out.println(q.poll());
        System.out.println(q.size());


        Queue<Integer> p=new PriorityQueue<>((i1,i2)->{return i2-i1;});
        p.offer(0);
        p.offer(2);
        p.offer(3);
        p.offer(1);
        System.out.println(p.toString());
    }
}
