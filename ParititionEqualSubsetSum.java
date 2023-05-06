import java.util.*;
public class ParititionEqualSubsetSum {

    public static int isSubsetSum(int arr[], int n, int sum , int dp[][]) {

        //O(n*w)

        int W = sum / 2;

        //bottom up
        for (int i = 1; i < n + 1; i++) {
            for (int j = 1; j < W + 1; j++) {
                //valid
                if (arr[i - 1] <= j) {
                    dp[i][j] = Math.max(arr[i - 1] + dp[i - 1][j - arr[i - 1]], dp[i - 1][j]);
                } else {
                    //invalid
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }
        return dp[n][W];

    }

    static int findPartiion(int arr[], int n)
    {
        // Calculate sum of the elements in array
        int sum = 0;
        for (int i = 0; i < n; i++)
            sum += arr[i];

        // If sum is odd, there cannot be two subsets
        // with equal sum
        if (sum % 2 != 0)
            return 0;

        // To store overlapping subproblems
        int dp[][] = new int[n + 1][sum + 1];
        for (int row[] : dp)
            Arrays.fill(row, -1);

        // Find if there is subset with sum equal to
        // half of total sum
        return isSubsetSum(arr, n, sum , dp);
    }

    public static void main(String[] args) {
        int arr[] = { 1, 5, 11, 5 };
        int n = arr.length;
        if (findPartiion(arr, n) == 1)
            System.out.println(
                    "Can be divided into two subsets of equal sum");
        else
            System.out.println(
                    "Can not be divided into two subsets of equal sum");
    }

}
