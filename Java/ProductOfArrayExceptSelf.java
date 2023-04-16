import java.util.Arrays;

public class ProductOfArrayExceptSelf {
    public int[] productExceptSelf(int[] numbers) {
        int len = numbers.length;
        int[] finalProdArr = new int[len];
        int zeros = 0;
        int totalProd0 = 1, totalProd1 = 1;

        for (int n : numbers) {
            if (n == 0) {
                zeros++;
            } else {
                totalProd1 *= n;
            }
            totalProd0 *= n;
        }

//        System.out.println(totalProd0);
//        System.out.println(totalProd1);
        if (zeros <= 1) {
            for (int i = 0; i < len; i++) {
                if (numbers[i] == 0) {
                    finalProdArr[i] = totalProd1;
                } else {
                    finalProdArr[i] = totalProd0 / numbers[i];
                }
            }
        }

        return finalProdArr;
    }

    public void func() {
        int[] numbers = new int[] { 1,2,3,4 };
        numbers = new int[] { -1,1,0,-3,3 };
        numbers = new int[] { 5,1,0,10,3,4,0 };
        System.out.println(Arrays.toString(productExceptSelf(numbers)));
    }

    public static void main (String[] args) {
        ProductOfArrayExceptSelf obj = new ProductOfArrayExceptSelf();
        obj.func();
    }
}
