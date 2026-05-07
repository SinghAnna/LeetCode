public class _2109_AddingSpacesToAString {
      public String addSpaces(String s, int[] spaces) {
        StringBuilder ans = new StringBuilder();
        
        int j = 0;
        for (int i = 0; i < s.length(); i++) {
            if (j < spaces.length && i == spaces[j]) {
                j++;
                ans.append(" ");
            }
            ans.append(s.charAt(i));
        }


        return ans.toString();
    }
    public static void main(String[] args) {
        String s = "LeetcodeHelpsMeLearn";
        int[] spaces = {8,13,15};

        _2109_AddingSpacesToAString spacesToAString = new _2109_AddingSpacesToAString();

        String ans = spacesToAString.addSpaces(s, spaces);

        System.out.println(ans);
    }
}
