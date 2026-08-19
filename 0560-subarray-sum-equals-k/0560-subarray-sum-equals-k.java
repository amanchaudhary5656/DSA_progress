class Solution {
    public int subarraySum(int[] nums, int k) {
        int n = nums.length;
        int presum=0, count=0;
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0,1);
        for(int i=0; i<n; i++){
            presum+=nums[i];
            int temp = presum-k;
            if(map.containsKey(temp)) {
                count += map.getOrDefault(temp, 0);
                }
            map.put(presum, map.getOrDefault(presum,0)+1 );

        }
        return count;

    }
}