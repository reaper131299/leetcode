package leetcode;
//
//import java.util.*;
//import java.util.stream.Collectors;
//
 //heapify full tree after each insertion
//public class KthLargestNumber {
//    int[] arr;
//    int k;
//    int currSize;
//    public static void main(String[] args) {
//        KthLargestNumber k = new KthLargestNumber(3, new int[]{4,5,8,2});
//
//        System.out.println(k.add(3));
//        System.out.println(k.add(5));
//        System.out.println(k.add(10));
//        System.out.println(k.add(9));
//        System.out.println(k.add(4));
//        System.out.println("exit");
//
//    }
//
//    public KthLargestNumber(int k, int[] nums) {
//        this.k = k;
//        arr = new int[k];
//        currSize = 0;
//        for (int i = 0; i <= nums.length - 1; i++) {
//            add(nums[i]);
//        }
//    }
//
//    private void heapify(int[] nums, int i) {
//        if ((i * 2) + 1 > currSize- 1 && (i * 2) + 2 > currSize - 1) return;
//        int leftIndex = (i * 2) + 1;
//        int smallest = leftIndex;
//
//        if ((i * 2) + 2 <= currSize - 1) {
//            int rightIndex = (i * 2) + 2;
//            smallest = nums[leftIndex] < nums[rightIndex] ? leftIndex : rightIndex;
//        }
//        if (nums[i] > nums[smallest]) {
//            int temp = nums[smallest];
//            nums[smallest] = nums[i];
//            nums[i] = temp;
//            heapify(nums, smallest);
//        }
//    }
//
//    public int add(int val) {
//        if (currSize < k-1) {
//            arr[currSize] = val;
//            currSize++;
//        } else if(currSize == k-1){
//            arr[currSize] = val;
//            currSize++;
//            for (int j = (currSize / 2) - 1; j >= 0; j--) {
//                heapify(arr, j);
//            }
//        }else if (val > arr[0]) {
//            arr[0] = val;
//            for (int j = (currSize / 2) - 1; j >= 0; j--) {
//                heapify(arr, j);
//            }
//        }
//        return arr[0];
//    }
//}
//

import java.util.Arrays;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.stream.Collectors;

////bruteforce using arraylist arraylsit is useless
////class KthLargest {
////    List<Integer> arr = new ArrayList<>();
////    int k;
////    public KthLargest(int k, int[] nums) {
////        this.k = k;
////        for (int i = 0; i <= nums.length - 1; i++) {
////            add(nums[i]);
////        }
////    }
////
////    private void heapify(List<Integer> nums, int i) {
////        int parentNode = i;
////        if ((parentNode * 2) + 1 > arr.size() - 1 && (parentNode * 2) + 2 > arr.size() - 1) return;
////        int leftIndex = (parentNode * 2) + 1;
////        int smallest = leftIndex;
////
////        if ((parentNode * 2) + 2 <= arr.size() - 1) {
////            int rightIndex = (parentNode * 2) + 2;
////            smallest = nums.get(leftIndex) < nums.get(rightIndex) ? leftIndex : rightIndex;
////        }
////        if (nums.get(parentNode) > nums.get(smallest)) {
////            Integer temp = nums.get(smallest);
////            nums.set(smallest, nums.get(parentNode));
////            nums.set(parentNode, temp);
////            heapify(nums, smallest);
////        }
////    }
////
////    public int add(int val) {
////        if (arr.isEmpty() || arr.size() < k) {
////            arr.add(val);
////            int n2 = arr.size();
////            for (int j = (n2 / 2) - 1; j >= 0; j--) {
////                heapify(arr, j);
////            }
////        } else if (val > arr.getFirst()) {
////            arr.set(0, val);
////            int n2 = arr.size();
////            for (int j = (n2 / 2) - 1; j >= 0; j--) {
////                heapify(arr, j);
////            }
////        }
////        return arr.getFirst();
////    }
////}

//heapify only the value that is inserted most effective
//public class KthLargest {
//
//    int k;
//    int currSize;
//    int[] arr;
//
//    public static void main(String[] args) {
//        int[] arrDummy = new int[]{5917,-7390,4070,-7571,-1336,8851,-4578,1999,143,8166,-2106,8508,-3534,1064};
//        Arrays.sort(arrDummy);
//
//        KthLargest k = new KthLargest(5, new int[]{5917,-7390,4070,-7571,-1336,8851,-4578,1999,143});
//
//        System.out.println(k.add(8166));
//        System.out.println(k.add(-2106));
//        System.out.println(k.add(8508));
//        System.out.println(k.add(-3534));
//        System.out.println(k.add(1064));
//        System.out.println("exit");
//
//    }
//
//    public KthLargest(int k, int[] nums) {
//        this.k = k;
//        currSize = 0;
//        arr = new int[k];
//        for(int i : nums){
//            add(i);
//        }
//    }
//
//    public int add(int i) {
//        if(currSize<k){
//            arr[currSize] = i;
//            currSize++;
//            heapUp(currSize);
//        } else if (arr[0]<i){
//            arr[0] = i;
//            heapDown(0);
//        }
//        return arr[0];
//    }
//
//    public void heapDown(int root) {
//        int left = root*2+1;
//        int right = root*2+2;
//        int smallest = root;
//
//        if(left<currSize && arr[smallest]>arr[left])
//            smallest = left;
//
//        if(right<currSize && arr[smallest]>arr[right])
//            smallest = right;
//
//        if(smallest != root && arr[smallest]<arr[root]){
//            int temp = arr[root];
//            arr[root] = arr[smallest];
//            arr[smallest] = temp;
//            heapDown(smallest);
//        }
//    }
//
//    private void heapUp(int currSize) {
//        if(currSize == 0) return;
//        else if(currSize >= 2) {
//            int parent = (currSize / 2) - 1;
//            if(arr[parent]>arr[currSize-1]){
//                int temp = arr[parent];
//                arr[parent] = arr[currSize-1];
//                arr[currSize-1] = temp;
//                heapUp(parent+1);
//            }
//        }
//    }
//}

    //using this que approach is slower than using heap in privous solution (heapify only the value that is inserted most effective)
class KthLargest {
    int k;
    int currSize;
    PriorityQueue<Integer> p;
    public static void main(String[] args) {
        KthLargest k = new KthLargest(4, new int[]{7, 7, 7, 7, 8, 3});

        System.out.println(k.add(2));
        System.out.println(k.add(10));
        System.out.println(k.add(9));
        System.out.println(k.add(9));
        System.out.println("exit");

    }

    public KthLargest(int k, int[] nums) {
        this.k = k;
        currSize = 0;
        p= new PriorityQueue<>();
        for(int i :nums)
            add(i);
    }

    //simple straight forward insertions
//    private int add(int i) {
//        if(currSize<=k-1) {
//            p.add(i);
//            currSize++;
//        }
//        else {
//            if(p.peek()<i) {
//                p.poll();
//                p.add(i);
//            }
//        }
//        return p.peek();
//    }
    //optiomized insertions
    public int add(int val) {
        p.add(val);
        if(p.size() > k) p.poll();

        return p.peek();
    }
}




























