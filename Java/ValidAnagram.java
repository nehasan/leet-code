import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class ValidAnagram {
    public void putOrIncrease(Map<Character, Integer> map, char c) {
        if(map.containsKey(c)) {
            map.put(c, map.get(c) + 1);
        } else {
            map.put(c, 1);
        }
    }

    public boolean isAnagram(String s, String t) {
        Map<Character, Integer> sMap = new HashMap<>();
        Map<Character, Integer> tMap = new HashMap<>();
//        int haveCount  = 0;
        for(int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            putOrIncrease(sMap, c);
        }

        for(int i = 0; i < t.length(); i++) {
            char c = t.charAt(i);
            putOrIncrease(tMap, c);
        }

        for (Map.Entry<Character, Integer> entry : tMap.entrySet()) {
            char c = entry.getKey();
            if(!sMap.containsKey(c)) {
                return false;
            } else {
                if(!sMap.get(c).equals(entry.getValue())) {
                    return false;
                }
            }
        }

        return true;
    }

    public boolean isAnagram2(String s, String t) {
        if(s.length() != t.length()) {
            return false;
        }

        char[] sArray = s.toCharArray();
        char[] tArray = t.toCharArray();

        Arrays.sort(sArray);
        Arrays.sort(tArray);

//        return sArray.equals(tArray);
        return Arrays.equals(sArray, tArray);
    }

    public void run() {
        System.out.println(isAnagram2("ab", "bac"));
    }

    public static void main(String[] args) {
        MaxDepthBinaryTree obj = new MaxDepthBinaryTree();
        obj.run();
    }
}
