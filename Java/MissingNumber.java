public class MissingNumber {
    public int missingNumber(int[] numbers) {
        int sum = 0;
        int length = numbers.length;

        for (int n : numbers) {
            sum += n;
        }

        return (length * (length + 1) / 2) - sum;
    }

    public void func() {
        int[] numbers = new int[]{1, 2, 4, 5};
        numbers = new int[]{ 0, 1 };
        System.out.println(missingNumber(numbers));
    }

    public static void main (String[] args) {
        MissingNumber sb = new MissingNumber();
        sb.func();
    }
}
