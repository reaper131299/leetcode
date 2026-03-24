package leetcode.medium;

public class SurroundedRegions {
    boolean[][] isSafe;
    char[][] board;

    public static void main(String args[]){
        SurroundedRegions s = new SurroundedRegions();
        s.solve(new char[][]{
                {'X','X','X','X','X'},
                {'X','X','O','O','X'},
                {'X','X','X','X','X'},
                {'X','O','O','O','X'},
                {'X','O','X','O','X'},
                {'X','O','X','X','X'},
        });
    }

    public void solve(char[][] board) {
        isSafe = new boolean[board.length][board[0].length];
        this.board = board;

        for(int c = 0; c<board[0].length; c++){
            solveUtil(0, c);
            solveUtil(board.length-1, c);
        }

        for(int r = 0; r<board.length; r++){
            solveUtil(r, 0);
            solveUtil(r, board[0].length-1);
        }

        for(int r = 0; r< board.length; r++){
            for(int c = 0; c< board[0].length; c++){
                if(!isSafe[r][c]){
                    board[r][c] = 'X';
                }
            }
        }
    }

    public void solveUtil(int r, int c) {
        if(r<0||c<0||r>=board.length||c>=board[0].length||isSafe[r][c]||board[r][c]=='X'){
            return;
        }

        isSafe[r][c] = true;

        solveUtil(r+1,c);
        solveUtil(r-1,c);
        solveUtil(r,c+1);
        solveUtil(r,c-1);
    }
}
