import com.sun.source.tree.Tree;

import java.util.*;

public class Main {
    public boolean containsAllChars(Map<Character, Integer> m1, Map<Character, Integer> m2, String t) {
        for (int i = 0; i < t.length(); i++) {
            char c = t.charAt(i);
            if(!m2.containsKey(c)) {
                return false;
            }
        }
        return true;
    }

    public void putIntoMap(Map<Character, Integer> map, char c) {
        if(map.containsKey(c)) {
            int num = map.get(c);
            map.put(c, ++num);
        } else {
            map.put(c, 1);
        }
    }

    public boolean sameSize(Map<Character, Integer> m1, Map<Character, Integer> m2, String t) {
        for(int i = 0; i < t.length(); i++) {
            char c = t.charAt(i);
            if((m1.get(c) > m2.get(c))) {
                return false;
            }
        }
        return true;
    }

    public String minWindow(String s, String t) {
        Map<Character, Integer> map = new HashMap<>();

        for(int i = 0 ; i < t.length(); i++) {
            char c = t.charAt(i);
            putIntoMap(map, c);
        }
        char[] charArr = new char[100001];
        int[] posArr = new int[100001];

        int charArrLen = 0;
        for(int i = 0, j = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (map.containsKey(c)) {
                charArr[j] = c;
                posArr[j] = i;
                j++;
                charArrLen++;
            }
        }

        int tLen = t.length();
        char[] tChars = t.toCharArray();
        Arrays.sort(tChars);
        t = new String(tChars);

        Map<Integer, String> finalMap = new HashMap<>();
        int minWindow = Integer.MAX_VALUE;
        for(int i = 0; i < charArrLen; i++) {
            Map<Character, Integer> tempMap = new HashMap<>();
            String tempStr = new String("");
            for(int j = i; j < charArrLen; j++){
                putIntoMap(tempMap, charArr[j]);
                tempStr = tempStr.concat(Character.toString(charArr[j]));
                if(containsAllChars(map, tempMap, t)) {
                    if (sameSize(map, tempMap, tempStr)) {
                        int posA = posArr[i];
                        int posB = posArr[j];
                        finalMap.put(posB - posA, s.substring(posA, posB + 1));
                        minWindow = Math.min(minWindow, (posB - posA));
                        break;
                    }
                }
            }
        }

        if (finalMap.isEmpty()) {
            return new String("");
        } else {
//            Map.Entry<Integer,String> entry = finalMap.entrySet().iterator().next();
            return finalMap.get(minWindow);
        }
    }



    public static void main(String[] args) {
        Main m = new Main();

    }
}