package leetcode.medium;

import java.util.*;

public class CarFleet {

    public static void main(String[] args) {
        CarFleet c = new CarFleet();
        System.out.println(c.carFleet(12 , new int[]{10,8,0,5,3,4}, new int[]{2,4,1,1,3,1}));
        System.out.println(c.carFleet(10, new int[]{6, 8}, new int[]{3, 2}));
        System.out.println(c.carFleet(10, new int[]{6, 8}, new int[]{3, 2}));
    }

//    public int carFleet(int target, int[] position, int[] speed) {
//        TreeMap<Integer, Float> positionToTimeMap = new TreeMap<>(Collections.reverseOrder());
//        for (int i = 0; i < position.length; i++) {
//            positionToTimeMap.putIfAbsent(position[i], (float)(target - position[i]) / (float)speed[i]);
//        }
//        float firstCarOfTheFleetTime = 0;
//        int res = 0;
//        for (Map.Entry<Integer, Float> entry : positionToTimeMap.entrySet()) {
//            if (entry.getValue() > firstCarOfTheFleetTime) {
//                res++;
//                firstCarOfTheFleetTime = entry.getValue();
//            }
//        }
//        return res;
//    }

    public int carFleet(int target, int[] position, int[] speed) {
        if(position.length <=1) return position.length;

        float[][] positionTimetoReachArray = new float[position.length][2];
        for(int i = 0;i< position.length;i++){
            positionTimetoReachArray[i] = new float[]{position[i], (float)(target-position[i]*1.0)/speed[i]};
        }
        Arrays.sort(positionTimetoReachArray, (a, b)-> (int) (b[0]-a[0]));

        int fleetCounter = 1;
        float firstCarOfTheFleetTime = positionTimetoReachArray[0][1];
        for (int i = 1; i<positionTimetoReachArray.length;i++){
            if(positionTimetoReachArray[i][1] > firstCarOfTheFleetTime) {
                fleetCounter++;
                firstCarOfTheFleetTime = positionTimetoReachArray[i][1];
            }
        }
        return fleetCounter;
    }
}
