package practiceForInternShip;

import java.util.HashMap;


/**
 * @author xuan
 * @date 2019-06-17 20:32.
 */

class Node {
    int key;
    int value;
    Node pre;
    Node next;
}

public class LRU {
    private HashMap<Integer, Node> cache;
    private Node head, tail;
    private int size, capacity;


    public LRU(int capacity) {
        init(capacity);
    }

    private void init(int capacity) throws IllegalArgumentException {
        if (capacity < 0) {
            throw new IllegalArgumentException();
        }
        this.capacity = capacity;
        cache = new HashMap<>(capacity);
        size = 0;

        head = new Node();
        tail = new Node();

        head.pre = null;
        head.next = tail;

        tail.pre = head;
        tail.next = null;
    }


    public Integer get(int key) {
        Node node = cache.get(key);
        if (node == null) {
            return null;
        }
        movetolast(node);
        return node.value;
    }

    public void put(int key, int value) {
        Node node = cache.get(key);
        if (node != null) {
            node.value = value;
            movetolast(node);
        } else {
            node = new Node();
            node.value = value;
            node.key = key;
            size++;
            if (size > capacity) {
                removeFirst();

            }

            insertasLast(node);
            cache.put(key, node);
        }
    }


    private void insertasLast(Node node) {

        node.pre = tail.pre;
        tail.pre.next = node;
        node.next = tail;
        tail.pre = node;

    }

    private void movetolast(Node node) {
        node.pre.next = node.next;
        node.next.pre = node.pre;
        insertasLast(node);
    }


    private void removeFirst() {
        Node node = cache.get(head.next.key);
        node.next.pre = head;
        head.next = node.next;
        cache.remove(node.key);
        size--;
    }


    @Override
    public String toString() {
        Node node = head;
        StringBuilder stringBuilder = new StringBuilder();

        while (node != null) {
            stringBuilder.append(node.key).append(" ");
            node = node.next;
        }

        return stringBuilder.toString();
    }

    public static void main(String[] args) {
        LRU lru = new LRU(3);
        lru.put(1, 1);
        lru.put(2, 2);
        lru.put(3, 3);
        System.out.println(lru.toString());
        System.out.println(lru.get(1));

        System.out.println(lru.toString());
        lru.put(4, 4);
        System.out.println(lru.toString());
    }


}
