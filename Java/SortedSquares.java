import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;

public class SortedSquares {
    public int[] sortedSquares(int[] numbers) {
        int[] unsortedSquares = new int[numbers.length];
        for (int i = 0; i < numbers.length; i++) {
            unsortedSquares[i] = numbers[i] * numbers[i];
        }

//        return unsortedSquares;
        Arrays.sort(unsortedSquares);
        return unsortedSquares;
    }

    public void func() {
        int[] numbers = new int[] { -4,-1,0,3,10 };
        numbers = new int[] { -7,-3,2,3,11 };
        System.out.println(Arrays.toString(sortedSquares(numbers)));
    }

    public static void main (String[] args) {
        SortedSquares obj = new SortedSquares();
        obj.func();
    }
}
