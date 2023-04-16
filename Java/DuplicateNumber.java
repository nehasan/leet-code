import java.util.HashSet;

public class DuplicateNumber {
    public int findDuplicate(int[] numbers) {
        HashSet<Integer> hashSet = new HashSet<>();

        for (int n : numbers) {
            if (hashSet.contains(n)) {
                return n;
            } else {
                hashSet.add(n);
            }
        }

        return 0;
    }

    public void func() {
        int [] numbers = new int[] { 100, 4, 200, 3, 1, 2 };
        numbers = new int[] { 0,3,7,2,5,8,4,6,0,1 };
        numbers = new int[] { 1, 2, 1 };
        System.out.println(findDuplicate(numbers));
    }

    public static void main (String[] args) {
        DuplicateNumber lps = new DuplicateNumber();
        lps.func();
    }
}
