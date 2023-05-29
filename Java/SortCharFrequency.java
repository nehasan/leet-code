// Leet code 451: Sort Characters By Frequency
// Nahid Hasan Khan

import java.util.*;
import java.util.stream.Collectors;

public class SortCharFrequency {

    /*
    * @param[String] incoming string to process
    * @return[String] final processed string
    * algorithm: store each character to a hashmap along with the number of times it appeared
    * example: tree, hashmap -> { t: 1, r: 1, e: 2 }
    * next sort the hashmap based on value -> { e: 2, r: 1, t: 1 }
    * iterate over the hashmap and build a new string based on the frequency of the characters
    * return the resulting string
    * */
    public String frequencySort(String s) {
        HashMap<Character, Integer> charMap = new HashMap<>();
        // Iterate through the string and update the frequency of each character
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            charMap.put(c, charMap.getOrDefault(c, 0) + 1);
        }

        LinkedHashMap<Character, Integer> sortedMap =
                charMap.entrySet().stream().
                        sorted(Map.Entry.comparingByValue(Comparator.reverseOrder())).
                        collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (e1, e2) -> e1, LinkedHashMap::new));

        StringBuilder resultingString = new StringBuilder("");
        for(Map.Entry<Character, Integer> entry: sortedMap.entrySet()) {
            // System.out.println(entry.getKey() + " : " + entry.getValue());

            for (int i = 0; i < entry.getValue(); i++) {
                resultingString.append(entry.getKey());
            }
        }

        return resultingString.toString();
    }

    public void func() {
        String test1 = "tree";
        test1 = "aaaccc";
        test1 = "bbAaa";
        System.out.println(frequencySort(test1));
    }

    public static void main(String[] args) {
        new SortCharFrequency().func();
    }
}
