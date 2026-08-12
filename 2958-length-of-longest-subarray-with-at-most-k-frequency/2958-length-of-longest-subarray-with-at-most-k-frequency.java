class Solution {
    public int maxSubarrayLength(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int i=0; int ans=0;
        for(int right=0 ; right<nums.length; right++){
            map.put(nums[right], map.getOrDefault(nums[right], 0)+1);
            while(map.get(nums[right]) > k){
                map.put(nums[i], map.get(nums[i])-1);
                i++;
                
            }
            ans= Math.max(ans, right-i+1 );
        }
        return ans;
    }
}