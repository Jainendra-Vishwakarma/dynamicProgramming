import java.util.Arrays;

public class MatrixChainMultiplication {

    public static int MCMRecursion(int arr[], int i, int j){

        if (i == j) {
            return 0;  // single  matrix case
        }

        int ans = Integer.MAX_VALUE;
        for (int k = i; k <= j-1; k++) {
            int cost1 = MCMRecursion(arr, i, k); // Ai....Ak = arrSize -> arr[i-1] * arr[k]
            int cost2 = MCMRecursion(arr, k+1, j);  //Ai+1....Aj = arrSize -> arr[K+1] * arr[j]

            int cost3 = arr[i-1] * arr[k] * arr[j];  // a * b * c

            int finalCost = cost1 + cost2 + cost3;
            ans = Math.min(ans, finalCost);

        }
        return ans;  // minCost
    }

    public static int MCMMemoization(int arr[], int i , int j, int dp[][]){
        if(i == j) {
            return 0;
        }

        if (dp[i][j] != -1){
            return dp[i][j];
        }
        int ans = Integer.MAX_VALUE;
        for (int k = i; k <= j-1; k++) {
            int cost1 =MCMMemoization(arr, i, k, dp);
            int cost2 = MCMMemoization(arr, k+1, j, dp);
            int cost3 = arr[i-1] * arr[k] * arr[j];

            int finalCost = cost1 + cost2 + cost3;
            ans = Math.min(ans, finalCost);
            dp[i][j] = ans;
        }
        return dp[i][j];
    }

    public static int MCMTabulation(int arr[]){
        int n = arr.length;
        int dp[][] = new int[n][n];

        //initialization
        for (int i = 0; i < n; i++) {
            dp[i][i] = 0;
        }

        //bottom up
        for (int len = 2; len <= n-1 ; len++) {
            for (int i = 1; i <= n-len; i++) {
                int j = i+len-1;  //col
                dp[i][j] = Integer.MAX_VALUE;
                for (int k = i; k <=j-1; k++) {
                    int cost1 = dp[i][k];
                    int cost2 = dp[k+1][j];
                    int cost3 = arr[i-1] *  arr[k] * arr[j];
                    int finalCost = cost1 + cost2 + cost3;
                    dp[i][j] = Math.min(finalCost, dp[i][j]);
                }

            }
        }
        print(dp);
        return dp[1][n-1];
    }
    public static void print(int dp[][]){
        for (int i = 0; i < dp.length; i++) {
            for (int j = 0; j < dp[0].length; j++) {
                System.out.print(dp[i][j] + "    ");
            }
            System.out.println();
        }
        System.out.println();
    }
    public static void main(String[] args) {
        int arr[] = {1, 2, 3, 4, 3};  // n = 5
    //    int n = arr.length;


        System.out.println(MCMTabulation(arr));

//        int dp[][] = new int[n][n];
//        for (int i = 0; i < n; i++) {
//            Arrays.fill(dp[i], -1);
//        }

    //    System.out.println(MCMMemoization(arr, 1, n-1, dp));
        //System.out.println(MCMRecursion(arr, 1, n-1));
    }
}
