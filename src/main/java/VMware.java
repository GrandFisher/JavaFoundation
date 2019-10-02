import java.util.*;

public class VMware {
    public static void main(String[] args) {
//        test1();
//        test2();
        test3();
    }


    public static void test1() {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        double res = 0;
        for (int i = 0; i < n; i++) {
            int a = in.nextInt();
            res += 1.0 / a;
        }
        String re = String.format("%.2f", res);
        System.out.println(re);
    }

    private static List<Integer> v = new LinkedList<>();
    private static HashMap<String, Integer> visit = new HashMap<>();

    public static void test2() {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        for (int i = 0; i < n; i++) {
            v.add(in.nextInt());
        }

        System.out.println(dfs2(0, n - 1));

    }

    private static int dfs2(int start, int end) {
        if (start == end) {
            return v.get(start);
        }
        if (end - 1 == start) {
            return Math.max(v.get(start), v.get(end));
        }

        String t = start + "," + end;
        if (visit.containsKey(t)) {
            return visit.get(t);
        }
        int left = 0, right = 0;

        left = Math.min(dfs2(start + 2, end), dfs2(start + 1, end - 1));
        right = Math.min(dfs2(start, end - 2), dfs2(start + 1, end - 1));

        left += v.get(start);
        right += v.get(end);

        visit.putIfAbsent(t, Math.max(left, right));
        return Math.max(left, right);
    }

    private static List<String> res = new LinkedList<>();
    private static List<Integer> primes = new ArrayList<>(11);
    private static Stack<Integer> stack = new Stack<>();

    public static void test3() {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] prime = new int[34];
        Arrays.fill(prime, 2, 33, 1);
        for (int i = 2; i < prime.length; i++) {
            if (prime[i] != 1) {
                continue;
            }
            for (int j = i * i; j < prime.length; j += i) {
                prime[j] = 0;
            }
        }

        for (int i = 0; i < prime.length; i++) {
            if (prime[i] > 0) {
                primes.add(i);
            }
        }

        StringBuilder sb = new StringBuilder();
        sb.append(1);
        stack.push(1);
        dfs3(n, 0, sb);

        Collections.sort(res);
        for (String s : res) {
            for (char c : s.toCharArray()) {
                System.out.print(c + " ");
            }
            System.out.println();
        }

    }

    private static void dfs3(int n, int p, StringBuilder sb) {
        if (p == n - 1) {
            int end = (sb.charAt(n - 1) - '0') + (sb.charAt(0) - '0');
            if (primes.contains(end)) {
                res.add(sb.toString());
            }
            return;
        } else {
            int pre = sb.charAt(p) - '0';
            for (int i = 2; i <= n; i++) {
                if (stack.contains(i)) continue;
                if (!primes.contains(i + pre)) {
                    continue;
                } else {
                    stack.push(i);
                    sb.append(i);
                    dfs3(n, p + 1, sb);
                    stack.pop();
                    sb.deleteCharAt(sb.length() - 1);
                }
            }
        }


    }
}
