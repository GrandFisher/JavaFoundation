package grammer;

import org.junit.Test;

import java.util.Arrays;

/**
 * @author xuan
 * @date 2019-03-28 21:25.
 */

public class TArrays {
    @Test
    public void test(){

        arrayTest();

    }
    private void arrayTest(){

       int[] a={1,2,3};
       int[] b,c;
       b=a;
       c=Arrays.copyOf(a,3);
       b[1]=4;
       c[1]=5;
       System.out.println(Arrays.toString(a));
       System.out.println(Arrays.toString(b));
       System.out.println(Arrays.toString(c));
       int[][] d={{1,2},{3,4}};
       System.out.println(Arrays.deepToString(d));
    }
}
