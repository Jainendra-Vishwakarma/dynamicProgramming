import java.util.Arrays;

public class ClimbingStairs {


    //climbing stairs -> Normal recursion  // O(2^n)
    public static int countWays(int n){
        if ( n == 0){
            return 1;
        }
        if (n < 0){
            return 0;
        }

       return countWays(n-1) + countWays(n-2);
    }


    //fibonacci
    public static int fib(int n ){ //O(n)
        if (n ==0 || n == 1 ){
            return n ;
        }
        return  fib(n-1)+ fib(n-2);
    }



    //climbing stairs -> Memoization  //O(n)
    public static int countWays2(int n , int ways[]){
        if ( n == 0){
            return 1;
        }
        if (n < 0){
            return 0;
        }

        if (ways[n] != -1) {// ways[n] is already  calculated[
            return ways[n];
        }
        ways[n] = countWays2(n-1, ways) + countWays2(n-2, ways) ;
        int ans = ways[n];

        return ans;
    }


    public static int countWays3(int n , int ways[]){
        if ( n == 0){
            return 1;
        }
        if (n < 0){
            return 0;
        }

        if (ways[n] != -1) {// ways[n] is already  calculated[
            return ways[n];
        }
        ways[n] = countWays3(n-1, ways) + countWays3(n-2, ways) + countWays3(n-3, ways);
        int ans = ways[n];

        return ans;
    }


    //climbing stair Tabulation


    static int climTabulation(int n){  //O(n)
        int dp []  = new int[n+1];
        dp[0] = 1;

        for (int i = 1 ; i <= n ; i++) {
           if (i == 1){
               dp[i] = dp[i-1] + 0;
           } else {
               dp[i] = dp[i-1] + dp[i-2];
           }
        }
        int ans = dp[n];
        return ans;
    }

    public static void main(String[] args) {
        int n = 5;   // n = 3 -> 3 & n = 4 -> 5 => 8
        //int ways[] = new int[n+1];
        //Arrays.fill(ways,-1);
       // System.out.println(countWays(n));
        //System.out.println(countWays3(n, ways));
        System.out.println(climTabulation(n));

    }
}
