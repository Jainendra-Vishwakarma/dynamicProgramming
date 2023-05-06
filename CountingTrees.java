import java.util.*;
public class CountingTrees {

    public static int countBST(int n ){
        int dp[] = new int[n+1];
        dp [0] = 1;
        dp[1] = 1;

        for (int i = 2; i < n+1; i++) {
            //Ci -> BST (i node ) dp [i]
            for (int j = 0; j < i; j++) {
                //ci  += cj * ci-j-1
                //dp[i] += dp[j]* dp[i-j-1];
                //or
                int left = dp[j];
                int right = dp[i-j-1];
                dp[i] +=left*right;
            }
        }

        return dp[n];
    }
    public static void main(String[] args) {
        int n = 5;
        System.out.println(countBST(n));
    }
}
