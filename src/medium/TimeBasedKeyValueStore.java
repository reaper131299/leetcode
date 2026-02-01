package medium;

import java.util.*;

public class TimeBasedKeyValueStore {
    Map<String,TreeMap<Integer, String>> map;

    public static void main(String args[]){

    }

    public TimeBasedKeyValueStore() {
        map = new HashMap<>();
    }

    public void set(String key, String value, int timestamp) {
        if(!map.containsKey(key)) {
            TreeMap<Integer, String> m = new TreeMap<>();
            m.put(timestamp, value);
            map.put(key, m);
        } else
            map.get(key).put(timestamp, value);

    }

    public String get(String key, int timestamp) {
        if (map.get(key) == null)
            return "";
        TreeMap<Integer, String> m = map.get(key);
        if(m.get(timestamp) == null) {
            if(timestamp > m.lastEntry().getKey())
                return m.lastEntry().getValue();
            else if(timestamp < m.firstEntry().getKey())
                return "";
            else {
                int largestTimeStamp = 0;
                for(Map.Entry<Integer, String> e : m.entrySet())
                    if(e.getKey()<timestamp)
                        largestTimeStamp = e.getKey();
                    else
                        break;
                return m.get(largestTimeStamp);
            }
        }
        return m.get(timestamp);
    }
}
