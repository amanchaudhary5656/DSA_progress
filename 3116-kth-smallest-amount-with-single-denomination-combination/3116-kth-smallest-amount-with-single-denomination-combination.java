class Solution {
    public long findKthSmallest(int[] coins, int k) {
        long low = 1;
        long high = (long) getMin(coins) * k;

        while (low < high) {
            long mid = low + (high - low) / 2;

            if (countValid(mid, coins) >= k) {
                high = mid;
            } else {
                low = mid + 1;
            }
        }

        return low;
    }

    private long countValid(long x, int[] coins) {
        int n = coins.length;
        long count = 0;

        for (int mask = 1; mask < (1 << n); mask++) {
            long lcm = 1;
            int bits = 0;
            boolean exceeds = false;

            for (int i = 0; i < n; i++) {
                if ((mask & (1 << i)) != 0) {
                    bits++;

                    long g = gcd(lcm, coins[i]);
                    lcm = lcm / g * coins[i];

                    if (lcm > x) {
                        exceeds = true;
                        break;
                    }
                }
            }

            if (exceeds) {
                continue;
            }

            long contribution = x / lcm;

            if ((bits & 1) == 1) {
                count += contribution;
            } else {
                count -= contribution;
            }
        }

        return count;
    }

    private long gcd(long a, long b) {
        while (b != 0) {
            long temp = a % b;
            a = b;
            b = temp;
        }
        return a;
    }

    private int getMin(int[] coins) {
        int minimum = coins[0];

        for (int coin : coins) {
            minimum = Math.min(minimum, coin);
        }

        return minimum;
    }
}