package medium;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class CarFleet {

    public static void main(String[] args) {
        CarFleet c = new CarFleet();
//        c.carFleet(12 , new int[]{10,8,0,5,3,4}, new int[]{2,4,1,1,3,1});
        c.carFleet(10, new int[]{6,8}, new int[]{3,2});
    }

    public int carFleet(int target, int[] position, int[] speed) {
        TreeMap<Integer, Float> positionToTimeMap = new TreeMap<>(Collections.reverseOrder());
        for (int i = 0; i < position.length; i++) {
            positionToTimeMap.putIfAbsent(position[i], (float)(target - position[i]) / (float)speed[i]);
        }
        float firstCarOfTheFleetTime = 0;
        int res = 0;
        for (Map.Entry<Integer, Float> entry : positionToTimeMap.entrySet()) {
            if (entry.getValue() > firstCarOfTheFleetTime) {
                res++;
                firstCarOfTheFleetTime = entry.getValue();
            }
        }
        return res;
    }

}
