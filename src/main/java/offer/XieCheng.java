package offer;

import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Scanner;

public class XieCheng {
    public static void main(String[] args) {

        test3();
    }

    // ac
    public static void test1() {

        Scanner in = new Scanner(System.in);
        String s = "";

        HashSet<Character> m = new HashSet<>();
        if (in.hasNext()) {//   注意，如果输入是多个测试用例，请通过while循环处理多个测试用例
            s = in.nextLine();
        }

        for (char c : s.toCharArray()) {
            if (c != ',') {
                if (!m.contains(c)) {
                    m.add(c);
                } else {
                    System.out.println(true);
                    return;
                }
            }
        }
        System.out.println(false);

    }

    //ac
    public static void test2() {


        Scanner in = new Scanner(System.in);
        String list = "";

        list = in.nextLine();
        int k = in.nextInt();
        if (list.length() <= 2) {
            System.out.println("[]");
            return;
        }

        list = list.substring(1, list.length() - 1);
        String[] s = list.split(",");
        int len = s.length;

        StringBuilder stringBuilder = new StringBuilder();

        int i = 0, j = 0;
        while (len - i >= k) {
            StringBuilder temp = new StringBuilder();
            while (j != k) {
                temp.insert(0, ",");
                temp.insert(0, s[i]);
                j++;
                i++;
            }
            j = 0;
            stringBuilder.append(temp);
        }
        for (; i < len; i++) {
            stringBuilder.append(s[i]);
            stringBuilder.append(",");
        }
        list = stringBuilder.toString();

        System.out.println("[" + list.substring(0, list.length() - 1) + "]");
    }


    public static void test3() {
        //5 /o/pp/ppp /o/pp/ppp/p /o/pp/ppp/p /o/pp/ppp /o/pp/ppp
        //1 /o/pp
        //2 /o/p /o/p
        Scanner in = new Scanner(System.in);
        int nums= in.nextInt();
        HashMap<String,Integer> map=new HashMap<>();
        String[] s=new String[nums];
        int[] cnt=new int[nums];
        for(int i=0;i<nums;i++){
            s[i]=in.next();

            if(map.keySet().contains(s[i])){
                map.put(s[i],map.get(s[i])+1);

            }else{
                map.put(s[i],1);
            }
            cnt[i]=map.get(s[i]);
        }

        for(int i=0;i<nums;i++){
            int len=s[i].split("/").length-1;
            StringBuilder temp=new StringBuilder();
            if(len<=2){
                if(len<=0){
                    temp.append("");
                }else{
                    while(len--!=0){
                        temp.append(1);
                    }
                }

            }else{
                temp.append(1);
                len=len-2;
                while (len--!=0){
                    temp.append(cnt[i]);
                }
                temp.append(1);
            }
            System.out.print(temp.toString()+" ");

        }





    }


}