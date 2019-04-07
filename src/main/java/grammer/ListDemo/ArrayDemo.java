package grammer.ListDemo;

import java.util.ArrayList;

public class ArrayDemo {






    public static void main(String[] args) {
        ArrayList<Integer> a = new ArrayList<>(100);
        a.add(1);
        a.add(2);
        a.add(3);
        System.out.println(a.toString());


        Integer in=2;
        a.remove(in);
        System.out.println(a.toString());


        a.add(1,2);
        System.out.println(a.toString());
        System.out.println("坐标"+a.indexOf(in));

        a.remove(2);
        System.out.println(a.toString());

        a.set(1,4);
        System.out.println(a.toString());

        System.out.println(a.clone());

        System.out.println(a.contains(1));

        for (int i = 0; i < a.size(); i++) {
            System.out.println(a.get(i));
        }

    }
}
