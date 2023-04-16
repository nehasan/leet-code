import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SpiralMatrix {
    public void spiralTraverse(int[][] matrix, List<Integer> list, int rows, int cols, int iniRow, int iniCol, int i, int j, String dir) {
//        System.out.println("I: " + i + " ROW: "+ rows + " J: " + j + " COL: " + cols + " IN_ROW: " + iniRow + " IN_COL: " + iniCol);

        if (i >= iniRow && i <= rows && j >= iniCol && j <= cols && iniRow <= rows && iniCol <= cols){
            if (matrix[i][j] != -101) {
                list.add(matrix[i][j]);
                matrix[i][j] = -101;
            }

            if (dir.equals("right")) {
                j++;
                if (j > cols) {
                    j--; i++;
                    iniRow++;
                    spiralTraverse(matrix, list, rows, cols, iniRow, iniCol, i, j, "down");
                }else {
                    spiralTraverse(matrix, list, rows, cols, iniRow, iniCol, i, j, "right");
                }
            } else if (dir.equals("down")) {
                i++;
                if (i > rows) {
                    i--; j--;
                    cols--;
                    spiralTraverse(matrix, list, rows, cols, iniRow, iniCol, i, j, "left");
                } else {
                    spiralTraverse(matrix, list, rows, cols, iniRow, iniCol, i, j, "down");
                }
            } else if (dir.equals("left")) {
                j--;
                if (j < iniCol) {
                    j++; i--;
                    rows--;
                    spiralTraverse(matrix, list, rows, cols, iniRow, iniCol, i, j, "up");
                } else {
                    spiralTraverse(matrix, list, rows, cols, iniRow, iniCol, i, j, "left");
                }
            } else {
                i--;
                if (i < iniRow) {
                    i++; j++;
                    iniCol++;
                    spiralTraverse(matrix, list, rows, cols, iniRow, iniCol, i, j, "right");
                } else {
                    spiralTraverse(matrix, list, rows, cols, iniRow, iniCol, i, j, "up");
                }
            }
        }
    }

    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> list = new ArrayList<>();
        int rows  = matrix.length;
        int cols = matrix[0].length;

        if (cols == 0)
            return list;

        spiralTraverse(matrix, list, rows - 1, cols - 1, 0, 0, 0, 0,"right");

        return list;
    }

    public void func() {
        int[][] matrix = new int[][] {
                {1,2,3}, {4, 5, 6}, {7, 8, 9}
        };
//        matrix = new int[][] {
//                {1,2,3, 4}, {5, 6, 7, 8}, {9, 10, 11, 12}, {13, 14, 15, 16}
//        };

//        matrix = new int[][] {{3}, {2}};

        List<Integer> list = spiralOrder(matrix);
        System.out.println(Arrays.toString(list.toArray()));
    }

    public static void main(String[] args) {
        SpiralMatrix obj = new SpiralMatrix();
        obj.func();
    }
}
