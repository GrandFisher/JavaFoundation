package grammer.ListDemo;

import java.util.BitSet;

/**
 * @author xuan
 * @date 2019-05-30 19:29.
 */

public class BItSetDemo {

    public static void main(String[] args) {
        BitSet bitSet=new BitSet(1024);
        bitSet.set(10);
        bitSet.set(5);
        bitSet.flip(4);
        bitSet.flip(5,7);
        System.out.println(bitSet.size());
        System.out.println(bitSet.length());
        System.out.println(bitSet.get(0,9).toString());
    }

}
