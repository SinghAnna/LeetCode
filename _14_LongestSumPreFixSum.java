public class _14_LongestSumPreFixSum {

    static String longestCommonPrefix(String[] str){

        if (str == null || str.length == 0) {
            return "";
        }

        // Star as first String as the prefix 

        String prefix = str[0];

        for (int i = 1; i < str.length; i++) {
            // reduce the prefix unite it mathes the current String 

            while (str[i].indexOf(prefix) != 0) {
                
                prefix = prefix.substring(0,prefix.length() -1);

                if (prefix.isEmpty()) {
                    return "";
                }

            }
        }



        return prefix;
    }
    public static void main(String[] args) {
        
        String[] ques = {"Anant Singh","Anand Kumar"};
        String ans = longestCommonPrefix(ques);

        System.out.println("Longest Common Prefix String is "+ ans);


    }
}
