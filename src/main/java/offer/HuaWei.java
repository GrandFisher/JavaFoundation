package offer;

import java.util.*;

public class HuaWei {

    public static void main(String[] args) {
//        test1();
//        test2();
//        test3();
    }

    private static Stack<Character> middle = new Stack<>();
    private static Stack<Character> large = new Stack<>();
    private static Stack<Character> quote = new Stack<>();
    private static Stack<Character> doute = new Stack<>();

    public static void test3() {
        Scanner in = new Scanner(System.in);


        while (in.hasNextLine()) {

            String line = in.nextLine().trim();
            if (line.contains("#")) break;
            for (char c : line.toCharArray()) {

                switch (c) {
                    case '{':
                        large.push(c);
                        doute.push(c);
                        break;
                    case '}':
                        if (!large.isEmpty() && large.peek() == '{')
                            large.pop();
                        else
                            large.push(c);
                        doute.push(c);
                        break;

                    case '[':
                        middle.push(c);
                        doute.push(c);
                        break;
                    case ']':
                        if (!middle.isEmpty() && middle.peek() == '[')
                            middle.pop();
                        else
                            middle.push(c);
                        doute.push(c);
                        break;
                    case '"':
                        if (!quote.isEmpty()) {
                            quote.pop();
                        } else {
                            quote.push(c);
                        }
                        break;
                    case ':':
                        doute.push(c);
                        break;
                    case ',':
                        doute.push(c);
                        break;

                }


            }
        }


    }


    private static Map<String, Integer> vars = new LinkedHashMap<>();
    private static List<String> varkey = new LinkedList<>();

    public static void test2() {
        String error = "NA";

        Scanner in = new Scanner(System.in);
        int n = Integer.valueOf(in.nextLine().trim());


        while (in.hasNextLine()) {
            n--;
            String line = in.nextLine();
            if (!check(line)) {
                System.out.println(error);
                return;
            }
            if (n <= 0) {
                break;
            }
        }
        int r = 0;
//        for (String s : vars.keySet()) {
//            r = vars.get(s);
//        }
        r = vars.get(varkey.get(varkey.size() - 1));
        System.out.println(r);
    }

    private static boolean checkVars(String v) {
        for (char c : v.toCharArray()) {
            if (!Character.isLetter(c))
                return false;

        }
        return true;
    }

    private static boolean checkNums(String v) {
        for (char c : v.toCharArray()) {
            if (!Character.isDigit(c))
                return false;

        }
        return true;
    }

    private static boolean check(String line) {
        String[] v = line.split("=");
        String temp = v[0].trim();
        if (!checkVars(temp)) {
            return false;
        }

        String add = "\\+";
        int sum = 0;
        if (v[1].contains("+")) {
            String[] variables = v[1].split(add);

            for (String variable : variables) {
                String vartemp = variable.trim();
                boolean isNum = checkNums(vartemp);
                boolean isVars = checkVars(vartemp);

                if (!isVars && !isNum) return false;
                if (isVars) {
                    if (vars.containsKey(vartemp)) {
                        sum += vars.get(vartemp);
                    } else {
                        return false;
                    }
                }
                if (isNum) {
                    sum += Integer.valueOf(vartemp);
                }
            }
        } else {
            String vartemp = v[1].trim();
            boolean isNum = checkNums(vartemp);
            boolean isVars = checkVars(vartemp);

            if (!isVars && !isNum) return false;
            if (isVars) {
                if (vars.containsKey(vartemp)) {
                    sum += vars.get(vartemp);
                } else {
                    return false;
                }
            }
            if (isNum) {
                sum += Integer.valueOf(vartemp);
            }
        }
        vars.put(temp, sum);
        varkey.add(temp);
        return true;
    }

    public static void test1() {
        Scanner in = new Scanner(System.in);
        int t1 = 4;
        int t2 = 9;
        int n = in.nextInt();
        if (n < 10) {
            if (n == 4) {
                System.out.println(1);

            } else {
                System.out.println(-1);
            }
            return;
        }
        int[] r = new int[n + 1];
        for (int i = 0; i < 11; i++) {
            r[i] = -1;
        }
        r[4] = 1;
        r[8] = 2;
        r[9] = 1;
        for (int i = 10; i < n + 1; i++) {
            r[i] = Integer.MAX_VALUE;
            if (r[i - t1] != -1) {
                r[i] = Math.min(r[i - t1] + 1, r[i]);
            }
            if (r[i - t2] != -1) {
                r[i] = Math.min(r[i - t2] + 1, r[i]);
            }

            if (r[i] == Integer.MAX_VALUE) r[i] = -1;
        }
        System.out.println(r[n]);
    }
}
