package leetcode.easy;

public class CountingBits {

//    public int[] countBits(int n) {
//        int[] arr = new int[n+1];
//        for(int i = 0; i< arr.length; i++) {
//            arr[i] = hammingWeight(i);
//        }
//        return arr;
//    }
//
//    public int hammingWeight(int n) {
//        int count = 0;
//        while (n>0) {
//            if(n%2 == 1) count++;
//            n = n>>1;
//        }
//        return count;
//    }

    public int[] countBits(int n) {
        int[] arr = new int[n+1];
        int offfset = 1;

        for(int i =1; i<=n; i++){
            if( offfset * 2 == i) offfset = i;
            arr[i] = 1 + arr[i-offfset];
        }

        return arr;
    }
}
