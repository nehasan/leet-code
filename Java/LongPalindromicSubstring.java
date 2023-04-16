import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LongPalindromicSubstring {
    public boolean checkPalindrome(String s, int beg, int end, int[] maxLen, String[] longest) {
        String tempS = s.substring(beg, end + 1);
        int len = tempS.length();
//        System.out.println(tempS);
        for (int i = 0, j = (len - 1); i < (len / 2); i++, j--) {
            if (tempS.charAt(i) != tempS.charAt(j)) {
                return false;
            }
        }

        if (len >= maxLen[0]) {
            maxLen[0] = len;
            longest[0] = tempS;
        }
        return true;
    }

    public String longestPalindrome(String s) {
        Map<Character, List<Integer>> map = new HashMap<>();

        if (s.length() == 1) {
            return s;
        }

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c >= 'a' && c <= 'z' || c >= 'A' && c <= 'Z' || c >= '0' && c <= '9') {
                if (map.containsKey(c)) {
                    List<Integer> positions = map.get(c);
                    positions.add(i);
                } else {
                    List<Integer> positions = new ArrayList<>();
                    positions.add(i);
                    map.put(c, positions);
                }
            }
        }

        int[] maxLen = new int[] { Integer.MIN_VALUE };
        String[] longestPal = new String[1];
//        String longestPal = new String("");
        for (Map.Entry<Character, List<Integer>> entry : map.entrySet()) {
            List<Integer> positions = entry.getValue();
            int arrSize = positions.size();
            if (arrSize == 1) {
                if (maxLen[0] < 1) {
                    maxLen[0] = 1;
                    longestPal[0] = s.substring(positions.get(0), positions.get(0) + 1);
                }
            } else {
                for (int i = 0; i < arrSize; i++) {
                    for (int j = (arrSize - 1); j > i; j--) {
                        int beg = positions.get(i);
                        int end = positions.get(j);
                        if (((end - beg) + 1) > maxLen[0]) {
                            checkPalindrome(s, positions.get(i), positions.get(j), maxLen, longestPal);
                        }
                    }
                }
            }
        }

        return longestPal[0];
    }

    public void func() {
//        String[] ss = new String[] {
//            "aacabdkacaa", "abb", "babad", "ac", "bccb", "abba", "cbbd", "a"
//        };
//        String[] ss = new String[]{"aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaabcaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa"};
        String[] ss = new String[] { "aacabdkacaa" };
        for (int i = 0; i < ss.length; i ++) {
            System.out.println(longestPalindrome(ss[i]));
        }
    }

    public static void main (String[] args) {
        LongPalindromicSubstring lps = new LongPalindromicSubstring();
        lps.func();
    }
}
