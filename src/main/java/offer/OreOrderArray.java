package offer;

import org.junit.Test;

import java.util.Arrays;
import java.util.Stack;

/**
 * @author xuan
 * @date 2019-03-31 13:27.
 */

public class OreOrderArray {
    @Test
    public void test(){
        int []a ={1,2,3,4};
        reOrderArray(a);
    }
    public void reOrderArray(int [] array) {
        if(array.length<=1) return ;
        int [] t=new int[array.length];
        int p=0;
        for(int i=0;i<array.length;i++){
            if(array[i]%2==1){
                t[p++]=array[i];
            }
        }
        for(int i=0;i<array.length;i++){
            if(array[i]%2==0){
                t[p++]=array[i];
            }
        }
//        array=t;
        array = Arrays.copyOf(t,t.length);
        System.out.println(Arrays.toString(array));

    }
}
