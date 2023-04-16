import java.util.Arrays;

public class LargestPerimeterTriangle {
    public int largestPerimeter(int[] numbers) {
        int len = numbers.length;
        Arrays.sort(numbers);

        for (int i = len -1; i > 1; i--) {
            int a = numbers[i];
            int b = numbers[i - 1];
            int c = numbers[i - 2];

            if ((a + b) > c && (b + c) > a && (a + c) > b) {
                return a + b + c;
            }
        }

        return 0;
    }

    public void func() {
        int[] numbers = new int[] { 2, 1, 2 };
        numbers = new int[] { 2, 1, 1, 10 };

        System.out.println(largestPerimeter(numbers));
    }

    public static void main(String[] args) {
        LargestPerimeterTriangle obj = new LargestPerimeterTriangle();
        obj.func();
    }
}
