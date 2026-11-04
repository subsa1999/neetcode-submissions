class Solution {
    public boolean isValidSudoku(char[][] board) {
        return validateBoxes(board) && validateRows(board) && validateCols(board);
    }

    boolean validateBoxes(char[][] board) {
        for (int startI = 0; startI < 9; startI += 3) {
            for (int startJ = 0; startJ < 9; startJ += 3) {
                boolean[] seen = new boolean[10];

                for (int i = startI; i < startI + 3; i++) {
                    for (int j = startJ; j < startJ + 3; j++) {
                        if (board[i][j] == '.') continue;
                        if (seen[(board[i][j] - '0')]) return false;
                        seen[(board[i][j] - '0')] = true;
                    }
                }
            }
        }

        return true;
    }

    boolean validateRows(char[][] board) {
        for (int i = 0; i < 9; i++) {
            boolean[] seen = new boolean[10];
            for (int j = 0; j < 9; j++) {
                if (board[i][j] == '.') continue;
                if (seen[(board[i][j] - '0')]) return false;
                seen[(board[i][j] - '0')] = true;
            }
        }

        return true;
    }

    boolean validateCols(char[][] board) {
        for (int j = 0; j < 9; j++) {
            boolean[] seen = new boolean[10];
            for (int i = 0; i < 9; i++) {
                if (board[i][j] == '.') continue;
                if (seen[(board[i][j] - '0')]) return false;
                seen[(board[i][j] - '0')] = true;
            }
        }

        return true;
    }
}
