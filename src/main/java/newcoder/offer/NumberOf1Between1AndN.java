package newcoder.offer;

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author xuan
 * @date 2019-06-10 16:57.
 */

public class NumberOf1Between1AndN {
    public static void main(String[] args) {
        int[] b=new int[]{1,2,3,4,5};
        int[] a=Arrays.copyOf(b,3);
        System.out.println(Arrays.toString(a));
        PriorityQueue<Integer> heap=new PriorityQueue<>((o1, o2) -> o1-o2);
        heap.add(1);
        heap.add(3);
        heap.add(2);
        ConcurrentHashMap<String,String> concurrentHashMap=new ConcurrentHashMap<>();
        StringBuilder stringBuilder=new StringBuilder();
        StringBuffer stringBuffer=new StringBuffer();
        System.out.println(heap.toString());
        System.out.println(NumberOf1Between1AndN_Solution2(55));
    }

    public static int NumberOf1Between1AndN_Solution2(int n) {
        int count = 0;
        for (int i = 1; i <= n; i *= 10) {
            int a = n / i,b = n % i;
            //之所以补8，是因为当百位为0，则a/10==(a+8)/10，
            //当百位>=2，补8会产生进位位，效果等同于(a/10+1)
            count += (a + 8) / 10 * i + ((a % 10 == 1) ? b + 1 : 0);
        }
        return count;
    }


}
