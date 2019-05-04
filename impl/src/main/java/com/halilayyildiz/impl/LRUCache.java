package com.halilayyildiz.impl;

import java.util.HashMap;
import java.util.Map;

class LRUCache {
    
    class Node{
        int key;
        int val;
        Node next;
        Node prev;
        
        Node(int key, int val){
            this.key = key;
            this.val = val;
        }
    }

    Map<Integer, Node> cache = new HashMap<>();
    Node head, last;
    int cacheLen;
    
    public LRUCache(int capacity) {
        this.cacheLen = capacity;
        head = new Node(-1,-1);
        last = new Node(-1,-1);
        head.next = last;
        last.prev = head;
    }
    
    public int get(int key) {
        Node node = cache.get(key);
        if(node == null)
            return -1;
        
        moveToHead(node);
        
        return node.val;
    }
    
    public void put(int key, int value) {
        
        Node node = cache.get(key);
        
        if(node == null){
            node = new Node(key, value);
            cache.put(key, node);
            addNode(node);
            
            if(cache.keySet().size() > cacheLen){
                cache.remove(last.prev.key);
                removeNode(last.prev);
            }

        }else{
            node.val = value;
            moveToHead(node);
        }
        
    }
    
    private void addNode(Node node){
        node.prev = head;
        node.next = head.next;

        head.next.prev = node;
        head.next = node;
    }
    
    private void removeNode(Node node){        
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }
    
    private void moveToHead(Node node){
        removeNode(node);
        addNode(node);
    }
}
