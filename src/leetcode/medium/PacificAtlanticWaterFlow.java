package leetcode.medium;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class PacificAtlanticWaterFlow {
    boolean[][] pacific;
    boolean[][] atlantic;
    int[][] heights;
    int ROWS;
    int COLUMNS;

    public static void main(String args[]){
        PacificAtlanticWaterFlow p = new PacificAtlanticWaterFlow();
        p.pacificAtlantic(new int[][]{
                {1,2,2,3,5},
                {3,2,3,4,4},
                {2,4,5,3,1},
                {6,7,1,4,5},
                {5,1,1,2,4}
        });
    }

    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        pacific = new boolean[heights.length][heights[0].length];
        atlantic = new boolean[heights.length][heights[0].length];
        ROWS = heights.length;
        COLUMNS = heights[0].length;
        List<List<Integer>> res = new ArrayList<>();

        for(int c = 0; c<COLUMNS; c++){
            findPathToOcean(0, c, pacific, 0);
            findPathToOcean(ROWS-1, c, atlantic, 0);
        }

        for(int r = 0; r<ROWS; r++){
            findPathToOcean(r, 0, pacific, 0);
            findPathToOcean(r, COLUMNS-1, atlantic, 0);
        }

        for(int r = 0; r<ROWS; r++){
            for(int c = 0; c<COLUMNS; c++){
                if(pacific[r][c] && atlantic[r][c]){
                    List<Integer> arr = new ArrayList<>();
                    arr.add(r);
                    arr.add(c);
                    res.add(arr);
                }
            }
        }
        return res;
    }

    public void findPathToOcean(int r, int c, boolean[][] ocean, int prevHeight){
        if(r<0||c<0||r>=ROWS||c>=COLUMNS||prevHeight>heights[r][c]||ocean[r][c]) return;

        ocean[r][c] = true;

        findPathToOcean(r+1,c,ocean,heights[r][c]);
        findPathToOcean(r-1,c,ocean,heights[r][c]);
        findPathToOcean(r,c+1,ocean,heights[r][c]);
        findPathToOcean(r,c-1,ocean,heights[r][c]);
    }

}
