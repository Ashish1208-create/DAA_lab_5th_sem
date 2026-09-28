public class Knapsack {

    public static int knapsack(int[] wt, int[] val, int W) {
        int n = wt.length;

        int[][] dp = new int[n + 1][W + 1];

        for (int i = 1; i <= n; i++) {
            for (int w = 1; w <= W; w++) {

                // Don't take the item
                dp[i][w] = dp[i - 1][w];

                // Take the item if it fits
                if (wt[i - 1] <= w) {
                    dp[i][w] = Math.max(
                        dp[i][w],
                        val[i - 1] + dp[i - 1][w - wt[i - 1]]
                    );
                }
            }
        }

        return dp[n][W];
    }

    public static void main(String[] args) {

        int[] wt = {1, 3, 4, 5};
        int[] val = {1, 4, 5, 7};

        int W = 7;

        System.out.println(knapsack(wt, val, W));
    }
}