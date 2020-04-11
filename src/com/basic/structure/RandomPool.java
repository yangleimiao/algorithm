package com.basic.structure;

import java.util.HashMap;

public class RandomPool<K> {
    private HashMap<K,Integer> keyIndexMap;
    private HashMap<Integer,K> indexKeyMap;
    int size;

    public RandomPool(){
        keyIndexMap = new HashMap<>();
        indexKeyMap = new HashMap<>();
        size = 0;
    }

    public void insertKey(K key){
        if (!keyIndexMap.containsKey(key)){
            keyIndexMap.put(key,size);
            indexKeyMap.put(size++,key);
        }
    }

    // 删除后也是连续的
    public void deleteKey(K key){
        if (this.keyIndexMap.containsKey(key)) {
            int deleteIndex = this.keyIndexMap.get(key);
            int lastIndex = --this.size;
            K lastKey = this.indexKeyMap.get(lastIndex);
            this.keyIndexMap.put(lastKey, deleteIndex);
            this.indexKeyMap.put(deleteIndex, lastKey);
            this.keyIndexMap.remove(key);
            this.indexKeyMap.remove(lastIndex);
        }
    }

    public K getRandom(){
        if (size == 1) {
            return null;
        }
        int randomIndex = (int) (Math.random() * this.size);
        return indexKeyMap.get(randomIndex);
    }

    public static void main(String[] args) {
        RandomPool<String> pool = new RandomPool<String>();
        pool.insertKey("a");
        pool.insertKey("b");
        pool.insertKey("c");
        System.out.println(pool.getRandom());
        System.out.println(pool.getRandom());
        System.out.println(pool.getRandom());
        System.out.println(pool.getRandom());
    }
}
