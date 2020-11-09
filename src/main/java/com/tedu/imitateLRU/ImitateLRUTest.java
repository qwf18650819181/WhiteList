package com.tedu.imitateLRU;

public class ImitateLRUTest {

    public static void  main(String[] args){
        LRUCache cache = new LRUCache(3);
        cache.put(1, "qwf");
        System.out.println(cache.toString());
        cache.put(2, "qwz");
        System.out.println(cache.toString());
        cache.put(3, "qwc");
        System.out.println(cache.toString());
        cache.remove(2);
        cache.put(4, "qwh");
        cache.put(5, "qwff");
        cache.put(6, "qwzz");
        System.out.println(cache.toString());

    }
}
