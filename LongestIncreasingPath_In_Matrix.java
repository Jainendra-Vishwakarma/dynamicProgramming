import java.util.Arrays;

public class LongestIncreasingPath_In_Matrix {

    public static int LIP(int dp[][],  int mat[][], int n, int m, int x, int y){
        if (dp[x][y]<0){
            int result = 0;
            if ( x == n-1 &&  y == m-1){
                return dp[x][y];
            }
            if (x == n-1 || y == m-1){
                result  = 1;
            }
            if (x+1 < n && mat[x][y] < mat[x+1][y]){
                result = 1 + LIP(dp, mat, n, m, x + 1, y);
            }
            if (y + 1 < m && mat[x][y] < mat[x][y + 1]){
                result = Math.max(result, 1 + LIP(dp, mat, n, m, x, y + 1));
            }
            dp[x][y] = result;
        }

        return dp[x][y];
    }

    public static int wapper(int mat[][], int n, int m){
        int dp[][] = new int[n+1][m+1];
        for (int i = 0; i < n+1; i++) {
            Arrays.fill(dp[i], -1);
        }
        return LIP(dp, mat, n, m, 0, 0);
    }
    public static void main(String[] args) {
        int mat[][] = {{ 1, 2, 3, 4 },
                { 2, 2, 3, 4 },
                { 3, 2, 3, 4 },
                { 4, 5, 6, 7 },};

        System.out.println(wapper(mat , 4, 4));
    }

}
