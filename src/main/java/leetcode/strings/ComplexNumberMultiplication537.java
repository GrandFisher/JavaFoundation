package leetcode.strings;

import org.junit.Test;

public class ComplexNumberMultiplication537 {
    @Test
    public void test(){
        String a="78+-76i";
        String b="-86+72i";
        System.out.println(complexNumberMultiply(a,b));
    }
    public String complexNumberMultiply(String a, String b) {
        int pplus=a.indexOf("+");
        int pii=a.indexOf("i");
        int a1=Integer.valueOf(a.substring(0,pplus));
        String at=a.substring(pplus+1, pii);
        System.out.println(at);
        int b1=0;
        if(at.contains("-")){
            b1=-1*Integer.valueOf(at.substring(1));
        }else {
            b1=Integer.valueOf(at);
        }

        pplus=b.indexOf("+");
        pii=b.indexOf("i");
        int a2=Integer.valueOf(b.substring(0,pplus));
        String bt=b.substring(pplus+1, pii);
        int b2=0;
        if(bt.contains("-")){
            b2=-1*Integer.valueOf(bt.substring(1));
        }else {
            b2=Integer.valueOf(bt);
        }
        return (a1*a2+(-1)*(b1*b2)) + "+" + (a1*b2+a2*b1) + "i";
//        return "";b.i
    }
}
