/*
* LeetCode 347 : Top k Frequent Elements in an array
* Author: Nahid Hasan Khan
* */
import java.util.*;

public class TopKFrequentElements {
    /*
    * @param[Array][int] numbers, from which top k frequent numbers will be extracted
    * @param[int] k, the number of top frequent numbers will be extracted
    * Algorithm: Solution using bucket sort
    * Bucket one hashmap contains the int, int pair, where key => element of the array
    * and value => number times the key occurred
    * Bucket two hashmap contains the int, int[], where key => value of bucket one and value => keys of bucket one
    * Later we search bucket two, starting from total number of elements in the array till 1
    * and find if the n-- contains in the bucket two which are top frequent element
    * Push the elements to the resulting array k times which is the final result
    * */
    public int[] topKFrequent(int[] numbers, int k) {
        HashMap<Integer, Integer> bucketOne = new HashMap<>();

        // Put all the elements into a bucket where key => n and value => times it appeared
        for (int n : numbers) {
            bucketOne.put(n, bucketOne.getOrDefault(n, 0) + 1);
        }

        // Maintain another bucket where key => value of bucketOne, value = key of bucketOne
        HashMap<Integer, List<Integer>> bucketTwo = new HashMap<>();
        List<Integer> elementList;
        for (Map.Entry<Integer, Integer> entry : bucketOne.entrySet()) {
            int key = entry.getKey();
            int value = entry.getValue();
            if (bucketTwo.containsKey(value)) {
                List<Integer> currentList = bucketTwo.get(value);
                currentList.add(key);
                bucketTwo.put(value, currentList);
            } else {
                elementList = new ArrayList<>();
                elementList.add(key);
                bucketTwo.put(value, elementList);
            }
        }

        int[] result = new int[k];
        for (int i = numbers.length, l = 0; i >= 1; i--) {
            // find number of occurrences
            if (bucketTwo.containsKey(i)) {
                List<Integer> numberList = bucketTwo.get(i);
                int j = 0;
                while(j < numberList.size() && k-- >= 0) {
                    result[l++] = numberList.get(j++);
                }
            }

            if (k == 0) break;
        }

        return result;
    }

    public void func() {
        int[] numbers = new int[] { 1,1,1,2,2,3 };
        int k = 2;
        numbers = new int[] { 1 };
        k = 1;
        System.out.println(Arrays.toString(topKFrequent(numbers, k)));
    }

    public static void main(String[] args) {
        TopKFrequentElements obj = new TopKFrequentElements();
        obj.func();
    }
}
