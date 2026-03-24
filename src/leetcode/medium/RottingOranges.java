package leetcode.medium;

import java.util.ArrayDeque;
import java.util.LinkedList;
import java.util.Queue;

public class RottingOranges {
    int[][] grid;
    int timer = 0;

    public static void main(String args[]) {
        RottingOranges r = new RottingOranges();
        r.orangesRotting(new int[][]{{2, 1, 1}, {1, 1, 0}, {0, 1, 1}});
    }

//    public int orangesRotting(int[][] grid) {
//        this.grid = grid;
//
//        for(int r = 0; r< grid.length; r++){
//            for(int c = 0; c< grid[0].length; c++){
//                if(grid[r][c] == 2){
//                    orangesRottingUtil(r,c, 0);
//                }
//            }
//        }
//
//        for (int[] ints : grid) {
//            for (int c = 0; c < grid[0].length; c++) {
//                if (ints[c] == 1) {
//                    return -1;
//                }
//            }
//        }
//
//        return timer;
//    }
//
//    public void orangesRottingUtil(int r, int c, int currTimer){
//        if(r<0||c<0||r>=grid.length||c>= grid[0].length||grid[r][c]==0){
//            return;
//        }
//
//        grid[r][c] = 0;
//        timer = Math.max(timer, currTimer);
//
//        orangesRottingUtil(r+1,c, currTimer+1);
//        orangesRottingUtil(r-1,c, currTimer+1);
//        orangesRottingUtil(r,c+1, currTimer+1);
//        orangesRottingUtil(r,c-1, currTimer+1);
//    }

    private static boolean arePendingOrenges(int[][] grid) {
        for (int[] ints : grid) {
            for (int c = 0; c < grid[0].length; c++) {
                if (ints[c] == 1) {
                    return true;
                }
            }
        }
        return false;
    }

    public int orangesRotting(int[][] grid) {
        // add all the rotten oranges to queue and mark then in added[][]
        Queue<Integer> queue = new ArrayDeque<>();
        for (int r = 0; r < grid.length; r++) {
            for (int c = 0; c < grid[0].length; c++) {
                if (grid[r][c] == 2) {
                    queue.add(r);
                    queue.add(c);
                }
            }
        }

        //if queue is empty that means no torrent oranges
        // then if there are fresh oranges return -1 meaning they cannot be ever rotten
        // if there are no fresh oranges meaning no rotten and no fresh so return 0 since it will take 0 amount of time for all the oranges to be not fresh.

        if (queue.isEmpty()) {
            if (arePendingOrenges(grid)) return -1;
            else return 0;
        }

        //while queue is not empty add the neighbouring oranges to queue
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 1; i <= size / 2; i++) {
                int r = queue.poll();
                int c = queue.poll();

                //add the neighbouring oranges if indexes are in bounds and if there is a fresh orange
                if (r + 1 < grid.length && grid[r + 1][c] == 1) {
                    queue.add(r + 1);
                    queue.add(c);
                    grid[r + 1][c] = 2;
                }

                if (r - 1 >= 0 && grid[r - 1][c] == 1) {
                    queue.add(r - 1);
                    queue.add(c);
                    grid[r - 1][c] = 2;
                }

                if (c + 1 < grid[0].length && grid[r][c + 1] == 1) {
                    queue.add(r);
                    queue.add(c + 1);
                    grid[r][c + 1] = 2;
                }

                if (c - 1 >= 0 && grid[r][c - 1] == 1) {
                    queue.add(r);
                    queue.add(c - 1);
                    grid[r][c - 1] = 2;
                }
            }

            //increment the timer
            timer++;
        }

        //after all the oranges are rotten check if there are any fresh oranges left. if yes then return -1
        if (arePendingOrenges(grid)) return -1;

        //the algorithm will take +1 time to mark first set of rotten oranges are rotten
        return timer - 1;
    }
}
