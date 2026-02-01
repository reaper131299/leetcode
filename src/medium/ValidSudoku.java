package medium;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class ValidSudoku {

    public static void main(String[] args) {
        char[][] board = {
                {'5','3','.','.','7','.','.','.','.'},
                {'6','.','.','1','9','5','.','.','.'},
                {'.','9','8','.','.','.','.','6','.'},
                {'8','.','.','.','6','.','.','.','3'},
                {'4','.','.','8','.','3','.','.','1'},
                {'7','.','.','.','2','.','.','.','6'},
                {'.','6','.','.','.','.','2','8','.'},
                {'.','.','.','4','1','9','.','.','5'},
                {'.','.','.','.','8','.','.','7','9'}
        };
        ValidSudoku v = new ValidSudoku();
        System.out.println(v.isValidSudoku(board));
    }

//    public boolean isValidSudoku(char[][] board) {
//        for(int i = 0; i<9; i++) {
//            Set<Character> h = new HashSet<>();
//            for (char c : board[i]) {
//                if (c!='.' && h.contains(c))
//                    return false;
//                h.add(c);
//            }
//        }
//        for(int i = 0; i<9; i++) {
//            int c =0;
//            Set<Character> h = new HashSet<>();
//            while(c<9) {
//                if (board[c][i]!='.' && h.contains(board[c][i]))
//                    return false;
//                h.add(board[c][i]);
//                c++;
//            }
//        }
//        for(int i =0; i<3; i++){
//            int istartIndex = i*3;
//            int iendIndex = istartIndex+2;
//            for(int j = 0; j<3; j++){
//                int jstartIndex = j*3;
//                int jendIndex = jstartIndex+2;
//                Set<Character> h = new HashSet<>();
//                for(int k = istartIndex; k<=iendIndex;k++){
//                    for(int l = jstartIndex; l <=jendIndex;l++){
//                        if (board[k][l]!='.' && h.contains(board[k][l]))
//                            return false;
//                        h.add(board[k][l]);
//                    }
//                }
//            }
//        }
//        return true;
//    }
    public boolean isValidSudoku(char[][] board) {
        boolean[][] rows = new boolean[9][9];
        boolean[][] columns = new boolean[9][9];
        boolean[][] boxes = new boolean[9][9];

        for(int i = 0; i<9;i++){
            for(int j = 0; j<9;j++){
                int c = board[i][j]-'0'-1;

                if(-3 == c)
                    continue;

                int rowNum = i;
                int colNum = j;
                int box = (i/3)*3 + j/3;

                if(rows[rowNum][c] || columns[colNum][c] || boxes[box][c]){
                    return false;
                }

                rows[rowNum][c] =true;
                columns[colNum][c] =true;
                boxes[box][c] = true;
            }
        }
        return true;
    }
}
