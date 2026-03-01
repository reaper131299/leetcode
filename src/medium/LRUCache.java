package medium;

import java.util.HashMap;
import java.util.LinkedList;

public class LRUCache {
    int capacity;
    int currCapacity;
    HashMap<Integer, CacheNode> cache = new HashMap<>();
    CacheNode head;
    CacheNode tail;

    public static void main(String args[]) {
        LRUCache l = new LRUCache(10);
        l.put(10,13);
        l.put(3,17);
        l.put(6,11);
        l.put(10,5);
        l.put(9,10);
        l.get(13);
        l.put(2,19);
        l.get(2);
        l.get(3);
        l.put(5,25);
        l.get(8);
        l.put(9,22);
        l.put(5,5);
        l.put(1,30);
        l.get(11);
        l.put(9,12);
        l.get(7);
        l.get(5);
        l.get(8);
        l.get(9);
        l.put(4,30);
        l.put(9,3);
        l.get(9);
        l.get(10);
        l.get(10);
    }

    public LRUCache(int capacity) {
        this.capacity = capacity;
        this.currCapacity = 0;
    }

    public int get(int key) {
        //get value from cache
        CacheNode c = cache.get(key);

        //is key does not exist return -1
        if(c == null) return -1;

        //if c is tail that means c is recently accessed and the position will remain the same that is tail
        if(c == tail) return c.value;

        //else if c is head remove the first element from list
        else if(c == head) removeFirst();

        //else remove middle
        else removeMiddle(c);

        //add the node to last(c is recently accessed)
        addLast(c);
        return c.value;
    }

    public void put(int key, int value) {
        CacheNode c = new CacheNode();
        c.key = key;
        c.value = value;
        //if currCapacity is less than max cache capacity then do not remove the least recent element just add new element
        if(currCapacity<capacity){
            //if currCapacity is 0 then initiate the list and all the pointers.
            if(currCapacity == 0){
                c.next = c;
                c.prev = c;
                head = c;
                tail = c;
            } else {
                CacheNode cr = cache.get(key);
                //check if key already exist if yes update same key
                if(cr!=null){
                    c = cr;
                    if (updateValueAndPos(value, c)) return;
                    currCapacity--;
                }
                //else add the key to last
                else {
                    addLast(c);
                }
            }
            currCapacity++;
        }
        //else if currCapacity>= capacity remove the ;east recent element adn add the new one
        else {
            CacheNode cr = cache.get(key);
            //check if key already exist if yes update same key
            if(cr!=null){
                c = cr;
                if (updateValueAndPos(value, c)) return;
            }
            //else add the key to last
            else {
                addLast(c);
                cache.remove(head.key);
                head = head.next;
                head.prev = tail;
                tail.next = head;
            }
        }
        //update the cache
        cache.put(key, c);
    }

    private boolean updateValueAndPos(int value, CacheNode c) {
        c.value = value;

        //if c is tail that means c is recently accessed and the position will remain the same that is tail
        if(c == tail) return true;

        //else if c is head remove the first element from list
        else if(c == head) removeFirst();

        //else remove middle
        else removeMiddle(c);

        //add the node to last(c is recently accessed)
        addLast(c);
        return false;
    }

    static class CacheNode{
        int key;
        int value;
        CacheNode next;
        CacheNode prev;
    }

    private CacheNode removeFirst(){
        CacheNode c = head;
        head = head.next;
        head.prev = tail;
        tail.next = head;
        return c;
    }

    private CacheNode removeMiddle(CacheNode c){
        c.prev.next = c.next;
        c.next.prev = c.prev;
        return c;
    }

    private CacheNode addLast(CacheNode c){
        c.prev = tail;
        c.next = head;
        tail.next = c;
        tail = c;
        head.prev = tail;
        return c;
    }
}
