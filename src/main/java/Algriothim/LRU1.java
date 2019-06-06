package Algriothim;

import java.util.LinkedHashMap;
import java.util.Map;

public class LRU1 {

    private LinkedHashMap<Integer, Integer> cache;
    private int capacity;

    public LRU1(int capacity) {
        this.capacity = capacity;
        this.cache = new LinkedHashMap<Integer, Integer>(16, 0.75f, true) {
            @Override
            protected boolean removeEldestEntry(Map.Entry<Integer, Integer> eldest) {
                return cache.size() > capacity;
            }
        };
    }

    public int get(int key) {
        int value = cache.getOrDefault(key, -1);
        return value;

    }

    public void put(int key, int value) {
        cache.put(key, value);
    }
}