package offer;

import java.util.*;

public class Alibaba {


    public static void main(String[] args) {

    }


    public void test1() {
        Scanner in = new Scanner(System.in);
        int n = 0;
        int m = 0;
        while (in.hasNextLine()) {
            n = in.nextInt();
            m = in.nextInt();
            for (int i = 0; i < n; i++) {

            }


        }

    }

//A,F
//A,NULL
//B,A
//D,B
//F,B
//E,A
//F,E
//E,D
//D,B
//C,B
//B,G
//G,F
//C,F

    class Node {
        public Character val;
        public List<Character> list;

        public Node(char val) {
            val = this.val;
            list = new ArrayList<>();
        }

    }

    private Map<Character, Node> map = new HashMap<>();

    public void test2() {
        char start;
        char end;
        String temp;
        Scanner in = new Scanner(System.in);
        if (in.hasNextLine()) {
            temp = in.nextLine();
            start = temp.charAt(0);
            end = temp.charAt(2);
        }

        while (in.hasNextLine()) {
            temp = in.nextLine();
            char tn = temp.charAt(0);
            // ts 是爸爸
            Character ts;
            if (temp.length() > 3) {
                ts = null;
            } else {
                ts = temp.charAt(2);
            }

            if (!map.containsKey(tn)) {
                map.put(tn, new Node(tn));
            }

            if (ts != null) {
                Node node = map.getOrDefault(ts, new Node(ts));
                node.list.add(tn);
                map.put(ts, node);
            }
        }
    }

    public void findpath(char start, char end) {
        int cnt = -1;
        int floor = 1;
        int t = 0;

        Queue<Node> q = new LinkedList<>();
        q.offer(map.get(start));

        while (!q.isEmpty()) {
            Node node = q.poll();
            if (node.val == end) {

                System.out.println(cnt);
                return;
            }

            List<Character> list = node.list;
            t += list.size();
            floor--;
            if (floor == 0) {
                cnt++;
                floor = t;
                t = 0;
            }
            for (char c : list) {
                q.offer(map.get(c));
            }

        }
    }

}