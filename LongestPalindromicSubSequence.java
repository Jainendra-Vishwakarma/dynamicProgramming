import java.util.Arrays;

public class LongestPalindromicSubSequence {
    public static int helper(String s, int left, int right, int [][] dp){
        if(left==right)
            return 1;

        if(left>right)
            return 0;

        if(dp[left][right]!=-1)
            return dp[left][right];

        if(s.charAt(left) == s.charAt(right)){
            dp[left][right] = 2 + helper(s, left+1, right-1, dp);
            return dp[left][right];
        } else {  //diff
            int leftIncrement = helper(s,left+1,right, dp);
            int rightIncrement =  helper(s,left,right-1, dp);
            dp[left][right] = Math.max(leftIncrement, rightIncrement);
        }
        return dp[left][right];

    }
    public static int longestPalindromeSubseq(String s) {

        int n = s.length();
        if(n==0 || s==null)
            return 0;
        int [][] dp = new int[n][n];
        for (int[] row : dp)
            Arrays.fill(row, -1);
        return helper(s, 0, s.length()-1,dp);
    }

    public static void main(String[] args) {
        String s = "agbcba";
        System.out.println(longestPalindromeSubseq(s));
    }
}
