package leetcode.medium;

import java.util.Arrays;

public class HandOfStraights {

    public static void main(String args[]){
        HandOfStraights h = new HandOfStraights();
        h.isNStraightHand(new int[]{1,4,9,7,8,2,3,10}, 4);
    }

    public boolean isNStraightHand(int[] hand, int groupSize) {
        if(hand.length%groupSize != 0) return false;
        if(groupSize == 1) return true;

        Arrays.sort(hand);
        for(int i = 0; i< hand.length; i++){
            if(hand[i] != -1 && !findNext(hand, i, groupSize)){
                return false;
            }
        }

        return true;
    }

    public boolean findNext(int[] hand, int idx, int groupSize){
        int num = hand[idx];
        hand[idx] = -1;
        int count = 1;

        for(int i = idx; i<hand.length; i++){
            if(hand[i]>num+1) return false;
            if(hand[i] == num || hand[i] == -1) continue;

            num = hand[i];
            hand[i] = -1;
            count++;

            if(count == groupSize) return true;
        }

        return false;
    }
}
