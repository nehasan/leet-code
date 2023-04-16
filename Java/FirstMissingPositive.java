import java.util.HashSet;

public class FirstMissingPositive {
    public int firstMissingPositive(int[] numbers) {
        HashSet<Integer> hashSet = new HashSet<>();

        for (int n : numbers) {
            hashSet.add(n);
        }

        int missing = 1;
        while (hashSet.contains(missing)) {
            missing++;
        }

        return missing;
    }

    public void func() {
        int[] numbers = new int[]{-1, 0, 2, 3, 4, 5};
        numbers = new int[]{ -1 };
        numbers = new int[]{ 2147483647 };
//        numbers = new int[]{ 1, 2, 3, 4, 5 };
        System.out.println(firstMissingPositive(numbers));
    }

    public static void main (String[] args) {
        FirstMissingPositive sb = new FirstMissingPositive();
        sb.func();
    }
}
