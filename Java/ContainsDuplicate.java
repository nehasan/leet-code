import java.util.*;

public class ContainsDuplicate {
    public boolean containsDuplicate(int[] numbers) {
        Arrays.sort(numbers);
        if (numbers.length == 1) {
            return false;
        } else if (numbers.length == 2) {
            return (Math.abs(numbers[0] - numbers[1])) == 0;
        }
        for (int i = 0; i < numbers.length - 1; i++) {
            if ((Math.abs(numbers[i] - numbers[i + 1])) == 0) {
                return true;
            }
        }
        return false;
    }

    public boolean containsDuplicate1(int[] numbers) {
        Map<Integer, Integer> numbersMap = new HashMap<>();

        for (int n : numbers) {
            if (numbersMap.containsKey(n)) {
                return true;
            } else {
                numbersMap.put(n, 0);
            }
        }

        return false;
    }

    public void func() {
        int[] numbers = new int[] { 1,2,3,10,2 };
        System.out.println(containsDuplicate(numbers));
    }

    public static void main (String[] args) {
        ContainsDuplicate sb = new ContainsDuplicate();
        sb.func();
    }
}
