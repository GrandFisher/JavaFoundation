package offer;

//        编译器版本: Java 1.8.0_66
//请使用标准输入输出(System.in, System.out)；已禁用图形、文件、网络、系统相关的操作，
// 如java.lang.Process , javax.swing.JFrame , Runtime.getRuntime；不要自定义包名称，否则会报错，即不要添加package answer之类的语句；
// 您可以写很多个类，但是必须有一个类名为Main，并且为public属性，并且Main为唯一的public class，Main类的里面必须包含一个名字为'main'的静态方法（函数），这个方法是程序的入口
//时间限制: 3S (C/C++以外的语言为: 5 S)   内存限制: 128M (C/C++以外的语言为: 640 M)
//输入:
//输入：n个广告位，n为大于0的正整数
//输出:
//输出：z种布局方案，z为大于0的正整数
//输入范例:
//输入范例：3
//输出范例:
//输出范例：3
//编程说明 ▲

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
    static int cnt=0;
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        Queue<Integer> q = new LinkedList<>();
        int n = in.nextInt();
        q.offer(n);
        while (!q.isEmpty()) {
            int temp = q.poll();
            for (int i = 1; i <= 3; i++) {

                if (temp - i == 0){
                    cnt++;
                    continue;
                }
                if (i == 1) {
                    for (int j = 2; j <= 3; j++) {
                        if (temp - i - j > 0) {
                            q.offer(temp - i - j);
                        } else if (temp - i - j == 0) {
                            cnt++;
                            break;
                        } else {
                            break;
                        }

                    }
                }else{
                    if (temp - i > 0) q.offer(temp - i);
                }

            }

        }


        System.out.println(cnt);
    }
}
