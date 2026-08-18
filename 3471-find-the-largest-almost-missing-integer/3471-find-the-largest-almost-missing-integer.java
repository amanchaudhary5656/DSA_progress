class Solution {
    public int largestInteger(int[] nums, int k) {
        int n = nums.length;

        // Case 1: k == 1
        if (k == 1) {
            int[] freq = new int[51]; // since 0 <= nums[i] <= 50
            for (int x : nums) {
                freq[x]++;
            }
            for (int x = 50; x >= 0; x--) {
                if (freq[x] == 1) {
                    return x;
                }
            }
            return -1;
        }

        // Case 2: k == n
        if (k == n) {
            int max = nums[0];
            for (int x : nums) {
                if (x > max) max = x;
            }
            return max;
        }

        // Case 3: 1 < k < n
        // Only nums[0] and nums[n-1] can be almost missing.

        int first = nums[0];
        int last = nums[n - 1];

        boolean firstAppearsAgain = false;
        boolean lastAppearsAgain = false;

        // Check if first element appears elsewhere
        for (int i = 1; i < n; i++) {
            if (nums[i] == first) {
                firstAppearsAgain = true;
                break;
            }
        }

        // Check if last element appears elsewhere
        for (int i = 0; i < n - 1; i++) {
            if (nums[i] == last) {
                lastAppearsAgain = true;
                break;
            }
        }

        int ans = -1;

        // If first appears only once in the whole array, it's a candidate
        if (!firstAppearsAgain) {
            ans = Math.max(ans, first);
        }

        // If last appears only once in the whole array, it's a candidate
        if (!lastAppearsAgain) {
            ans = Math.max(ans, last);
        }

        return ans;
    }
}