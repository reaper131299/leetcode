package leetcode.medium;

public class KokoEatingBananas {

    public static void main(String args[]){
        KokoEatingBananas k = new KokoEatingBananas();
        k.minEatingSpeed(new int[]{805306368,805306368,805306368}, 1000000000);
    }

    public int minEatingSpeed(int[] piles, int h) {
        int max = 0 ;
        for(int  p : piles)
            if (p>max) max = p;

        if(piles.length == h) return max;

        int res = max;
        int left = 1;
        int right = max;
        long hours = 0;
        while(left<=right) {
            int currSpeed = left + ((right - left) / 2);
            for (int p : piles)
                hours = hours + ((p+currSpeed-1)/currSpeed);
            if(hours <= h) {
                res = Math.min(res, currSpeed);
                right = currSpeed-1;
            } else {
                left = currSpeed+1;
            }
            hours = 0;
        }
        return res;
    }
}
