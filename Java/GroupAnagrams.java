import java.util.*;

public class GroupAnagrams {
    public List<List<String>> groupAnagrams(String[] args) {
        List<List<String>> result = new ArrayList<>();
        if (args.length == 0) {
            return result;
        }
        Map<String, List<String>> map = new HashMap<>();
        for (String s : args) {
            char[] chars = s.toCharArray();
            Arrays.sort(chars);
            if (map.containsKey(Arrays.toString(chars))) {
                try {
                    List<String> group = map.get(Arrays.toString(chars));
                    group.add(s);
                } catch (Exception ex) {
                    List<String> group = new ArrayList<>();
                    group.add(s);
                    map.put(Arrays.toString(chars), group);
                }
            } else {
                List<String> group = new ArrayList<>();
                group.add(s);
                map.put(Arrays.toString(chars), group);
            }
        }

        for (Map.Entry<String, List<String>> entry : map.entrySet()) {
            result.add(entry.getValue());
        }

        return result;
    }

    public void func() {
        String[] args = new String[] { "eat","tea","tan","ate","nat","bat" };
        System.out.println(Arrays.toString(groupAnagrams(args).toArray()));
        args = new String[]{};
        System.out.println(Arrays.toString(groupAnagrams(args).toArray()));
    }

    public static void main (String[] args) {
        GroupAnagrams ga = new GroupAnagrams();
        ga.func();
    }
}
