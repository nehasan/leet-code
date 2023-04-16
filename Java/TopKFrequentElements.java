import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TopKFrequentElements {
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

        while (bucketTwo.entrySet().iterator().hasNext()) {

        }
    }

    public void func() {

    }

    public static void main(String[] args) {
        WordSearch obj = new WordSearch();
        obj.func();
    }
}
