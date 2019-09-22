package com.bianchi.structure;

public class Pair<K, V> {
    
    private final K key;
    private final V value;

    public Pair(K k, V v) {
        this.key = k;
        this.value =v;
    }

    /**
     * @return the key
     */
    public K getKey() {
        return key;
    }

    /**
     * @return the value
     */
    public V getValue() {
        return value;
    }

    public static Pair from(Object k, Object v) {
        return new Pair(k, v);
    }
} 