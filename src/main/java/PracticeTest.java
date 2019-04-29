/**
 * @author xuan
 * @date 2019-04-25 10:24.
 */

public class PracticeTest {

    public static void main(String[] args) {
        int i = 0, j = 0;
        for (i = 1; i < 31; i++) {
            j = 60 - i;
            if (count(i, j) == 84) {
                System.out.println(i);
                System.out.println(j);
                break;
            }
        }
    }

    private static int count(int i, int j) {
        int maxComDivisor = gcd(i, j);
        return i * j / maxComDivisor + maxComDivisor;
    }

    private static int gcd(int i, int j) {
        if (i < j) {
            i = i + j;
            j = i - j;
            i = i - j;
        }
        while (i % j != 0) {
            int temp = i % j;
            i = j;
            j = temp;
        }
        return j;
    }


}
