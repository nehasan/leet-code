import java.util.HashMap;
import java.util.Map;

public class LongestSubstring {
    /*
    *
    * */
    public int lengthOfLongestSubstring(String s) {
        Map<Character, Integer> map = new HashMap<>();
        int currStartPos = 0;
        int currLen = 0;
        int maxLen = 0;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if(map.containsKey(c) && map.get(c) >= currStartPos) {
                int foundPos = map.get(c);
                currLen = i - foundPos;
                currStartPos = foundPos + 1;
                maxLen = Math.max(maxLen, currLen);
                map.put(c, i);
            } else {
                map.put(c, i);
                currLen++;
                maxLen = Math.max(maxLen, currLen);
            }
        }
        return Math.max(maxLen, currLen);
    }

    public void run() {
        System.out.println(lengthOfLongestSubstring("pwwkew"));
    }

    public static void main(String[] args) {
        LongestSubstring obj = new LongestSubstring();
        obj.run();
    }
}
