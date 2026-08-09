class Solution {
    public int stoneGameII(int[] piles) {
        int n = piles.length;

        int[] suffix = new int[n + 1];

        for (int i = n - 1; i >= 0; i--) {
            suffix[i] = suffix[i + 1] + piles[i];
        }

        int[][] dp = new int[n + 1][n + 1];

        for (int i = n - 1; i >= 0; i--) {
            for (int m = n; m >= 1; m--) {
                if (2 * m >= n - i) {
                    dp[i][m] = suffix[i];
                    continue;
                }
                int opponentBest = Integer.MAX_VALUE;
                for (int x = 1; x <= 2 * m; x++) {
                    int nextIndex = i + x;
                    int nextM = Math.max(m, x);

                    opponentBest = Math.min(
                            opponentBest,
                            dp[nextIndex][nextM]
                    );
                }

                dp[i][m] = suffix[i] - opponentBest;
            }
        }

        return dp[0][1];
    }
}