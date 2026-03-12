package leetcode.medium;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Map;
import java.util.PriorityQueue;

public class KClosestPointsToOrigin {

    public static void main(String args[]){

        KClosestPointsToOrigin k = new KClosestPointsToOrigin();
        int[][] points = {{1,3},{-2,2}};
        k.kClosest(points, 1);

    }

//    public int[][] kClosest(int[][] points, int k) {
//        ArrayList<Point> arr = new ArrayList<>();
//        for (int i = 0; i<points.length;i++){
//            Point p = new Point();
//            p.x = points[i][0];
//            p.y = points[i][1];
//            p.dist = Math.sqrt((double) p.x*p.x + p.y*p.y);
//            arr.add(p);
//        }
//
//        arr.sort(Comparator.comparingDouble(p -> p.dist));
//
//        int[][] res = new int[k][2];
//        for(int i = 0; i<k;i++){
//            res[i][0] = arr.get(i).x;
//            res[i][1] = arr.get(i).y;
//        }
//
//        return res;
//    }

    public int[][] kClosest(int[][] points, int k) {
        PriorityQueue<Point> queue = new PriorityQueue<>((a,b) -> a.dist-b.dist);
        for (int[] arr : points){
            queue.add(new Point(arr[0], arr[1], arr[0]*arr[0] + arr[1]*arr[1]));
        }

        int[][] res = new int[k][2];
        for(int i = 0; i<k;i++){
            Point p = queue.poll();
            res[i][0] = p.x;
            res[i][1] = p.y;
        }

        return res;
    }

    class Point{
        int x;
        int y;
        int dist;
        public Point(int x, int y, int dist){
            this.x = x;
            this.y = y;
            this.dist = dist;
        }

    }

}
