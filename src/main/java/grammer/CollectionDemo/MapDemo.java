package grammer.CollectionDemo;

import java.util.HashMap;
import java.util.Map;

public class MapDemo {

    public static void main(String[] args) {
        Map<Integer,String> map=new HashMap<>();
        for (Map.Entry<Integer,String> m:map.entrySet()){
            System.out.println( m.getKey());
            m.getValue();
        }

    }
}
