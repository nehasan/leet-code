// Leetcode 791. Custom Sort String
import java.util.Arrays;
import java.util.HashMap;

public class CustomSortString {
    public String customSortString(String order, String s) {
        HashMap<Character, Integer> hashMap = new HashMap<>();

        // Insert all the distinct character to hashmap with their respective index
        for (int i = 0; i < order.length(); i++) {
            char c = order.charAt(i);
            hashMap.put(c, i);
        }

        char[] charSet = new char[200];
        int[] charFreq = new int[200];
        Arrays.fill(charSet, '0');
        Arrays.fill(charFreq, 0);
        StringBuilder leftOver = new StringBuilder("");

        // Now iterate through the S and see if each character is present in the hashmap
        // If yes then place that character to respective index and track the frequency of that character
        // Unavailable characters are going to be concatenated to a different string builder
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (hashMap.containsKey(c)) {
                int pos = hashMap.get(c);
                charSet[pos] = c;
                charFreq[pos]++;
            } else {
                leftOver.append(c);
            }
        }

        // When the above processing is finished then read the characters inserted into charSet array
        // Also repeat the character number of times occurred from frequency index
        StringBuilder result = new StringBuilder("");
        for (int i = 0; i < 200; i++) {
            if (charSet[i] != '0') {
                for (int j = 0; j < charFreq[i]; j++) {
                    result.append(charSet[i]);
                }
            }
        }

        // Merge the two string (result + leftOver) and return
        return result.append(leftOver).toString();
    }

    public void func() {
        String order = "cba", s = "abcd";
        order = "kqep"; s = "pekeq";
        System.out.println(customSortString(order, s));
    }

    public static void main (String[] args) {
        CustomSortString obj = new CustomSortString();
        obj.func();
    }
}
