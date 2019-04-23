package offer;
import java.util.*;


class Node {
    public Integer val;
    public List<Integer> list = new ArrayList<>();
    public boolean visit = false;

    public Node(Integer val) {
        this.val = val;
    }
}



public class Jingdong {
    public static void main(String[] args) {

         test2();
    }



    private static String[] strs;
    public static void test2() {
        Scanner in = new Scanner(System.in);
        int num = in.nextInt();
        strs = new String[num];

        in.nextLine();
        for (int i = 0; i < num; i++) {
            strs[i] = in.nextLine();
        }
        String T = in.next();
        Arrays.sort(strs, Comparator.comparingInt(String::length));


        System.out.println("start");

        int cnt = 0;
//        int prelen=T.length();
//        int nowlen;
        int start=0;
        for(int i=1;i<T.length();i++){
            for (String s:strs){
                if(s.equals(T.substring(start,i))) {
                    start = i;
                    cnt++;
                    break;
                }
            }
        }





//        for (String s : strs) {
//            nowlen=0;
//            T = T.replaceAll(s, " ");
//            for(char c:T.toCharArray()){
//                if(c!=' '){
//                    nowlen++;
//                }
//            }
//            cnt += (prelen - nowlen) / s.length();
//            prelen=nowlen;
//
//        }
        System.out.println(cnt);


    }




//    private static int temp;
//
//    private static Stack<Integer> s;

//
//    6
//2 1
//3 2
//4 3
//5 2
//6 1

    private static Map<Integer, Node> map = new HashMap<>();

    public static void test1() {
        Scanner in = new Scanner(System.in);
        int num = in.nextInt();


        while (in.hasNextInt()) {
            int n1 = in.nextInt();
            int n2 = in.nextInt();
            Node node1 = map.getOrDefault(n1, new Node(n1));
            Node node2 = map.getOrDefault(n2, new Node(n2));
            node1.list.add(n2);
            node2.list.add(n1);

            map.put(n1, node1);
            map.put(n2, node2);
        }

        int max=0;
        Node en=map.get(1);
        en.visit=true;
        map.put(map.get(1).val,en);
        List<Integer> l=map.get(1).list;
        for(int x:l){
            max=Math.max(nodes(x),max) ;
        }
        System.out.println(max);
    }

    public static int nodes(Integer node){
        int cnt=0;
        Queue<Node> q=new LinkedList<>();
        q.offer(map.get(node));
        cnt++;
        while (!q.isEmpty()){
            Node temp=q.poll();
            temp.visit=true;
            map.put(temp.val,temp);
            List<Integer> list=temp.list;
            for(int x:list  ){
                Node n=map.get(x);
                if(!n.visit){
                    q.offer(n);
                    cnt++;
                }
            }
        }
        System.out.println(cnt);
        return cnt ;
    }




}
