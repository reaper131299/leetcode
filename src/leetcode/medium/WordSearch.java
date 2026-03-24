package leetcode.medium;

public class WordSearch {
    char[][] board;
    boolean[][] visited;
    String word;

    public static void main(String[] args){
        char[][] board = new char[][]{
                {'A','B','C','E'},
                {'S','F','C','S'},
                {'A','D','E','E'}
        };
        WordSearch w = new WordSearch();
        w.exist(board, "SEE");
    }

    public boolean exist(char[][] board, String word) {
        this.board = board;
        this.visited = new boolean[board.length][board[0].length] ;
        this.word = word;

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] == word.charAt(0) && existUtility(i, j, 0)){
                        return true;
                    }

            }
        }
        return false;
    }

    public boolean existUtility(int i, int j, int pos){
        if(pos == word.length()){
            return true;
        }
        if(i<0 || j<0 || i>=board.length || j>=board[0].length || visited[i][j] || board[i][j] != word.charAt(pos)) return false;

        visited[i][j] = true;

        if(existUtility(i, j+1, pos+1) || existUtility(i+1, j, pos+1) || existUtility(i, j-1, pos+1) || existUtility(i-1, j, pos+1)){
            return true;
        } else {
            visited[i][j] = false;
            return false;
        }
    }
}
