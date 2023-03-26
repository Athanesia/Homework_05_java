// На шахматной доске расставить 8 ферзей так, чтобы они не били друг друга.

public class EightQueens04 {
    
    // Размер доски
    static int BOARD_SIZE = 8;
    
    // Размещение ферзя на доске
    static void placeQueens(int[][] board, int row) {
        if (row == BOARD_SIZE) {
            printBoard(board);
            return;
        }
        
        for (int col = 0; col < BOARD_SIZE; col++) {
            if (isValid(board, row, col)) {
                board[row][col] = 1;
                placeQueens(board, row + 1);
                board[row][col] = 0;
            }
        }
    }
    
    // Проверка наличия угрозы других ферзей
    static boolean isValid(int[][] board, int row, int col) {
        // Проверяем, нет ли угрозы по горизонтали и вертикали
        for (int i = 0; i < row; i++) {
            if (board[i][col] == 1) {
                return false;
            }
        }
        for (int i = 0; i < col; i++) {
            if (board[row][i] == 1) {
                return false;
            }
        }
        
        // Проверяем, нет ли угрозы по диагоналям
        for (int i = row - 1, j = col - 1; i >= 0 && j >= 0; i--, j--) {
            if (board[i][j] == 1) {
                return false;
            }
        }
        for (int i = row - 1, j = col + 1; i >= 0 && j < BOARD_SIZE; i--, j++) {
            if (board[i][j] == 1) {
                return false;
            }
        }
        
        return true;
    }
    
    // Вывод доски
    static void printBoard(int[][] board) {
        for (int i = 0; i < BOARD_SIZE; i++) {
            for (int j = 0; j < BOARD_SIZE; j++) {
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();
    }
    
    public static void main(String[] args) {
        int[][] board = new int[BOARD_SIZE][BOARD_SIZE];
        placeQueens(board, 0);
    }
}