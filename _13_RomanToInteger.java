import java.util.HashMap;
import java.util.Map;

public class _13_RomanToInteger {

    static int romanToInteger(String roman){

        Map<Character , Integer> map = new HashMap<>();

        map.put('I', 1);
        map.put('V', 5);
        map.put('X', 10);
        map.put('L', 50);
        map.put('C', 100);
        map.put('D', 500);
        map.put('M', 1000);
      
        int result = 0;

       // int prevValue = 0;

        // left to right
        for (int i = 0; i < roman.length() - 1; i++) {

            int curr = map.get(roman.charAt(i));
            int next = map.get(roman.charAt(i + 1));

            if (curr < next) {
                result -= curr;
            }else{
                result += curr;
            }
            
        }

        result += map.get(roman.charAt(roman.length() - 1));


        // Right To Left
        // for (int i = roman.length() - 1; i >= 0; i--) {
        //     char currItem = roman.charAt(i);
        //     int currVal = map.get(currItem);

        //     if (currVal >= prevValue) {
        //         result += currVal;
        //     }else{
        //         result -= currVal;
        //     }

        //     prevValue = currVal;
        // }

        return result;
    }

    public static void main(String[] args) {

        String roman = "XXIV";
        int rs = romanToInteger(roman);
        System.out.println("Roman To Integer of "+ roman + "is " +rs);
    }
}