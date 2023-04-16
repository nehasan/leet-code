import java.util.Arrays;
import java.util.List;

public class WordSearch {
    // recursive DFS to find the word
    public boolean wordExists(char[][] board, int[] border, int i, int j, String word, int wordPos) {
//        System.out.println("I: " + i + " J: " + j + " ALPHA: " + word.charAt(wordPos) + " BOARD ALPHA: " + board[i][j]);

        if (i >= border[0] && i <= border[1] &&
                j >= border[2] && j <= border[3]) {

            System.out.println("I: " + i + " J: " + j + " ALPHA: " + word.charAt(wordPos) + " BOARD ALPHA: " + board[i][j]);
            if (board[i][j] == word.charAt(wordPos)) {
                System.out.println("MATCHED: " + board[i][j]);
                if (wordPos == (word.length() - 1)) {
                    return true;
                } else {
                    return wordExists(board, border, i, j - 1, word, wordPos + 1) ||
                            wordExists(board, border, i - 1, j, word, wordPos + 1) ||
                            wordExists(board, border, i, j + 1, word, wordPos + 1) ||
                            wordExists(board, border, i + 1, j, word, wordPos + 1);
                }
            }
            return false;
        }
        return false;
    }

    public boolean exist(char[][] board, String word) {
        int rowSize = board.length;
        int colSize = board[0].length;

        boolean found = false;
        for (int i = 0; i < rowSize; i++) {
            for (int j = 0; j < colSize; j++) {
                if (board[i][j] == word.charAt(0)) {

//                    System.out.println("START: " + board[i][j]);
                    if (wordExists(board, new int[]{0, rowSize - 1, 0, colSize - 1}, i, j, word, 0)) {
                        found = true;
                        break;
                    }
                }
            }
        }

        return found;
    }

    public void func() {
        char[][] board = new char[][] {
                {'R','T','R'},
                {'A', 'A', 'N'},
                {'B', 'C', 'O'}
        };

        board = new char[][] {
                {'A','B','C', 'E'},
                {'S', 'F', 'C', 'S'},
                {'A', 'D', 'E', 'E'}
        };

        System.out.println(exist(board, "SEE"));
    }

    public static void main(String[] args) {
        WordSearch obj = new WordSearch();
        obj.func();
    }
}
