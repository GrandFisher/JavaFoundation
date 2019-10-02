package offer;

import java.util.*;

public class KuaiShou {
    public static void main(String[] args) {
//        test1();
//         test2();
//        test3();
        test4();
    }

    public static void test1() {
        Scanner in = new Scanner(System.in);
        int stus = in.nextInt();
        int ques = in.nextInt();
        in.nextLine();


        int[][] question = new int[ques][5];
        for (int i = 0; i < stus; i++) {
            String line = in.nextLine();

            int p = 0;
            for (char c : line.toCharArray()) {
                question[p][c - 'A']++;
                p++;
            }
        }

        String[] v = in.nextLine().split(" ");
        int r = 0;
        for (int i = 0; i < v.length; i++) {
            int max = 0;
            for (int x : question[i]) {
                max = Math.max(max, x);
            }
            r += Integer.valueOf(v[i]) * max;

        }
        System.out.println(r);

    }

    public static void test2() {
        Scanner in = new Scanner(System.in);
        int k = in.nextInt();
        in.nextLine();
        String line = in.nextLine();
        int l = 0, r = 0;
        int total = 0;
        int cnt = 0;


        while (r < line.length()) {
            if (line.charAt(r) == '1') {
                cnt++;
            }
            int left = 0, right = 0;
            if (cnt >= k) {
                right++;
                while (r < line.length() - 1 && line.charAt(r + 1) == '0') {
                    right++;
                    r++;
                }
            }
            while (cnt >= k) {
                left++;
                if (line.charAt(l) == '1') {
                    cnt--;
                }
                l++;
            }

            total += left * right;
            r++;
        }
        System.out.println(total);
    }


    public static class Node {
        int full;
        int parent = -1;
        List<Integer> children = new LinkedList<>();

    }

    private static HashMap<Integer, Node> nodes;

    public static void test3() {
        Scanner in = new Scanner(System.in);
        nodes = new HashMap<>();
        int num = in.nextInt();
        for (int i = 0; i < num - 1; i++) {
            int v1 = in.nextInt();
            int v2 = in.nextInt();

            if (v1 < v2) {
                v1 = v2 + v1;
                v2 = v1 - v2;
                v1 = v1 - v2;
            }

            Node child = nodes.getOrDefault(v1, new Node());
            Node parent = nodes.getOrDefault(v2, new Node());

            child.parent = v2;
            parent.children.add(v1);

            nodes.put(v1, child);
            nodes.put(v2, parent);
        }

        int actnums = in.nextInt();
        for (int i = 0; i < actnums; i++) {
            int act = in.nextInt();
            int v = in.nextInt();
            exe(act, v);
        }


    }

    private static void exe(int act, int v) {
        switch (act) {
            case 1:
                addwater(v);
                break;
            case 2:
                pullwater(v);
                break;
            case 3:
                System.out.println(nodes.get(v).full);
                break;
        }

    }

    private static void addwater(int v) {
        Node node = nodes.get(v);
        if (node.full == 1) return;
        node.full = 1;
        for (int i = 0; i < node.children.size(); i++) {
            addwater(node.children.get(i));
        }
    }

    private static void pullwater(int v) {
        Node node = nodes.get(v);
        if (node.full == 0) return;
        node.full = 0;
        if (node.parent != -1) {
            pullwater(node.parent);
        }
    }


    public static void test4() {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();

        Queue<Integer> heap = new PriorityQueue<>(Collections.reverseOrder());

        for (int i = 0; i < n; i++) {
            heap.offer(in.nextInt());
        }
        while (heap.size() > 1) {
            int a1 = heap.poll();
            int a2 = heap.poll();
            int res = Math.abs(a2 - a1);
            if (res != 0) heap.offer(res);
        }
        System.out.println(heap.poll());
    }
}
