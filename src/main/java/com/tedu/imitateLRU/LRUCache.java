package com.tedu.imitateLRU;

import java.util.HashMap;
import java.util.Map;

/**
 * 节点
 */
public class LRUCache {

    private Map<Object, LinkedNode> lruMap = new HashMap<Object, LinkedNode>();
    private int size;
    private int capacity;
    private LinkedNode head,tail;

    @Override
    public String toString() {
        return "LRUCache{" +
                "lruMap=" + lruMap +
                ", size=" + size +
                ", capacity=" + capacity +
                '}';
    }

    class LinkedNode {
        Object value;
        LinkedNode last;
        LinkedNode next;

        @Override
        public String toString() {
            return "LinkedNode{" +
                    "value=" + value +
                    '}';
        }
    }

    public LRUCache(int capacity){
        this.capacity = capacity;
        this.size = 0;
        head = new LinkedNode();
        tail = new LinkedNode();
        head.next = tail;
        tail.last = head;
    }

    public Object get(Object key){
        LinkedNode node = lruMap.get(key);
        if (node != null){
            removNode(node);
            addNode(node);
            return node.value;
        }else{
            return null;
        }
    }

    public int remove(Object key){
        LinkedNode node = lruMap.get(key);
        if (node != null){
            removNode(node);
            lruMap.remove(key);
            return 1;
        }else{
            return -1;
        }
    }

    public void put(Object key, Object val){
        LinkedNode priNode = lruMap.get(key);
        //1.更新
        if (priNode != null){
            priNode.value = val;
            removNode(priNode);
            addNode(priNode);
        }else{
            LinkedNode newNode = new LinkedNode();
            newNode.value = val;
            lruMap.put(key, newNode);
            addNode(newNode);
            if (size > capacity){
                removeLastNode();
            }
        }
    }

    /**
     * 头增加
     * @param addNode
     */
    private void addNode(LinkedNode addNode){
        addNode.next = head.next;
        addNode.last = head;
        head.next.last = addNode;
        head.next = addNode;
        size++;
    }

    /**
     * 尾减&& map移除
     */
    private void removeLastNode(){
        Object key = null;
        for (Map.Entry entry : lruMap.entrySet()){
            LinkedNode node = (LinkedNode)entry.getValue();
            if (node.next == tail) {
                key = entry.getKey();
            }
        }
        lruMap.remove(key);
//        LinkedNode lastNode = tail.last;
//        LinkedNode lastLastNode = tail.last.last;
//        lastLastNode.next = tail;
//        tail.last = lastLastNode;
//        size--;
        removNode(tail.last);
    }


    /**
     *移除
     */
    private void removNode(LinkedNode linkedNode){
        LinkedNode lastNode = linkedNode.last;
        LinkedNode nextNode = linkedNode.next;
        lastNode.next = nextNode;
        nextNode.last = lastNode;
        size--;
    }


}
