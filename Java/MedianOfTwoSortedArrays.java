import java.util.Arrays;
import java.util.List;

public class MedianOfTwoSortedArrays {
    public double findMedianSortedArrays(int[] numbersOne, int[] numbersTwo) {
        int minLen = Math.min(numbersOne.length, numbersTwo.length);
        int lenOne = numbersOne.length;
        int lenTwo = numbersTwo.length;
        int totalLen = numbersOne.length + numbersTwo.length;

        int[] resArr = new int[totalLen];

        int i = 0, j = 0, k = 0;
        for (i = 0, j = 0; i < lenOne && j < lenTwo;) {
            if (numbersOne[i] == numbersTwo[j]) {
                resArr[k++] = numbersOne[i++];
                resArr[k++] = numbersTwo[j++];
            } else if (numbersOne[i] < numbersTwo[j]) {
                resArr[k++] = numbersOne[i++];
            } else {
                resArr[k++] = numbersTwo[j++];
            }
        }

        for (int l = i; l < numbersOne.length; l++){
            resArr[k++] = numbersOne[l];
        }

        for (int m = j; m < numbersTwo.length; m++){
            resArr[k++] = numbersTwo[m];
        }

//        System.out.println(Arrays.toString(resArr));
        if (totalLen % 2 == 0) {
            return (resArr[(totalLen / 2)] + resArr[(totalLen /2) - 1]) / 2.00;
        } else {
            return resArr[(totalLen / 2)];
        }
    }

    public void func() {
        int[] arrOne = new int[] {1, 3};
        int[] arrTwo = new int[] {2};

        arrOne = new int[] {1, 2};
        arrTwo = new int[] {3, 4};

        double res = findMedianSortedArrays(arrOne, arrTwo);
        System.out.println(res);
    }

    public static void main(String[] args) {
        MedianOfTwoSortedArrays obj = new MedianOfTwoSortedArrays();
        obj.func();
    }
}
