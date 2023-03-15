package Solutions;
public class SudoKuSolution {
    public void solveSudoku(char[][] board) {
        if (board == null || board.length == 0) {
            return;
        }
        backtrack(board, 0, 0);
    }

    private boolean backtrack(char[][] board, int row, int col) {
        if (col == 9) {
            // 列越界，进入下一行
            return backtrack(board, row + 1, 0);
        }
        if (row == 9) {
            // 行越界，数独已解决
            return true;
        }
        if (board[row][col] != '.') {
            // 当前位置已有数字，进入下一个位置
            return backtrack(board, row, col + 1);
        }
        for (char ch = '1'; ch <= '9'; ch++) {
            if (isValid(board, row, col, ch)) {
                board[row][col] = ch;
                if (backtrack(board, row, col + 1)) {
                    return true;
                }
                board[row][col] = '.';
            }
        }
        return false;
    }

    private boolean isValid(char[][] board, int row, int col, char ch) {
        for (int i = 0; i < 9; i++) {
            if (board[row][i] == ch || board[i][col] == ch ||
                    board[(row/3)*3 + i/3][(col/3)*3 + i%3] == ch) {
                return false;
            }
        }
        return true;
    }
}

//import Solutions.*;
//public class Main {
//    public static void main(String[] args) {
//        // 将输入的数独问题转化为一个字符矩阵
//        char[][] board = {
//                {'.', '.', '5', '3', '.', '.', '.', '.', '.'},
//                {'8', '.', '.', '.', '.', '.', '.', '2', '.'},
//                {'.', '7', '.', '.', '1', '.', '5', '.', '.'},
//                {'4', '.', '.', '.', '.', '5', '3', '.', '.'},
//                {'.', '1', '.', '.', '7', '.', '.', '.', '6'},
//                {'.', '.', '3', '2', '.', '.', '.', '8', '.'},
//                {'.', '6', '.', '5', '.', '.', '.', '.', '9'},
//                {'.', '.', '4', '.', '.', '.', '.', '3', '.'},
//                {'.', '.', '.', '.', '.', '9', '7', '.', '.'},
//        };
//
//// 解决数独问题
//        Solution solution = new Solution();
//        solution.solveSudoku(board);
//
//// 输出解决后的字符矩阵
//        for (int i = 0; i < 9; i++) {
//            for (int j = 0; j < 9; j++) {
//                System.out.print(board[i][j] + " ");
//            }
//            System.out.print("\n");
//        }
//    }
//}
