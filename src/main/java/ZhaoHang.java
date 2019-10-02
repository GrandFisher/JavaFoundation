import java.util.*;

public class ZhaoHang {
    public static void main(String[] args) {
//        test1();
        test2();
    }

    public static void test1() {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] monsters = new int[n + 1];
        for (int i = 0; i < n + 1; i++) {
            monsters[i] = in.nextInt();

        }
        int[] kills = new int[n];
        for (int i = 0; i < n; i++) {
            kills[i] = in.nextInt();
        }

        int total = 0;
        for (int i = 0; i < n; i++) {
            int present = monsters[i];
            int next = monsters[i + 1];

            present -= kills[i];
            if (present >= 0) {
                total += kills[i];
                continue;
            } else {
                next += present;
                if (next >= 0) {
                    total += kills[i];
                    monsters[i + 1] = next;
                } else {
                    total += kills[i] + next;
                    monsters[i + 1] = 0;
                }
            }


        }
        System.out.println(total);

    }

    public static class Node {
        int key;
        int value = 0;
        long max = 0;
        List<Node> children = new LinkedList<>();

        public Node(int key) {
            this.key = key;
        }

    }

    private static HashMap<Integer, Node> nodes;

    public static void test2() {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        nodes = new HashMap<>();
        for (int i = 0; i < n - 1; i++) {
            int parent = in.nextInt();
            int child = in.nextInt();
            int value = in.nextInt();

            Node n1 = nodes.getOrDefault(parent, new Node(parent));
            Node n2 = nodes.getOrDefault(child, new Node(child));
            n2.value = value;
            n1.children.add(n2);
            nodes.put(parent, n1);
            nodes.put(child, n2);
        }
        Node start = nodes.get(1);
        start.max = dfs(start);
        bfs(start);
    }

    private static long dfs(Node node) {

        long ret = 0;
        if (node.max != 0) return node.max;
        for (Node x : node.children) {

            ret = Math.max(ret, dfs(x) + x.value);
        }
        node.max = ret;
        return ret;
    }

    private static void bfs(Node start) {
        Queue<Node> q = new LinkedList<>();
        q.offer(start);
        while (!q.isEmpty()) {
            Node node = q.poll();
            for (Node x : node.children) {
                q.offer(x);
            }
            System.out.print(node.max + " ");

        }
    }


}
