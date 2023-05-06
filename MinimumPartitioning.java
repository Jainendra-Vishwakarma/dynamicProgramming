public class MinimumPartitioning {
    public static int   minimumPartition(int arr[]) {

        //O(n*w)
        int n = arr.length;
        int sum = 0;
        for (int i = 0; i < arr.length; i++) {
            sum += arr[i];
        }

        int W = sum / 2;
        int dp[][] = new int[n + 1][W + 1];
        //initialization
        for (int i = 0; i < dp.length; i++) {
            dp[i][0] = 0;
        }
        for (int j = 0; j < dp[0].length; j++) {
            dp[0][j] = 0;
        }

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
//   print diff  = 0 ,so apply this means sum1 - sum2 == 0
//        int sum1 = dp[n][W];
//        int sum2 = sum - sum1;
//        if (sum1 == sum2) {
//            System.out.println("it's possible ");
//        } else {
//            System.out.println("not possible ");
//
//        }
//        return sum2;


        int sum1 = dp[n][W];
        int sum2 = sum - sum1;
        return Math.abs(sum2 -sum1) ;
    }

    public static void main(String[] args) {
       int numbers[] = {1, 6, 11, 5};
        //int numbers[] = {1, 2, 3};
        System.out.println(minimumPartition(numbers));

    }
}
