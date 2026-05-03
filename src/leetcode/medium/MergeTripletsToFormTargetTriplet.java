package leetcode.medium;

public class MergeTripletsToFormTargetTriplet {

    public static void main(String[] args){
        MergeTripletsToFormTargetTriplet m = new MergeTripletsToFormTargetTriplet();
        m.mergeTriplets(new int[][]{
                {2,5,3},
                {1,8,4},
                {1,7,5}
        }, new int[]{2,7,5});
    }

    public boolean mergeTriplets(int[][] triplets, int[] target) {
        boolean[] arr = new boolean[3];
        for(int i = 0 ; i<3; i++) {
            int num = target[i];

            for(int[] t: triplets) {
                if(t[i] == num) {
                    if(i == 0 && t[1] <= target[1] && t[2] <= target[2]) {
                        arr[i] = true;
                        break;
                    } else if (i == 1 && t[0] <= target[0] && t[2] <= target[2]) {
                        arr[i] = true;
                        break;
                    } else if (i == 2  && t[0] <= target[0] && t[1] <= target[1]) {
                        arr[i] = true;
                        break;
                    }
                }
            }
        }

        return arr[0] && arr[1] && arr[2];
    }
}
