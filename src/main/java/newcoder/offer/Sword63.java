package newcoder.offer;

import java.util.LinkedList;
import java.util.List;

/**
 * @author xuan
 * @date 2019-05-30 15:57.
 */

public class Sword63 {
    // mid number 求中位数

    public static void main(String[] args) {
        Sword63 c=new Sword63();
        c.Insert(5);
        c.Insert(2);
        c.Insert(3);
        c.Insert(4);
        c.outputlist();
        System.out.println(c.GetMedian());
    }

    private List<Integer> l = new LinkedList<>();

    public void Insert(Integer num) {

        if (l.size() <= 0) l.add(num);
        else {
            int p = 0;
            for (int i : l) {
                if (i > num) {
                    break;
                }
                p++;
            }
            l.add(p, num);
        }

    }

    public Double GetMedian() {
        if (l.size() == 0) return null;
        if (l.size() % 2 == 1) return Double.valueOf(l.get(l.size() / 2));
        System.out.println(l.get(l.size() - 1) / 2);
        System.out.println(l.get(l.size() / 2));
        return (double) ((l.get((l.size() - 1) / 2 )+ l.get(l.size() / 2)) / 2.0);
    }


    public void outputlist(){
        System.out.println(l.toString());
    }
}
