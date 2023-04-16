import java.util.Arrays;

public class FindMinInRotated {

    public void merge(int start, int mid, int end, int[] arr) {
        int leftArrLen = (mid - start) + 1;
        int rightArrLen = (end - mid);

        // allocate two new array for left and right
        int[] leftArr = new int[leftArrLen];
        int[] rightArr = new int[rightArrLen];

        // insert all the element from original array to left array [start - mid]
        for (int i = 0, j = start; i < leftArrLen;) {
            leftArr[i++] = arr[j++];
        }

        // insert all the element from original array to right array [mid + 1, end]
        for (int i = 0, j = mid + 1; i < rightArrLen;) {
            rightArr[i++] = arr[j++];
        }

        // it's a tricky part, both the two new arrays are sorted in their own places
        // assume the original array was [5,4,3]
        // now after first merging process left array would be 4,5 and right would be 3
        // 4,5 is already sorted
        // initialize i = j = 0
        // if left[i] < right[j] then place the element to new array and change the position to next
        // if right[i] < left[j] then place the element to new array and change the position to next
        int i, j, k;
        for (i = 0, j = 0, k = start; i < rightArrLen && j < rightArrLen;) {
            if (leftArr[i] < rightArr[i]) {
                arr[k++] = leftArr[i++];
            } else {
                arr[k++] = rightArr[j++];
            }
        }

        while(i < leftArrLen) {
            arr[k++] = leftArr[i++];
        }

        while(j < rightArrLen) {
            arr[k++] = rightArr[j++];
        }
    }

    public void mergeSort(int low, int high, int[] arr) {
        if (low < high) {
            int mid = (low + high) / 2;
            mergeSort(low, mid, arr);
            mergeSort(mid + 1, high, arr);
            merge(low, mid, high, arr);
        }
    }

    public int findMin(int[] numbers) {
        mergeSort(0, numbers.length - 1, numbers);
        System.out.println(Arrays.toString(numbers));
        return numbers[0];
    }

    public void func() {
        int[] numbers = new int[]{7,5,4,3,1};
        numbers = new int[]{4,5,6,7,0,1,2};
        System.out.println(findMin(numbers));
    }

    public static void main (String[] args) {
        FindMinInRotated sb = new FindMinInRotated();
        sb.func();
    }
}
