import java.util.HashMap;

public class _387_FirstUniqueCharacterinaString {

    public static int firstUniqChar(String s) {

        HashMap<Character, Integer> map = new HashMap<>();

        // frequency count
        for (char c : s.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }

        // find first unique character
        for (int i = 0; i < s.length(); i++) {
            if (map.get(s.charAt(i)) == 1) {
                return i;
            }
        }

        return -1;
    }

    public static void main(String[] args) {
        String s = "loveleetcode";
        System.out.println(firstUniqChar(s));
    }
}