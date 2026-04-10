import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class _17_letterCombinationOfPhoneNumber {

    public static List<String> letterCombination(String digits){
        List<String> result = new ArrayList<>();

        if (digits == null || digits.length() == 0) {
            return result;
        }

        Map<Character, String> map = new HashMap<>();
        map.put('2', "abc");
        map.put('3', "def");
        map.put('4', "ghi");
        map.put('5', "jkl");
        map.put('6', "mno");
        map.put('7', "pqrs");
        map.put('8', "tuv");
        map.put('9', "wxyz");

        backTrack(result,map,digits,0,new StringBuilder());


        return result;
    } 

    public static void backTrack(List<String> result, Map<Character,String> map, String digits, int index, StringBuilder current){
        if (index == digits.length()) {
            result.add(current.toString());
            return;
        }

        String letters = map.get(digits.charAt(index));
        for(char c : letters.toCharArray()){
            current.append(c);
            backTrack(result, map, digits, index + 1, current);
            current.deleteCharAt(current.length()-1); // backtrack
        }
    }

    public static void main(String[] args) {
        List<String> rs = letterCombination("23");
        System.out.println(rs);
    }
}
