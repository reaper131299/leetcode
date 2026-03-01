package medium;

import java.util.*;

public class TimeBasedKeyValueStore {
    Map<String,List<Pair>> map;

    //earlier implemented using tree map. but since time stamps are in increasing order binary search will be easy on array list.
    public static void main(String args[]){
        TimeBasedKeyValueStore t = new TimeBasedKeyValueStore();
        t.set("foo","bar", 1);
        System.out.println(t.get("foo", 1));
        System.out.println(t.get("foo", 3));
        t.set("foo","bar2", 4);
        System.out.println(t.get("foo", 4));
        System.out.println(t.get("foo", 5));
    }

    public TimeBasedKeyValueStore() {
        map = new HashMap<>();
    }

    public void set(String key, String value, int timestamp) {
        Pair p = new Pair();
        p.value = value;
        p.timeStamp = timestamp;
        if(!map.containsKey(key)) {
            List<Pair> pairList = new ArrayList<>();
            pairList.add(p);
            map.put(key, pairList);
        } else
            map.get(key).add(p);

    }

    public String get(String key, int timestamp) {
        if (map.get(key) == null)
            return "";
        List<Pair> listPair = map.get(key);
        int left = 0;
        int right = listPair.size()-1;
        String value = "";
        while(left<=right){
            int mid = (left+right)/2;
            if(listPair.get(mid).timeStamp <= timestamp){
                value = listPair.get(mid).value;
                left = mid+1;
            } else if(listPair.get(mid).timeStamp>timestamp){
                right = mid-1;
            }
        }
        return value;
    }

    class Pair{
        String value;
        int timeStamp;
    }
}
