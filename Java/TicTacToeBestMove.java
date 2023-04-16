import java.util.Arrays;

public class TicTacToeBestMove {
    public static class Move {
        int x;
        int y;

        public Move (){}
        public Move (int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public boolean hasMoveLeft (char[][] board) {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (board[i][j] == '-') {
                    return true;
                }
            }
        }

        return false;
    }

    public boolean hasWon(char[][] board, char player, int depth, int i, int j, String movement) {
        if (i >= 0 && i < 3 && j >= 0 && j < 3) {
            if (board[i][j] == player && depth == 2) return true;

            if (board[i][j] == player) {
                if (movement.equals("left")) return
                        hasWon(board, player, depth + 1, i, j - 1, movement);

                if (movement.equals("leftUp")) return
                        hasWon(board, player, depth + 1, i - 1, j - 1, movement);

                if (movement.equals("up")) return
                        hasWon(board, player, depth + 1, i - 1, j, movement);

                if (movement.equals("rightUp")) return
                        hasWon(board, player, depth + 1, i - 1, j + 1, movement);

                if (movement.equals("right")) return
                        hasWon(board, player, depth + 1, i, j + 1, movement);

                if (movement.equals("rightDown")) return
                        hasWon(board, player, depth + 1, i + 1, j + 1, movement);

                if (movement.equals("down")) return
                        hasWon(board, player, depth + 1, i + 1, j, movement);

                if (movement.equals("leftDown")) return
                        hasWon(board, player, depth + 1, i + 1, j - 1, movement);

            }
        }

        return false;
    }

    public int evaluate(char[][] board) {
        for (int i = 0, j = 0, k = 2; i < 3; i++, j++, k--) {
            // Check rows to confirm if anyone wins
            if (hasWon(board, 'x', 0, i, 0, "right")) return 1;
            if (hasWon(board, 'o', 0, i, 0, "right")) return -1;

            // Check columns to confirm if anyone wins
            if (hasWon(board, 'x', 0, 0, j, "down")) return 1;
            if (hasWon(board, 'o', 0, 0, j, "down")) return -1;
        }

        // Cross from up to right down check to confirm the winner
        if (hasWon(board, 'x', 0, 0, 0, "rightDown")) return 1;
        if (hasWon(board, 'o', 0, 0, 0, "rightDown")) return -1;

        if (hasWon(board, 'x', 0, 0, 2, "leftDown")) return 1;
        if (hasWon(board, 'o', 0, 0, 2, "leftDown")) return -1;

        if (!hasMoveLeft(board)) return 0;

        return -2;
    }

    /*
    * Minimizing Maximizing algorithm to find best move
    * */
    public int minimax(char[][] board, int depth, boolean isMaximizing) {
        int score = evaluate(board);
//        System.out.println(Arrays.deepToString(board));
//        System.out.println("SCORE: " + score);

        if (score == 0 || score == -1 || score == 1) return score;

        int best;
        if (isMaximizing) {
            best = -10;

            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 3; j++) {
                    if (board[i][j] == '-') {
                        board[i][j] = 'x';
                        best = Math.max(best, minimax(board, depth + 1, false));
                        board[i][j] = '-';
                    }
                }
            }

        } else {
            best = 10;

            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 3; j++) {
                    if (board[i][j] == '-') {
                        board[i][j] = 'o';
                        best = Math.min(best, minimax(board, depth + 1, true));
                        board[i][j] = '-';
                    }
                }
            }
        }
        return best;
    }

    public Move nextMove(char[][] board, char player, boolean isMaximizing) {

        int bestValue = Integer.MIN_VALUE;
//        int bestValue = Integer.MAX_VALUE;
        Move move = new Move();
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (board[i][j] == '-') {
                    board[i][j] = player;
                    int moveValue = minimax(board, 0, isMaximizing);

                    board[i][j] = '-';
                    if (moveValue > bestValue) {
                        bestValue = moveValue;
                        move.x = i;
                        move.y = j;
                    }
                }
            }
        }
        System.out.println(move.x + " " + move.y);
        return move;
    }

    public void func() {
        char[][] board = new char[][] {
                {'R', 'T', 'R'},
                {'A', 'A', 'N'},
                {'B', 'C', 'O'}
        };

        board = new char[][] {
                {'o', '-', 'o'},
                {'-', 'x', '-'},
                {'x', '-', '-'}
        };

        /*
        * board = new char[][] {
                {'o', 'x', 'o'},
                {'o', 'x', 'x'},
                {'x', 'o', 'x'}
        };
        * */

//        System.out.println(evaluate(board));
        System.out.println(nextMove(board, 'x', false));
    }

    public static void main(String[] args) {
        TicTacToeBestMove obj = new TicTacToeBestMove();
        obj.func();
    }
}
