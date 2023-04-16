import java.util.*;

public class LongestConsecutive {
    public int longestConsecutive(int[] numbers) {
        HashSet<Integer> set = new HashSet<>();
        int longestLength = 0;

        for (int n : numbers) {
            set.add(n);
        }

        for (Integer n: set) {
            if (!set.contains(n - 1)) {
//                System.out.println("STARTING FOR: " + n);
                int start = n;
                while (set.contains(start + 1)) {
                    start += 1;
//                    System.out.println(start);
                }

                longestLength = Math.max(longestLength,  (start - n) + 1);
            }
        }

        return longestLength;
    }

    public void func() {
        int [] numbers = new int[] { 100, 4, 200, 3, 1, 2 };
        numbers = new int[] { 0,3,7,2,5,8,4,6,0,1 };
        System.out.println(longestConsecutive(numbers));
    }

    public static void main (String[] args) {
        LongestConsecutive lps = new LongestConsecutive();
        lps.func();
    }
}
