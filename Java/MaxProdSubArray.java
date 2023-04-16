public class MaxProdSubArray {
    public int maxProduct(int[] numbers) {
        int minProd = numbers[0];
        int maxProd = numbers[0];
        int result = numbers[0];

        if (numbers.length == 0) return 0;

        for (int i = 1; i < numbers.length; i++) {
            int tempMax = Math.max(maxProd * numbers[i], Math.max(minProd * numbers[i], numbers[i]));
            minProd = Math.min(minProd * numbers[i], Math.min(maxProd * numbers[i], numbers[i]));
            maxProd = tempMax;

            result = Math.max(result, maxProd);
        }

        return result;
    }

    public void func() {
        int[] numbers = new int[] { -2,1,-3,4,-1,2,1,-5,4 };
//        numbers = new int[] { -1,1,0,-3,3 };
//        numbers = new int[] { 5,1,0,10,3,4,0 };
//        numbers = new int[] { 3,2,-4,6,4 };
//        numbers = new int[] { -2,3,4 };
        numbers = new int[] { 0,-2 };
//        numbers = new int[] { 3,-1,4 };
        System.out.println(maxProduct(numbers));
    }

    public static void main (String[] args) {
        MaxProdSubArray obj = new MaxProdSubArray();
        obj.func();
    }
}
