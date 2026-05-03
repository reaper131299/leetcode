package leetcode.hard;

import java.util.Comparator;
import java.util.PriorityQueue;

public class SwimInRisingWater {
    public static void main(String[] args) {
        SwimInRisingWater s = new SwimInRisingWater();
//        s.swimInWater(new int[][]{
//                {0,2},
//                {1,3}
//        });

        s.swimInWater(new int[][]{
                {0, 1, 2, 3, 4},
                {24, 23, 22, 21, 5},
                {12, 13, 14, 15, 100},
                {11, 17, 18, 19, 20},
                {10, 9, 8, 7, 6}
        });
    }

    public int swimInWater(int[][] grid) {
        int t = 0;
        int ROW = grid.length;
        int COL = grid[0].length;
        boolean[][] visited = new boolean[grid.length][grid[0].length];
        visited[0][0] = true;
        int[] nextRow = new int[]{1,0,-1,0};
        int[] nextCol = new int[]{0,1,0,-1};

        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a[2]));
        pq.add(new int[]{0, 0, grid[0][0]});

        while (!pq.isEmpty()) {
            if (pq.peek()[2] > t) t = pq.peek()[2];
            int[] node = pq.poll();
            int r = node[0];
            int c = node[1];

            if (r == ROW-1 && c == COL-1) break;

            for(int i = 0; i<4; i++) {
                int nextR = r + nextRow[i];
                int nextC = c + nextCol[i];

                if(nextR < ROW && nextR >= 0 &&  nextC < COL && nextC >= 0 && !visited[nextR][nextC]) {
                    visited[nextR][nextC] = true;
                    pq.add(new int[]{nextR, nextC, grid[nextR][nextC]});
                }
            }
        }

        return t;
    }

//    public int swimInWater(int[][] grid) {
//        int n=grid.length;
//        int[][]visited=new int[n][n];
//        return bfs(grid,visited,n);
//    }
//    public static int bfs(int[][]grid,int[][]visited,int n){
//        PriorityQueue<Pair>pq=new PriorityQueue<>((a,b)->a.time -b.time);
//        pq.offer(new Pair(0,0,grid[0][0],grid[0][0]));
//        visited[0][0]=1;
//        int[]allowedRow={0,-1,1,0};
//        int[]allowedCol={-1,0,0,1};
//        while(!pq.isEmpty()){
//            Pair cur=pq.poll();
//            if(cur.row==n-1&&cur.col==n-1)return cur.time;
//            for(int i=0;i<4;i++){
//                int newRow=cur.row+allowedRow[i];
//                int newCol=cur.col+allowedCol[i];
//                if(newRow>=0&&newRow<n&&newCol>=0&&newCol<n&&visited[newRow][newCol]==0){
//                    int curTime=Math.max(cur.time,grid[newRow][newCol]);
//                    pq.offer(new Pair(newRow,newCol,grid[newRow][newCol],curTime));
//                    visited[newRow][newCol]=1;
//                }
//            }
//        }
//        return -1;
//    }
}
