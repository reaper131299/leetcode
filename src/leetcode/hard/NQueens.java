package leetcode.hard;

import java.util.ArrayList;
import java.util.List;

public class NQueens {
//    List<List<String>> res = new ArrayList<>();
//    int n;

    List<List<String>> res = new ArrayList<>();

    //    public List<List<String>> solveNQueens(int n) {
//        this.n = n;
//
//        for (int x = 0; x < n; x++) {
//            char[][] killZone = new char[n][n];
//            setKillzone(0, x, killZone);
//            killZone[0][x] = 'Q';
//            solveNQueensUtil(0, 1, killZone);
//        }
//
//        return res;
//    }
//
//    private void solveNQueensUtil(int i, int queensPlaced, char[][] killZone) {
//        if (queensPlaced == n) {
//            res.add(constructRes(killZone));
//        }
//
//        //placenext queen out side of kill zone
//        for (int x = i+1; x < n; x++) {
//            for (int z = 0; z < n; z++) {
//                if (!(killZone[x][z] == 'Q' || killZone[x][z] == 'T')) {
//                    char[][] kzopy = copy2DArray(killZone);
//
//                    //set killzone
//                    setKillzone(x, z, kzopy);
//
//                    //place queen
//                    kzopy[x][z] = 'Q';
//
//                    solveNQueensUtil(x, queensPlaced + 1, kzopy);
//
//                }
//            }
//        }
//    }
//
//    private List<String> constructRes(char[][] killZone) {
//        List<String> s = new ArrayList<>();
//        for (char[] chars : killZone) {
//            StringBuilder sb = new StringBuilder();
//            for (char ch : chars) {
//                if (ch == 'Q') sb.append('Q');
//                else sb.append('.');
//            }
//            s.add(sb.toString());
//        }
//        return s;
//    }
//
//    private char[][] copy2DArray(char[][] killZone) {
//        char[][] kzCopy = new char[n][n];
//        for (int i = 0; i < n; i++) {
//            System.arraycopy(killZone[i], 0, kzCopy[i], 0, n);
//        }
//
//        return kzCopy;
//    }
//
//    private void setKillzone(int i, int j, char[][] killZone) {
//        for (int h = 0; h < n; h++) {
//            killZone[i][h] = 'T';
//        }
//        for (int v = 0; v < n; v++) {
//            killZone[v][j] = 'T';
//        }
//
//        int id = i;
//        int jd = j;
//        while (id >= 0 && jd >= 0 && id < n && jd < n) {
//            killZone[id][jd] = 'T';
//            id++;
//            jd++;
//        }
//
//        id = i;
//        jd = j;
//        while (id >= 0 && jd >= 0 && id < n && jd < n) {
//            killZone[id][jd] = 'T';
//            id--;
//            jd++;
//        }
//
//        id = i;
//        jd = j;
//        while (id >= 0 && jd >= 0 && id < n && jd < n) {
//            killZone[id][jd] = 'T';
//            id++;
//            jd--;
//        }
//
//        id = i;
//        jd = j;
//        while (id >= 0 && jd >= 0 && id < n && jd < n) {
//            killZone[id][jd] = 'T';
//            id--;
//            jd--;
//        }
//    }
    char[][] board;
    boolean[] column;
    boolean[] positiveDiag;
    boolean[] negativeDiag;
    int n;

    public static void main(String args[]) {
        NQueens n = new NQueens();
        n.solveNQueens(4);
    }

    public List<List<String>> solveNQueens(int n) {
        this.board = new char[n][n];
        this.column = new boolean[n];
        this.positiveDiag = new boolean[2 * n];
        this.negativeDiag = new boolean[2 * n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                board[i][j] = '.';
            }
        }
        this.n = n;

        solveQueenUtil(0);

        return res;
    }

    public void solveQueenUtil(int row) {
        if (row == n) {
            //add to res.
            List<String> arr = new ArrayList<>();
            for (char[] chars : board) {
                arr.add(new String(chars));
            }
            res.add(arr);

            return;
        }

        for (int j = 0; j < n; j++) {

            if (column[j] || positiveDiag[row + j] || negativeDiag[row - j + n]) {
                continue;
            }

            board[row][j] = 'Q';
            column[j] = true;
            positiveDiag[row + j] = true;
            negativeDiag[row - j + n] = true;

            solveQueenUtil(row + 1);

            board[row][j] = '.';
            column[j] = false;
            positiveDiag[row + j] = false;
            negativeDiag[row - j + n] = false;
        }
    }
}
