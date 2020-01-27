package CoinChange;

public class main {
                          // {2, 5, 7}   // 27
    public static int coinChange(int[] A, int M){
        int[] f = new int[M + 1];
        int n = A.length;   // number of kinds of coins

        // init
        f[0] = 0;

        int i, j;
        // f[1], f[2], ... , f[27]
        for(i = 1; i <= M; ++i){
            f[i] = Integer.MAX_VALUE;
            // last coin A[j]
            // f[i] = min{f[i-A[0]]+1, ... , f[i-A[n-1]]+1}
            for(j = 0; j < n; ++j){
                if(i >= A[j] && f[i - A[j]] != Integer.MAX_VALUE)
                f[i] = Math.min(f[i - A[j]] + 1 , f[i]);
            }
        }

        if(f[M] == Integer.MAX_VALUE){
            f[M] = -1;
        }

        return f[M];
    }

    public static void main(String[] args) {
        int[] A = {2, 5, 7};
        int M = 48;
        System.out.println(coinChange(A, M));
    }
}
