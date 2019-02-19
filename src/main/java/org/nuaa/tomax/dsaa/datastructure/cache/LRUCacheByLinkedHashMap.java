package org.nuaa.tomax.dsaa.datastructure.cache;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * @Author: ToMax
 * @Description: LRU cache (use LinkedHashMap)
 * @Date: Created in 2019/2/19 22:48
 */
public class LRUCacheByLinkedHashMap {
    /**
     * cache map
     */
    private LinkedHashMap<Integer, Integer> cache;

    public LRUCacheByLinkedHashMap(int capacity) {
        this.cache = new LinkedHashMap<Integer, Integer>(capacity * 2, (float) 0.5, true){
            @Override
            protected boolean removeEldestEntry(Map.Entry<Integer, Integer> eldest) {
                return size() > capacity;
            }
        };
    }

    /**
     * get data by key
     * @param key key
     * @return value
     */
    public int get(int key) {
        if(cache.containsKey(key)) {
            return cache.get(key);
        }

        return -1;
    }

    /**
     * put key , value to cache
     * @param key key
     * @param value value
     */
    public void put(int key, int value) {
        cache.put(key, value);
    }
}
