import java.util.Arrays;

public class MaxSubArray {
    public int maxSubArray(int[] numbers) {
        int maxSum = Integer.MIN_VALUE;
        int currSum = 0;

        for (int i = 0; i < numbers.length; i++) {
            currSum = Math.max(currSum + numbers[i], numbers[i]);
            maxSum = Math.max(maxSum, currSum);
        }
        return maxSum;
    }

    public void func() {
        int[] numbers = new int[] { -2,1,-3,4,-1,2,1,-5,4 };
//        numbers = new int[] { -1,1,0,-3,3 };
//        numbers = new int[] { 5,1,0,10,3,4,0 };
        numbers = new int[] { 3,2,-4,6,4 };
        System.out.println(maxSubArray(numbers));
    }

    public static void main (String[] args) {
        MaxSubArray obj = new MaxSubArray();
        obj.func();
    }
}
