import java.util.HashMap;
import java.util.Scanner;

public class TestSTDIN {
    public int smallestSpecialNumber(String s) {
        String[] words = new String[] {
                "zero", "one", "two", "three", "four",
                "five", "six", "seven", "eight", "nine"
        };

        HashMap<Character, Integer> map = new HashMap<>();
        HashMap<String, Integer> numberMap = new HashMap<>();
        HashMap<Integer, Integer> digitsMap = new HashMap<>();


        for (int i = 0; i < words.length; i++) {
            numberMap.put(words[i], i);
        }

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            map.put(c, (map.containsKey(c) ? map.get(c) + 1 : 1));
        }

        for (int i = 0; i < words.length; i++) {
            boolean found = true;
            String word = words[i];

            do {
                for (int j = 0; j < word.length(); j++) {
                    char c = word.charAt(j);
                    if (!map.containsKey(c) || map.get(c) < 0) {
                        found = false;
                        break;
                    }
                }

                if (found) {
                    for (int j = 0; j < word.length(); j++) {
                        char c = word.charAt(j);
                        map.put(c, (map.get(c) - 1));
                    }

                    int digit = numberMap.get(word);
                    digitsMap.put(digit, (digitsMap.containsKey(digit) ? digitsMap.get(digit) + 1 : 1));
                }
            } while (found);
        }

        String[] wordsOne = new String[] {
                "one", "zero", "two", "three", "four",
                "five", "six", "seven", "eight", "nine"
        };

        StringBuilder str = new StringBuilder();

        for (String word : wordsOne) {
            int digit = numberMap.get(word);
            int count = digitsMap.getOrDefault(digit, 0);
            for (int i = 0; i < count; i++) {
                str.append(numberMap.get(word).toString());
            }
        }

        return Integer.parseInt(str.toString());
    }
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);

        int testCases = s.nextInt();
        while(s.hasNext()) {
            String str = s.next();
            System.out.println(new TestSTDIN().smallestSpecialNumber(str));
        }
    }
}
