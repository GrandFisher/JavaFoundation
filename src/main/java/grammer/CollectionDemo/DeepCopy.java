package grammer.CollectionDemo;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

class Node {
    String key;
    int i;

    public Node() {

    }

    public Node(String key, int i) {
        this.key = key;
        this.i = i;
    }

    @Override
    public String toString() {
        return key + " " + i;
    }
}

public class DeepCopy {
    public static void main(String[] args) {

        test1();
        test2();
        test3();
    }

    private static void test3() {
        ArrayList<Node> list = new ArrayList<>();
        Node node = new Node("a", 1);
        Node node1 = new Node("b", 2);
        Node node2 = new Node("c", 3);
        list.add(node);
        list.add(node1);
        list.add(node2);
        List<Node> list1 = (List<Node>) list.clone();
        List<Node> list2=list;
        System.out.println(list.toString());
        System.out.println(list1.toString());
        System.out.println(list2.toString());

        Node newNode = list1.get(1);
        newNode.i = 100;
        list2.set(0,null);

        System.out.println(list.toString());
        System.out.println(list1.toString());
        System.out.println(list2.toString());
    }


    private static void test2() {
        ArrayList<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        List<Integer> list1 = (List<Integer>) list.clone();

        System.out.println(list.toString());
        System.out.println(list1.toString());
        list1.set(1, 0);

        System.out.println(list.toString());
        System.out.println(list1.toString());
    }


    private static void test1() {
        HashMap<String, Node> map = new HashMap<>();
        Node node = new Node();
        node.key = "a";
        node.i = 0;
        map.put(node.key, node);

        System.out.println(map.toString());
        add(node);
        System.out.println(map.toString());
    }

    private static void add(Node node) {
        node.i++;
    }
}
