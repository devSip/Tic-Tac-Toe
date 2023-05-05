import java.util.Scanner;

public class Code {

    Scanner sc = new Scanner(System.in);

    char[][] board = {
            { '_', '_', '_' },
            { '_', '_', '_' },
            { '_', '_', '_' }
    };

    public void run() {
        System.out.println("\nLet's play tic-tac-toe!");
        printBoard(board);
        whoseTurn(board);
        checkWin(board);
    }

    private int checkWin(char[][] board) {
        int rows = checkRows(board);
        if (Math.abs(rows) == 3)
            return rows;

        int columns = checkColumns(board);
        if (Math.abs(columns) == 3)
            return columns;

        int leftDiagonal = checkLeft(board);
        if (Math.abs(leftDiagonal) == 3)
            return leftDiagonal;

        int rightDiagonal = checkRight(board);
        if (Math.abs(rightDiagonal) == 3)
            return rightDiagonal;

        return -1;
    }

    private void whoseTurn(char[][] board) {
        for (int i = 0; i < 10; i++) {
            if (i % 2 == 0) {
                System.out.println("Turn X:");
                int[] spot = askUser(board);
                board[spot[0]][spot[1]] = 'X';
            } else {
                System.out.println("Turn O:");
                int[] spot = askUser(board);
                board[spot[0]][spot[1]] = 'O';
            }
            printBoard(board);

            int count = checkWin(board);
            if (count == 3) {
                System.out.println("X wins!");
                break;
            } else if (count == -3) {
                System.out.println("O wins!");
                break;
            } else if (i == 8) {
                System.out.println("It's a tie!");
            }
        }
    }

    private int[] askUser(char[][] board) {
        System.out.print("Pick the row and column: ");
        int row = sc.nextInt();
        int column = sc.nextInt();
        while (board[row][column] != '_') {
            System.out.print("Spot taken, pick another! ");
            row = sc.nextInt();
            column = sc.nextInt();
        }
        return new int[] { row, column };
    }

    private void printBoard(char[][] board) {
        System.out.println();
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                System.out.print("\t" + board[i][j] + " ");
            }
            System.out.print("\n\n");
        }
    }

    private int checkRows(char[][] board) {
        int count = 0;
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if (board[i][j] == 'X') {
                    count++;
                } else if (board[i][j] == 'O') {
                    count--;
                }
            }
            if (Math.abs(count) == 3) {
                return count;
            } else {
                count = 0;
            }
        }
        return count;
    }

    private int checkColumns(char[][] board) {
        int count = 0;
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if (board[j][i] == 'X') {
                    count++;
                } else if (board[j][i] == 'O') {
                    count--;
                }
            }
            if (Math.abs(count) == 3) {
                return count;
            } else {
                count = 0;
            }
        }
        return count;
    }

    private int checkLeft(char[][] board) {
        int count = 0;
        for (int i = 0; i < board.length; i++) {
            if (board[i][i] == 'X'){
            count++;
        } else if (board[i][i] == 'O'){
            count--;
        }
    }
    return count;
}

    private int checkRight(char[][] board) {
        int count = 0;
        for (int i = 0; i < board.length; i++) {
            if (board[2-i][i] == 'X'){
            count++;
        } else if (board[2-i][i] == 'O'){
            count--;
        }
    }
        return count;
    }

}
