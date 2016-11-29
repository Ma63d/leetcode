# -*- coding:utf-8 -*-


# Design and implement a data structure for Least Recently Used (LRU) cache. It should support the following operations: get and set.
#
#
#
# get(key) - Get the value (will always be positive) of the key if the key exists in the cache, otherwise return -1.
# set(key, value) - Set or insert the value if the key is not already present. When the cache reached its capacity, it should invalidate the least recently used item before inserting a new item.


public class LRUCache {
    public class Node{
        Node prev;
        Node next;
        int value;
        int key;
        Node(Node p,Node n,int v,int k){
            prev = p;
            next = n;
            value = v;
            key = k;
        }
    }
    Map<Integer,Node> map;
    Node tail,front;
    int cap;
    int current;
    public LRUCache(int capacity) {
        map = new HashMap<>();
        tail = new Node(null,null,0,0);
        front = new Node(null,null,0,0);
        front.next = tail;
        tail.prev = front;
        cap = capacity;
        current = 0;
    }
    
    public int get(int key) {
        Node result = map.get(key);
        if(result == null){
            return -1;
        }else{
            result.prev.next = result.next;
            result.next.prev = result.prev;
            result.next = front.next;
            result.next.prev = result;
            front.next = result;
            result.prev = front;
            return result.value;
        }
    }
    
    public void set(int key, int value) {
        Node result = map.get(key);
        if(result == null){
            result = new Node(null,null,value,key);
            if(current == cap){
                map.remove(tail.prev.key);
                tail.prev.prev.next = tail;
                tail.prev = tail.prev.prev;
            }else{
                current++;
            }
            map.put(key,result);
        }else{
            result.value = value;
            result.prev.next = result.next;
            result.next.prev = result.prev;
        }
        result.next = front.next;
        result.next.prev = result;
        front.next = result;
        result.prev = front;
    }
}
