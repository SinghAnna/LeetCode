import java.util.Arrays;

public class _72_EditDistance {

    

      public int minDistance(String word1, String word2) {
        

        int m = word1.length();
        int n = word2.length();

      int[][] dp;  dp = new int[m][n];

        for (int i = 0; i < dp.length; i++) {
            Arrays.fill(dp[i], -1);
        }

        
        return solve(word1,word2,0,0, dp);
    }

    int solve(String word1,String word2, int i, int j,int[][] dp){

        if(i == word1.length()){
            return word2.length() - j;
        }

        if(j == word2.length()){
            return word1.length() - i;
        }

        if(dp[i][j] != -1){
            return dp[i][j];
        }

        if(word1.charAt(i) == word2.charAt(j)){
            return dp[i][j] = solve(word1, word2, i + 1, j + 1, dp);
        }

        //insert
        
        int insert = solve(word1, word2, i, j + 1, dp);

        //delete

        int delete = solve(word1, word2, i + 1, j, dp);


        int update = solve(word1, word2, i + 1, j + 1, dp);

        return dp[i][j] =  1 + Math.min(insert, Math.min(update, delete));

    }

    public static void main(String[] args) {

        _72_EditDistance distance = new _72_EditDistance();
        String  word1 = "horse", word2 = "ros";

        int ans = distance.minDistance(word1, word2);
        System.out.println(ans);
    }
}
