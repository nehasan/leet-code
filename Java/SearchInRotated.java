import java.util.Arrays;

public class SearchInRotated {

    public int binarySearch(int beg, int end, int[] arr, int target) {
        int mid = (beg + end) / 2;

        if(arr[mid] == target) {
            return mid;
        } else if (beg == end) {
            return -1;
        } else if (target < arr[mid]) {
            return binarySearch(beg, (mid - 1), arr, target);
        } else {
            return binarySearch((mid + 1), end, arr, target);
        }
    }

    public int search(int[] numbers, int target) {
        return binarySearch(0, numbers.length - 1, numbers, target);
    }

    public int search1(int[] numbers, int target) {
//        return binarySearch(0, numbers.length - 1, numbers, target);
        int len = numbers.length;
        for (int i = 0, j = len - 1; i < (len / 2) + 1; i++, j--) {
            if (numbers[i] == target) {
                return i;
            } else if (numbers[j] == target) {
                return j;
            }
        }
        return -1;
    }

    public void func() {
        int[] numbers = new int[]{7,5,4,3,1};
        numbers = new int[]{4,5,6,7,0,1,2};
//        System.out.println(search(numbers, 0));
        System.out.println(search1(numbers, 0));
    }

    public static void main (String[] args) {
        SearchInRotated obj = new SearchInRotated();
        obj.func();
    }
}
