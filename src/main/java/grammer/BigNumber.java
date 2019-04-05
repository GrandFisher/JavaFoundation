package grammer;

import org.junit.Test;

import java.math.BigDecimal;
import java.math.BigInteger;

/**
 * @author xuan
 * @date 2019-03-28 21:13.
 */

public class BigNumber {
    @Test
    public void test(){
        bigNum();
    }
    private void bigNum(){
        BigInteger bigInteger=BigInteger.valueOf(100);
        BigInteger bigInteger1=BigInteger.valueOf(144);
        System.out.println(bigInteger1.add(bigInteger));
    }
}
