import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class _49_groupAnagrams {

    public List<List<String>> groupAnagrams(String[] strs){
        Map<String,List<String>> map = new HashMap<>();

        for (String s: strs) {
            int[] count = new int[26];

            for (char c : s.toCharArray()) {
                count[c - 'a']++;
            }

            String key = Arrays.toString(count);

            map.putIfAbsent(key, new ArrayList<>());
            map.get(key).add(s);
        }
        return new ArrayList<>(map.values());
    }

    public static void main(String[] args) {
        
        String[] in = {"eat","tea","tan","ate","nat","bat"};
        List<List<String>> output =  new _49_groupAnagrams().groupAnagrams(in);

        System.out.println(output);
        
    }
}