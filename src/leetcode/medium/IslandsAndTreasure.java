package leetcode.medium;

import java.util.ArrayDeque;
import java.util.Queue;

//this problem is same as walls and gates
public class IslandsAndTreasure {

    public static void main(String args[]){
        IslandsAndTreasure i = new IslandsAndTreasure();
        i.islandsAndTreasure(new int [][]{
                {2147483647,-1,0,2147483647},
                {2147483647,2147483647,2147483647,-1},
                {2147483647,-1,2147483647,-1},
                {0,-1,2147483647,2147483647}
        });

    }

    public void islandsAndTreasure(int[][] grid) {
        int distance = 1;
        Queue<Integer> queue = new ArrayDeque<>();

        for(int r = 0; r< grid.length; r++){
            for(int c = 0; c<grid[0].length; c++){
                if(grid[r][c] == 0){
                    queue.add(r);
                    queue.add(c);
                }
            }
        }

        while (!queue.isEmpty()){
            int size = queue.size();
            for(int i = 0; i<size/2; i++){
                int r = queue.poll();
                int c = queue.poll();

                if(r-1>=0 && grid[r-1][c] == 2147483647){
                    grid[r-1][c] = distance;
                    queue.add(r-1);
                    queue.add(c);
                }

                if(c-1>=0 && grid[r][c-1] == 2147483647){
                    grid[r][c-1] = distance;
                    queue.add(r);
                    queue.add(c-1);
                }

                if(r+1<grid.length && grid[r+1][c] == 2147483647){
                    grid[r+1][c] = distance;
                    queue.add(r+1);
                    queue.add(c);
                }

                if(c+1<grid[0].length && grid[r][c+1] == 2147483647){
                    grid[r][c+1] = distance;
                    queue.add(r);
                    queue.add(c+1);
                }
            }
            distance++;
        }
    }
}
