package Algriothim;

import java.util.HashMap;

class DlinkedNode {
    int key;
    int value;
    DlinkedNode before;
    DlinkedNode after;
}


public class LRUCache {

    private HashMap<Integer, DlinkedNode> cache;
    private int capacity;
    private int size;
    private DlinkedNode head, tail;


    public LRUCache(int capacity) {
        this.capacity = capacity;
        cache = new HashMap<>(capacity);
        head = new DlinkedNode();
        tail = new DlinkedNode();
        head.before = null;
        head.after = tail;
        tail.before = head;
        tail.after = null;
        size = 0;
    }

    public int get(int key) {
        DlinkedNode node = cache.get(key);
        if (node == null) {
            return -1;
            //put key
        }
        removeNode(node);
        insertAsLast(node);
        return node.value;

    }

    public void put(int key, int value) {
        DlinkedNode node = cache.get(key);
        if (node == null) {


            node = new DlinkedNode();
            node.key = key;
            node.value = value;

            cache.put(key, node);
            insertAsLast(node);


            size++;
            if (size > capacity) {
                cache.remove(head.after.key);
                removeFirst();
                size--;
            }
        } else {
            removeNode(node);
            node.value = value;
            cache.put(key, node);
            insertAsLast(node);
        }
    }

    private void insertAsLast(DlinkedNode node) {

        node.after = tail;
        node.before = tail.before;
        tail.before.after = node;
        tail.before = node;
    }


    private void removeFirst() {
        removeNode(head.after);
    }

    private void removeNode(DlinkedNode node) {

        DlinkedNode before = node.before;
        DlinkedNode after = node.after;
        before.after = after;
        after.before = before;
    }


}
